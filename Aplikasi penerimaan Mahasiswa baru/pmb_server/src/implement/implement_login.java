/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_login;
import intface.intface_login;
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
public class implement_login extends UnicastRemoteObject implements intface_login{
    
    public implement_login()throws RemoteException{
        
    }

    @Override
    public entitas_login insert(entitas_login r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_login (id_user,pass,status)values(?,?,?)");
            ps.setString(1, r.getId());
            ps.setString(2, r.getPass());
            ps.setString(3, r.getStatus());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_login.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_login r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_login set pass=?, status=? where id_user=?");
            ps.setString(1, r.getPass());
            ps.setString(2, r.getStatus());
            ps.setString(3, r.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_login where id_user =?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_login> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_login");
            List<entitas_login>daftar=new ArrayList<entitas_login>();
            while(rs.next()){
                entitas_login ent =new entitas_login();
                ent.setId(rs.getString("id_user"));
                ent.setPass(rs.getString("pass"));
                ent.setStatus(rs.getString("status"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_login.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public entitas_login get() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
