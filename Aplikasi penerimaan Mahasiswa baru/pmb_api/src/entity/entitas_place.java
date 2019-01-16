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
public class entitas_place implements Serializable{
    private String no_ujian;
    private String no_aplikan;
    private String nama;
    private Date tgl;
    private String jur1;
    private String jur2;
    private String testke1;
    private String waktu1;
    private String testke2;
    private String waktu2;
    private String testke3;
    private String waktu3;
    private String petugas;

    public entitas_place() {
    }

    public entitas_place(String no_ujian, String no_aplikan, String nama, Date tgl, String jur1, String jur2, String testke1, String waktu1, String testke2, String waktu2, String testke3, String waktu3, String petugas) {
        this.no_ujian = no_ujian;
        this.no_aplikan = no_aplikan;
        this.nama = nama;
        this.tgl = tgl;
        this.jur1 = jur1;
        this.jur2 = jur2;
        this.testke1 = testke1;
        this.waktu1 = waktu1;
        this.testke2 = testke2;
        this.waktu2 = waktu2;
        this.testke3 = testke3;
        this.waktu3 = waktu3;
        this.petugas = petugas;
    }

    public String getJur1() {
        return jur1;
    }

    public void setJur1(String jur1) {
        this.jur1 = jur1;
    }

    public String getJur2() {
        return jur2;
    }

    public void setJur2(String jur2) {
        this.jur2 = jur2;
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

    public String getNo_ujian() {
        return no_ujian;
    }

    public void setNo_ujian(String no_ujian) {
        this.no_ujian = no_ujian;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getTestke1() {
        return testke1;
    }

    public void setTestke1(String testke1) {
        this.testke1 = testke1;
    }

    public String getTestke2() {
        return testke2;
    }

    public void setTestke2(String testke2) {
        this.testke2 = testke2;
    }

    public String getTestke3() {
        return testke3;
    }

    public void setTestke3(String testke3) {
        this.testke3 = testke3;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getWaktu1() {
        return waktu1;
    }

    public void setWaktu1(String waktu1) {
        this.waktu1 = waktu1;
    }

    public String getWaktu2() {
        return waktu2;
    }

    public void setWaktu2(String waktu2) {
        this.waktu2 = waktu2;
    }

    public String getWaktu3() {
        return waktu3;
    }

    public void setWaktu3(String waktu3) {
        this.waktu3 = waktu3;
    }

}
