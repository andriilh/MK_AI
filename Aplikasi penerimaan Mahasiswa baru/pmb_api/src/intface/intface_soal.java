/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_soal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_soal extends Remote {
    entitas_soal insert (entitas_soal r)throws RemoteException;
    void update (entitas_soal r)throws RemoteException;
    void delete (String kd)throws RemoteException;
    entitas_soal select()throws RemoteException;
    entitas_soal selectby(String kd)throws RemoteException;
    List<entitas_soal>getall()throws RemoteException;
    entitas_soal count()throws RemoteException;
    List<entitas_soal>getby()throws RemoteException;
    List<entitas_soal>getbynosoal(String no)throws RemoteException;
    entitas_soal getbyno(String no)throws RemoteException;
    List<entitas_soal>random()throws RemoteException;
}
