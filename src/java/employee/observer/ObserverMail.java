/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.observer;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;

/**
 *
 * @author Dotmons
 */
public class ObserverMail extends ActionSupport {

    Mailbox genMail[];
    PostOffice poster;
    
    public String sendObserverMail(String emaillist, String message) {
        try {
            java.util.ArrayList usernamemail = new java.util.ArrayList<>();
            usernamemail.addAll(Arrays.asList(emaillist.split(",")));

            
            genMail = new Mailbox[usernamemail.size()];

            for (int i = 0; i < genMail.length; i++) {
                genMail[i] = new Mailbox(usernamemail.get(i).toString());
            }

            poster = new PostOffice(message);
            for (Mailbox mails : genMail) {
                poster.AddObserver(mails);
                poster.newMail();
                poster.RemoveObserver(mails);
            }
            return SUCCESS;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, exception.toString());
            return ERROR;
        }
    }

//    public static void main(String[] ars)
//    {
//        ObserverMail mainer = new ObserverMail();
//        mainer.sendObserverMail("DOTMONS@GMAIL.COM, DOTMONS@YAHOO.COM");
//    }
}
