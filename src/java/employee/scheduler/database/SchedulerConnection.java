/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.scheduler.database;

/**
 *
 * @author Dotmons
 */
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SchedulerConnection extends ActionSupport {

    Connection connection = null;

    public Connection getConnection() {
        System.out.println("Connection is " + connection) ;
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean getconnections() {

        try {

            Context initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext.lookup("java:comp/env");
            String dataResourceName = "jdbc/scheduler";
            DataSource dataSource = (DataSource) environmentContext.lookup(dataResourceName);
            connection = dataSource.getConnection();
            setConnection(connection);
//            Connection cn = null;
//            Class.forName("com.mysql.jdbc.Driver");
//            cn = DriverManager.getConnection("jdbc:mysql://node4541-env-3002604.ocs.opusinteractive.io/employeescheduler", "root", "IHYdfc81933");
//            setConnection(connection);

            return true;
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(SchedulerConnection.class.getName()).log(java.util.logging.Level.SEVERE, "<<<SchedulerConnection: Error creating connection, error found >>>\n");
            System.out.println(e.toString());
            return false;
        }
    }

    public String execute() {
        return SUCCESS;
    }
}
