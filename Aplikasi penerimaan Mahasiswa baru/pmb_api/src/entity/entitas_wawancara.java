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
public class entitas_wawancara implements Serializable {
    private String no_ujian;
    private String no_aplikan;
    private String nama;
    private String jur1;
    private String jur2;
    private String komu_lisan;
    private String komu_tulis;
    private String kem_intelek;
    private String motivasi;
    private String kedewasaa;
    private String kem_kerjasama;
    private String pd;
    private String daya_analisis;
    private String kem_adm;
    private String kelebihan;
    private String penampilan;
    private String penyakit;
    private String kacamata;
    private String ukuran;
    private String iq;
    private String kesimpulan;
    private String predikat;
    private String jurusan;
    private String petugas;

    public entitas_wawancara() {
    }

    public entitas_wawancara(String no_ujian, String no_aplikan, String nama, String jur1, String jur2, String komu_lisan, String komu_tulis, String kem_intelek, String motivasi, String kedewasaa, String kem_kerjasama, String pd, String daya_analisis, String kem_adm, String kelebihan, String penampilan, String penyakit, String kacamata, String ukuran, String iq, String kesimpulan, String predikat, String jurusan, String petugas) {
        this.no_ujian = no_ujian;
        this.no_aplikan = no_aplikan;
        this.nama = nama;
        this.jur1 = jur1;
        this.jur2 = jur2;
        this.komu_lisan = komu_lisan;
        this.komu_tulis = komu_tulis;
        this.kem_intelek = kem_intelek;
        this.motivasi = motivasi;
        this.kedewasaa = kedewasaa;
        this.kem_kerjasama = kem_kerjasama;
        this.pd = pd;
        this.daya_analisis = daya_analisis;
        this.kem_adm = kem_adm;
        this.kelebihan = kelebihan;
        this.penampilan = penampilan;
        this.penyakit = penyakit;
        this.kacamata = kacamata;
        this.ukuran = ukuran;
        this.iq = iq;
        this.kesimpulan = kesimpulan;
        this.predikat = predikat;
        this.jurusan = jurusan;
        this.petugas = petugas;
    }

    public String getDaya_analisis() {
        return daya_analisis;
    }

    public void setDaya_analisis(String daya_analisis) {
        this.daya_analisis = daya_analisis;
    }

    public String getIq() {
        return iq;
    }

    public void setIq(String iq) {
        this.iq = iq;
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

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKacamata() {
        return kacamata;
    }

    public void setKacamata(String kacamata) {
        this.kacamata = kacamata;
    }

    public String getKedewasaa() {
        return kedewasaa;
    }

    public void setKedewasaa(String kedewasaa) {
        this.kedewasaa = kedewasaa;
    }

    public String getKelebihan() {
        return kelebihan;
    }

    public void setKelebihan(String kelebihan) {
        this.kelebihan = kelebihan;
    }

    public String getKem_adm() {
        return kem_adm;
    }

    public void setKem_adm(String kem_adm) {
        this.kem_adm = kem_adm;
    }

    public String getKem_intelek() {
        return kem_intelek;
    }

    public void setKem_intelek(String kem_intelek) {
        this.kem_intelek = kem_intelek;
    }

    public String getKem_kerjasama() {
        return kem_kerjasama;
    }

    public void setKem_kerjasama(String kem_kerjasama) {
        this.kem_kerjasama = kem_kerjasama;
    }

    public String getKesimpulan() {
        return kesimpulan;
    }

    public void setKesimpulan(String kesimpulan) {
        this.kesimpulan = kesimpulan;
    }

    public String getKomu_lisan() {
        return komu_lisan;
    }

    public void setKomu_lisan(String komu_lisan) {
        this.komu_lisan = komu_lisan;
    }

    public String getKomu_tulis() {
        return komu_tulis;
    }

    public void setKomu_tulis(String komu_tulis) {
        this.komu_tulis = komu_tulis;
    }

    public String getMotivasi() {
        return motivasi;
    }

    public void setMotivasi(String motivasi) {
        this.motivasi = motivasi;
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

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getPenampilan() {
        return penampilan;
    }

    public void setPenampilan(String penampilan) {
        this.penampilan = penampilan;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getPredikat() {
        return predikat;
    }

    public void setPredikat(String predikat) {
        this.predikat = predikat;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
    
}
