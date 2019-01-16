/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas_lap;

/**
 *
 * @author radhial22
 */
public class entitas_laptes {
    private String kd_soal;
    private String soal;

    public entitas_laptes() {
    }

    public entitas_laptes(String kd_soal, String soal) {
        this.kd_soal = kd_soal;
        this.soal = soal;
    }

    public String getKd_soal() {
        return kd_soal;
    }

    public void setKd_soal(String kd_soal) {
        this.kd_soal = kd_soal;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }
        
    
}
