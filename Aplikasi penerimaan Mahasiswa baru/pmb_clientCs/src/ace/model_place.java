/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_aplikan;
import entity.entitas_place;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_place extends AbstractTableModel{
    
    private List<entitas_place>daftar=new ArrayList<entitas_place>();
    
    public model_place(){
        
    }
       public entitas_place get(int r){
        return daftar.get(r);
    }
public void insert(entitas_place ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_place ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_place> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "nama";
            case 1:return "Tanggal";
            case 2:return "Program Prioritas";
            case 3:return "Alternatif";
            case 4:return "Petugas Ujian";
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
            case 0:return daftar.get(rowIndex).getNama();
            case 1:return daftar.get(rowIndex).getTgl();
            case 2:return daftar.get(rowIndex).getJur1();
            case 3:return daftar.get(rowIndex).getJur2();
            case 4:return daftar.get(rowIndex).getPetugas();
            default:return null;
        }
    }
}
