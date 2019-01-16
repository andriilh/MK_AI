/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_aplikan;
import entity.entitas_pendaftaran;
import entity.entitas_place;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_pendaftaran extends AbstractTableModel{
    
    private List<entitas_pendaftaran>daftar=new ArrayList<entitas_pendaftaran>();
    
    public model_pendaftaran(){
        
    }
       public entitas_pendaftaran get(int r){
        return daftar.get(r);
    }
public void insert(entitas_pendaftaran ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_pendaftaran ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_pendaftaran> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "NO Daftar";
            case 1:return "No Aplikan";
            case 2:return "NO Ujian";
            case 3:return "Nama";
            case 4:return "Tgl Daftar";
            case 5:return "Tahun Ajaran";
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
            case 0:return daftar.get(rowIndex).getNo_daftar();
            case 1:return daftar.get(rowIndex).getNo_aplikan();
            case 2:return daftar.get(rowIndex).getNo_ujian();
            case 3:return daftar.get(rowIndex).getNama();
            case 4:return daftar.get(rowIndex).getTgl();
            case 5:return daftar.get(rowIndex).getThn_ajaran();
            default:return null;
        }
    }
    
}
