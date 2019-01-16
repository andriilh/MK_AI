/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement_lap;

import entity_laporan.*;
import intface_lap.Intface_laporan;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class implement_laporan extends UnicastRemoteObject implements Intface_laporan{
    public implement_laporan()throws RemoteException{
        
    }

    @Override
    public List<lap_aplikanPerpresenter> aplikanPerpresenter(String pre) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("SELECT tb_aplikan.nama,tb_aplikan.hp, tb_aplikan.tgl_datang, tb_aplikan.tahun_ajaran,tb_aplikan.presenter, tb_pendaftaran.tgl, tb_inggris.tgl, tb_wawancara.jurusan, tb_registrasi.tgl from tb_aplikan, tb_pendaftaran, tb_wawancara, tb_inggris, tb_registrasi where tb_aplikan.presenter = ? group by tb_aplikan.nmr_aplikan");
            ps.setString(1, pre);
            ResultSet rs = ps.executeQuery();
            List<lap_aplikanPerpresenter>daftar = new ArrayList<lap_aplikanPerpresenter>();
            while(rs.next()){
                lap_aplikanPerpresenter lap = new lap_aplikanPerpresenter();
                lap.setNama(rs.getString("nama"));
                lap.setHp(rs.getInt("hp"));
                lap.setTgl_datang(rs.getDate("tgl_datang"));
                lap.setTahun_ajaran(rs.getString("tahun_ajaran"));
                lap.setTgl_daftar(rs.getDate("tgl"));
                lap.setTgl_ujian(rs.getDate("tgl"));
                lap.setJurusan(rs.getString("jurusan"));
                lap.setTgl_reg(rs.getDate("tgl"));
                lap.setPresenter(rs.getString("presenter"));
                daftar.add(lap);
            } return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_laporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<lap_kuitansi> kuitansi(String kuin) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("SELECT no_daftar, nama, tgl, bayar, terbilang FROM tb_pendaftaran WHERE no_daftar = ?");
            ps.setString(1, kuin);
            ResultSet rs =ps.executeQuery();
            List<lap_kuitansi>daftar=new ArrayList<lap_kuitansi>();
            while(rs.next()){
                lap_kuitansi lap = new lap_kuitansi();
                lap.setNo(rs.getString("no_daftar"));
                lap.setNama(rs.getString("nama"));
                lap.setTanggal(rs.getDate("tgl"));
                lap.setJumlah(rs.getInt("bayar"));
                lap.setTerbilang(rs.getString("terbilang"));
                daftar.add(lap);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_laporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<lap_kartuUjian> kartuUjian(String nokar) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("SELECT no_ujian, nama FROM tb_pendaftaran WHERE no_ujian =?");
            ps.setString(1, nokar);
            ResultSet rs =ps.executeQuery();
            List<lap_kartuUjian>daftar=new ArrayList<lap_kartuUjian>();
            while(rs.next()){
                lap_kartuUjian ent = new lap_kartuUjian();
                ent.setNo(rs.getString("no_ujian"));
                ent.setNama(rs.getString("nama"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_laporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<lap_grading> grading(String Jur) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("SELECT tb_inggris.`no_ujian` AS tb_inggris_no_ujian, tb_wawancara.`no_ujian` AS tb_wawancara_no_ujian, tb_inggris.`jur1` AS tb_inggris_jur1, tb_inggris.`nama` AS tb_inggris_nama, tb_inggris.`grade` AS tb_inggris_grade FROM `tb_wawancara` tb_wawancara INNER JOIN `tb_inggris` tb_inggris ON tb_wawancara.`no_ujian` = tb_inggris.`no_ujian` WHERE tb_inggris.jur1 = ?");
            ps.setString(1, Jur);
            ResultSet rs =ps.executeQuery();
            List<lap_grading>daftar=new ArrayList<lap_grading>();
            while(rs.next()){
                lap_grading ent = new lap_grading();
                ent.setGrade(rs.getString("tb_inggris_grade"));
                ent.setJur(rs.getString("tb_inggris_jur1"));
                ent.setNama(rs.getString("tb_inggris_nama"));
                ent.setTb_ing_noujian(rs.getString("tb_inggris_no_ujian"));
                ent.setTb_wawan_noujian("tb_wawancara_no_ujian");
                daftar.add(ent);
            }
            return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_laporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    

    @Override
    public List<lap_pengumuman_lulus> pengumumanlulus(Date tgl1, Date tgl2) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("SELECT tb_inggris.`no_ujian` AS tb_inggris_no_ujian, tb_inggris.`tgl` AS tb_inggris_tgl, tb_inggris.`grade` AS tb_inggris_grade, tb_wawancara.`no_ujian` AS tb_wawancara_no_ujian, tb_wawancara.`no_aplikan` AS tb_wawancara_no_aplikan, tb_wawancara.`nama` AS tb_wawancara_nama, tb_wawancara.`jurusan` AS tb_wawancara_jurusan FROM `tb_inggris` tb_inggris INNER JOIN `tb_wawancara` tb_wawancara ON tb_inggris.`no_ujian` = tb_wawancara.`no_ujian` where tb_inggris.tgl between ? and ?");
            ps.setDate(1, new java.sql.Date(tgl1.getTime()));
            ps.setDate(2, new java.sql.Date(tgl2.getTime()));
            ResultSet rs = ps.executeQuery();
            List<lap_pengumuman_lulus>daftar = new ArrayList<lap_pengumuman_lulus>();
            while(rs.next()){
                lap_pengumuman_lulus lap = new lap_pengumuman_lulus();
                lap.setTb_inggris_no_ujian(rs.getString("tb_inggris_no_ujian"));
                lap.setTb_inggris_tgl(rs.getDate("tb_inggris_tgl"));
                lap.setTb_inggris_grade(rs.getString("tb_inggris_grade"));
                lap.setTb_wawancara_no_ujian(rs.getString("tb_wawancara_no_ujian"));
                lap.setTb_wawancara_no_aplikan(rs.getString("tb_wawancara_no_aplikan"));
                lap.setTb_wawancara_nama(rs.getString("tb_wawancara_nama"));
                lap.setTb_wawancara_jurusan(rs.getString("tb_wawancara_jurusan"));
                lap.setTgl1(new java.sql.Date(tgl1.getTime()));
                lap.setTgl2(new java.sql.Date(tgl2.getTime()));
                daftar.add(lap);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_laporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<lap_rekapMgm> rekapMgm() throws RemoteException {
        try {
            Statement st =conn.getcekkoneksi().createStatement();
            ResultSet rs=st.executeQuery("SELECT COUNT(tb_aplikan.mgm) as jumlah, tb_aplikan.mgm, tb_mgm.`kd_mgm` , tb_mgm.`nama` FROM `tb_mgm` tb_mgm left JOIN `tb_aplikan` tb_aplikan ON tb_mgm.`nama` = tb_aplikan.`mgm` GROUP BY mgm");
            List<lap_rekapMgm>daftar = new ArrayList<lap_rekapMgm>();
            while(rs.next()){
                lap_rekapMgm lap = new lap_rekapMgm();
                lap.setJumlah(rs.getInt("jumlah"));
                lap.setMgm(rs.getString("mgm"));
                lap.setKd_mgm(rs.getString("kd_mgm"));
                lap.setNama(rs.getString("nama"));
                daftar.add(lap);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_laporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<lap_grafikMedia> grafikMedia() throws RemoteException {
        try {
            Statement st =conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(tb_aplikan.sumber_info) as jumlah, tb_aplikan.`sumber_info`, tb_media.`kd_media` , tb_media.`media_info` FROM `tb_media` tb_media left JOIN `tb_aplikan` tb_aplikan ON tb_media.`media_info` = tb_aplikan.`sumber_info` GROUP BY tb_aplikan.sumber_info");
            List<lap_grafikMedia>daftar=new ArrayList<lap_grafikMedia>();
            while(rs.next()){
                lap_grafikMedia lap = new lap_grafikMedia();
                lap.setJumlah(rs.getInt("jumlah"));
                lap.setSumber_info(rs.getString("sumber_info"));
                lap.setKd_media(rs.getString("kd_media"));
                lap.setMedia_info(rs.getString("media_info"));
                daftar.add(lap);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_laporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }


   
}
