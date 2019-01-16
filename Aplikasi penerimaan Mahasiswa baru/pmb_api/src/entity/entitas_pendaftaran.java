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
public class entitas_pendaftaran implements Serializable{
    private String no_daftar;
    private String no_aplikan;
    private String no_ujian;
    private String nama;
    private Date tgl;
    private String thn_ajaran;
    private int biaya;
    private String tipe_diskon;
    private int diskon;
    private int bayar;
    private String terbilang;

    public entitas_pendaftaran() {
    }

    public entitas_pendaftaran(String no_daftar, String no_aplikan, String no_ujian, String nama, Date tgl, String thn_ajaran, int biaya, String tipe_diskon, int diskon, int bayar, String terbilang) {
        this.no_daftar = no_daftar;
        this.no_aplikan = no_aplikan;
        this.no_ujian = no_ujian;
        this.nama = nama;
        this.tgl = tgl;
        this.thn_ajaran = thn_ajaran;
        this.biaya = biaya;
        this.tipe_diskon = tipe_diskon;
        this.diskon = diskon;
        this.bayar = bayar;
        this.terbilang = terbilang;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_aplikan() {
        return no_aplikan;
    }

    public void setNo_aplikan(String no_aplikan) {
        this.no_aplikan = no_aplikan;
    }

    public String getNo_daftar() {
        return no_daftar;
    }

    public void setNo_daftar(String no_daftar) {
        this.no_daftar = no_daftar;
    }

    public String getNo_ujian() {
        return no_ujian;
    }

    public void setNo_ujian(String no_ujian) {
        this.no_ujian = no_ujian;
    }

    public String getTerbilang() {
        return terbilang;
    }

    public void setTerbilang(String terbilang) {
        this.terbilang = terbilang;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getThn_ajaran() {
        return thn_ajaran;
    }

    public void setThn_ajaran(String thn_ajaran) {
        this.thn_ajaran = thn_ajaran;
    }

    public String getTipe_diskon() {
        return tipe_diskon;
    }

    public void setTipe_diskon(String tipe_diskon) {
        this.tipe_diskon = tipe_diskon;
    }

}
