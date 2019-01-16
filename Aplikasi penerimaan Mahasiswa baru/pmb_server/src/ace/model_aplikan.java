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
public class model_aplikan extends AbstractTableModel{
    
    private List<entitas_aplikan>daftar=new ArrayList<entitas_aplikan>();
    
    public model_aplikan(){
        
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
            case 0:return "Kode Aplikan";
            case 1:return "Nama";
            case 2:return "Tempat Lahir";
            case 3:return "Tanggal Lahir";
            case 4:return "Alamat";
            case 5:return "Pendidikan";
            case 6:return "Tahun Lulus";
            case 7:return "Presenter";
            case 8:return "SMA";
                default:return null;
        }
    } 
    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return daftar.get(rowIndex).getNomor_aplikan();
            case 1:return daftar.get(rowIndex).getNama();
            case 2:return daftar.get(rowIndex).getTmp_lahir();
            case 3:return daftar.get(rowIndex).getTgl_lahir();
            case 4:return daftar.get(rowIndex).getAlamat();
            case 5:return daftar.get(rowIndex).getPend_terakhir();
            case 6:return daftar.get(rowIndex).getThn_lulus();
            case 7:return daftar.get(rowIndex).getPrsenter();
            case 8:return daftar.get(rowIndex).getSma();
            default:return null;
        }
    }
    
}
