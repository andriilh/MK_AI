/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_inggris;
import intface.intface_inggris;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class implement_inggris extends UnicastRemoteObject implements intface_inggris{
    
    public implement_inggris()throws RemoteException{
        
    }

    @Override
    public entitas_inggris insert(entitas_inggris r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_inggris (no_ujian,no_aplikan,nama,presenter,jur1,jur2,tgl,benar,waktu,grade,petugas)values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, r.getNo_ujian());
            ps.setString(2, r.getNo_aplikan());
            ps.setString(3, r.getNama());
            ps.setString(4, r.getPresenter());
            ps.setString(5, r.getJur1());
            ps.setString(6, r.getJur2());
            ps.setDate(7, new java.sql.Date(r.getTanggal().getTime()));
            ps.setInt(8, r.getBenar());
            ps.setString(9, r.getWaktu());
            ps.setString(10, r.getGrade());
            ps.setString(11, r.getPetugas());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_inggris.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_inggris r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_inggris set no_aplikan=?,nama=?,presenter=?,tgl=?,benar=?,waktu=?,grade=?,petugas=? where no_ujian=?");
            ps.setString(1, r.getNo_aplikan());
            ps.setString(2, r.getNama());
            ps.setString(3, r.getPresenter());
            ps.setString(4, r.getJur1());
            ps.setString(5, r.getJur2());
            ps.setDate(6, new java.sql.Date(r.getTanggal().getTime()));
            ps.setInt(7, r.getBenar());
            ps.setString(8, r.getWaktu());
            ps.setString(9, r.getGrade());
            ps.setString(10, r.getPetugas());
            ps.setString(11, r.getNo_ujian());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_inggris.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_inggris where no_ujian=?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_inggris.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_inggris> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_inggris");
            List<entitas_inggris>daftar=new ArrayList<entitas_inggris>();
            while(rs.next()){
                entitas_inggris ent = new entitas_inggris();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setPresenter(rs.getString("presenter"));
                ent.setJur1(rs.getString("jur1"));
                ent.setJur2(rs.getString("jur2"));
                ent.setTanggal(rs.getDate("tgl"));
                ent.setBenar(rs.getInt("benar"));
                ent.setWaktu(rs.getString("waktu"));
                ent.setGrade(rs.getString("grade"));
                ent.setPetugas(rs.getString("petugas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_inggris.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_inggris> getby(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_inggris where no_ujian=?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_inggris>daftar = new ArrayList<entitas_inggris>();
            while(rs.next()){
                entitas_inggris ent = new entitas_inggris();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setPresenter(rs.getString("presenter"));
                ent.setJur1(rs.getString("jur1"));
                ent.setJur2(rs.getString("jur2"));
                ent.setTanggal(rs.getDate("tgl"));
                ent.setBenar(rs.getInt("benar"));
                ent.setWaktu(rs.getString("waktu"));
                ent.setGrade(rs.getString("grade"));
                ent.setPetugas(rs.getString("petugas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_inggris.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_inggris> getbygrade(String g) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tb_inggris where grade = ?");
            ps.setString(1, g);
            ResultSet rs = ps.executeQuery();
            List<entitas_inggris>daftar=new ArrayList<entitas_inggris>();
            while(rs.next()){
                entitas_inggris ent = new entitas_inggris();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setPresenter(rs.getString("presenter"));
                ent.setJur1(rs.getString("jur1"));
                ent.setJur2(rs.getString("jur2"));
                ent.setTanggal(rs.getDate("tgl"));
                ent.setBenar(rs.getInt("benar"));
                ent.setWaktu(rs.getString("waktu"));
                ent.setGrade(rs.getString("grade"));
                ent.setPetugas(rs.getString("petugas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_inggris.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_inggris> getbytgl(java.util.Date tgl) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tb_inggris where tgl = ?");
            ps.setDate(1, new java.sql.Date(tgl.getTime()));
            ResultSet rs = ps.executeQuery();
            List<entitas_inggris>daftar=new ArrayList<entitas_inggris>();
            while(rs.next()){
                entitas_inggris ent = new entitas_inggris();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setPresenter(rs.getString("presenter"));
                ent.setJur1(rs.getString("jur1"));
                ent.setJur2(rs.getString("jur2"));
                ent.setTanggal(rs.getDate("tgl"));
                ent.setBenar(rs.getInt("benar"));
                ent.setWaktu(rs.getString("waktu"));
                ent.setGrade(rs.getString("grade"));
                ent.setPetugas(rs.getString("petugas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_inggris.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
