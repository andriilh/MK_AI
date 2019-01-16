/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_laporan;

import java.io.Serializable;

/**
 *
 * @author radhial22
 */
public class lap_rekapInter implements Serializable{
    private int jumlah_interview;
    private String tb_pewawancara_kd_pewawancara;
    private String tb_pewawancara_nama;
    private String tb_wawancara_petugas;

    public lap_rekapInter() {
    }

    public lap_rekapInter(int jumlah_interview, String tb_pewawancara_kd_pewawancara, String tb_pewawancara_nama, String tb_wawancara_petugas) {
        this.jumlah_interview = jumlah_interview;
        this.tb_pewawancara_kd_pewawancara = tb_pewawancara_kd_pewawancara;
        this.tb_pewawancara_nama = tb_pewawancara_nama;
        this.tb_wawancara_petugas = tb_wawancara_petugas;
    }

    public int getJumlah_interview() {
        return jumlah_interview;
    }

    public void setJumlah_interview(int jumlah_interview) {
        this.jumlah_interview = jumlah_interview;
    }

    public String getTb_pewawancara_kd_pewawancara() {
        return tb_pewawancara_kd_pewawancara;
    }

    public void setTb_pewawancara_kd_pewawancara(String tb_pewawancara_kd_pewawancara) {
        this.tb_pewawancara_kd_pewawancara = tb_pewawancara_kd_pewawancara;
    }

    public String getTb_pewawancara_nama() {
        return tb_pewawancara_nama;
    }

    public void setTb_pewawancara_nama(String tb_pewawancara_nama) {
        this.tb_pewawancara_nama = tb_pewawancara_nama;
    }

    public String getTb_wawancara_petugas() {
        return tb_wawancara_petugas;
    }

    public void setTb_wawancara_petugas(String tb_wawancara_petugas) {
        this.tb_wawancara_petugas = tb_wawancara_petugas;
    }

    
}
