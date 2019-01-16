/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_login;
import intface.inface_cekLogin;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class implement_cekLogin extends UnicastRemoteObject implements inface_cekLogin{
    
    public implement_cekLogin()throws RemoteException{
        
    }

    @Override
    public entitas_login login(String id, String pass) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_login where id_user=? and pass=?");
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            entitas_login ent = new entitas_login();
            while(rs.next()){
                ent.setId(rs.getString("id_user"));
                ent.setPass(rs.getString("pass"));
                ent.setStatus(rs.getString("status"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_cekLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
