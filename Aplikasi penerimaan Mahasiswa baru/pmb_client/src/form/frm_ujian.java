/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entitas_lap.entitas_laptes;
import entity.*;
import intface.intface_aplikan;
import intface.intface_inggris;
import intface.intface_petugas_ujian;
import intface.intface_soal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.hssf.record.PageBreakRecord;

/**
 *
 * @author radhial22
 */
public class frm_ujian extends javax.swing.JFrame {
    List<entitas_soal>daftar = new ArrayList<entitas_soal>();
    List<entitas_soal>daftar2=new ArrayList<entitas_soal>();
    intface_soal ins;
    intface_petugas_ujian inpet;
    intface_aplikan iap;
    intface_inggris inggris;
    int r;
    int nilai=0;
    int salah=0;
    boolean benar;
    
Timer time;
int milideti,detik,menit,jam;
String nol_jam = "";
  String nol_men = "";
  String nol_det = "";
  String nol_mili = "";
  
    /**
     * Creates new form frm_ujian
     */
    public frm_ujian(intface_soal ins,intface_petugas_ujian inpet,intface_aplikan iap,intface_inggris inggris) {
        this.ins=ins;
        this.inpet=inpet;
        this.iap=iap;
        this.inggris=inggris;
        initComponents();
        jDialog2.setSize(400, 165);
        jDialog2.setLocationRelativeTo(null);
        petugas_ujian.requestFocus();
        jDialog2.setVisible(true);
        setLocationRelativeTo(null);
        enab(false); 
        txt_benar.setText("0");
        setSize(800, 210);
        takesoal2();
        //takeSoal();
        
        isi();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                r= jTable1.getSelectedRow();
                if(r!=-1){
                    entitas_soal ent = daftar.get(r);
                    kd_soal.setText(ent.getKd_soal());
                    getbenar.setText(ent.getBenar());
//                    jTextArea1.setText(ent.getSoal());
//                    a.setText(ent.getPilihan1());
//                    b.setText(ent.getPilihan2());
//                    c.setText(ent.getPilihan3());
//                    d.setText(ent.getPilihan4());
//                    eee.setText(ent.getPilihan5());
                    takebykd();
                }
            }
        });
        
       
    }
    
    void takeSoal(){
        try {
            daftar=ins.getby();
        } catch (RemoteException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void takesoal2(){
        try {
            daftar=ins.getby();
        } catch (RemoteException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void takebykd(){
        try {
            entitas_soal entt =new entitas_soal();
            entt=ins.getbyno(kd_soal.getText());
            jTextArea1.setText(entt.getSoal());
                    a.setText(entt.getPilihan1());
                    b.setText(entt.getPilihan2());
                    c.setText(entt.getPilihan3());
                    d.setText(entt.getPilihan4());
                    eee.setText(entt.getPilihan5());
//            if(getter.getText().equalsIgnoreCase(getbenar.getText())){
//               nilai++;
//                txt_benar.setText(String.valueOf(nilai));
//                jTextArea1.setText(entt.getSoal());
//                    a.setText(entt.getPilihan1());
//                    b.setText(entt.getPilihan2());
//                    c.setText(entt.getPilihan3());
//                    d.setText(entt.getPilihan4());
//                    eee.setText(entt.getPilihan5());
//                    
//            }else {
//                
//           jTextArea1.setText(entt.getSoal());
//                    a.setText(entt.getPilihan1());
//                    b.setText(entt.getPilihan2());
//                    c.setText(entt.getPilihan3());
//                    d.setText(entt.getPilihan4());
//                    eee.setText(entt.getPilihan5());
//        }
        } catch (RemoteException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    void visible(boolean a){
        no_ujian.setVisible(a);
        nama.setVisible(a);
        presenter.setVisible(a);
        jur1.setVisible(a);
        jur2.setVisible(a);
        waktu.setVisible(a);
        txt_benar.setVisible(a);
        grade.setVisible(a);
        tgl.setVisible(a);
        
    }
    
    void isi(){
        Object dat [][]=new Object[daftar.size()][2];
        int i =0;
        for(entitas_soal ent:daftar){
            dat[i][0]=ent.getKd_soal();
            dat[i][1]=ent.getBenar();
            i++;
        }
        String nm[]={"Soal","Benar"};
        jTable1.setModel(new DefaultTableModel(dat,nm));
        jScrollPane2.setViewportView(jTable1);
    }
    
    void next(){
        int row = jTable1.getSelectedRow();
        int b =  jTable1.getRowCount();
        int c = jTable1.getRowCount();
        
        
      
        b-=1;
        if(row==b){
            row=b;
        }else {
            row+=1;
        }
        jTable1.changeSelection(row, WIDTH, false, false);
        int i =jTable1.getSelectedRow();
        nilaitabel.setText(String.valueOf(i));
        if(nilaitabel.getText().equalsIgnoreCase("25")){
            try {
                
                entitas_inggris ening = new entitas_inggris();
                ening.setNo_ujian(no_ujian.getText());
                ening.setNo_aplikan(no_aplikan.getText());
                ening.setNama(nama.getText());
                ening.setPresenter(presenter.getText());
                ening.setJur1(jur1.getText());
                ening.setJur2(jur2.getText());
                ening.setTanggal((Date)tgl.getValue());
                ening.setBenar(Integer.parseInt(txt_benar.getText()));
                ening.setWaktu(waktu.getText());
                
                ening.setGrade(grade.getText());
                ening.setPetugas(petugas_ujian.getText());
                
                
                inggris.insert(ening);
                setVisible(false);
                
                jDialog3.setSize(350, 300);
                jDialog3.setVisible(true);
                jDialog3.setLocationRelativeTo(null);
                no_ujian2.setText(no_ujian.getText());
                nama2.setText(nama.getText());
                benar2.setText(txt_benar.getText());
                grade2.setText(grade.getText());
            } catch (RemoteException ex) {
                Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex);
            }
            time.stop();
        }
    }
    
    void enab(boolean a){
        no_ujian.setEnabled(a);
        nama.setEnabled(a);
        presenter.setEnabled(a);
        jur1.setEnabled(a);
        jur2.setEnabled(a);
        waktu.setEnabled(a);
        txt_benar.setEnabled(a);
        grade.setEnabled(a);
        tgl.setEnabled(a);
    }
    
    void empt(){
        no_ujian.setText("");
        no_aplikan.setText("");
        nama.setText("");
        presenter.setText("");
        jur1.setText("");
        jur2.setText("");
        txt_benar.setText("");
        grade.setText("");
        petugas_ujian.setText("");
    }
    
    void radio(){
        jbe.setSelected(false);
        jba.setSelected(false);
        jbb.setSelected(false);
        jbc.setSelected(false);
        jbd.setSelected(false);
    }
    
    void verivy(){
        entitas_soal ent = new entitas_soal();
        if(jba.isSelected()){
            
        }
    }
    
void waktuUjian(){
    ActionListener ts = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               milideti++;
               if(milideti==100){
                   milideti=0;
                   
                   detik++;
                   if(detik==60){
                       detik=0;
                       
                       menit++;
                       if(menit==60){
                           menit=0;
                           jam++;
                           if(jam==24);{
                               jam=0;
                           }
                       }
                   }
               }
               
               if(jam<=9){
                   nol_jam ="0";
               }else {
                   nol_jam="";
               }
               if(menit<=9){
                   nol_men="0";
               }else{
                   nol_men="";
               }
               if(detik<=9){
                   nol_det="0";
               }else{
                   nol_det="";
               }
               if(milideti<=9){
                   nol_mili="0";
               }else{
                   nol_mili="";
               }
                waktu.setText(nol_jam+Integer.toString(jam)+":"+nol_men + Integer.toString(menit)+":"+
                        nol_det + Integer.toString(detik)+":"+ nol_mili + Integer.toString(milideti));
            }
        };
    time = new Timer(10, ts);
    time.start();
    
}

void waktuDua(){
    ActionListener ts = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               milideti++;
               if(milideti==100){
                   milideti=0;
                   
                   detik++;
                   if(detik==60){
                       detik=0;
                       
                       menit++;
                       if(menit==60){
                           menit=0;
                           
                       }
                   }
               }
               
               
               if(menit<=9){
                   nol_men="0";
               }else{
                   nol_men="";
               }
               if(detik<=9){
                   nol_det="0";
               }else{
                   nol_det="";
               }
               if(milideti<=9){
                   nol_mili="0";
               }else{
                   nol_mili="";
               }
                waktu.setText(nol_men + Integer.toString(menit)+":"+
                        nol_det + Integer.toString(detik)+":"+ nol_mili + Integer.toString(milideti));
            }
        };
    time = new Timer(10, ts);
    time.start();
}

void loginPetugas(){
        try {
            entitas_petugas_ujian ent = new entitas_petugas_ujian();
            ent=inpet.getbyname(petugas_ujian.getText());
            if(petugas_ujian.getText().equalsIgnoreCase(ent.getNama())){
                jDialog2.setVisible(false);
                enab(true);
                no_ujian.requestFocus();
            }else {
                JOptionPane.showMessageDialog(this, "Petugas Tidak Dikenali, atau Terjadi Gangguan Koneksi Server!!!");
                //enab(false);
            }
        } catch (RemoteException ex) {
             JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        no_aplikan = new javax.swing.JTextField();
        getter = new javax.swing.JTextField();
        kd_soal = new javax.swing.JTextField();
        nilaitabel = new javax.swing.JTextField();
        getbenar = new javax.swing.JTextField();
        jDialog2 = new javax.swing.JDialog();
        panelMenu1 = new ace.panelMenu();
        jPanel4 = new javax.swing.JPanel();
        petugas_ujian = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jDialog3 = new javax.swing.JDialog();
        panelMenu_white2 = new ace.panelMenu_white();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        no_ujian2 = new javax.swing.JTextField();
        nama2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        benar2 = new javax.swing.JTextField();
        grade2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        panelMenu_white1 = new ace.panelMenu_white();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        no_ujian = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        presenter = new javax.swing.JTextField();
        jur1 = new javax.swing.JTextField();
        jur2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        waktu = new javax.swing.JTextField();
        txt_benar = new javax.swing.JTextField();
        grade = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tgl = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        eee = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jba = new javax.swing.JRadioButton();
        jbb = new javax.swing.JRadioButton();
        jbc = new javax.swing.JRadioButton();
        jbd = new javax.swing.JRadioButton();
        jbe = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nilaitabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(getter, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(no_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kd_soal, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(getbenar))
                .addGap(44, 44, 44))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getbenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kd_soal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nilaitabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jDialog2.setUndecorated(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukkan Petugas Ujian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 102, 255)));
        jPanel4.setOpaque(false);

        petugas_ujian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                petugas_ujianKeyTyped(evt);
            }
        });

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(petugas_ujian, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(petugas_ujian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMenu1Layout = new javax.swing.GroupLayout(panelMenu1);
        panelMenu1.setLayout(panelMenu1Layout);
        panelMenu1Layout.setHorizontalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenu1Layout.setVerticalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jDialog2.getContentPane().add(panelMenu1, java.awt.BorderLayout.CENTER);

        jDialog3.setUndecorated(true);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hasil Ujian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)));
        jPanel5.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("No. Ujian :");

        no_ujian2.setEditable(false);

        nama2.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Nama :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("grade :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Benar :");

        benar2.setEditable(false);

        grade2.setEditable(false);

        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Hasil Ujian Masuk Bahasa Inggris :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(no_ujian2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(benar2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grade2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(45, 45, 45))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(no_ujian2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(benar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(grade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMenu_white2Layout = new javax.swing.GroupLayout(panelMenu_white2);
        panelMenu_white2.setLayout(panelMenu_white2Layout);
        panelMenu_white2Layout.setHorizontalGroup(
            panelMenu_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu_white2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMenu_white2Layout.setVerticalGroup(
            panelMenu_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu_white2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialog3.getContentPane().add(panelMenu_white2, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Identitas Peserta Ujian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(153, 153, 153)));
        jPanel1.setOpaque(false);

        jLabel11.setText("Nama :");

        jLabel12.setText("Nomor Ujian :");

        jLabel13.setText("Presenter :");

        jLabel14.setText("Program Pilihan Prioritas :");

        jLabel15.setText("Program Pilihan Alternatif :");

        no_ujian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_ujianActionPerformed(evt);
            }
        });
        no_ujian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                no_ujianKeyTyped(evt);
            }
        });

        jLabel16.setText("Waktu :");

        jLabel17.setText("Benar :");

        jLabel18.setText("Grade :");

        jLabel20.setText("Tanggal :");

        tgl.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl.setValue(new java.util.Date());

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(presenter, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(no_ujian, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jur2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jur1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tgl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(waktu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(grade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                        .addComponent(txt_benar, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(30, 30, 30)))
                        .addContainerGap(150, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(no_ujian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txt_benar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(presenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Pilihan Jawaban", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(153, 153, 153)));
        jPanel2.setOpaque(false);

        jLabel1.setText("A.");

        jLabel2.setText("B.");

        jLabel3.setText("C.");

        jLabel4.setText("D.");

        jLabel5.setText("E.");

        a.setText("jLabel6");

        b.setText("jLabel6");

        c.setText("jLabel6");

        d.setText("jLabel6");

        eee.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eee)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(a))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(b))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(d))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(eee))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Jawaban", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(153, 153, 153)));
        jPanel3.setOpaque(false);

        buttonGroup1.add(jba);
        jba.setText("A");
        jba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbb);
        jbb.setText("B");
        jbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbc);
        jbc.setText("C");
        jbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbd);
        jbd.setText("D");
        jbd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbdActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbe);
        jbe.setText("E");
        jbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jba)
                .addGap(18, 18, 18)
                .addComponent(jbb)
                .addGap(18, 18, 18)
                .addComponent(jbc)
                .addGap(18, 18, 18)
                .addComponent(jbd)
                .addGap(18, 18, 18)
                .addComponent(jbe)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jba)
                    .addComponent(jbb)
                    .addComponent(jbc)
                    .addComponent(jbd)
                    .addComponent(jbe))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jButton3.setText("Soal Selanjutnya");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu_white1Layout = new javax.swing.GroupLayout(panelMenu_white1);
        panelMenu_white1.setLayout(panelMenu_white1Layout);
        panelMenu_white1Layout.setHorizontalGroup(
            panelMenu_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu_white1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenu_white1Layout.createSequentialGroup()
                        .addGroup(panelMenu_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu_white1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(panelMenu_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenu_white1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(191, Short.MAX_VALUE)))
        );
        panelMenu_white1Layout.setVerticalGroup(
            panelMenu_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu_white1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(panelMenu_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu_white1Layout.createSequentialGroup()
                    .addContainerGap(540, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu_white1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu_white1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void no_ujianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_ujianKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            if(no_ujian.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Masukkan Nomor Ujian Anda");
            }else {
            try {
                entitas_aplikan ent = new entitas_aplikan();
                ent=iap.getbynoujian(no_ujian.getText());
                nama.setText(ent.getNama());
                no_aplikan.setText(ent.getNomor_aplikan());
                presenter.setText(ent.getPrsenter());
                jur1.setText(ent.getJurusan1());
                jur2.setText(ent.getJurusan2());
                
                 setSize(800, 700);
                 next();
                 
                 waktuDua();
            } catch (RemoteException ex) {
                Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }//GEN-LAST:event_no_ujianKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:\
//        nilai++;
//            jTextField7.setText(Integer.toString(nilai));
        
//        entitas_soal ent = new entitas_soal();
//        if(getter.getText().equalsIgnoreCase(ent.getBenar())){
//            nilai++;
//            txt_benar.setText(String.valueOf(nilai));
//            next();
//        radio();
//        }else{
       
        //radio();
//        }
        
        takebykd();
        entitas_soal entt = new entitas_soal();
        if(getter.getText().equalsIgnoreCase(getbenar.getText())){
               nilai++;
                txt_benar.setText(String.valueOf(nilai));
                jTextArea1.setText(entt.getSoal());
                    a.setText(entt.getPilihan1());
                    b.setText(entt.getPilihan2());
                    c.setText(entt.getPilihan3());
                    d.setText(entt.getPilihan4());
                    eee.setText(entt.getPilihan5());
                    
            }else {
                
           jTextArea1.setText(entt.getSoal());
                    a.setText(entt.getPilihan1());
                    b.setText(entt.getPilihan2());
                    c.setText(entt.getPilihan3());
                    d.setText(entt.getPilihan4());
                    eee.setText(entt.getPilihan5());
        }
        int be = Integer.parseInt(txt_benar.getText());
                if(be<=10){
                    grade.setText("D");
                }else if(be>=10&& be<=15){
                    grade.setText("C");
                }else if(be>=15 && be<=20){
                    grade.setText("B");
                }else if(be>=20){
                    grade.setText("A");
                }
         next();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void petugas_ujianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_petugas_ujianKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            loginPetugas();
            
        }
    }//GEN-LAST:event_petugas_ujianKeyTyped

    private void jbaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbaActionPerformed
        // TODO add your handling code here:
        getter.setText("A");
        
    }//GEN-LAST:event_jbaActionPerformed

    private void jbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbActionPerformed
        // TODO add your handling code here:
        getter.setText("B");
    }//GEN-LAST:event_jbbActionPerformed

    private void jbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcActionPerformed
        // TODO add your handling code here:
        getter.setText("C");
    }//GEN-LAST:event_jbcActionPerformed

    private void jbdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbdActionPerformed
        // TODO add your handling code here:
        getter.setText("D");
    }//GEN-LAST:event_jbdActionPerformed

    private void jbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeActionPerformed
        // TODO add your handling code here:
        getter.setText("E");
    }//GEN-LAST:event_jbeActionPerformed

    private void no_ujianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_ujianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_ujianActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jDialog2.setVisible(false);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jDialog3.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jDialog1.setSize(500,500);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    void teslap1(){
        try {
            // TODO add your handling code here:
            Map param = new HashMap();
            //entitas mybe
            List<entitas_tes>dftartes = new ArrayList<entitas_tes>();
            entitas_tes ent = new entitas_tes();
            for(int i=0;i<20;++i){
                ent= new entitas_tes();
                ent.setNo(1222);
                ent.setNama("hahaha");
                dftartes.add(ent);
            }
            JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(dftartes);
            System.out.println(datasource.getRecordCount());
            param.put("datasource", datasource);
            
            JasperPrint printer = JasperFillManager.fillReport(getClass().getResourceAsStream("testlap.jasper"), param, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(printer);
            jv.show();
        } catch (JRException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void teslap2pakek(){
        try {
            
            InputStream strimReport = JRLoader.getFileInputStream("/Users/radhial22/Documents/NetBeansProjects/pmb_client/src/lap/tesLap1.jasper");
            List<entitas_soal>daftar = ins.getby();
            
                entitas_laptes ent = new entitas_laptes();
                entitas_soal ents = new entitas_soal();
                ent.setKd_soal(ents.getKd_soal());
                ent.setSoal(ents.getSoal());
                daftar.add(ents);
            
            
            JRDataSource datasource = new JRBeanCollectionDataSource(daftar);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(strimReport, map);
            
            JasperViewer.viewReport(print);
            //JasperExportManager.exportReportToPdfFile(print,"C:/Users/radhial22/Documents/NetBeansProjects/pmb_client/report.pdf");
        } catch (RemoteException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void testlap3sangatpakek(){
        try {
            Properties prop = System.getProperties();
            String currndir = prop.getProperty("user.dir");
            File dir = new File(currndir);
            String nmllap = "tesLap1.jasper";
            String lokasi = "lap";
            File fileap;
            String fupath=null;
            
            if(dir.isDirectory()){
                String[] isidir = dir.list();
                for (int i=0;i<isidir.length;i++){
                    fileap = new File(currndir+File.separatorChar+isidir[i]+File.separatorChar+lokasi+File.separatorChar+nmllap);
                    if(fileap.isFile()){
                        fupath=fileap.toString();
                    }
                }
            }
            
           // InputStream strimReport = JRLoader.getFileInputStream("/Users/radhial22/Documents/NetBeansProjects/pmb_client/src/lap/tesLap1.jasper");
            List<entitas_soal>daftar = ins.getby();
            
                entitas_laptes ent = new entitas_laptes();
                entitas_soal ents = new entitas_soal();
                ent.setKd_soal(ents.getKd_soal());
                ent.setSoal(ents.getSoal());
                daftar.add(ents);
            
            
            JRDataSource datasource = new JRBeanCollectionDataSource(daftar);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print);
            //JasperExportManager.exportReportToPdfFile(print,"C:/Users/radhial22/Documents/NetBeansProjects/pmb_client/report.pdf");
        } catch (RemoteException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(frm_ujian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JLabel b;
    private javax.swing.JTextField benar2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel c;
    private javax.swing.JLabel d;
    private javax.swing.JLabel eee;
    private javax.swing.JTextField getbenar;
    private javax.swing.JTextField getter;
    private javax.swing.JTextField grade;
    private javax.swing.JTextField grade2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton jba;
    private javax.swing.JRadioButton jbb;
    private javax.swing.JRadioButton jbc;
    private javax.swing.JRadioButton jbd;
    private javax.swing.JRadioButton jbe;
    private javax.swing.JTextField jur1;
    private javax.swing.JTextField jur2;
    private javax.swing.JTextField kd_soal;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nama2;
    private javax.swing.JTextField nilaitabel;
    private javax.swing.JTextField no_aplikan;
    private javax.swing.JTextField no_ujian;
    private javax.swing.JTextField no_ujian2;
    private ace.panelMenu panelMenu1;
    private ace.panelMenu_white panelMenu_white1;
    private ace.panelMenu_white panelMenu_white2;
    private javax.swing.JTextField petugas_ujian;
    private javax.swing.JTextField presenter;
    private javax.swing.JFormattedTextField tgl;
    private javax.swing.JTextField txt_benar;
    private javax.swing.JTextField waktu;
    // End of variables declaration//GEN-END:variables
}
