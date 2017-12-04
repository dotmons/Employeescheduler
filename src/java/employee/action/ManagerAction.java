/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import employee.scheduler.database.Generalcodeapi;
import static employee.scheduler.database.Generalcodeapi.selectSomeElements;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Dotmons
 */
public class ManagerAction extends ActionSupport implements employee.interfaces.Employee {

    Map session = ActionContext.getContext().getSession();
    int employeeid;
    String firstname;
    String lastname;
    String emailaddress;
    String dob;
    String hiredate;
    String gender;
    int sinno;
    String aboutstaff;
    private String username;
    String managerradio;
    private java.util.ArrayList<ManagerAction> arrlistmanager = new java.util.ArrayList();

    public ArrayList<ManagerAction> getArrlistmanager() {
        return arrlistmanager;
    }

    public void setArrlistmanager(ArrayList<ManagerAction> arrlistmanager) {
        this.arrlistmanager = arrlistmanager;
    }

    public String getManagerradio() {
        return managerradio;
    }

    public void setManagerradio(String managerradio) {
        this.managerradio = managerradio;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSinno() {
        return sinno;
    }

    public void setSinno(int sinno) {
        this.sinno = sinno;
    }

    public String getAboutstaff() {
        return aboutstaff;
    }

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

    public String createnewmanager() {

        
        try {

            if (isUsername()) {
                Generalcodeapi.setSession("ManagerActionUsername", "true");
            } else if (isEmailaddress()) {                
                Generalcodeapi.setSession("ManagerActionEmailaddress", "true");
            } else {
                
                java.util.ArrayList arrlistnewmanager = new java.util.ArrayList<>();

                arrlistnewmanager.add(0);
                arrlistnewmanager.add(getUsername());
                arrlistnewmanager.add(getFirstname());
                arrlistnewmanager.add(getLastname());
                arrlistnewmanager.add(getEmailaddress());
                arrlistnewmanager.add(getDob());
                arrlistnewmanager.add(getHiredate());
                arrlistnewmanager.add(getGender());
                arrlistnewmanager.add(getSinno());
                arrlistnewmanager.add(getAboutstaff());
                System.out.println(getManagerradio());
                arrlistnewmanager.add("Manager".equals(getManagerradio()) ? "1" : "0");
                arrlistnewmanager.add(session.get("username").toString());

                // = {"0", "baba", "firstname", "lastname", "emailaddress", "dob", "hiredate", "gender", "100", "aboutstaff"};
                if (getUsername().length() != 0) {

                    Generalcodeapi.insertAllElement(arrlistnewmanager, "employeedetails");
                    String randomPassword = Generalcodeapi.getRandomPassword();

                    //Setting list for username and password field
                    ArrayList listUsernamePassword = new ArrayList();
                    listUsernamePassword.add(0);
                    listUsernamePassword.add(getUsername());
                    listUsernamePassword.add(Generalcodeapi.convertToPasswordHash(randomPassword));
                    Generalcodeapi.insertAllElement(listUsernamePassword, "employeelogin");

                    // To create email and send email at run time to client
                    EmailAction email = new EmailAction();
                    email.setBody("Welcome to Employee Scheduler. Your Scheduler username is " + getUsername() + " and password is: " + randomPassword);
                    email.setTo(getEmailaddress());
                    email.execute();

                    Generalcodeapi.setSession("staffupdate", "true");
                }
            }
            getstafflist();
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(ManagerAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }

    }

    public String getstafflist() {

        try {
            ManagerAction managerAction;
            java.util.ArrayList ll = new java.util.ArrayList<>();
            ll.add("username");
            ll.add("lastname");
            ll.add("firstname");
            java.util.ArrayList lsls = selectSomeElements(ll, "employeedetails");

            for (int i = 0; i < lsls.size(); i++) {
                managerAction = new ManagerAction();
                managerAction.setUsername(((java.util.ArrayList) lsls.get(i)).get(0).toString());
                managerAction.setLastname(((java.util.ArrayList) lsls.get(i)).get(1).toString());
                managerAction.setFirstname(((java.util.ArrayList) lsls.get(i)).get(2).toString());
                arrlistmanager.add(managerAction);
            }

        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(ManagerAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
        return SUCCESS;
    }

    public boolean isUsername() {
        return Generalcodeapi.isExist("username", "employeedetails", getUsername());
     //   return Generalcodeapi.ExecuteSql("select username from employeedetails where username = '" + getUsername() + "'");
    }

    public boolean isEmailaddress() {
        return Generalcodeapi.isExist("emailaddress", "employeedetails", getEmailaddress());
        //return Generalcodeapi.ExecuteSql("select emailaddress from employeedetails where emailaddress = '" + getEmailaddress() + "'");
    }

}
