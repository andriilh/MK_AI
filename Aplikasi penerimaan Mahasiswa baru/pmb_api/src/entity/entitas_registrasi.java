/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author radhial22
 */
public class entitas_registrasi implements Serializable {
    private String no_regis;
    private String no_aplikan;
    private String nama;
    private Date tgl;
    private String kls;

    public entitas_registrasi() {
    }

    public entitas_registrasi(String no_regis, String no_aplikan, String nama, Date tgl, String kls) {
        this.no_regis = no_regis;
        this.no_aplikan = no_aplikan;
        this.nama = nama;
        this.tgl = tgl;
        this.kls = kls;
    }

    public String getKls() {
        return kls;
    }

    public void setKls(String kls) {
        this.kls = kls;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_aplikan() {
        return no_aplikan;
    }

    public void setNo_aplikan(String no_aplikan) {
        this.no_aplikan = no_aplikan;
    }

    public String getNo_regis() {
        return no_regis;
    }

    public void setNo_regis(String no_regis) {
        this.no_regis = no_regis;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

   
}
