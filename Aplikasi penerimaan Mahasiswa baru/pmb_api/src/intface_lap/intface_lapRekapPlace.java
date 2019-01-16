/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface_lap;

import entity_laporan.lap_kuitansi;
import entity_laporan.lap_rekapInter;
import entity_laporan.lap_rekapPlace;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_lapRekapPlace extends Remote {
    List<lap_rekapPlace>daftarplace()throws RemoteException;
    List<lap_rekapInter>daftarInter()throws RemoteException;
    List<lap_kuitansi>kuitansi(String no)throws RemoteException;
}
