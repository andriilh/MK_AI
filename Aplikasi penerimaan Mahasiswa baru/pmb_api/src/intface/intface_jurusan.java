/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_jurusan;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_jurusan extends Remote{
entitas_jurusan insert (entitas_jurusan r)throws RemoteException;
void update (entitas_jurusan r)throws RemoteException;
    List<entitas_jurusan>getall()throws RemoteException;
    void delete (String kd)throws RemoteException;
}
