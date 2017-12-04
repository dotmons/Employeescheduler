/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.interfaces;

/**
 *
 * @author Dotmons
 */
public interface Employee {

    public int getEmployeeid();

    public void setEmployeeid(int employeeid);

    public String getFirstname();

    public void setFirstname(String firstname);

    public String getLastname();

    public void setLastname(String lastname);

    public String getEmailaddress();

    public void setEmailaddress(String emailaddress);

    public String getDob();

    public void setDob(String dob);

    public String getHiredate();

    public void setHiredate(String hiredate);

    public String getGender();

    public void setGender(String gender);

    public int getSinno();

    public void setSinno(int sinno);

    public String getAboutstaff();

    public void setAboutstaff(String aboutstaff);

    public String getUsername();

    public void setUsername(String username);

}
