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
public class entitas_lapSuratLulus implements Serializable{
    private String nama;
    private String no_ujian;
    private String jurusan;
    private String test1;
    private String waktu1;
    private String test2;
    private String waktu2;
    private String test3;
    private String waktu3;
    private String grade;

    public entitas_lapSuratLulus() {
    }

    public entitas_lapSuratLulus(String nama, String no_ujian, String jurusan, String test1, String waktu1, String test2, String waktu2, String test3, String waktu3, String grade) {
        this.nama = nama;
        this.no_ujian = no_ujian;
        this.jurusan = jurusan;
        this.test1 = test1;
        this.waktu1 = waktu1;
        this.test2 = test2;
        this.waktu2 = waktu2;
        this.test3 = test3;
        this.waktu3 = waktu3;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_ujian() {
        return no_ujian;
    }

    public void setNo_ujian(String no_ujian) {
        this.no_ujian = no_ujian;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3;
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
