/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_aplikan;
import entity.entitas_tahun;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_tahun extends AbstractTableModel{
    
    private List<entitas_tahun>daftar=new ArrayList<entitas_tahun>();
    
    public model_tahun(){
        
    }
       public entitas_tahun get(int r){
        return daftar.get(r);
    }
public void insert(entitas_tahun ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_tahun ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_tahun> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Tahun Ajaran";
            case 1:return "Biaya";
            case 2:return "Diskon Quis";
            case 3:return "Diskon Sekolah";
            case 4:return "Undangan";
                default:return null;
        }
    } 
    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return daftar.get(rowIndex).getThn_ajaran();
            case 1:return daftar.get(rowIndex).getBiaya_daftar();
            case 2:return daftar.get(rowIndex).getDisk_quis();
            case 3:return daftar.get(rowIndex).getDisk_sekolah();
            case 4:return daftar.get(rowIndex).getUndangan();
            default:return null;
        }
    }
    
}
