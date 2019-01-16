/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_jurusan;
import entity.entitas_kab;
import entity.entitas_media;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_media extends AbstractTableModel{
    
    private List<entitas_media>daftar=new ArrayList<entitas_media>();
    
    public model_media(){
        
    }
       public entitas_media get(int r){
        return daftar.get(r);
    }
public void insert(entitas_media ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_media ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_media> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Kode Media";
            case 1:return "Media";
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
            case 0:return daftar.get(rowIndex).getKd_media();
            case 1:return daftar.get(rowIndex).getMedia_info();
            default:return null;
        }
    }
    
}
