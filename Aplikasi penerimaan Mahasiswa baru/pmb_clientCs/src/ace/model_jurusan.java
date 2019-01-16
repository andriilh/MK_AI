/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_jurusan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_jurusan extends AbstractTableModel{
    
    private List<entitas_jurusan>daftar=new ArrayList<entitas_jurusan>();
    
    public model_jurusan(){
        
    }
       public entitas_jurusan get(int r){
        return daftar.get(r);
    }
public void insert(entitas_jurusan ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_jurusan ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_jurusan> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Kode Jurusan";
            case 1:return "Jurusan";
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
            case 0:return daftar.get(rowIndex).getKd_jurusan();
            case 1:return daftar.get(rowIndex).getJurusan();
            default:return null;
        }
    }
    
}
