/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_login extends AbstractTableModel{
    
    private List<entitas_login>daftar=new ArrayList<entitas_login>();
    
    public model_login(){
        
    }
       public entitas_login get(int r){
        return daftar.get(r);
    }
public void insert(entitas_login ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_login ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_login> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "ID User";
            case 1:return "Pass";
            case 2:return "Status";
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
            case 0:return daftar.get(rowIndex).getId();
            case 1:return daftar.get(rowIndex).getPass();
            case 2:return daftar.get(rowIndex).getStatus();
            default:return null;
        }
    }
    
}
