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
public class entitas_inggris implements Serializable{
    private String no_ujian;
    private String no_aplikan;
    private String nama;
    private String presenter;
    private String jur1;
    private String jur2;
    private Date tanggal;
    private int benar;
    private String waktu;
    private String grade;
    private String petugas;

    public entitas_inggris() {
    }

    public entitas_inggris(String no_ujian, String no_aplikan, String nama, String presenter, String jur1, String jur2, Date tanggal, int benar, String waktu, String grade, String petugas) {
        this.no_ujian = no_ujian;
        this.no_aplikan = no_aplikan;
        this.nama = nama;
        this.presenter = presenter;
        this.jur1 = jur1;
        this.jur2 = jur2;
        this.tanggal = tanggal;
        this.benar = benar;
        this.waktu = waktu;
        this.grade = grade;
        this.petugas = petugas;
    }

    public int getBenar() {
        return benar;
    }

    public void setBenar(int benar) {
        this.benar = benar;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    
}
