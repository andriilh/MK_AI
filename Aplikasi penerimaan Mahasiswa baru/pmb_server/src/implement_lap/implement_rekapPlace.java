/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement_lap;

import entity_laporan.lap_kuitansi;
import entity_laporan.lap_rekapInter;
import entity_laporan.lap_rekapPlace;
import intface_lap.intface_lapRekapPlace;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class implement_rekapPlace extends UnicastRemoteObject implements intface_lapRekapPlace{

    public implement_rekapPlace()throws RemoteException{
        
    }
    
    @Override
    public List<lap_rekapPlace> daftarplace() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(petugas_ujian) as jumlah, tb_place.`petugas_ujian`, tb_petugas_ujian.`kd_petugas` , tb_petugas_ujian.`nama` FROM `tb_petugas_ujian` tb_petugas_ujian left JOIN `tb_place` tb_place ON tb_petugas_ujian.`nama` = tb_place.`petugas_ujian` GROUP BY petugas_ujian");
            List<lap_rekapPlace>daftar = new ArrayList<lap_rekapPlace>();
            while(rs.next()){
                lap_rekapPlace lap = new lap_rekapPlace();
                lap.setJumlah(rs.getInt("jumlah"));
                lap.setPetugas_ujian(rs.getString("petugas_ujian"));
                lap.setKd_petugas(rs.getString("kd_petugas"));
                lap.setNama(rs.getString("nama"));
                daftar.add(lap);
            }return daftar;   
        } catch (SQLException ex) {
            Logger.getLogger(implement_rekapPlace.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<lap_rekapInter> daftarInter() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(petugas) AS 'Jumlah_Interview', tb_pewawancara.`kd_pewawancara` AS tb_pewawancara_kd_pewawancara, tb_pewawancara.`nama` AS tb_pewawancara_nama, tb_wawancara.`petugas` AS tb_wawancara_petugas FROM      `tb_pewawancara` tb_pewawancara left JOIN `tb_wawancara` tb_wawancara ON tb_pewawancara.`nama` = tb_wawancara.`petugas`GROUP BY petugas");
            List<lap_rekapInter>daftar=new ArrayList<lap_rekapInter>();
            while(rs.next()){
                lap_rekapInter lap = new lap_rekapInter();
                lap.setJumlah_interview(rs.getInt("Jumlah_Interview"));
                lap.setTb_pewawancara_kd_pewawancara(rs.getString("tb_pewawancara_kd_pewawancara"));
                lap.setTb_pewawancara_nama(rs.getString("tb_pewawancara_nama"));
                lap.setTb_wawancara_petugas(rs.getString("tb_wawancara_petugas"));
                daftar.add(lap);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_rekapPlace.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<lap_kuitansi> kuitansi(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("SELECT no_daftar, nama, tgl, bayar, terbilang FROM tb_pendaftaran WHERE no_daftar = ?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<lap_kuitansi>daftarkuin=new ArrayList<lap_kuitansi>();
            while(rs.next()){
                lap_kuitansi lap = new lap_kuitansi();
                lap.setNo(rs.getString("no_daftar"));
                lap.setNama(rs.getString("nama"));
                lap.setTanggal(rs.getDate("tgl"));
                lap.setJumlah(rs.getInt("bayar"));
                lap.setTerbilang(rs.getString("terbilang"));
                daftarkuin.add(lap);
            }return daftarkuin;
        } catch (SQLException ex) {
            Logger.getLogger(implement_rekapPlace.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
