/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_mgm;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_mgm extends Remote {
    entitas_mgm insert (entitas_mgm r)throws RemoteException;
    void update (entitas_mgm r)throws RemoteException;;
    void delete (String id)throws RemoteException;
    List<entitas_mgm>getall()throws RemoteException;
}
