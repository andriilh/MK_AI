/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_kab;
import entity.entitas_sekolah;
import intface.intface_sekolah;
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
public class implement_sekolah extends UnicastRemoteObject implements intface_sekolah{
    
    public implement_sekolah()throws RemoteException{
        
    }

    @Override
    public entitas_sekolah insert(entitas_sekolah r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_sekolah (kd_sekolah,nama,kabupaten)values(?,?,?)");
            ps.setString(1, r.getKd_sekolah());
            ps.setString(2, r.getNama());
            ps.setString(3, r.getKabuaten());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_sekolah.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_sekolah r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_sekolah set nama=?, kabupaten=? where kd_sekolah=?");
            ps.setString(1, r.getNama());
            ps.setString(2, r.getKabuaten());
            ps.setString(3, r.getKd_sekolah());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_sekolah.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String id) throws RemoteException {
        
    }

    @Override
    public List<entitas_sekolah> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
                ResultSet rs = st.executeQuery("select * from tb_sekolah");
                List<entitas_sekolah>daftar = new ArrayList<entitas_sekolah>();
                while(rs.next()){
                    entitas_sekolah ent = new entitas_sekolah();
                    ent.setKd_sekolah(rs.getString("kd_sekolah"));
                    ent.setNama(rs.getString("nama"));
                    ent.setKabuaten(rs.getString("kabupaten"));
                    daftar.add(ent);
                }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_sekolah.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public entitas_sekolah get() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
