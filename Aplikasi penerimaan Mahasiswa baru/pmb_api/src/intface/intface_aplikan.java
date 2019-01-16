/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_aplikan;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_aplikan extends Remote{
    entitas_aplikan insert (entitas_aplikan r)throws RemoteException;
    void update (entitas_aplikan r)throws RemoteException;
    void delete(String no)throws RemoteException;
    List<entitas_aplikan>getlist()throws RemoteException;
    List<entitas_aplikan>getByno(String no)throws RemoteException;
    entitas_aplikan getBy(String no)throws RemoteException;
    List<entitas_aplikan>stat()throws RemoteException;
    List<entitas_aplikan>statdafsudah()throws RemoteException;
    List<entitas_aplikan>reg()throws RemoteException;
    List<entitas_aplikan>regsudah()throws RemoteException;
    List<entitas_aplikan>ujbelum()throws RemoteException;
    List<entitas_aplikan>ujsudah()throws RemoteException;
    List<entitas_aplikan>getbytgl(Date tgl)throws RemoteException;
    List<entitas_aplikan>getbytglbetween(Date tgl1,Date tgl2)throws RemoteException;
    void updatedaf(entitas_aplikan r)throws RemoteException;
    void updatedafre(entitas_aplikan r)throws RemoteException;
    void updateregre(entitas_aplikan r)throws RemoteException;
    void updatereg(entitas_aplikan r)throws RemoteException;
    void updatenoUjian(entitas_aplikan r)throws RemoteException;
    entitas_aplikan getbynoujian(String noujian)throws RemoteException;
    entitas_aplikan no_aplikan()throws RemoteException;
    void updateUj(entitas_aplikan r)throws RemoteException;
    void updateUjre(entitas_aplikan r)throws RemoteException;
    
}
