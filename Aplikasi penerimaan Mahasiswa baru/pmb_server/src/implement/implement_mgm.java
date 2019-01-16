/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_mgm;
import intface.intface_mgm;
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
public class implement_mgm extends UnicastRemoteObject implements intface_mgm{
    
    public implement_mgm()throws RemoteException{
        
    }

    @Override
    public entitas_mgm insert(entitas_mgm r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_mgm (kd_mgm,nama)values(?,?)");
            ps.setString(1, r.getKd_mgm());
            ps.setString(2, r.getNama());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_mgm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void update(entitas_mgm r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_mgm set nama =? where kd_mgm=?");
            ps.setString(1, r.getNama());
            ps.setString(2, r.getKd_mgm());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_mgm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String id) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_mgm where kd_mgm =?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_mgm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_mgm> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_mgm");
            List<entitas_mgm>daftar=new ArrayList<entitas_mgm>();
            while(rs.next()){
                entitas_mgm ent = new entitas_mgm();
                ent.setKd_mgm(rs.getString("kd_mgm"));
                ent.setNama(rs.getString("nama"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_mgm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
