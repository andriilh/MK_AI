/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_tahun;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_tahun extends Remote{
    entitas_tahun insert (entitas_tahun r)throws RemoteException;
    void update (entitas_tahun r)throws RemoteException;
    void delete (String no)throws RemoteException;
    List<entitas_tahun>getall()throws RemoteException;
    List<entitas_tahun>getby(String no)throws RemoteException;
}
