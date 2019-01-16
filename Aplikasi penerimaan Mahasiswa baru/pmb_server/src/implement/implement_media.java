/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_media;
import intface.intface_media;
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
public class implement_media extends UnicastRemoteObject implements intface_media{
    
    public implement_media()throws RemoteException{
        
    }

    @Override
    public entitas_media insert(entitas_media r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_media (kd_media,media_info) values (?,?)");
            ps.setString(1, r.getKd_media());
            ps.setString(2, r.getMedia_info());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_media.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void update(entitas_media r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_media set media_info =? where kd_media=?");
            ps.setString(1, r.getMedia_info());
            ps.setString(2, r.getKd_media());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_media.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_media> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_media");
            List<entitas_media>daftar= new ArrayList<entitas_media>();
            while(rs.next()){
                entitas_media ent = new entitas_media();
                ent.setKd_media(rs.getString("kd_media"));
                ent.setMedia_info(rs.getString("media_info"));
                daftar.add(ent);
                
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_media.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
