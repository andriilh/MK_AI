/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_laporan;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author radhial22
 */
public class lap_aplikanPerpresenter implements Serializable {
    private String nama;
    private int hp;
    private Date tgl_datang;
    private Date tgl_daftar;
    private Date tgl_ujian;
    private String tahun_ajaran;
    private String jurusan;
    private Date tgl_reg;
    private String presenter;

    public lap_aplikanPerpresenter() {
    }

    public lap_aplikanPerpresenter(String nama, int hp, Date tgl_datang, Date tgl_daftar, Date tgl_ujian, String tahun_ajaran, String jurusan, Date tgl_reg, String presenter) {
        this.nama = nama;
        this.hp = hp;
        this.tgl_datang = tgl_datang;
        this.tgl_daftar = tgl_daftar;
        this.tgl_ujian = tgl_ujian;
        this.tahun_ajaran = tahun_ajaran;
        this.jurusan = jurusan;
        this.tgl_reg = tgl_reg;
        this.presenter = presenter;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public String getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(String tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public Date getTgl_daftar() {
        return tgl_daftar;
    }

    public void setTgl_daftar(Date tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
    }

    public Date getTgl_datang() {
        return tgl_datang;
    }

    public void setTgl_datang(Date tgl_datang) {
        this.tgl_datang = tgl_datang;
    }

    public Date getTgl_reg() {
        return tgl_reg;
    }

    public void setTgl_reg(Date tgl_reg) {
        this.tgl_reg = tgl_reg;
    }

    public Date getTgl_ujian() {
        return tgl_ujian;
    }

    public void setTgl_ujian(Date tgl_ujian) {
        this.tgl_ujian = tgl_ujian;
    }
    
}
