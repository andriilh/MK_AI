/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_inggris;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_inggris extends Remote{
    entitas_inggris insert (entitas_inggris r)throws RemoteException;
    void update (entitas_inggris r)throws RemoteException;
    void delete (String no)throws RemoteException;
    List<entitas_inggris>getall()throws RemoteException;
    List<entitas_inggris>getbygrade(String g)throws RemoteException;
    List<entitas_inggris>getby(String no)throws RemoteException;
    List<entitas_inggris>getbytgl(Date tgl)throws RemoteException;
}
