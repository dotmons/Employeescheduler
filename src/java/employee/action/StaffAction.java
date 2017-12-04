/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import employee.interfaces.Employee;
import java.util.Map;

/**
 *
 * @author Dotmons
 */
public class StaffAction extends ActionSupport implements Employee {

    Map session = ActionContext.getContext().getSession();

    int employeeid;
    String firstname;
    String lastname;
    String emailaddress;
    String dob;
    String hiredate;
    String gender;
    int sinno;
    int departmentid;
    String aboutstaff;
    private String username;

    @Override
    public int getEmployeeid() {
        return employeeid;
    }

    @Override
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getEmailaddress() {
        return emailaddress;
    }

    @Override
    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Override
    public String getDob() {
        return dob;
    }

    @Override
    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String getHiredate() {
        return hiredate;
    }

    @Override
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int getSinno() {
        return sinno;
    }

    @Override
    public void setSinno(int sinno) {
        this.sinno = sinno;
    }

    @Override
    public String getAboutstaff() {
        return aboutstaff;
    }

    @Override
    public void setAboutstaff(String aboutstaff) {
        this.aboutstaff = aboutstaff;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }
//    @Override
//    public String execute() {
//
//        try {
//            String employeeid = session.get("emploginid").toString();
//            String empdetailsobject[] = {"employeeid", "firstname", "lastname", "emailaddress", "dob", "hiredate", "gender", "sinno", "departmentid"};
//            java.util.ArrayList<String> empdetails = Generalcodeapi.selectElementById(empdetailsobject, "employeedetails", "employeeid", employeeid);
//            empdetails.stream().forEach((datalist) -> {
//                System.out.println("List:" + datalist);
//            });
//            return SUCCESS;
//        } catch (Exception ee) {
//            Generalcodeapi.logerror(StaffAction.class.toString(), ee);
//            return ERROR;
//        }
//
//    }

    public String inserttostaff() {
        try {
            //String empdetailsobject[] = {"employeeid", "firstname", "lastname", "emailaddress", "dob", "hiredate", "gender", "sinno", "departmentid"};
            //String employeeid = session.get("emploginid").toString();            
            //java.util.ArrayList<String> empdetails = Generalcodeapi.selectElementById(empdetailsobject, "employeedetails", "employeeid", employeeid);

            //Generalcodeapi.insertAllElement(empdetailsobject, "tablename");
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(StaffAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
    }
}
