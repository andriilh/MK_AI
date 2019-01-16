/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_aplikan;
import intface.intface_aplikan;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;
import sun.misc.JavaxSecurityAuthKerberosAccess;

/**
 *
 * @author radhial22
 */
public class implement_aplikan extends UnicastRemoteObject implements intface_aplikan{
    
    public implement_aplikan()throws RemoteException{
        
    }

    @Override
    public entitas_aplikan insert(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("insert into tb_aplikan (nmr_aplikan,nama,tpt_lahir,tgl_lahir,alamat,kode_pos,telp,hp,email,pendidikan,thn_lulus,nama_ortu,tgl_datang,presenter,jurusan1,jurusan2,sumber_info,sma,tahun_ajaran,mgm,stat_reg,stat_daf,no_ujian,kd_jurusan,stat_uj)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'belum','belum',null,?,'belum')");
            ps.setString(1, r.getNomor_aplikan());
            ps.setString(2, r.getNama());
            ps.setString(3, r.getTmp_lahir());
            ps.setDate(4, new java.sql.Date(r.getTgl_lahir().getTime()));
            ps.setString(5, r.getAlamat());
            ps.setString(6, r.getKode_pos());
            ps.setInt(7, r.getTlp());
            ps.setInt(8, r.getHp());
            ps.setString(9, r.getEmail());
            ps.setString(10, r.getPend_terakhir());
            ps.setString(11, r.getThn_lulus());
            ps.setString(12, r.getNm_ortu());
            ps.setDate(13, new java.sql.Date(r.getTgl_datang().getTime()));
            ps.setString(14, r.getPrsenter());
            ps.setString(15, r.getJurusan1());
            ps.setString(16, r.getJurusan2());
            ps.setString(17, r.getSumber_info());
            ps.setString(18, r.getSma());
            ps.setString(19, r.getThn_ajaran());
            ps.setString(20, r.getMgm());
            ps.setString(21, r.getKd_jurusan());
            ps.executeUpdate();
            
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("update tb_aplikan set nama=?, tpt_lahir=?, tgl_lahir=?, alamat=?, kode_pos=?,telp=?,hp=?,email=?,pendidikan=?,thn_lulus=?,nama_ortu=?,tgl_datang=?,presenter=?,jurusan1=?,jurusan2=?,sumber_info=?,sma=?,tahun_ajaran=?,mgm=?, kd_jurusan=? where nmr_aplikan=?");
            
            ps.setString(1, r.getNama());
            ps.setString(2, r.getTmp_lahir());
            ps.setDate(3, new java.sql.Date(r.getTgl_lahir().getTime()));
            ps.setString(4, r.getAlamat());
            ps.setString(5, r.getKode_pos());
            ps.setInt(6, r.getTlp());
            ps.setInt(7, r.getHp());
            ps.setString(8, r.getEmail());
            ps.setString(9, r.getPend_terakhir());
            ps.setString(10, r.getThn_lulus());
            ps.setString(11, r.getNm_ortu());
            ps.setDate(12, new java.sql.Date(r.getTgl_datang().getTime()));
            ps.setString(13, r.getPrsenter());
            ps.setString(14, r.getJurusan1());
            ps.setString(15, r.getJurusan2());
            ps.setString(16, r.getSumber_info());
            ps.setString(17, r.getSma());
            ps.setString(18, r.getThn_ajaran());
            ps.setString(19, r.getMgm());
            ps.setString(20, r.getKd_jurusan());
            ps.setString(21, r.getNomor_aplikan());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_aplikan> getlist() throws RemoteException {
        try {
            Statement st =conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from tb_aplikan");
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
                
    }

    @Override
    public List<entitas_aplikan> getByno(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_aplikan where nmr_aplikan =?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("thn_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public entitas_aplikan getBy(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("select * from tb_aplikan where nmr_aplikan =?");
            ps.setString(1, no);
            ResultSet rs = ps.executeQuery();
            entitas_aplikan ent =new entitas_aplikan();
            while(rs.next()){
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("thn_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void delete(String no) throws RemoteException {
        try {
            PreparedStatement ps = conn.getcekkoneksi().prepareStatement("delete from tb_aplikan where nmr_aplikan=?");
            ps.setString(1, no);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<entitas_aplikan> stat() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_aplikan WHERE stat_daf =  'belum'");
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void updatedaf(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_aplikan set stat_daf = 'sudah' where nmr_aplikan =?");
            ps.setString(1, r.getNomor_aplikan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updatedafre(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_aplikan set stat_daf = 'belum' where nmr_aplikan =?");
            ps.setString(1, r.getNomor_aplikan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_aplikan> reg() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM tb_aplikan WHERE stat_reg =  'belum'");
              List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);  
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void updateregre(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_aplikan set stat_reg = 'sudah' where nmr_aplikan =?");
            ps.setString(1, r.getNomor_aplikan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatereg(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_aplikan set stat_reg = 'belum' where nmr_aplikan =?");
                ps.setString(1, r.getNomor_aplikan());
                ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatenoUjian(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("update tb_aplikan set no_ujian = ? where nmr_aplikan =?");
            ps.setString(1, r.getNo_ujian());
            ps.setString(2, r.getNomor_aplikan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public entitas_aplikan getbynoujian(String noujian) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tb_aplikan where no_ujian =?");
            ps.setString(1, noujian);
            ResultSet rs = ps.executeQuery();
            entitas_aplikan ent = new entitas_aplikan();
            while(rs.next()){
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public entitas_aplikan no_aplikan() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX( nmr_aplikan ) AS no FROM tb_aplikan");
            entitas_aplikan ent = new entitas_aplikan();
            while(rs.next()){
                ent.setNo(rs.getInt("no"));
            }return ent;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    }

    @Override
    public void updateUj(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps=conn.getcekkoneksi().prepareStatement("update tb_aplikan set stat_uj = 'sudah' where nmr_aplikan =?");
            ps.setString(1, r.getNomor_aplikan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updateUjre(entitas_aplikan r) throws RemoteException {
        try {
            PreparedStatement ps=conn.getcekkoneksi().prepareStatement("update tb_aplikan set stat_uj = 'belum' where nmr_aplikan =?");
                ps.setString(1, r.getNomor_aplikan());
                ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<entitas_aplikan> ujbelum() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_aplikan WHERE stat_uj =  'belum'");
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_aplikan> ujsudah() throws RemoteException {
       try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_aplikan WHERE stat_uj =  'sudah'");
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_aplikan> statdafsudah() throws RemoteException {
       try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_aplikan WHERE stat_daf =  'sudah'");
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_aplikan> regsudah() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM tb_aplikan WHERE stat_reg =  'sudah'");
              List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);  
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_aplikan> getbytgl(Date tgl) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tb_aplikan where tgl_datang =?");
            ps.setDate(1, new java.sql.Date(tgl.getTime()));
            ResultSet rs =ps.executeQuery();
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<entitas_aplikan> getbytglbetween(Date tgl1, Date tgl2) throws RemoteException {
        try {
            PreparedStatement ps =conn.getcekkoneksi().prepareStatement("select * from tb_aplikan where tgl_datang between ? and ?");
            ps.setDate(1, new java.sql.Date(tgl1.getTime()));
            ps.setDate(2, new java.sql.Date(tgl2.getTime()));
            ResultSet rs =ps.executeQuery();
            List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
            while(rs.next()){
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(rs.getString("nmr_aplikan"));
                ent.setNama(rs.getString("nama"));
                ent.setTmp_lahir(rs.getString("tpt_lahir"));
                ent.setTgl_lahir(rs.getDate("tgl_lahir"));
                ent.setAlamat(rs.getString("alamat"));
                ent.setKode_pos(rs.getString("kode_pos"));
                ent.setTlp(rs.getInt("telp"));
                ent.setHp(rs.getInt("hp"));
                ent.setEmail(rs.getString("email"));
                ent.setPend_terakhir(rs.getString("pendidikan"));
                ent.setThn_lulus(rs.getString("thn_lulus"));
                ent.setNm_ortu(rs.getString("nama_ortu"));
                ent.setTgl_datang(rs.getDate("tgl_datang"));
                ent.setPrsenter(rs.getString("presenter"));
                ent.setJurusan1(rs.getString("jurusan1"));
                ent.setJurusan2(rs.getString("jurusan2"));
                ent.setSumber_info(rs.getString("sumber_info"));
                ent.setSma(rs.getString("sma"));
                ent.setThn_ajaran(rs.getString("tahun_ajaran"));
                ent.setMgm(rs.getString("mgm"));
                ent.setNo_ujian(rs.getString("no_ujian"));
                ent.setKd_jurusan(rs.getString("kd_jurusan"));
                daftar.add(ent);
            }return daftar;
        } catch (SQLException ex) {
            Logger.getLogger(implement_aplikan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
