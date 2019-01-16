/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_pewawancara;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_pewawancara extends Remote {
    entitas_pewawancara insert(entitas_pewawancara r)throws RemoteException;
    void update (entitas_pewawancara r)throws RemoteException;
    void delete (String id)throws RemoteException;
    List<entitas_pewawancara>getall()throws RemoteException;
}
