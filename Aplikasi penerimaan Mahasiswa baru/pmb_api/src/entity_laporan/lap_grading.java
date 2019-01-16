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
public class lap_grading implements Serializable{
    private String tb_ing_noujian;
    private String tb_wawan_noujian;
    private String jur;
    private String nama;
    private String grade;

    public lap_grading() {
    }

    public lap_grading(String tb_ing_noujian, String tb_wawan_noujian, String jur, String nama, String grade) {
        this.tb_ing_noujian = tb_ing_noujian;
        this.tb_wawan_noujian = tb_wawan_noujian;
        this.jur = jur;
        this.nama = nama;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getJur() {
        return jur;
    }

    public void setJur(String jur) {
        this.jur = jur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTb_ing_noujian() {
        return tb_ing_noujian;
    }

    public void setTb_ing_noujian(String tb_ing_noujian) {
        this.tb_ing_noujian = tb_ing_noujian;
    }

    public String getTb_wawan_noujian() {
        return tb_wawan_noujian;
    }

    public void setTb_wawan_noujian(String tb_wawan_noujian) {
        this.tb_wawan_noujian = tb_wawan_noujian;
    }
    
}
