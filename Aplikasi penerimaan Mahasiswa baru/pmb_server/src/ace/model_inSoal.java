/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_jurusan;
import entity.entitas_soal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_inSoal extends AbstractTableModel{
    
    private List<entitas_soal>daftar=new ArrayList<entitas_soal>();
    
    public model_inSoal(){
        
    }
       public entitas_soal get(int r){
        return daftar.get(r);
    }
public void insert(entitas_soal ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_soal ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_soal> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Kode Soal";
            case 1:return "Soal";
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
            case 0:return daftar.get(rowIndex).getKd_soal();
            case 1:return daftar.get(rowIndex).getSoal();
            default:return null;
        }
    }
    
}
