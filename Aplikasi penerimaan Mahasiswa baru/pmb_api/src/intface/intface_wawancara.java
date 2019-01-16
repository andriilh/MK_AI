/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_wawancara;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_wawancara extends Remote {
    entitas_wawancara insert (entitas_wawancara r)throws RemoteException;
    void update (entitas_wawancara r)throws RemoteException;
    void delete (String no)throws RemoteException;
    List<entitas_wawancara>getall()throws RemoteException;
    List<entitas_wawancara>getby(String no)throws RemoteException;
}
