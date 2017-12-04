/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author Dotmons
 */
public class LogoutAction extends ActionSupport {

    public String logoff() {
        try {
            Map session = ActionContext.getContext().getSession();
            session.remove("username");
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(LogoutAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
    }
}
