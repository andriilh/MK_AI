/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_place;
import intface.intface_place;
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
import javax.naming.spi.DirStateFactory;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class implement_place extends UnicastRemoteObject implements intface_place{
    
    public implement_place()throws RemoteException{
        
    }

    @Override
    public entitas_place insert(entitas_place r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("insert into tb_place (no_ujian,no_aplikan,nama,tgl,jurusan1,jurusan2,test_ke1,waktu1,test_ke2,waktu2,test_ke3,waktu3,petugas_ujian)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, r.getNo_ujian());
            ps.setString(2, r.getNo_aplikan());
            ps.setString(3, r.getNama());
            ps.setDate(4, new java.sql.Date(r.getTgl().getTime()));
            ps.setString(5, r.getJur1());
            ps.setString(6, r.getJur2());
            ps.setString(7, r.getTestke1());
            ps.setString(8, r.getWaktu1());
            ps.setString(9, r.getTestke2());
            ps.setString(10, r.getWaktu2());
            ps.setString(11, r.getTestke3());
            ps.setString(12, r.getWaktu3());
            ps.setString(13, r.getPetugas());
            ps.executeUpdate();
            return r;
            
        } catch (SQLException ex) {
            Logger.getLogger(implement_place.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void update(entitas_place r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_place set no_aplikan=?, nama=?, tgl=?, jurusan1=?, jurusan2=?, test_ke1=?,waktu1=?,test_ke2=?,waktu2=?,test_ke3=?,waktu3=?, petugas_ujian=? where no_ujian=?");
            ps.setString(1, r.getNo_aplikan());
            ps.setString(2, r.getNama());
            ps.setDate(3, new java.sql.Date(r.getTgl().getTime()));
            ps.setString(4, r.getJur1());
            ps.setString(5, r.getJur2());
            ps.setString(6, r.getTestke1());
            ps.setString(7, r.getWaktu1());
            ps.setString(8, r.getTestke2());
            ps.setString(9, r.getWaktu2());
            ps.setString(10, r.getTestke3());
            ps.setString(11, r.getWaktu3());
            ps.setString(12, r.getPetugas());
            ps.setString(13, r.getNo_ujian());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_place.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("delete from tb_place where no_ujian = ?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_place.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_place> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_place");
            List<entitas_place>daftar=new ArrayList<entitas_place>();
            while(rs.next()){
                entitas_place ent = new entitas_place();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTgl(rs.getDate("tgl"));
                ent.setJur1(rs.getString("jurusan1"));
                ent.setJur2(rs.getString("jurusan2"));
                ent.setTestke1(rs.getString("test_ke1"));
                ent.setWaktu1(rs.getString("waktu1"));
                ent.setTestke2(rs.getString("test_ke2"));
                ent.setWaktu2(rs.getString("waktu2"));
                ent.setTestke3(rs.getString("test_ke3"));
                ent.setWaktu3(rs.getString("waktu3"));
                ent.setPetugas(rs.getString("petugas_ujian"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_place.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_place> getby(String no) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tb_place where no_ujian =?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_place>daftar=new ArrayList<entitas_place>();
            while(rs.next()){
                entitas_place ent = new entitas_place();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTgl(rs.getDate("tgl"));
                ent.setJur1(rs.getString("jurusan1"));
                ent.setJur2(rs.getString("jurusan2"));
                ent.setTestke1(rs.getString("test_ke1"));
                ent.setWaktu1(rs.getString("waktu1"));
                ent.setTestke2(rs.getString("test_ke2"));
                ent.setWaktu2(rs.getString("waktu2"));
                ent.setTestke3(rs.getString("test_ke3"));
                ent.setWaktu3(rs.getString("waktu3"));
                ent.setPetugas(rs.getString("petugas_ujian"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_place.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
