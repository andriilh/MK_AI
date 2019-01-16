/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_lapSuratLulus;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_suratLulus extends Remote {
    List<entitas_lapSuratLulus>daftar(String no)throws RemoteException;
}
