/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.action;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Dotmons
 */
public class AdapterAction {

    String name;
    String email;
    String subject;
    String message;
    
    public boolean SendAdapterMail(String name, String email, String subject, String message) {
        String value = "";
        try {
            
            this.name = URLEncoder.encode(name.trim(), "UTF-8");
            this.email = URLEncoder.encode(email.trim(), "UTF-8");
            this.subject = URLEncoder.encode(subject.trim(), "UTF-8");
            this.message = URLEncoder.encode(message.trim(), "UTF-8");
         
            
            String webMessage = "http://dotmons.com/schedulermail.php?name=" + this.name + "&email=" + this.email + "&subject=" + this.subject + "&message=" + this.message + "";
            System.out.println("web message:" + webMessage);

            URL url = new URL(webMessage);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            InputStream is = conn.getInputStream();

            StringBuilder sb;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
                sb = new StringBuilder("");
                String line = "";
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
            }
            value = sb.toString();
            System.out.println("Output:" + value);

            //value+=value;
        } catch (Exception exception) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, exception.toString());
        }

        return ("".equals(value));
    }
}
