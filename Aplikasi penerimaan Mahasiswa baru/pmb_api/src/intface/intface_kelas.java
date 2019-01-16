/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_kelas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_kelas extends Remote {
    entitas_kelas insert (entitas_kelas r)throws RemoteException;
    void update (entitas_kelas r)throws RemoteException;
    void delete (String no)throws RemoteException;
    List<entitas_kelas>getall()throws RemoteException;
    List<entitas_kelas>getby(String no)throws RemoteException;
}
