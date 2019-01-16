/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_jurusan;
import entity.entitas_kab;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_kab extends AbstractTableModel{
    
    private List<entitas_kab>daftar=new ArrayList<entitas_kab>();
    
    public model_kab(){
        
    }
       public entitas_kab get(int r){
        return daftar.get(r);
    }
public void insert(entitas_kab ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_kab ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_kab> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Kode Kabupaten";
            case 1:return "Kabupaten";
                default:return null;
        }
    } 
    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return daftar.get(rowIndex).getKd_kab();
            case 1:return daftar.get(rowIndex).getKabupaten();
            default:return null;
        }
    }
    
}
