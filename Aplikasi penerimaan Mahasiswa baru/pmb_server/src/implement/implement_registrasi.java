/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_registrasi;
import intface.intface_registrasi;
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
public class implement_registrasi extends UnicastRemoteObject implements intface_registrasi{
    
    public implement_registrasi()throws RemoteException{
        
    }

    @Override
    public entitas_registrasi insert(entitas_registrasi r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_registrasi (no_regis,no_aplikan,nama,tgl,kelas)values(?,?,?,?,?)");
            ps.setString(1, r.getNo_regis());
            ps.setString(2, r.getNo_aplikan());
            ps.setString(3, r.getNama());
            ps.setDate(4, new java.sql.Date(r.getTgl().getTime()));
            ps.setString(5, r.getKls());
            ps.executeUpdate();
           return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_registrasi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

  
    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_registrasi where no_regis =?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_registrasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<entitas_registrasi> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_registrasi");
            List<entitas_registrasi>daftar=new ArrayList<entitas_registrasi>();
            while(rs.next()){
                entitas_registrasi ent = new entitas_registrasi();
                ent.setNo_regis(rs.getString("no_regis"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTgl(rs.getDate("tgl"));
                ent.setKls(rs.getString("kelas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_registrasi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
             
    }

    @Override
    public List<entitas_registrasi> getby(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_registrasi where kd_regis=?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_registrasi>daftar=new ArrayList<entitas_registrasi>();
            while(rs.next()){
                entitas_registrasi ent = new entitas_registrasi();
                ent.setNo_regis(rs.getString("no_regis"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTgl(rs.getDate("tgl"));
                ent.setKls(rs.getString("kelas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_registrasi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_registrasi r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_registrasi set no_aplikan=?,nama=?,tgl=?,kelas=? where no_regis=?");
            ps.setString(1, r.getNo_aplikan());
            ps.setString(2, r.getNama());
            ps.setDate(3, new java.sql.Date(r.getTgl().getTime()));
            ps.setString(4, r.getKls());
            ps.setString(5, r.getNo_regis());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_registrasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
