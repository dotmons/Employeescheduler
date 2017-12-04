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
public interface Subject {
    
    void AddObserver(Observer o);
    void RemoveObserver(Observer o);
    void NotifyObservers();
}
