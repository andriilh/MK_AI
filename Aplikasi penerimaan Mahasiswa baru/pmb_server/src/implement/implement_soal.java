/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_soal;
import intface.intface_soal;
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
public class implement_soal extends UnicastRemoteObject implements intface_soal{

    public implement_soal() throws RemoteException {
    }

    
    @Override
    public entitas_soal insert(entitas_soal r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tabel_soal (kd_soal,soal,a,b,c,d,e,benar)values(?,?,?,?,?,?,?,?)");
            ps.setString(1, r.getKd_soal());
            ps.setString(2, r.getSoal());
            ps.setString(3, r.getPilihan1());
            ps.setString(4, r.getPilihan2());
            ps.setString(5, r.getPilihan3());
            ps.setString(6, r.getPilihan4());
            ps.setString(7, r.getPilihan5());
            ps.setString(8, r.getBenar());
            ps.executeUpdate();
            
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }

    @Override
    public void update(entitas_soal r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tabel_soal set soal=?, a=?,b=?,c=?,d=?,e=?,benar=? where kd_soal =?");
            ps.setString(1, r.getSoal());
            ps.setString(2, r.getPilihan1());
            ps.setString(3, r.getPilihan2());
            ps.setString(4, r.getPilihan3());
            ps.setString(5, r.getPilihan4());
            ps.setString(6, r.getPilihan5());
            ps.setString(7, r.getBenar());
            ps.setString(8, r.getKd_soal());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String kd) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tabel_soal where kd_soal=?");
            ps.setString(1, kd);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    @Override
    public entitas_soal select() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tabel_soal");
            entitas_soal ent = new entitas_soal();
            while(rs.next()){
                ent.setKd_soal(rs.getString("kd_soal"));
                ent.setSoal(rs.getString("soal"));
                ent.setPilihan1(rs.getString("a"));
                ent.setPilihan2(rs.getString("b"));
                ent.setPilihan3(rs.getString("c"));
                ent.setPilihan4(rs.getString("d"));
                ent.setPilihan5(rs.getString("e"));
                ent.setBenar(rs.getString("benar"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public entitas_soal selectby(String kd) throws RemoteException {
        try {
            PreparedStatement ps=conn.getcekkoneksi().prepareStatement("select * from tabel_soal where kd_soal=?");
            ps.setString(1, kd);
            ResultSet rs = ps.executeQuery();
            entitas_soal ent = new entitas_soal();
            while(rs.next()){
                
                 ent.setKd_soal(rs.getString("kd_soal"));
                ent.setSoal(rs.getString("soal"));
                ent.setPilihan1(rs.getString("a"));
                ent.setPilihan2(rs.getString("b"));
                ent.setPilihan3(rs.getString("c"));
                ent.setPilihan4(rs.getString("d"));
                ent.setPilihan5(rs.getString("e"));
                ent.setBenar(rs.getString("benar"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_soal> getall() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tabel_soal");
            List<entitas_soal>daftar = new ArrayList<entitas_soal>();
            while(rs.next()){
                entitas_soal ent = new entitas_soal();
                 ent.setKd_soal(rs.getString("kd_soal"));
                ent.setSoal(rs.getString("soal"));
                ent.setPilihan1(rs.getString("a"));
                ent.setPilihan2(rs.getString("b"));
                ent.setPilihan3(rs.getString("c"));
                ent.setPilihan4(rs.getString("d"));
                ent.setPilihan5(rs.getString("e"));
                ent.setBenar(rs.getString("benar"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public entitas_soal count() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
                 ResultSet rs = st.executeQuery("select count(*) as jumlah from tabel_soal");
                 entitas_soal ent = new entitas_soal();
                 while(rs.next()){
                     ent.setJumlah(rs.getString("jumlah"));
         }return  ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_soal> getby() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select kd_soal,soal,benar from tabel_soal ORDER BY RAND()");
            List<entitas_soal>daftar=new ArrayList<entitas_soal>();
            while(rs.next()){
                entitas_soal ent = new entitas_soal();
                ent.setKd_soal(rs.getString("kd_soal"));
                ent.setSoal(rs.getString("soal"));
                ent.setBenar(rs.getString("benar"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_soal> getbynosoal(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select kd_soal,soal from tabel_soal where kd_soal=?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_soal>daftar=new ArrayList<entitas_soal>();
            while(rs.next()){
                entitas_soal ent = new entitas_soal();
                ent.setKd_soal(rs.getString("kd_soal"));
                ent.setSoal(rs.getString("soal"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public entitas_soal getbyno(String no) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tabel_soal where kd_soal=?");
            ps.setString(1, no);
            ResultSet rs =ps.executeQuery();
            entitas_soal ent =new entitas_soal();
            while(rs.next()){
                ent.setKd_soal(rs.getString("kd_soal"));
                ent.setSoal(rs.getString("soal"));
                ent.setPilihan1(rs.getString("a"));
                ent.setPilihan2(rs.getString("b"));
                ent.setPilihan3(rs.getString("c"));
                ent.setPilihan4(rs.getString("d"));
                ent.setPilihan5(rs.getString("e"));
                ent.setBenar(rs.getString("benar"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_soal> random() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT soal FROM tabel_soal ORDER BY RAND()");
            List<entitas_soal>daftar = new ArrayList<>();
            while(rs.next()){
                entitas_soal ent =new entitas_soal();
                ent.setSoal(rs.getString("soal"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_soal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
