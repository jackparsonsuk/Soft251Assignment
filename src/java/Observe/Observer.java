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
public interface Observer {

    /**
     * Update all observers
     * @param stock
     * @param ID
     */
    public void update(int stock, String ID);
}
