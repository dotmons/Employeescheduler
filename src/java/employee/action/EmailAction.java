/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

/**
 *
 * @author Dotmons
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

public class EmailAction extends ActionSupport {

    AdapterAction abmail;
    
    private String from = "scheduler@dotmons.com";
    private String name = "Employee Scheduler";
    private String password = "Scheduler123";
    private String to;
    private String subject = "Employee Scheduler";
    private String body;

//    static Properties properties = new Properties();
//
//    static {
//        properties.put("mail.smtp.host", "mail.dotmons.com");
//        properties.put("mail.smtp.socketFactory.port", "25");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.port", "25");
//    }

    public String execute() {
        try {
            
            abmail = new AdapterAction();
            if (abmail.SendAdapterMail(name, to, subject, body))
                return SUCCESS;
//            Session session = Session.getDefaultInstance(properties,
//                    new javax.mail.Authenticator() {
//                @Override
//                protected PasswordAuthentication
//                        getPasswordAuthentication() {
//                    return new PasswordAuthentication(getFrom(), getPassword());
//                }
//            });
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(to));
//            message.setSubject(subject);
//            message.setText(body);
//            Transport.send(message);
            
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, exception.toString());
        
        }
            return ERROR;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
//
//    public static Properties getProperties() {
//        return properties;
//    }
//
//    public static void setProperties(Properties properties) {
//        EmailAction.properties = properties;
//    }

//    public static void main(String[] args) {
//        EmailAction ea = new EmailAction();
//        ea.setBody("This is Dotmons, the greatest");
//        ea.setTo("dotmons@gmail.com");
//        ea.execute();
//    }
}
