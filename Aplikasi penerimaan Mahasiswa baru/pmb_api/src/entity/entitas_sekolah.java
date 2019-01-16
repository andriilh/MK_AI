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
public class entitas_sekolah implements Serializable {
    private String kd_sekolah;
    private String nama;
    private String kabuaten;

    public entitas_sekolah() {
    }

    public entitas_sekolah(String kd_sekolah, String nama, String kabuaten) {
        this.kd_sekolah = kd_sekolah;
        this.nama = nama;
        this.kabuaten = kabuaten;
    }

    public String getKabuaten() {
        return kabuaten;
    }

    public void setKabuaten(String kabuaten) {
        this.kabuaten = kabuaten;
    }

    public String getKd_sekolah() {
        return kd_sekolah;
    }

    public void setKd_sekolah(String kd_sekolah) {
        this.kd_sekolah = kd_sekolah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
