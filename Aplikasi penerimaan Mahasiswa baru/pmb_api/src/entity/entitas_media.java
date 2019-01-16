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
public class entitas_media implements Serializable {
    private String kd_media;
    private String media_info;

    public entitas_media() {
    }

    public entitas_media(String kd_media, String media_info) {
        this.kd_media = kd_media;
        this.media_info = media_info;
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

  
}
