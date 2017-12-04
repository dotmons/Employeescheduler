/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import employee.scheduler.database.Generalcodeapi;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Dotmons
 */
public class LoginAction extends ActionSupport {

    int employeeid;
    String username;
    String password;

    int managernumb;
    int staffnumb;

    Generalcodeapi generalcodeapi = new Generalcodeapi();

    public int getManagernumb() {
        return managernumb;
    }

    public void setManagernumb(int managernumb) {
        this.managernumb = managernumb;
    }

    public int getStaffnumb() {
        return staffnumb;
    }

    public void setStaffnumb(int staffnumb) {
        this.staffnumb = staffnumb;
    }

    public String isusernamepasswordvalid() {
        try {

            java.util.ArrayList<String> usern = Generalcodeapi.selectSql("select username from employeelogin where username = '" + getUsername() + "' and password = '" + Generalcodeapi.convertToPasswordHash(getPassword()) + "'", "username");

            int emploginidsize = usern.size();
            if (emploginidsize > 0) {

                Generalcodeapi.setSession("username", username);
                String managerstatus = Generalcodeapi.selectSql("select ismanager from " + EmployeeConstantValues.tableDetails + " where username = '" + getUsername() + "'", "ismanager").get(0).toString();
                System.out.println(managerstatus);
                Generalcodeapi.setSession("managerstatus", managerstatus);

                setManagernumb(getManagerNumber(1));
                setStaffnumb(getManagerNumber(0));

                return SUCCESS;
            } else {
                return ERROR;
            }

        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(LoginAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getManagerNumber(int n) {
        return Integer.parseInt(Generalcodeapi.selectSql("select count(*) as empno from employeedetails where ismanager = '" + n + "'", "empno").get(0).toString());
    }

    public String loadindex() {
        try {
            setManagernumb(getManagerNumber(1));
            setStaffnumb(getManagerNumber(0));
            return SUCCESS;
        } catch (Exception exception) {
            return ERROR;
        }
    }

}
