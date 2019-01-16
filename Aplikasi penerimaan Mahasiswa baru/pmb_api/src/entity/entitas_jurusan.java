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
public class entitas_jurusan implements Serializable{
    private String kd_jurusan;
    private String jurusan;

    public entitas_jurusan() {
    }

    public entitas_jurusan(String kd_jurusan, String jurusan) {
        this.kd_jurusan = kd_jurusan;
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKd_jurusan() {
        return kd_jurusan;
    }

    public void setKd_jurusan(String kd_jurusan) {
        this.kd_jurusan = kd_jurusan;
    }
    
    
}
