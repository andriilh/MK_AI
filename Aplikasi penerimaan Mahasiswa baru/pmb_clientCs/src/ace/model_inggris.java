/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ace;

import entity.entitas_inggris;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author radhial22
 */
public class model_inggris extends AbstractTableModel{
    
    private List<entitas_inggris>daftar=new ArrayList<entitas_inggris>();
    
    public model_inggris(){
        
    }
       public entitas_inggris get(int r){
        return daftar.get(r);
    }
public void insert(entitas_inggris ent){
    daftar.add(ent);
    fireTableDataChanged();
}

public void update(int row,entitas_inggris ent){
    daftar.set(row, ent);
    fireTableChanged(null);
}

public void delete(int row){
    daftar.remove(row);
    fireTableDataChanged();
}

public void setdata(List<entitas_inggris> daftar){
    this.daftar=daftar;
    fireTableDataChanged();
}
 @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "No. Ujian";
            case 1:return "No. Aplikan";
            case 2:return "Nama";
            case 3:return "Presenter";
            case 4:return "Tgl. Tes";
            case 5:return "Benar";
            case 6:return "Waktu";
            case 7:return "Grade";
            case 8:return "Petugas";
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
            case 0:return daftar.get(rowIndex).getNo_ujian();
            case 1:return daftar.get(rowIndex).getNo_aplikan();
            case 2:return daftar.get(rowIndex).getNama();
            case 3:return daftar.get(rowIndex).getPresenter();
            case 4:return daftar.get(rowIndex).getTanggal();
            case 5:return daftar.get(rowIndex).getBenar();
            case 6:return daftar.get(rowIndex).getWaktu();
            case 7:return daftar.get(rowIndex).getGrade();
            case 8:return daftar.get(rowIndex).getPetugas();
            default:return null;
        }
    }
    
}
