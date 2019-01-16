/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author radhial22
 */
public class entitas_aplikan implements Serializable{
    private String nomor_aplikan;
    private String nama;
    private String tmp_lahir;
    private Date tgl_lahir;
    private String alamat;
    private String kode_pos;
    private int tlp;
    private int hp;
    private String email;
    private String pend_terakhir;
    private String thn_lulus;
    private String nm_ortu;
    private Date tgl_datang;
    private String prsenter;
    private String jurusan1;
    private String jurusan2;
    private String sumber_info;
    private String sma;
    private String thn_ajaran;
    private String mgm;
    private String stat_daf;
    private String stat_reg;
    private String no_ujian;
    private int no;
    private String kd_jurusan;
    private String stat_uj;

    public entitas_aplikan() {
    }

    public entitas_aplikan(String nomor_aplikan, String nama, String tmp_lahir, Date tgl_lahir, String alamat, String kode_pos, int tlp, int hp, String email, String pend_terakhir, String thn_lulus, String nm_ortu, Date tgl_datang, String prsenter, String jurusan1, String jurusan2, String sumber_info, String sma, String thn_ajaran, String mgm, String stat_daf, String stat_reg, String no_ujian, int no, String kd_jurusan, String stat_uj) {
        this.nomor_aplikan = nomor_aplikan;
        this.nama = nama;
        this.tmp_lahir = tmp_lahir;
        this.tgl_lahir = tgl_lahir;
        this.alamat = alamat;
        this.kode_pos = kode_pos;
        this.tlp = tlp;
        this.hp = hp;
        this.email = email;
        this.pend_terakhir = pend_terakhir;
        this.thn_lulus = thn_lulus;
        this.nm_ortu = nm_ortu;
        this.tgl_datang = tgl_datang;
        this.prsenter = prsenter;
        this.jurusan1 = jurusan1;
        this.jurusan2 = jurusan2;
        this.sumber_info = sumber_info;
        this.sma = sma;
        this.thn_ajaran = thn_ajaran;
        this.mgm = mgm;
        this.stat_daf = stat_daf;
        this.stat_reg = stat_reg;
        this.no_ujian = no_ujian;
        this.no = no;
        this.kd_jurusan = kd_jurusan;
        this.stat_uj = stat_uj;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getJurusan1() {
        return jurusan1;
    }

    public void setJurusan1(String jurusan1) {
        this.jurusan1 = jurusan1;
    }

    public String getJurusan2() {
        return jurusan2;
    }

    public void setJurusan2(String jurusan2) {
        this.jurusan2 = jurusan2;
    }

    public String getKd_jurusan() {
        return kd_jurusan;
    }

    public void setKd_jurusan(String kd_jurusan) {
        this.kd_jurusan = kd_jurusan;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getMgm() {
        return mgm;
    }

    public void setMgm(String mgm) {
        this.mgm = mgm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNm_ortu() {
        return nm_ortu;
    }

    public void setNm_ortu(String nm_ortu) {
        this.nm_ortu = nm_ortu;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNo_ujian() {
        return no_ujian;
    }

    public void setNo_ujian(String no_ujian) {
        this.no_ujian = no_ujian;
    }

    public String getNomor_aplikan() {
        return nomor_aplikan;
    }

    public void setNomor_aplikan(String nomor_aplikan) {
        this.nomor_aplikan = nomor_aplikan;
    }

    public String getPend_terakhir() {
        return pend_terakhir;
    }

    public void setPend_terakhir(String pend_terakhir) {
        this.pend_terakhir = pend_terakhir;
    }

    public String getPrsenter() {
        return prsenter;
    }

    public void setPrsenter(String prsenter) {
        this.prsenter = prsenter;
    }

    public String getSma() {
        return sma;
    }

    public void setSma(String sma) {
        this.sma = sma;
    }

    public String getStat_daf() {
        return stat_daf;
    }

    public void setStat_daf(String stat_daf) {
        this.stat_daf = stat_daf;
    }

    public String getStat_reg() {
        return stat_reg;
    }

    public void setStat_reg(String stat_reg) {
        this.stat_reg = stat_reg;
    }

    public String getStat_uj() {
        return stat_uj;
    }

    public void setStat_uj(String stat_uj) {
        this.stat_uj = stat_uj;
    }

    public String getSumber_info() {
        return sumber_info;
    }

    public void setSumber_info(String sumber_info) {
        this.sumber_info = sumber_info;
    }

    public Date getTgl_datang() {
        return tgl_datang;
    }

    public void setTgl_datang(Date tgl_datang) {
        this.tgl_datang = tgl_datang;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getThn_ajaran() {
        return thn_ajaran;
    }

    public void setThn_ajaran(String thn_ajaran) {
        this.thn_ajaran = thn_ajaran;
    }

    public String getThn_lulus() {
        return thn_lulus;
    }

    public void setThn_lulus(String thn_lulus) {
        this.thn_lulus = thn_lulus;
    }

    public int getTlp() {
        return tlp;
    }

    public void setTlp(int tlp) {
        this.tlp = tlp;
    }

    public String getTmp_lahir() {
        return tmp_lahir;
    }

    public void setTmp_lahir(String tmp_lahir) {
        this.tmp_lahir = tmp_lahir;
    }
    
   
}
