/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface_lap;

import entity_laporan.lap_aplikanPerpresenter;
import entity_laporan.lap_grading;
import entity_laporan.lap_grafikMedia;
import entity_laporan.lap_kartuUjian;
import entity_laporan.lap_kuitansi;
import entity_laporan.lap_pengumuman_lulus;
import entity_laporan.lap_rekapMgm;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import java.util.List;

/**
 *
 * @author radhial22
 */
public interface Intface_laporan extends Remote{
    List<lap_aplikanPerpresenter>aplikanPerpresenter(String pre)throws RemoteException;
    List<lap_kuitansi>kuitansi(String kuin)throws RemoteException;
    List<lap_kartuUjian>kartuUjian(String nokar)throws RemoteException;
    List<lap_grading>grading(String Jur)throws RemoteException;
    List<lap_pengumuman_lulus>pengumumanlulus(Date tgl1, Date tgl2)throws RemoteException;
    List<lap_rekapMgm>rekapMgm()throws RemoteException;
    List<lap_grafikMedia>grafikMedia()throws RemoteException;
}

