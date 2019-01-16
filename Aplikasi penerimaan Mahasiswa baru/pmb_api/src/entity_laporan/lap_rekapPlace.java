/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_laporan;

import java.io.Serializable;

/**
 *
 * @author radhial22
 */
public class lap_rekapPlace implements Serializable{
    private int jumlah;
    private String petugas_ujian;
    private String kd_petugas;
    private String nama;

    public lap_rekapPlace() {
    }

    public lap_rekapPlace(int jumlah, String petugas_ujian, String kd_petugas, String nama) {
        this.jumlah = jumlah;
        this.petugas_ujian = petugas_ujian;
        this.kd_petugas = kd_petugas;
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKd_petugas() {
        return kd_petugas;
    }

    public void setKd_petugas(String kd_petugas) {
        this.kd_petugas = kd_petugas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPetugas_ujian() {
        return petugas_ujian;
    }

    public void setPetugas_ujian(String petugas_ujian) {
        this.petugas_ujian = petugas_ujian;
    }
    
}
