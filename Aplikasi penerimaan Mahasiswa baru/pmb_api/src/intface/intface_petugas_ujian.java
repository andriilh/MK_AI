/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_petugas_ujian;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_petugas_ujian extends Remote{
    entitas_petugas_ujian insert (entitas_petugas_ujian r)throws RemoteException;
    void update (entitas_petugas_ujian r)throws RemoteException;
    void delete (String id)throws RemoteException;
    List<entitas_petugas_ujian>getall()throws RemoteException;
    entitas_petugas_ujian getbyname(String nama)throws RemoteException;
}
