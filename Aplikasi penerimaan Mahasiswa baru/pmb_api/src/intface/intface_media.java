/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_media;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_media extends Remote {
    entitas_media insert(entitas_media r)throws RemoteException;
    void update (entitas_media r)throws RemoteException;
    List<entitas_media> getall()throws RemoteException;
}
