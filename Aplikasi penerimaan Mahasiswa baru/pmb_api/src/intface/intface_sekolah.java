/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_sekolah;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_sekolah extends Remote{
    entitas_sekolah insert (entitas_sekolah r)throws RemoteException;
    void update (entitas_sekolah r)throws RemoteException;
    void delete (String id)throws RemoteException;
    List<entitas_sekolah>getall ()throws RemoteException;
    entitas_sekolah get()throws RemoteException;
}
