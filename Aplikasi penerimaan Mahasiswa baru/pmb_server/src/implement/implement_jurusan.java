/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_jurusan;
import intface.intface_jurusan;
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
public class implement_jurusan extends UnicastRemoteObject implements intface_jurusan{
    
    public implement_jurusan()throws RemoteException{
        
    }

    @Override
    public entitas_jurusan insert(entitas_jurusan r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("INSERT INTO  `db_pmb`.`tb_jurusan` (`kd_jurusan` ,`jurusan`)VALUES (?,?)");
            ps.setString(1, r.getKd_jurusan());
            ps.setString(2, r.getJurusan());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_jurusan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

   

    @Override
    public List<entitas_jurusan> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_jurusan");
            List<entitas_jurusan>daftar=new ArrayList<entitas_jurusan>();
            while(rs.next()){
                entitas_jurusan ent = new entitas_jurusan();
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                ent.setJurusan(rs.getString("jurusan"));
                daftar.add(ent);
            }
            return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_jurusan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void update(entitas_jurusan r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_jurusan set jurusan=? where kd_jurusan=?");
            ps.setString(1, r.getJurusan());
            ps.setString(2, r.getKd_jurusan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_jurusan.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void delete(String kd) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_jurusan where kd_jurusan=?");
            ps.setString(1, kd);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_jurusan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
