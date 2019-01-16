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
public class entitas_mgm implements Serializable {
    private String kd_mgm;
    private String nama;

    public entitas_mgm() {
    }

    public entitas_mgm(String kd_mgm, String nama) {
        this.kd_mgm = kd_mgm;
        this.nama = nama;
    }

    public String getKd_mgm() {
        return kd_mgm;
    }

    public void setKd_mgm(String kd_mgm) {
        this.kd_mgm = kd_mgm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
