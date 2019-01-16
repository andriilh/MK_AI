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
public class entitas_presenter implements Serializable{
    private String kd_presenter;
    private String nama;
    private String no_hp;

    public entitas_presenter() {
    }

    public entitas_presenter(String kd_presenter, String nama, String no_hp) {
        this.kd_presenter = kd_presenter;
        this.nama = nama;
        this.no_hp = no_hp;
    }

    public String getKd_presenter() {
        return kd_presenter;
    }

    public void setKd_presenter(String kd_presenter) {
        this.kd_presenter = kd_presenter;
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
