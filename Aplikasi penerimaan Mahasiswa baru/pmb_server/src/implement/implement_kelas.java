/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_kelas;
import intface.intface_kelas;
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
public class implement_kelas extends UnicastRemoteObject implements intface_kelas{
    
    public implement_kelas()throws RemoteException{
        
    }

    @Override
    public entitas_kelas insert(entitas_kelas r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_kelas(kd_kelas,kelas,jumlah_siswa)values(?,?,?)");
            ps.setString(1, r.getKd_kelas());
            ps.setString(2, r.getKelas());
            ps.setInt(3, r.getJumlahSiswa());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_kelas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_kelas r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_kelas set kelas=?, jumlah_siswa=? where kd_kelas=?");
            ps.setString(1, r.getKelas());
            ps.setInt(2, r.getJumlahSiswa());
            ps.setString(3, r.getKd_kelas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_kelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_kelas where kd_kelas=?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_kelas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<entitas_kelas> getall() throws RemoteException {
        try {
            Statement st =conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_kelas");
            List<entitas_kelas>daftar = new ArrayList<entitas_kelas>();
            while(rs.next()){
                entitas_kelas ent = new entitas_kelas();
                ent.setKd_kelas(rs.getString("kd_kelas"));
                ent.setKelas(rs.getString("kelas"));
                ent.setJumlahSiswa(rs.getInt("jumlah_siswa"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_kelas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_kelas> getby(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_kelas where kd_kelas=?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_kelas>daftar=new ArrayList<entitas_kelas>();
            while(rs.next()){
                entitas_kelas ent = new entitas_kelas();
                ent.setKd_kelas(rs.getString("kd_kelas"));
                ent.setKelas(rs.getString("kelas"));
                ent.setJumlahSiswa(rs.getInt("jumlah_siswa"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_kelas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
