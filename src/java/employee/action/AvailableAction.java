/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import com.opensymphony.xwork2.ActionSupport;
import employee.scheduler.database.GeneralWorkingDays;
import employee.scheduler.database.Generalcodeapi;
import employee.scheduler.database.WorkingDays;
import java.util.ArrayList;

/**
 *
 * @author Dotmons
 */
public class AvailableAction extends ActionSupport {

    java.util.ArrayList returndayworkschedule = new java.util.ArrayList();
    java.util.ArrayList returndayworkdays = new java.util.ArrayList();

    WorkingDays sch;
    GeneralWorkingDays genworkdays;

    String capacitty;
    String dayy;
    String idd;

    String managerdays;
    String managerstarttime;
    String managerendtime;

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getManagerdays() {
        return managerdays;
    }

    public void setManagerdays(String managerdays) {
        this.managerdays = managerdays;
    }

    public String getManagerstarttime() {
        return managerstarttime;
    }

    public void setManagerstarttime(String managerstarttime) {
        this.managerstarttime = managerstarttime;
    }

    public String getManagerendtime() {
        return managerendtime;
    }

    public void setManagerendtime(String managerendtime) {
        this.managerendtime = managerendtime;
    }

    public ArrayList getReturndayworkdays() {
        return returndayworkdays;
    }

    public void setReturndayworkdays(ArrayList returndayworkdays) {
        this.returndayworkdays = returndayworkdays;
    }

    public String getCapacitty() {
        return capacitty;
    }

    public void setCapacitty(String capacitty) {
        this.capacitty = capacitty;
    }

    public String getDayy() {
        return dayy;
    }

    public void setDayy(String dayy) {
        this.dayy = dayy;
    }

    public ArrayList getReturndayworkschedule() {
        return returndayworkschedule;
    }

    public void setReturndayworkschedule(ArrayList returndayworkschedule) {
        this.returndayworkschedule = returndayworkschedule;
    }

    public String available() {

        try {

            insertcapacity();
            getWorkingDays();
            java.util.ArrayList workdayschedule = new java.util.ArrayList();

            workdayschedule.add("id");
            workdayschedule.add("days");
            workdayschedule.add("capacity");
            workdayschedule.add("timespanfrom");
            workdayschedule.add("timespanto");

            String sql = "select shiftresources.id, (select timeday.weekday from timeday where id = shiftresources.timedayid) as days, (select timeday.capacity from timeday where id = shiftresources.timedayid) as capacity, shiftresources.timespanfrom, shiftresources.timespanto from shiftresources order by shiftresources.timedayid";
            java.util.ArrayList listWork = Generalcodeapi.selectSomeElementsWithQuery(workdayschedule, sql);

            for (Object listschedule : listWork) {
                sch = new WorkingDays();
                sch.setId(Integer.valueOf(((java.util.ArrayList) listschedule).get(0).toString()));
                sch.setAvail(getAvailableCapacity(sch.getId()));
                sch.setDays(((java.util.ArrayList) listschedule).get(1).toString());
                sch.setCapacity(Integer.valueOf(((java.util.ArrayList) listschedule).get(2).toString()));
                sch.setTimespanfrom(((java.util.ArrayList) listschedule).get(3).toString());
                sch.setTimespanto(((java.util.ArrayList) listschedule).get(4).toString());
                sch.setUnregisavail(getFilledCapacityPerUser(sch.getId()));                
                
                returndayworkschedule.add(sch);
            }
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(AvailableAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
    }

    public boolean insertcapacity() {
        if (!"".equals(getCapacitty())) {

            Generalcodeapi.update(EmployeeConstantValues.tableTimeday, "capacity", getCapacitty(), "weekday", getDayy());

            //Generalcodeapi.insertAllElement(capacity, EmployeeConstantValues.tableTimeday);
        }

        return false;
    }

    public void getWorkingDays() {

        try {

            java.util.ArrayList workdayschedule = new java.util.ArrayList();

            workdayschedule.add("weekday");
            workdayschedule.add("capacity");
            String sql = "select weekday, capacity from " + EmployeeConstantValues.tableTimeday;
            java.util.ArrayList listWork = Generalcodeapi.selectSomeElementsWithQuery(workdayschedule, sql);

            for (Object listschedule : listWork) {
                genworkdays = new GeneralWorkingDays();
                genworkdays.setGenWeekday((((java.util.ArrayList) listschedule).get(0).toString()));
                genworkdays.setGenCapacity(((java.util.ArrayList) listschedule).get(1).toString());
                returndayworkdays.add(genworkdays);
            }
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(AvailableAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());

        }
    }

    public String inserttimezone() {

        try {

            java.util.ArrayList arrlistimezone = new java.util.ArrayList<>();
            arrlistimezone.add("0");
            arrlistimezone.add(getManagerdays());
            arrlistimezone.add(convertDate(getManagerstarttime()));
            arrlistimezone.add(convertDate(getManagerendtime()));
            Generalcodeapi.insertAllElement(arrlistimezone, EmployeeConstantValues.tableShiftresources);
            available();
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(AvailableAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());

        }
        return ERROR;
    }

    public String convertDate(String datevalue) {
        String firstvalue = "";
        String secondvalue = "";

        firstvalue = (Generalcodeapi.zero(Integer.parseInt(datevalue.substring(0, datevalue.indexOf(":")))));
        secondvalue = (Generalcodeapi.zero(Integer.parseInt(datevalue.substring(datevalue.indexOf(":") + 1, datevalue.lastIndexOf(" ")))));

        String extention = datevalue.substring(datevalue.lastIndexOf(" ") + 1);
        if ("PM".equals(extention) && Integer.parseInt(firstvalue) < 12) {
            int newfirst = Integer.parseInt(firstvalue) + 12;
            firstvalue = String.valueOf(newfirst);
        }
        return (firstvalue + ":" + secondvalue + ":00");
    }

    public String insertstaffavailability() {
        try {
            
            java.util.ArrayList staffavailability = new java.util.ArrayList<>();
            staffavailability.add("0");
            staffavailability.add(getIdd());
            staffavailability.add(Generalcodeapi.getSessionUsername());
            Generalcodeapi.insertAllElement(staffavailability, EmployeeConstantValues.tableWorkingdays);
            available();
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(AvailableAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());

        }
        return ERROR;
    }

    public String removestaffavailability() {
        try {
            //Generalcodeapi.deleteItem(EmployeeConstantValues.tableWorkingdays, "shiftid", getIdd());
            //"delete from " + table + " where " + pritable + " = '" + id + "'";
            Generalcodeapi.ExecuteDelete("delete from " + EmployeeConstantValues.tableWorkingdays + " where shiftid = '"+ getIdd() + "' and username = '" + Generalcodeapi.getSessionUsername() + "'");
            available();
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(AvailableAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());

        }
        return ERROR;
    }

    public int getAvailableCapacity(int n) {
        return Integer.parseInt(Generalcodeapi.selectSql("select count(shiftid) as availcounter from workingdays where shiftid = '" + n + "'", "availcounter").get(0).toString());
    }
    
    public int getFilledCapacityPerUser(int n)
    {
        try
        {        
        return Generalcodeapi.selectSql("select id from workingdays where shiftid = '" + n + "' and username = '" + Generalcodeapi.getSessionUsername()+"'","id").size();
        }
        catch (Exception ee)
        {
            return 0;
        }
    }

}
