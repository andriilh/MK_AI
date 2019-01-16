/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_place;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_place extends Remote {
    entitas_place insert (entitas_place r)throws RemoteException;
    void update (entitas_place r)throws RemoteException;
    void delete (String no)throws RemoteException;
    List<entitas_place>getall()throws RemoteException;
    List<entitas_place>getby(String no)throws RemoteException;
}
