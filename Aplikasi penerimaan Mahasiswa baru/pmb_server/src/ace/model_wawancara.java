/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_aplikan;
import entity.entitas_wawancara;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_wawancara extends AbstractTableModel{
    
    private List<entitas_wawancara>daftar=new ArrayList<entitas_wawancara>();
    
    public model_wawancara(){
        
    }
       public entitas_wawancara get(int r){
        return daftar.get(r);
    }
public void insert(entitas_wawancara ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_wawancara ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_wawancara> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "NO Ujian";
            case 1:return "NO Aplikan";
            case 2:return "Nama";
            case 3:return "Prioritas";
            case 4:return "Lulus Di";
            case 5:return "Petugas";
                default:return null;
        }
    } 
    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return daftar.get(rowIndex).getNo_ujian();
            case 1:return daftar.get(rowIndex).getNo_aplikan();
            case 2:return daftar.get(rowIndex).getNama();
            case 3:return daftar.get(rowIndex).getJur1();
            case 4:return daftar.get(rowIndex).getJurusan();
            case 5:return daftar.get(rowIndex).getPetugas();
            default:return null;
        }
    }
    
}
