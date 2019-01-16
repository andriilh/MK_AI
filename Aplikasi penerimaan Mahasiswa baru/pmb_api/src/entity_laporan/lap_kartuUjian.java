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
public class lap_kartuUjian implements Serializable{
    private String no;
    private String nama;

    public lap_kartuUjian() {
    }

    public lap_kartuUjian(String no, String nama) {
        this.no = no;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    
}
