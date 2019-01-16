/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_jurusan;
import entity.entitas_sekolah;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_sekolah extends AbstractTableModel{
    
    private List<entitas_sekolah>daftar=new ArrayList<entitas_sekolah>();
    
    public model_sekolah(){
        
    }
       public entitas_sekolah get(int r){
        return daftar.get(r);
    }
public void insert(entitas_sekolah ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_sekolah ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_sekolah> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Kode Sekolah";
            case 1:return "Nama Sekolah";
            case 2:return "Kabupaten";
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
            case 0:return daftar.get(rowIndex).getKd_sekolah();
            case 1:return daftar.get(rowIndex).getNama();
            case 2:return daftar.get(rowIndex).getKabuaten();
            default:return null;
        }
    }
    
}
