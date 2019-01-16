/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_lapSuratLulus;
import intface.intface_suratLulus;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class implement_lapSuratLulus extends UnicastRemoteObject implements intface_suratLulus{

    public implement_lapSuratLulus()throws RemoteException{
        
    }
    
    @Override
    public List<entitas_lapSuratLulus> daftar(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select tb_wawancara.nama,tb_wawancara.no_ujian,tb_wawancara.jurusan,tb_place.test_ke1,tb_place.waktu1,tb_place.test_ke2,tb_place.waktu2,tb_place.test_ke3, tb_place.waktu3, tb_inggris.grade from tb_wawancara, tb_place, tb_inggris where tb_wawancara.no_ujian = ?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_lapSuratLulus>daftar = new ArrayList<entitas_lapSuratLulus>();
            while(rs.next()){
                entitas_lapSuratLulus ent = new entitas_lapSuratLulus();
                ent.setNama(rs.getString("nama"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setJurusan(rs.getString("jurusan"));
                ent.setTest1(rs.getString("test_ke1"));
                ent.setWaktu1(rs.getString("waktu1"));
                ent.setTest2(rs.getString("test_ke2"));
                ent.setWaktu2(rs.getString("waktu2"));
                ent.setTest3(rs.getString("test_ke3"));
                ent.setWaktu3(rs.getString("waktu3"));
                ent.setGrade(rs.getString("grade"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_lapSuratLulus.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
