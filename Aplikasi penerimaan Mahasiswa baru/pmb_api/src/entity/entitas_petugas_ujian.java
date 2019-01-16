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
public class entitas_petugas_ujian implements Serializable {
    private String kd_petugas;
    private String nama;
    private String no_hp;

    public entitas_petugas_ujian() {
    }

    public entitas_petugas_ujian(String kd_petugas, String nama, String no_hp) {
        this.kd_petugas = kd_petugas;
        this.nama = nama;
        this.no_hp = no_hp;
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

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
    
}
