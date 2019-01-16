/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_aplikan;
import entity.entitas_kelas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_kelas extends AbstractTableModel{
    
    private List<entitas_kelas>daftar=new ArrayList<entitas_kelas>();
    
    public model_kelas(){
        
    }
       public entitas_kelas get(int r){
        return daftar.get(r);
    }
public void insert(entitas_kelas ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_kelas ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_kelas> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Kode Kelas";
            case 1:return "Kelas";
            case 2:return "Jumlah Siswa";
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
            case 0:return daftar.get(rowIndex).getKd_kelas();
            case 1:return daftar.get(rowIndex).getKelas();
            case 2:return daftar.get(rowIndex).getJumlahSiswa();
            default:return null;
        }
    }
    
}
