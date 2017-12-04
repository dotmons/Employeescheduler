/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.observer;

import employee.interfaces.Observer;
import employee.interfaces.Subject;
import java.util.ArrayList;

/**
 *
 * @author Dotmons
 */
public class PostOffice implements Subject{

    String Message;
    public ArrayList<Observer> observers;
    
    
    public PostOffice(String message)
    {
        super();
        this.Message = message;
        observers = new ArrayList<>();        
    }
    
    public void newMail()
    {
        NotifyObservers();
    }
    
    @Override
    public void AddObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void RemoveObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void NotifyObservers() {
        observers.stream().forEach((observer) -> {
            observer.Update(Message);
            
        });
    }
    
    
}
