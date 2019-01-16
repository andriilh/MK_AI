/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_petugas_ujian;
import intface.intface_petugas_ujian;
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
public class implement_petugas_ujian extends UnicastRemoteObject implements intface_petugas_ujian{
    
    public implement_petugas_ujian()throws RemoteException{
        
    }

    @Override
    public entitas_petugas_ujian insert(entitas_petugas_ujian r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_petugas_ujian (kd_petugas,nama,no_hp)values(?,?,?)");
            ps.setString(1, r.getKd_petugas());
            ps.setString(2, r.getNama());
            ps.setString(3, r.getNo_hp());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_petugas_ujian.class.getName()).log(Level.SEVERE, null, ex);
            return  null;
        }
    }

    @Override
    public void update(entitas_petugas_ujian r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_petugas_ujian set nama=?,no_hp=? where kd_petugas=?");
            ps.setString(1, r.getNama());
            ps.setString(2, r.getNo_hp());
            ps.setString(3, r.getKd_petugas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_petugas_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void delete(String id) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_petugas_ujian where kd_petugas =?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_petugas_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_petugas_ujian> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_petugas_ujian");
            List<entitas_petugas_ujian>daftar=new ArrayList<entitas_petugas_ujian>();
            while(rs.next()){
                entitas_petugas_ujian ent = new entitas_petugas_ujian();
                ent.setKd_petugas(rs.getString("kd_petugas"));
                ent.setNama(rs.getString("nama"));
                ent.setNo_hp(rs.getString("no_hp"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_petugas_ujian.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public entitas_petugas_ujian getbyname(String nama) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_petugas_ujian where nama = ?");
            ps.setString(1, nama);
            ResultSet rs =ps.executeQuery();
            entitas_petugas_ujian ent = new entitas_petugas_ujian();
            while(rs.next()){
                ent.setKd_petugas(rs.getString("kd_petugas"));
                ent.setNama(rs.getString("nama"));
                ent.setNo_hp(rs.getString("no_hp"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_petugas_ujian.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
}
