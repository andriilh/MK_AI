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
public class entitas_kab implements Serializable{
    private String Kd_kab;
private String kabupaten;

    public entitas_kab() {
    }

    public entitas_kab(String Kd_kab, String kabupaten) {
        this.Kd_kab = Kd_kab;
        this.kabupaten = kabupaten;
    }

    public String getKd_kab() {
        return Kd_kab;
    }

    public void setKd_kab(String Kd_kab) {
        this.Kd_kab = Kd_kab;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }


}
