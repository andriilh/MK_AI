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
public class lap_grafikMedia implements Serializable{
    private int jumlah;
    private String sumber_info;
    private String kd_media;
    private String media_info;

    public lap_grafikMedia() {
    }

    public lap_grafikMedia(int jumlah, String sumber_info, String kd_media, String media_info) {
        this.jumlah = jumlah;
        this.sumber_info = sumber_info;
        this.kd_media = kd_media;
        this.media_info = media_info;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKd_media() {
        return kd_media;
    }

    public void setKd_media(String kd_media) {
        this.kd_media = kd_media;
    }

    public String getMedia_info() {
        return media_info;
    }

    public void setMedia_info(String media_info) {
        this.media_info = media_info;
    }

    public String getSumber_info() {
        return sumber_info;
    }

    public void setSumber_info(String sumber_info) {
        this.sumber_info = sumber_info;
    }
    
}
