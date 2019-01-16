/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_jurusan;
import entity.entitas_petugas_ujian;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_petugasUjian extends AbstractTableModel{
    
    private List<entitas_petugas_ujian>daftar=new ArrayList<entitas_petugas_ujian>();
    
    public model_petugasUjian(){
        
    }
       public entitas_petugas_ujian get(int r){
        return daftar.get(r);
    }
public void insert(entitas_petugas_ujian ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_petugas_ujian ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_petugas_ujian> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "NIK";
            case 1:return "Nama";
            case 2:return "Nomor HP";
                default:return null;
        }
    } 
    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return daftar.get(rowIndex).getKd_petugas();
            case 1:return daftar.get(rowIndex).getNama();
            case 2:return daftar.get(rowIndex).getNo_hp();
            default:return null;
        }
    }
    
}
