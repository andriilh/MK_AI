/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_login;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_login extends Remote{
    entitas_login insert (entitas_login r)throws RemoteException;
    void update (entitas_login r)throws RemoteException;
    void delete (String id)throws RemoteException;
    List<entitas_login>getall()throws RemoteException;
    entitas_login get()throws RemoteException;
}
