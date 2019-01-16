/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_kab;
import intface.intface_kab;
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
public class implement_kab extends UnicastRemoteObject implements intface_kab{
    
    public implement_kab() throws RemoteException{
        
    }

    @Override
    public entitas_kab insert(entitas_kab r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_kab (kd_kab,kabupaten) values (?,?)");
            ps.setString(1, r.getKd_kab());
            ps.setString(2, r.getKabupaten());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_kab.class.getName()).log(Level.SEVERE, null, ex);
            return  null;
        }
        
    }

  

    @Override
    public List<entitas_kab> gettall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_kab");
            List<entitas_kab>daftar = new ArrayList<entitas_kab>();
            while(rs.next()){
                 entitas_kab ent = new entitas_kab();
                 ent.setKd_kab(rs.getString("kd_kab"));
                 ent.setKabupaten(rs.getString("kabupaten"));
                 daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_kab.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_kab r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_kab set kabupaten=? where kd_kab=?");
            ps.setString(1, r.getKabupaten());
            ps.setString(2, r.getKd_kab());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_kab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public entitas_kab get() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    
}
