/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_presenter;
import intface.intface_presenter;
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
public class implement_presenter extends UnicastRemoteObject implements intface_presenter{
    
    public implement_presenter()throws RemoteException{
        
    }

    @Override
    public entitas_presenter insert(entitas_presenter r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_presenter(kd_presenter,nama,no_hp)values (?,?,?)");
            ps.setString(1, r.getKd_presenter());
            ps.setString(2, r.getNama());
            ps.setString(3, r.getNo_hp());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_presenter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_presenter r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_presenter set nama = ?, no_hp=? where kd_presenter=?");
            ps.setString(1, r.getNama());
            ps.setString(2, r.getNo_hp());
            ps.setString(3, r.getKd_presenter());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_presenter where kd_presenter=?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_presenter> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
           ResultSet rs = st.executeQuery("select * from tb_presenter");
           List<entitas_presenter>daftar=new ArrayList<entitas_presenter>();
           while(rs.next()){
               entitas_presenter ent = new entitas_presenter();
               ent.setKd_presenter(rs.getString("kd_presenter"));
               ent.setNama(rs.getString("nama"));
               ent.setNo_hp(rs.getString("no_hp"));
               daftar.add(ent);
           }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_presenter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
