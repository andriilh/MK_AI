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
public class entitas_soal implements Serializable{
    private String kd_soal;
    private String soal;
    private String pilihan1;
    private String pilihan2;
    private String pilihan3;
    private String pilihan4;
    private String pilihan5;
    private String benar;
    private String jumlah;

    public entitas_soal() {
    }

    public entitas_soal(String kd_soal, String soal, String pilihan1, String pilihan2, String pilihan3, String pilihan4, String pilihan5, String benar, String jumlah) {
        this.kd_soal = kd_soal;
        this.soal = soal;
        this.pilihan1 = pilihan1;
        this.pilihan2 = pilihan2;
        this.pilihan3 = pilihan3;
        this.pilihan4 = pilihan4;
        this.pilihan5 = pilihan5;
        this.benar = benar;
        this.jumlah = jumlah;
    }

    public String getBenar() {
        return benar;
    }

    public void setBenar(String benar) {
        this.benar = benar;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getKd_soal() {
        return kd_soal;
    }

    public void setKd_soal(String kd_soal) {
        this.kd_soal = kd_soal;
    }

    public String getPilihan1() {
        return pilihan1;
    }

    public void setPilihan1(String pilihan1) {
        this.pilihan1 = pilihan1;
    }

    public String getPilihan2() {
        return pilihan2;
    }

    public void setPilihan2(String pilihan2) {
        this.pilihan2 = pilihan2;
    }

    public String getPilihan3() {
        return pilihan3;
    }

    public void setPilihan3(String pilihan3) {
        this.pilihan3 = pilihan3;
    }

    public String getPilihan4() {
        return pilihan4;
    }

    public void setPilihan4(String pilihan4) {
        this.pilihan4 = pilihan4;
    }

    public String getPilihan5() {
        return pilihan5;
    }

    public void setPilihan5(String pilihan5) {
        this.pilihan5 = pilihan5;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }
    
}
