/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_aplikan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_aplikan2 extends AbstractTableModel{
    
    private List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
    
    public model_aplikan2(){
        
    }
       public entitas_aplikan get(int r){
        return daftar.get(r);
    }
public void insert(entitas_aplikan ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_aplikan ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_aplikan> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "No.Ujian";
            case 1:return "Nama";
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
            case 0:return daftar.get(rowIndex).getNo_ujian();
            case 1:return daftar.get(rowIndex).getNama();
            default:return null;
        }
    }
    
}
