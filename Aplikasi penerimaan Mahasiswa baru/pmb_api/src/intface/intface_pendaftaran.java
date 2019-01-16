/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_pendaftaran;
import entity.entitas_registrasi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_pendaftaran extends Remote {
    entitas_pendaftaran insert(entitas_pendaftaran r)throws RemoteException;
    void update (entitas_pendaftaran r)throws RemoteException;
    void delete (String no)throws RemoteException;
    List<entitas_pendaftaran>getall()throws RemoteException;
    List<entitas_pendaftaran>getby(String no)throws RemoteException;
    entitas_pendaftaran getbyno(String no)throws RemoteException;
}
