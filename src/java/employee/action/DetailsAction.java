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
public class DetailsAction extends ActionSupport {

    Map session = ActionContext.getContext().getSession();

//    @Override
//    public String execute() {
//
//        try {
//
//            String employeeid = session.get("emploginid").toString();
//            String empdetailsobject[] = {"employeeid", "firstname", "lastname", "emailaddress", "dob", "hiredate", "gender", "sinno", "departmentid"};
//            java.util.ArrayList<String> empdetails = Generalcodeapi.selectElementById(empdetailsobject, "employeedetails", "employeeid", employeeid);
//            return SUCCESS;
//        }
//        catch (Exception ee)
//        {
//            Generalcodeapi.logerror(DetailsAction.class.getName(), ee);
//            return ERROR;
//        }
//
//    }
}
