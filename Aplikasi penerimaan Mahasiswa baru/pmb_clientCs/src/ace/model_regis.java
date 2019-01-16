/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_aplikan;
import entity.entitas_registrasi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_regis extends AbstractTableModel{
    
    private List<entitas_registrasi>daftar=new ArrayList<entitas_registrasi>();
    
    public model_regis(){
        
    }
       public entitas_registrasi get(int r){
        return daftar.get(r);
    }
public void insert(entitas_registrasi ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_registrasi ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_registrasi> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "NO Registrasi";
            case 1:return "Nomor Aplikan";
            case 2:return "Nama Aplikan";
            case 3:return "Tanggal";
            case 4:return "Kelas";
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
            case 0:return daftar.get(rowIndex).getNo_regis();
            case 1:return daftar.get(rowIndex).getNo_aplikan();
            case 2:return daftar.get(rowIndex).getNama();
            case 3:return daftar.get(rowIndex).getTgl();
            case 4:return daftar.get(rowIndex).getKls();
            default:return null;
        }
    }
    
}
