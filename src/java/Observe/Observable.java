/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observe;

/**
 *
 * @author Jack
 */
public interface Observable {

    /**
     * Register an observer
     * @param o
     */
    public void registerObserver(Observer o);

    /**
     * Remove an observer
     * @param o
     */
    public void removeObserver(Observer o);

    /**
     * Notify all observers
     */
    public void notifyObserver();
}
