/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_tahun;
import intface.intface_tahun;
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
public class implement_tahun extends UnicastRemoteObject implements intface_tahun{
    
    public implement_tahun()throws RemoteException{
        
    }

    @Override
    public entitas_tahun insert(entitas_tahun r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("INSERT INTO `db_pmb`.`tb_tahun` (`thn_ajaran`, `biaya`, `diskon_quis`, `diskon_sekolah`, `undangan`) VALUES (?,?,?,?,?)");
            ps.setString(1, r.getThn_ajaran());
            ps.setInt(2, r.getBiaya_daftar());
            ps.setInt(3, r.getDisk_quis());
            ps.setInt(4, r.getDisk_sekolah());
            ps.setString(5, r.getUndangan());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_tahun.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_tahun r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("UPDATE `db_pmb`.`tb_tahun` SET `biaya` = ?, `diskon_quis` = ?, `diskon_sekolah` = ?, `undangan` = ? WHERE `tb_tahun`.`thn_ajaran` = ?");
            
            ps.setInt(1, r.getBiaya_daftar());
            ps.setInt(2, r.getDisk_quis());
            ps.setInt(3, r.getDisk_sekolah());
            ps.setString(4, r.getUndangan());
            ps.setString(5, r.getThn_ajaran());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_tahun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_tahun where thn_ajaran=?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_tahun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<entitas_tahun> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_tahun");
            List<entitas_tahun>daftar=new ArrayList<entitas_tahun>();
            while(rs.next()){
                entitas_tahun ent = new entitas_tahun();
                ent.setThn_ajaran(rs.getString("thn_ajaran"));
                ent.setBiaya_daftar(rs.getInt("biaya"));
                ent.setDisk_quis(rs.getInt("diskon_quis"));
                ent.setDisk_sekolah(rs.getInt("diskon_sekolah"));
                ent.setUndangan(rs.getString("undangan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_tahun.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_tahun> getby(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_tahun where thn_ajaran=?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_tahun>daftar =new ArrayList<entitas_tahun>();
            while(rs.next()){
                entitas_tahun ent = new entitas_tahun();
                ent.setThn_ajaran(rs.getString("thn_ajaran"));
                ent.setBiaya_daftar(rs.getInt("biaya"));
                ent.setDisk_quis(rs.getInt("diskon_quis"));
                ent.setDisk_sekolah(rs.getInt("diskon_sekolah"));
                ent.setUndangan(rs.getString("undangan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_tahun.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
