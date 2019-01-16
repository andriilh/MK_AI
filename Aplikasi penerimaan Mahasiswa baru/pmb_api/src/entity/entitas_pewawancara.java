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
public class entitas_pewawancara implements Serializable {
    private String kd_pw;
    private String nama;
    private String no_hp;

    public entitas_pewawancara() {
    }

    public entitas_pewawancara(String kd_pw, String nama, String no_hp) {
        this.kd_pw = kd_pw;
        this.nama = nama;
        this.no_hp = no_hp;
    }

    public String getKd_pw() {
        return kd_pw;
    }

    public void setKd_pw(String kd_pw) {
        this.kd_pw = kd_pw;
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
