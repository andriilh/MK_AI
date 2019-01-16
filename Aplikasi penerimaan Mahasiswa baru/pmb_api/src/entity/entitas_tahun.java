/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author radhial22
 */
public class entitas_tahun implements Serializable {
    private String thn_ajaran;
    private int biaya_daftar;
    private int disk_quis;
    private int disk_sekolah;
    private String undangan;

    public entitas_tahun() {
    }

    public entitas_tahun(String thn_ajaran, int biaya_daftar, int disk_quis, int disk_sekolah, String undangan) {
        this.thn_ajaran = thn_ajaran;
        this.biaya_daftar = biaya_daftar;
        this.disk_quis = disk_quis;
        this.disk_sekolah = disk_sekolah;
        this.undangan = undangan;
    }

    public int getBiaya_daftar() {
        return biaya_daftar;
    }

    public void setBiaya_daftar(int biaya_daftar) {
        this.biaya_daftar = biaya_daftar;
    }

    public int getDisk_quis() {
        return disk_quis;
    }

    public void setDisk_quis(int disk_quis) {
        this.disk_quis = disk_quis;
    }

    public int getDisk_sekolah() {
        return disk_sekolah;
    }

    public void setDisk_sekolah(int disk_sekolah) {
        this.disk_sekolah = disk_sekolah;
    }

    public String getThn_ajaran() {
        return thn_ajaran;
    }

    public void setThn_ajaran(String thn_ajaran) {
        this.thn_ajaran = thn_ajaran;
    }

    public String getUndangan() {
        return undangan;
    }

    public void setUndangan(String undangan) {
        this.undangan = undangan;
    }
    
}
