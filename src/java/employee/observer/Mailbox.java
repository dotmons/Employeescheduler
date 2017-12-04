/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.observer;

import employee.action.EmailAction;
import employee.interfaces.Observer;

/**
 *
 * @author Dotmons
 */
public class Mailbox implements Observer {

    String Address;
    EmailAction email;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Mailbox(String address) {
        this.Address = address;
    }

    @Override
    public void Update(String message) {

        email = new EmailAction();
        email.setBody(message);
        email.setTo(Address.trim());
        email.execute();
        System.out.println("A new mail just dropped in: " + Address);
    }

    @Override
    public String toString() {
        return Address;
    }
}
