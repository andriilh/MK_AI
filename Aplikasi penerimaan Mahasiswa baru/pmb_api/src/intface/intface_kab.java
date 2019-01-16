/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_kab;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_kab extends Remote{
    entitas_kab insert (entitas_kab r)throws RemoteException;
    void update (entitas_kab r)throws RemoteException;
    List<entitas_kab>gettall()throws RemoteException;
    entitas_kab get()throws RemoteException;
}
