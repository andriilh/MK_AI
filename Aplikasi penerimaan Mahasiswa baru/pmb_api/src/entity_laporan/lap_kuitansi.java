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
public class lap_kuitansi implements Serializable{
    private String no;
    private String nama;
    private Date tanggal;
    private int jumlah;
    private String terbilang;

    public lap_kuitansi() {
    }

    public lap_kuitansi(String no, String nama, Date tanggal, int jumlah, String terbilang) {
        this.no = no;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.terbilang = terbilang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getTerbilang() {
        return terbilang;
    }

    public void setTerbilang(String terbilang) {
        this.terbilang = terbilang;
    }

}
