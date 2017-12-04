/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import com.opensymphony.xwork2.ActionSupport;
import employee.scheduler.database.Generalcodeapi;

/**
 *
 * @author Dotmons
 */
public class PasswordAction extends ActionSupport {

    String oldpassword;
    String newpassword;
    String repeatnewpassword;
    EmailAction emailAction;
        
    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getRepeatnewpassword() {
        return repeatnewpassword;
    }

    public void setRepeatnewpassword(String repeatnewpassword) {
        this.repeatnewpassword = repeatnewpassword;
    }

    public String updatepassword() {
        
        if (isOldPassword()) {
            if (Generalcodeapi.update("employeelogin", "password", Generalcodeapi.convertToPasswordHash(getNewpassword()), "username", Generalcodeapi.getSessionUsername())) {
                String emailAddress = Generalcodeapi.selectSql("select emailaddress from employeedetails where username = '" + Generalcodeapi.getSessionUsername() + "'", "emailaddress").get(0).toString();
                emailAction = new EmailAction();
                emailAction.setBody("You new password is :" + getNewpassword());
                emailAction.setTo(emailAddress);
                emailAction.execute();
                Generalcodeapi.setSession("passwordupdate", "true");
                return SUCCESS;
            }
        }
        else
        {
            Generalcodeapi.setSession("passwordIncorrectUsername", "true");
            return SUCCESS;
        }
        return ERROR;
    }

    public boolean isOldPassword() {
        return Generalcodeapi.isExist("password", "employeelogin", Generalcodeapi.getSessionUsername(), "username");
        
       // return Generalcodeapi.isExist("select password from employeelogin where username = '" + Generalcodeapi.getSessionUsername() + "'", "password").get(0).toString().equals(Generalcodeapi.convertToPasswordHash(getOldpassword()));
    }

}
