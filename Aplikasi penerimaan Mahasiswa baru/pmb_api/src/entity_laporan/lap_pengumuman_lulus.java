/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_laporan;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author radhial22
 */
public class lap_pengumuman_lulus implements Serializable{
    private String tb_inggris_no_ujian;
    private Date tb_inggris_tgl;
    private String tb_inggris_grade;
    private String tb_wawancara_no_ujian;
    private String tb_wawancara_no_aplikan;
    private String tb_wawancara_nama;
    private String tb_wawancara_jurusan;
    private Date tgl1;
    private Date tgl2;

    public lap_pengumuman_lulus() {
    }

    public lap_pengumuman_lulus(String tb_inggris_no_ujian, Date tb_inggris_tgl, String tb_inggris_grade, String tb_wawancara_no_ujian, String tb_wawancara_no_aplikan, String tb_wawancara_nama, String tb_wawancara_jurusan, Date tgl1, Date tgl2) {
        this.tb_inggris_no_ujian = tb_inggris_no_ujian;
        this.tb_inggris_tgl = tb_inggris_tgl;
        this.tb_inggris_grade = tb_inggris_grade;
        this.tb_wawancara_no_ujian = tb_wawancara_no_ujian;
        this.tb_wawancara_no_aplikan = tb_wawancara_no_aplikan;
        this.tb_wawancara_nama = tb_wawancara_nama;
        this.tb_wawancara_jurusan = tb_wawancara_jurusan;
        this.tgl1 = tgl1;
        this.tgl2 = tgl2;
    }

    public String getTb_inggris_grade() {
        return tb_inggris_grade;
    }

    public void setTb_inggris_grade(String tb_inggris_grade) {
        this.tb_inggris_grade = tb_inggris_grade;
    }

    public String getTb_inggris_no_ujian() {
        return tb_inggris_no_ujian;
    }

    public void setTb_inggris_no_ujian(String tb_inggris_no_ujian) {
        this.tb_inggris_no_ujian = tb_inggris_no_ujian;
    }

    public Date getTb_inggris_tgl() {
        return tb_inggris_tgl;
    }

    public void setTb_inggris_tgl(Date tb_inggris_tgl) {
        this.tb_inggris_tgl = tb_inggris_tgl;
    }

    public String getTb_wawancara_jurusan() {
        return tb_wawancara_jurusan;
    }

    public void setTb_wawancara_jurusan(String tb_wawancara_jurusan) {
        this.tb_wawancara_jurusan = tb_wawancara_jurusan;
    }

    public String getTb_wawancara_nama() {
        return tb_wawancara_nama;
    }

    public void setTb_wawancara_nama(String tb_wawancara_nama) {
        this.tb_wawancara_nama = tb_wawancara_nama;
    }

    public String getTb_wawancara_no_aplikan() {
        return tb_wawancara_no_aplikan;
    }

    public void setTb_wawancara_no_aplikan(String tb_wawancara_no_aplikan) {
        this.tb_wawancara_no_aplikan = tb_wawancara_no_aplikan;
    }

    public String getTb_wawancara_no_ujian() {
        return tb_wawancara_no_ujian;
    }

    public void setTb_wawancara_no_ujian(String tb_wawancara_no_ujian) {
        this.tb_wawancara_no_ujian = tb_wawancara_no_ujian;
    }

    public Date getTgl1() {
        return tgl1;
    }

    public void setTgl1(Date tgl1) {
        this.tgl1 = tgl1;
    }

    public Date getTgl2() {
        return tgl2;
    }

    public void setTgl2(Date tgl2) {
        this.tgl2 = tgl2;
    }
   
}
