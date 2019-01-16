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
public class entitas_kelas implements Serializable{
    private String kd_kelas;
    private String kelas;
    private int jumlahSiswa;

    public entitas_kelas() {
    }

    public entitas_kelas(String kd_kelas, String kelas, int jumlahSiswa) {
        this.kd_kelas = kd_kelas;
        this.kelas = kelas;
        this.jumlahSiswa = jumlahSiswa;
    }

    public int getJumlahSiswa() {
        return jumlahSiswa;
    }

    public void setJumlahSiswa(int jumlahSiswa) {
        this.jumlahSiswa = jumlahSiswa;
    }

    public String getKd_kelas() {
        return kd_kelas;
    }

    public void setKd_kelas(String kd_kelas) {
        this.kd_kelas = kd_kelas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
}
