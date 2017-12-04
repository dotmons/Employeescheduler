/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import employee.observer.ObserverMail;
import com.opensymphony.xwork2.ActionSupport;
import employee.scheduler.database.Generalcodeapi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Dotmons
 */
public class InternalMessageAction extends ActionSupport {
InternalMessageAction managerAction;

    public InternalMessageAction() {
    }

    String username;
    String tousername;
    String message;
    String isread = "0";
    String isdelete = "0";

    String multiselectemployee;
    String allstaffs;
    String allmanagers;
    String nonmamager;

    java.util.ArrayList internalArrayList = new java.util.ArrayList<>();
    ObserverMail observer;

    public ArrayList getInternalArrayList() {
        return internalArrayList;
    }

    public void setInternalArrayList(ArrayList internalArrayList) {
        this.internalArrayList = internalArrayList;
    }
    
    
    
    public String getMultiselectemployee() {
        return multiselectemployee;
    }

    public void setMultiselectemployee(String multiselectemployee) {
        this.multiselectemployee = multiselectemployee;
    }

    public String getAllstaffs() {
        return allstaffs;
    }

    public void setAllstaffs(String allstaffs) {
        this.allstaffs = allstaffs;
    }

    public String getAllmanagers() {
        return allmanagers;
    }

    public void setAllmanagers(String allmanagers) {
        this.allmanagers = allmanagers;
    }

    public String getNonmamager() {
        return nonmamager;
    }

    public void setNonmamager(String nonmamager) {
        this.nonmamager = nonmamager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public boolean SendMessage() {
        try {
            java.util.ArrayList messageList = new java.util.ArrayList<>();
            messageList.add(0);
            //Add username session of user
            messageList.add(Generalcodeapi.getSessionUsername());
            messageList.add(getTousername());
            messageList.add(getTousername());
            messageList.add(getMessage());
            messageList.add(getIsread());
            messageList.add(getIsdelete());
            //Generalcodeapi.insertAllElement(listUsernamePassword, "employeelogin");
            Generalcodeapi.insertAllElement(messageList, EmployeeConstantValues.tableMessage);
            return true;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(InternalMessageAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return false;
        }
    }

    public String getAllUsername() {
        try {
            Map<String, String> mapusername = new LinkedHashMap<>();
            Map referenceList = new HashMap();
            java.util.ArrayList messagelist = new java.util.ArrayList<>();
            messagelist.add("username");
            messagelist.add("emailaddress");
            java.util.ArrayList lsls = Generalcodeapi.selectSomeElements(messagelist, EmployeeConstantValues.tableDetails);

            for (int i = 0; i < lsls.size(); i++) {
                String uusername = ((java.util.ArrayList) lsls.get(i)).get(0).toString();
                String emailaddress = ((java.util.ArrayList) lsls.get(i)).get(1).toString();
                
                System.out.println("Username: " + uusername + "  emailaddress:" + emailaddress);
                
                mapusername.put(uusername, emailaddress);
                //System.out.println("username:" + ((java.util.ArrayList)lsls.get(i)).get(0).toString());
            }
            referenceList.put("usernamelist", mapusername);
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(InternalMessageAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
    }
    
    public String loadpage() {
        getinternalmessages();
        System.out.println("Reading");
        return SUCCESS;
    }

    
    public ArrayList getEmailAddressList() {
        return Generalcodeapi.selectSql("select username, emailaddress from " + EmployeeConstantValues.tableDetails, "emailaddress");
    }

    public ArrayList getUsernameList() {
        return Generalcodeapi.selectSql("select username, emailaddress from " + EmployeeConstantValues.tableDetails, "username");
    }

    public String sendObserver() {
        try {
            observer = new ObserverMail();
            observer.sendObserverMail(getMultiselectemployee(), getMessage());
            loadpage();
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
    }

//    public String getAllUsername() {
//        try {
//            Map referenceList = new HashMap();
//            
//            
//            java.util.ArrayList messagelist = new java.util.ArrayList<>();
//            messagelist.add("username");
//            messagelist.add("emailaddress");
//            java.util.ArrayList lsls = Generalcodeapi.selectSomeElements(messagelist, EmployeeConstantValues.tableDetails);
//      
//            for (int i = 0; i < lsls.size(); i++) {
//                mapusername.put( ((java.util.ArrayList)lsls.get(i)).get(0).toString(), ((java.util.ArrayList)lsls.get(i)).get(1).toString());
//                //System.out.println("username:" + ((java.util.ArrayList)lsls.get(i)).get(0).toString());
//            }
//            referenceList.put("usernamelist", mapusername);
//            return SUCCESS;
//        } catch (Exception exception) {
//            java.util.logging.Logger.getLogger(InternalMessageAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
//            return ERROR;
//        }        
//    }

    public String printpage() {
        System.out.println(getAllmanagers());
        System.out.println(getAllstaffs());
        System.out.println(getNonmamager());
        System.out.println(getMessage());
        System.out.println(getMultiselectemployee());
        return SUCCESS;
    }

    public void getinternalmessages() {

        try {
            
            java.util.ArrayList ll = new java.util.ArrayList<>();
            
            ll.add("username");
            ll.add("tousername");
            ll.add("message");
            ll.add("isread");
            ll.add("isdelete");
            
            java.util.ArrayList lsls = Generalcodeapi.selectSomeElements(ll, EmployeeConstantValues.tableMessage);

            for (int i = 0; i < lsls.size(); i++) {
                managerAction = new InternalMessageAction();
                managerAction.setUsername(((java.util.ArrayList) lsls.get(i)).get(0).toString());
                managerAction.setTousername(((java.util.ArrayList) lsls.get(i)).get(1).toString());
                managerAction.setMessage(((java.util.ArrayList) lsls.get(i)).get(2).toString());
                managerAction.setIsread(((java.util.ArrayList) lsls.get(i)).get(3).toString());
                managerAction.setIsdelete(((java.util.ArrayList) lsls.get(i)).get(2).toString());                
                internalArrayList.add(managerAction);
            }

        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(ManagerAction.class.getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            
        }
    }

}
