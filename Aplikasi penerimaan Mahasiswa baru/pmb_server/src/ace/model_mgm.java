/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_jurusan;
import entity.entitas_kab;
import entity.entitas_media;
import entity.entitas_mgm;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_mgm extends AbstractTableModel{
    
    private List<entitas_mgm>daftar=new ArrayList<entitas_mgm>();
    
    public model_mgm(){
        
    }
       public entitas_mgm get(int r){
        return daftar.get(r);
    }
public void insert(entitas_mgm ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_mgm ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_mgm> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Kode MGM";
            case 1:return "Nama MGM";
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
            case 0:return daftar.get(rowIndex).getKd_mgm();
            case 1:return daftar.get(rowIndex).getNama();
            default:return null;
        }
    }
    
}
