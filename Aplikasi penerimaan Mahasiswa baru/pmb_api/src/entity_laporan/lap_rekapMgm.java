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
public class lap_rekapMgm implements Serializable{
    private int jumlah;
    private String mgm;
    private String kd_mgm;
    private String nama;

    public lap_rekapMgm() {
    }

    public lap_rekapMgm(int jumlah, String mgm, String kd_mgm, String nama) {
        this.jumlah = jumlah;
        this.mgm = mgm;
        this.kd_mgm = kd_mgm;
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKd_mgm() {
        return kd_mgm;
    }

    public void setKd_mgm(String kd_mgm) {
        this.kd_mgm = kd_mgm;
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
    
}
