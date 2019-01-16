/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import com.sun.crypto.provider.RSACipher;
import entity.entitas_pewawancara;
import entity.entitas_wawancara;
import intface.intface_pewawancara;
import intface.intface_wawancara;
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
public class implement_wawancara extends UnicastRemoteObject implements intface_wawancara{
    
    public implement_wawancara()throws RemoteException{
        
    }

    @Override
    public entitas_wawancara insert(entitas_wawancara r) throws RemoteException {
        try {
            PreparedStatement ps= conn.getcekkoneksi().prepareStatement("INSERT INTO `db_pmb`.`tb_wawancara` (`no_ujian`, `no_aplikan`, `nama`, `jurusan1`, `jurusan2`, `komu_lisan`, `komu_tulis`, `kem_itel`, `motivasi`, `kedewasaan`, `kem_kerjasama`, `pd`, `daya_analisis`, `kem_adm`, `kelebihan`, `penampilan`, `penyakit`, `kacamata`, `ukuran`, `iq`, `kesimpulan`, `predikat`, `jurusan`, `petugas`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, r.getNo_ujian());
            ps.setString(2, r.getNo_aplikan());
            ps.setString(3, r.getNama());
            ps.setString(4, r.getJur1());
            ps.setString(5, r.getJur2());
            ps.setString(6, r.getKomu_lisan());
            ps.setString(7, r.getKomu_tulis());
            ps.setString(8, r.getKem_intelek());
            ps.setString(9, r.getMotivasi());
            ps.setString(10, r.getKedewasaa());
            ps.setString(11, r.getKem_kerjasama());
            ps.setString(12, r.getPd());
            ps.setString(13, r.getDaya_analisis());
            ps.setString(14, r.getKem_adm());
            ps.setString(15, r.getKelebihan());
            ps.setString(16, r.getPenampilan());
            ps.setString(17, r.getPenyakit());
            ps.setString(18, r.getKacamata());
            ps.setString(19, r.getUkuran());
            ps.setString(20, r.getIq());
            ps.setString(21, r.getKesimpulan());
            ps.setString(22, r.getPredikat());
            ps.setString(23, r.getJurusan());
            ps.setString(24, r.getPetugas());
            ps.executeUpdate();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_wawancara.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_wawancara r) throws RemoteException {
        try {
            PreparedStatement ps= conn.getcekkoneksi().prepareStatement("UPDATE `db_pmb`.`tb_wawancara` SET `no_aplikan` = ?, `nama` = ?, `jurusan1` = ?, `jurusan2` = ?, `komu_lisan` = ?, `komu_tulis` = ?, `kem_itel` = ?, `motivasi` = ?, `kedewasaan` = ?, `kem_kerjasama` = ?, `pd` = ?, `daya_analisis` = ?, `kem_adm` = ?, `kelebihan` = ?, `penampilan` = ?, `penyakit` = ?, `kacamata` = ?, `ukuran` = ?, `iq` = ?, `kesimpulan` = ?, `predikat` = ?, `jurusan` = ?, `petugas` = ? WHERE `tb_wawancara`.`no_ujian` = ?");
            
            ps.setString(1, r.getNo_aplikan());
            ps.setString(2, r.getNama());
            ps.setString(3, r.getJur1());
            ps.setString(4, r.getJur2());
            ps.setString(5, r.getKomu_lisan());
            ps.setString(6, r.getKomu_tulis());
            ps.setString(7, r.getKem_intelek());
            ps.setString(8, r.getMotivasi());
            ps.setString(9, r.getKedewasaa());
            ps.setString(10, r.getKem_kerjasama());
            ps.setString(11, r.getPd());
            ps.setString(12, r.getDaya_analisis());
            ps.setString(13, r.getKem_adm());
            ps.setString(14, r.getKelebihan());
            ps.setString(15, r.getPenampilan());
            ps.setString(16, r.getPenyakit());
            ps.setString(17, r.getKacamata());
            ps.setString(18, r.getUkuran());
            ps.setString(19, r.getIq());
            ps.setString(20, r.getKesimpulan());
            ps.setString(21, r.getPredikat());
            ps.setString(22, r.getJurusan());
            ps.setString(23, r.getPetugas());
            ps.setString(24, r.getNo_ujian());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_wawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("delete from tb_wawancara where no_ujian=?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_wawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<entitas_wawancara> getall() throws RemoteException {
        try {
            Statement st =conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_wawancara");
            List<entitas_wawancara>daftar=new ArrayList<entitas_wawancara>();
            while(rs.next()){
                entitas_wawancara ent = new entitas_wawancara();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setJur1(rs.getString("jurusan1"));
                ent.setJur2(rs.getString("jurusan2"));
                ent.setKomu_lisan(rs.getString("komu_lisan"));
                ent.setKomu_tulis(rs.getString("komu_tulis"));
                ent.setKem_intelek(rs.getString("kem_itel"));
                ent.setMotivasi(rs.getString("motivasi"));
                ent.setKedewasaa(rs.getString("kedewasaan"));
                ent.setKem_kerjasama(rs.getString("kem_kerjasama"));
                ent.setPd(rs.getString("pd"));
                ent.setDaya_analisis(rs.getString("daya_analisis"));
                ent.setKem_adm(rs.getString("kem_adm"));
                ent.setKelebihan(rs.getString("kelebihan"));
                ent.setPenampilan(rs.getString("penampilan"));
                ent.setPenyakit(rs.getString("penyakit"));
                ent.setKacamata(rs.getString("kacamata"));
                ent.setUkuran(rs.getString("ukuran"));
                ent.setIq(rs.getString("iq"));
                ent.setKesimpulan(rs.getString("kesimpulan"));
                ent.setPredikat(rs.getString("predikat"));
                ent.setJurusan(rs.getString("jurusan"));
                ent.setPetugas(rs.getString("petugas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_wawancara.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<entitas_wawancara> getby(String no) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tb_wawancara where no_ujian=?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_wawancara>daftar=new ArrayList<entitas_wawancara>();
            while(rs.next()){
                entitas_wawancara ent = new entitas_wawancara();
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setNo_aplikan(rs.getString("no_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setJur1(rs.getString("jurusan1"));
                ent.setJur2(rs.getString("jurusan2"));
                ent.setKomu_lisan(rs.getString("komu_lisan"));
                ent.setKomu_tulis(rs.getString("komu_tulis"));
                ent.setKem_intelek(rs.getString("kem_itel"));
                ent.setMotivasi(rs.getString("motivasi"));
                ent.setKedewasaa(rs.getString("kedewasaan"));
                ent.setKem_kerjasama(rs.getString("kem_kerjasama"));
                ent.setPd(rs.getString("pd"));
                ent.setDaya_analisis(rs.getString("daya_analisis"));
                ent.setKem_adm(rs.getString("kem_adm"));
                ent.setKelebihan(rs.getString("kelebihan"));
                ent.setPenampilan(rs.getString("penampilan"));
                ent.setPenyakit(rs.getString("penyakit"));
                ent.setKacamata(rs.getString("kacamata"));
                ent.setUkuran(rs.getString("ukuran"));
                ent.setIq(rs.getString("iq"));
                ent.setKesimpulan(rs.getString("kesimpulan"));
                ent.setPredikat(rs.getString("predikat"));
                ent.setJurusan(rs.getString("jurusan"));
                ent.setPetugas(rs.getString("petugas"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_wawancara.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

}
