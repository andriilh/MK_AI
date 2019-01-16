/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_pewawancara;
import intface.intface_pewawancara;
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
public class implement_pewawancara extends UnicastRemoteObject implements intface_pewawancara{
    
    public implement_pewawancara()throws RemoteException{
        
    }

    @Override
    public entitas_pewawancara insert(entitas_pewawancara r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("insert into tb_pewawancara(kd_pewawancara,nama,no_hp)values(?,?,?)");
            ps.setString(1, r.getKd_pw());
            ps.setString(2, r.getNama());
            ps.setString(3, r.getNo_hp());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_pewawancara.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_pewawancara r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_pewawancara set nama = ?, no_hp=? where kd_pewawancara=?");
            ps.setString(1, r.getNama());
            ps.setString(2, r.getNo_hp());
            ps.setString(3, r.getKd_pw());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_pewawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String id) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("delete from tb_pewawancara where kd_pewawancara =?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_pewawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_pewawancara> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
           ResultSet rs = st.executeQuery("select * from tb_pewawancara");
           List<entitas_pewawancara>daftar=new ArrayList<entitas_pewawancara>();
           while(rs.next()){
               entitas_pewawancara ent = new entitas_pewawancara();
               ent.setKd_pw(rs.getString("kd_pewawancara"));
               ent.setNama(rs.getString("nama"));
               ent.setNo_hp(rs.getString("no_hp"));
               daftar.add(ent);
           }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_pewawancara.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
