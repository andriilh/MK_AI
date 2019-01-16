/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_registrasi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_registrasi extends Remote {
    entitas_registrasi insert(entitas_registrasi r)throws RemoteException;
    void update(entitas_registrasi r)throws RemoteException;
    void delete (String no)throws RemoteException;
    List<entitas_registrasi>getall()throws RemoteException;
    List<entitas_registrasi>getby(String no)throws RemoteException;
}
