/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import com.opensymphony.xwork2.ActionSupport;
import employee.scheduler.database.Generalcodeapi;
import employee.scheduler.database.WorkingSchedule;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dotmons
 */
public class ReportAction extends ActionSupport {

    String workingschedule = "";
    String currentdatepage = "";
    WorkingSchedule sch;
    
    

    public String getCurrentdatepage() {
        return currentdatepage;
    }

    public void setCurrentdatepage(String currentdatepage) {
        this.currentdatepage = currentdatepage;
    }
    
    public String getWorkingschedule() {
        return workingschedule;
    }

    public void setWorkingschedule(String workingschedule) {
        this.workingschedule = workingschedule;
    }

    public java.util.ArrayList getWorkingDays(String day) {

        java.util.ArrayList listworkingdays = new ArrayList();
        try {
            String currentdate = Generalcodeapi.datenoformat();            
            currentdatepage = "'"+currentdate+"'";
            
            String input_date = (currentdate.substring(0, currentdate.lastIndexOf("-")) + "-");
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat format2 = new SimpleDateFormat("EEEE");

            for (int i = 1; i <= Generalcodeapi.getLastDate(); i++) {
                Date dt1 = format1.parse(input_date + i);
                String finalDay = format2.format(dt1);
                if (day.equalsIgnoreCase(finalDay)) {
                    listworkingdays.add(input_date.replace("/", "-") + Generalcodeapi.zero(i) + "T");
                }
            }
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(ReportAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
        }
        return listworkingdays;
    }

    public java.util.ArrayList getWorkingSchedule() {

        java.util.ArrayList workschedule = new java.util.ArrayList();
        java.util.ArrayList returnworkschedule = new java.util.ArrayList();

        workschedule.add("username");
        workschedule.add("weekdays");
        workschedule.add("timespanfrom");
        workschedule.add("timespanto");
        String sql = "select workingdays.username, (select weekday from timeday where id = shiftresources.timedayid) as weekdays, shiftresources.timespanfrom, shiftresources.timespanto from workingdays, shiftresources where (workingdays.shiftid = shiftresources.id)";
//select shiftresources.timespanfrom, (select timeday.weekday from timeday where id = shiftresources.timedayid) as days, (select timeday.capacity from timeday where id = shiftresources.timedayid) as capacity, shiftresources.timespanto from shiftresources;
        java.util.ArrayList listWork = Generalcodeapi.selectSomeElementsWithQuery(workschedule, sql);
        
            for (Object listschedule: listWork)
            {   
                sch = new WorkingSchedule();
                sch.setUsername(((java.util.ArrayList) listschedule).get(0).toString());
                sch.setWeekdays(((java.util.ArrayList) listschedule).get(1).toString());
                sch.setTimespanfrom(((java.util.ArrayList) listschedule).get(2).toString());
                sch.setTimespanto(((java.util.ArrayList) listschedule).get(3).toString());
                returnworkschedule.add(sch);                
            }
        return returnworkschedule;
    }
    
    public String workingschedule()
    {
        try { 
            java.util.ArrayList listworkschedule = getWorkingSchedule();

            for (Object listworkschedule1 : listworkschedule) {

                WorkingSchedule sc = (WorkingSchedule) listworkschedule1;

                java.util.ArrayList listweekDays = getWorkingDays(sc.getWeekdays());

                for (int ii = 0; ii < listweekDays.size(); ii++) {
                    workingschedule += "{ title:'" + sc.getUsername() + "', start: '" + listweekDays.get(ii) + sc.getTimespanfrom() + "', end: '" + listweekDays.get(ii) + sc.getTimespanto() + "' },";
                }
            }
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(ReportAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }

    }
}
