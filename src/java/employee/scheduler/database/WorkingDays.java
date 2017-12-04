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
public class WorkingDays {
    
    int id;
    String days;
    int capacity;
    String timespanfrom;
    String timespanto;
    
    int avail;
    int unregisavail;

    public int getUnregisavail() {
        return unregisavail;
    }

    public void setUnregisavail(int unregisavail) {
        this.unregisavail = unregisavail;
    }

    
    
    
    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
