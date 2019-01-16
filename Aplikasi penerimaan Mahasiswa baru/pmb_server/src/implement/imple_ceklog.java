/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import com.sun.crypto.provider.RSACipher;
import entity.entitas_login;
import intface.inface_ceklog;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class imple_ceklog extends UnicastRemoteObject implements inface_ceklog{
    
    public imple_ceklog()throws RemoteException{
        
    }

    @Override
    public String loginLevel(Connection cenn, entitas_login ent) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String logIn(entitas_login ent) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    @Override
//    public entitas_login gett() throws RemoteException {
//        Statement st = conn.getcekkoneksi().createStatement();
//        ResultSet rs = st.executeQuery("select * from tb_login where id_user=? and pass = ?")
//    }

    @Override
    public entitas_login gett(String id, String pass) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_login where id_user =? and pass=?");
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            entitas_login ent = new entitas_login();
            while(rs.next()){
                ent.setId(rs.getString("id_user"));
                ent.setPass(rs.getString("pass"));
                ent.setStatus(rs.getString("status"));
                
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(imple_ceklog.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
