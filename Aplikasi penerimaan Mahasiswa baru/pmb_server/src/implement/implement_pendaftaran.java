/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_pendaftaran;
import entity.entitas_registrasi;
import intface.intface_pendaftaran;
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
public class implement_pendaftaran extends UnicastRemoteObject implements intface_pendaftaran{
    
    public implement_pendaftaran()throws RemoteException{
        
    }

    @Override
    public entitas_pendaftaran insert(entitas_pendaftaran r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_pendaftaran(no_daftar,no_aplikan,no_ujian,nama,tgl,thn_ajaran,biaya,tipe_diskon,diskon,bayar,terbilang)values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, r.getNo_daftar());
            ps.setString(2, r.getNo_aplikan());
            ps.setString(3, r.getNo_ujian());
            ps.setString(4, r.getNama());
            ps.setDate(5, new java.sql.Date(r.getTgl().getTime()));
            ps.setString(6, r.getThn_ajaran());
            ps.setInt(7, r.getBiaya());
            ps.setString(8, r.getTipe_diskon());
            ps.setInt(9, r.getDiskon());
            ps.setInt(10, r.getBayar());
            ps.setString(11, r.getTerbilang());
            ps.executeUpdate();
            
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    
    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_pendaftaran where no_daftar=?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_pendaftaran> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_pendaftaran");
            List<entitas_pendaftaran>daftar=new ArrayList<entitas_pendaftaran>();
            while(rs.next()){
                entitas_pendaftaran ent = new entitas_pendaftaran();
                ent.setNo_daftar(rs.getString("no_daftar"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNama(rs.getString("nama"));
                ent.setTgl(rs.getDate("tgl"));
                ent.setThn_ajaran(rs.getString("thn_ajaran"));
                ent.setBiaya(rs.getInt("biaya"));
                ent.setTipe_diskon(rs.getString("tipe_diskon"));
                ent.setDiskon(rs.getInt("diskon"));
                ent.setBayar(rs.getInt("bayar"));
                ent.setTerbilang(rs.getString("terbilang"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_pendaftaran> getby(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_pendaftaran where no_daftar =?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_pendaftaran>daftar = new ArrayList<entitas_pendaftaran>();
            while(rs.next()){
                entitas_pendaftaran ent = new entitas_pendaftaran();
                ent.setNo_daftar(rs.getString("no_daftar"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNama(rs.getString("nama"));
                ent.setTgl(rs.getDate("tgl"));
                ent.setThn_ajaran(rs.getString("thn_ajaran"));
                ent.setBiaya(rs.getInt("biaya"));
                ent.setTipe_diskon(rs.getString("tipe_diskon"));
                ent.setDiskon(rs.getInt("diskon"));
                ent.setBayar(rs.getInt("bayar"));
                ent.setTerbilang(rs.getString("terbilang"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public entitas_pendaftaran getbyno(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_pendaftaran where no_ujian=?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            entitas_pendaftaran ent = new entitas_pendaftaran();
            while(rs.next()){
                 ent.setNo_daftar(rs.getString("no_daftar"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNama(rs.getString("nama"));
                ent.setTgl(rs.getDate("tgl"));
                ent.setThn_ajaran(rs.getString("thn_ajaran"));
                ent.setBiaya(rs.getInt("biaya"));
                ent.setTipe_diskon(rs.getString("tipe_diskon"));
                ent.setDiskon(rs.getInt("diskon"));
                ent.setBayar(rs.getInt("bayar"));
                ent.setTerbilang(rs.getString("terbilang"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void update(entitas_pendaftaran r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_pendaftaran set no_aplikan=?,no_ujian=?,nama=?,tgl=?,thn_ajaran=?,biaya=?,tipe_diskon=?,diskon=?,bayar=?,terbilang=? where no_daftar=?");
            ps.setString(1, r.getNo_aplikan());
            ps.setString(2, r.getNo_ujian());
            ps.setString(3, r.getNama());
            ps.setDate(4, new java.sql.Date(r.getTgl().getTime()));
            ps.setString(5, r.getThn_ajaran());
            ps.setInt(6, r.getBiaya());
            ps.setString(7, r.getTipe_diskon());
            ps.setInt(8, r.getDiskon());
            ps.setInt(9, r.getBayar());
            ps.setString(10, r.getTerbilang());
            ps.setString(11, r.getNo_daftar());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
