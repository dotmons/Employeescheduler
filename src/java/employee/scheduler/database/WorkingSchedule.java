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
public class WorkingSchedule {

    String username;
    String weekdays;
    String timespanfrom;
    String timespanto;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public String getTimespanfrom() {
        return timespanfrom;
    }

    public void setTimespanfrom(String timespanfrom) {
        this.timespanfrom = timespanfrom;
    }

    public String getTimespanto() {
        return timespanto;
    }

    public void setTimespanto(String timespanto) {
        this.timespanto = timespanto;
    }

}
