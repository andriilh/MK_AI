/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import ace.JavaTerbilang;
import ace.model_aplikan1;
import ace.model_pendaftaran;
import ace.model_tahun;
import entity.entitas_aplikan;
import entity.entitas_pendaftaran;
import entity.entitas_tahun;
import entity_laporan.lap_kartuUjian;
import entity_laporan.lap_kuitansi;
import intface.intface_aplikan;
import intface.intface_pendaftaran;
import intface.intface_tahun;
import intface_lap.Intface_laporan;
import intface_lap.intface_lapRekapPlace;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author radhial22
 */
public class frm_pendaftaran extends javax.swing.JFrame {
model_pendaftaran pendaftaran = new model_pendaftaran();
model_tahun tahun = new model_tahun();
model_aplikan1 aplikan = new model_aplikan1();
intface_pendaftaran inp;
intface_aplikan iap;
intface_tahun ith;
intface_lapRekapPlace kuin;
Intface_laporan kuin2;

List<entitas_pendaftaran>daftar = new ArrayList<entitas_pendaftaran>();
    List<entitas_aplikan>daftarApli= new ArrayList<entitas_aplikan>();
    List<entitas_tahun>daftarthn = new ArrayList<entitas_tahun>();
    List<lap_kuitansi>daftarkuintasni=new ArrayList<lap_kuitansi>();
    List<lap_kartuUjian>daftarkartu=new ArrayList<lap_kartuUjian>();
boolean beda;
int r;
    /**
     * Creates new form frm_pendaftaran
     */
    public frm_pendaftaran(intface_pendaftaran inp, intface_aplikan iap, intface_tahun ith, intface_lapRekapPlace kuin,Intface_laporan kuin2) {
        this.inp=inp;
        this.iap=iap;
        this.ith=ith;
        this.kuin=kuin;
        this.kuin2=kuin2;
        initComponents();
        setLocationRelativeTo(null);
        buton(true, false);
        enabel(false);
        
        take();
        jTable1.setModel(pendaftaran);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                r=jTable1.getSelectedRow();
                if(r!=-1){
                    entitas_pendaftaran ent =daftar.get(r);
                    nodaftar.setText(String.valueOf(ent.getNo_daftar()));
                    noaplikan.setText(ent.getNo_aplikan());
                    noujian.setText(ent.getNo_ujian());
                    nama.setText(ent.getNama());
                    tgl.setValue(ent.getTgl());
                    thn.setText(ent.getThn_ajaran());
                    biaya.setText(String.valueOf(ent.getBiaya()));
                    if(ent.getTipe_diskon().equalsIgnoreCase("quisioner")){
                        quis.setSelected(true);
                    }else if(ent.getTipe_diskon().equalsIgnoreCase("Sekolah")){
                        sekolah.setSelected(true);
                    }else if (ent.getTipe_diskon().equalsIgnoreCase("Undangan")){
                        undangan.setSelected(true);
                    }else{
                        quis.setSelected(false);
                        undangan.setSelected(false);
                        sekolah.setSelected(false);
                    }
                    diskon.setText(String.valueOf(ent.getDiskon()));
                    bayar.setText(String.valueOf(ent.getBayar()));
                    terbilang.setText(ent.getTerbilang());
                }
            }
        });
    }
void take(){
        try {
            daftar=inp.getall();
            pendaftaran.setdata(daftar);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeTahun(){
        try {
            daftarthn=ith.getall();
            tahun.setdata(daftarthn);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeaplikan(){
        try {
            daftarApli=iap.stat();
            aplikan.setdata(daftarApli);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void empt(){
    //nodaftar.setText("");
    noaplikan.setText("");
    nama.setText("");
    noujian.setText("");
    thn.setText("");
    biaya.setText("");
    quis.setSelected(false);
    sekolah.setSelected(false);
    undangan.setSelected(false);
    diskon.setText("");
    bayar.setText("");
    terbilang.setText("");
}

void enabel(boolean a){
    nodaftar.setEnabled(a);
    noaplikan.setEnabled(a);
    nama.setEnabled(a);
    noujian.setEnabled(a);
    thn.setEnabled(a);
    tgl.setEnabled(a);
    biaya.setEnabled(a);
    quis.setEnabled(a);
    sekolah.setEnabled(a);
    undangan.setEnabled(a);
    diskon.setEnabled(a);
    bayar.setEnabled(a);
    terbilang.setEnabled(a);
}

void buton(boolean a,boolean b){
    jButton1.setEnabled(a);
    jButton2.setEnabled(a);
    jButton3.setEnabled(b);
    jButton4.setEnabled(b);
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
        jDialog_aplikan = new javax.swing.JDialog();
        panelMenuTes2 = new ace.panelMenuTes();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jDialog_tahun = new javax.swing.JDialog();
        panelMenuTes3 = new ace.panelMenuTes();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        panelMenu1 = new ace.panelMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nodaftar = new javax.swing.JTextField();
        noaplikan = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        noujian = new javax.swing.JTextField();
        tgl = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        thn = new javax.swing.JTextField();
        bayar = new javax.swing.JTextField();
        terbilang = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        diskon = new javax.swing.JTextField();
        quis = new javax.swing.JCheckBox();
        sekolah = new javax.swing.JCheckBox();
        undangan = new javax.swing.JCheckBox();
        biaya = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jDialog_aplikan.setUndecorated(true);

        jTable2.setForeground(new java.awt.Color(102, 102, 102));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jTextField4.setForeground(new java.awt.Color(102, 102, 102));
        jTextField4.setText("Cari");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("X");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes2Layout = new javax.swing.GroupLayout(panelMenuTes2);
        panelMenuTes2.setLayout(panelMenuTes2Layout);
        panelMenuTes2Layout.setHorizontalGroup(
            panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(panelMenuTes2Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22)))
                .addContainerGap())
        );
        panelMenuTes2Layout.setVerticalGroup(
            panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes2Layout.createSequentialGroup()
                .addGroup(panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_aplikanLayout = new javax.swing.GroupLayout(jDialog_aplikan.getContentPane());
        jDialog_aplikan.getContentPane().setLayout(jDialog_aplikanLayout);
        jDialog_aplikanLayout.setHorizontalGroup(
            jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_aplikanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_aplikanLayout.setVerticalGroup(
            jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_aplikanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog_tahun.setUndecorated(true);

        jTable3.setForeground(new java.awt.Color(102, 102, 102));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jTextField5.setForeground(new java.awt.Color(102, 102, 102));
        jTextField5.setText("Cari");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("X");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes3Layout = new javax.swing.GroupLayout(panelMenuTes3);
        panelMenuTes3.setLayout(panelMenuTes3Layout);
        panelMenuTes3Layout.setHorizontalGroup(
            panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(panelMenuTes3Layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)))
                .addContainerGap())
        );
        panelMenuTes3Layout.setVerticalGroup(
            panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes3Layout.createSequentialGroup()
                .addGroup(panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_tahunLayout = new javax.swing.GroupLayout(jDialog_tahun.getContentPane());
        jDialog_tahun.getContentPane().setLayout(jDialog_tahunLayout);
        jDialog_tahunLayout.setHorizontalGroup(
            jDialog_tahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_tahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_tahunLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_tahunLayout.setVerticalGroup(
            jDialog_tahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_tahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_tahunLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pendaftaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 102, 255)));
        jPanel1.setOpaque(false);

        jLabel1.setText("No. Daftar :");

        jLabel2.setText("No. Aplikan :");

        jLabel3.setText("Nama :");

        jLabel4.setText("No. Ujian :");

        jLabel6.setText("Tgl. Daftar :");

        jLabel7.setText("Tahun Ajaran :");

        jLabel8.setText("Bayar :");

        jLabel9.setText("Terbilang :");

        noaplikan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noaplikanKeyTyped(evt);
            }
        });

        tgl.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl.setValue(new java.util.Date());

        jLabel10.setText("Biaya :");

        thn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                thnKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/add.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/delete.png"))); // NOI18N
        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/arrow_down.png"))); // NOI18N
        jButton3.setText("Simpan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton3KeyTyped(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/replay.png"))); // NOI18N
        jButton4.setText("Batal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton4KeyTyped(evt);
            }
        });

        jLabel11.setText("Diskon :");

        buttonGroup1.add(quis);
        quis.setText("Quisioner");
        quis.setOpaque(false);
        quis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quisActionPerformed(evt);
            }
        });

        buttonGroup1.add(sekolah);
        sekolah.setText("Sekolah");
        sekolah.setOpaque(false);
        sekolah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sekolahActionPerformed(evt);
            }
        });

        buttonGroup1.add(undangan);
        undangan.setText("Undangan");
        undangan.setOpaque(false);
        undangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undanganActionPerformed(evt);
            }
        });

        biaya.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton5.setText("Cetak Kuitansi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton5KeyTyped(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton6.setText("Cetak Kartu Ujian");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nodaftar)
                                .addComponent(noaplikan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noujian, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(biaya, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(thn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(tgl, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(diskon, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sekolah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(undangan))
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(terbilang, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nodaftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(noaplikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noujian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(biaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(quis)
                    .addComponent(sekolah)
                    .addComponent(undangan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(terbilang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/window_delete.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenu1Layout = new javax.swing.GroupLayout(panelMenu1);
        panelMenu1.setLayout(panelMenu1Layout);
        panelMenu1Layout.setHorizontalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        panelMenu1Layout.setVerticalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        beda=true;
        buton(false, true);
        enabel(true);
        empt();
        noaplikan.requestFocus();
        diskon.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            beda=false;
            buton(false, true);
            enabel(true);
            nodaftar.setEnabled(false);
            noaplikan.requestFocus();
//        }else if(evt.getClickCount()==1){
//            buton(true, false);
//            enabel(true);
//            nodaftar.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        buton(true, false);
        enabel(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(beda==true){
            if(noaplikan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Masukkan Nomor Aplikan yang Akan Mendaftar");
                noaplikan.requestFocus();
            }else{
                try {
                    entitas_pendaftaran ent = new entitas_pendaftaran();
                    entitas_aplikan entt = new entitas_aplikan();
                    entitas_aplikan enttt = new entitas_aplikan();
                    ent.setNo_daftar(nodaftar.getText());
                    ent.setNo_aplikan(noaplikan.getText());
                    ent.setNama(nama.getText());
                    ent.setNo_ujian(noujian.getText());
                    ent.setTgl((Date)tgl.getValue());
                    ent.setThn_ajaran(thn.getText());
                    ent.setBiaya(Integer.valueOf(biaya.getText()));
                    if(quis.isSelected()){
                        ent.setTipe_diskon("Quisioner");
                    }else if(sekolah.isSelected()){
                        ent.setTipe_diskon("Sekolah");
                    }else if(undangan.isSelected()){
                        ent.setTipe_diskon("Undangan");
                    }else {
                        ent.setTipe_diskon("");
                    }
                    ent.setDiskon(Integer.parseInt(diskon.getText()));
                    ent.setBayar(Integer.valueOf(bayar.getText()));
                    ent.setTerbilang(terbilang.getText());
                    entt.setNomor_aplikan(noaplikan.getText());
                    enttt.setNomor_aplikan(noaplikan.getText());
                    enttt.setNo_ujian(noujian.getText());
                    iap.updatedaf(entt);
                    inp.insert(ent);
                    iap.updatenoUjian(enttt);
                    
                    take();
                    takeaplikan();
                    
                    enabel(true);
                    nodaftar.setEnabled(false);
                } catch (RemoteException ex) {
                    Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(beda==false){
            if(noaplikan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Pilih Data Aplikan yang Akan Diubah");
            }else{
                try {
                    entitas_pendaftaran ent = new entitas_pendaftaran();
                    entitas_aplikan entt = new entitas_aplikan();
                    ent.setNo_daftar(nodaftar.getText());
                        ent.setNo_aplikan(noaplikan.getText());
                        ent.setNama(nama.getText());
                        ent.setNo_ujian(noujian.getText());
                        ent.setTgl((Date)tgl.getValue());
                        ent.setThn_ajaran(thn.getText());
                        ent.setBiaya(Integer.valueOf(biaya.getText()));
                        if(quis.isSelected()){
                            ent.setTipe_diskon("Quisioner");
                        }else if(sekolah.isSelected()){
                            ent.setTipe_diskon("Sekolah");
                        }else if(undangan.isSelected()){
                            ent.setTipe_diskon("Undangan");
                        }else {
                            ent.setTipe_diskon("");
                        }
                        ent.setDiskon(Integer.parseInt(diskon.getText()));
                        ent.setBayar(Integer.valueOf(bayar.getText()));
                        ent.setTerbilang(terbilang.getText());
                        entt.setNomor_aplikan(noaplikan.getText());
                        entt.setNo_ujian(noujian.getText());
                        inp.update(ent);
                        iap.updatenoUjian(entt);
                        take();
                        enabel(true);
                        nodaftar.setEnabled(false);
                        noaplikan.requestFocus();
                } catch (RemoteException ex) {
                    Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nm = nama.getText();
        int pesan = JOptionPane.showConfirmDialog(getRootPane(), "Apakah "+ nm + " Akan Dihapus dari Date Pendaftaran ?","konsfirmasi",JOptionPane.YES_NO_OPTION);
        if(pesan==JOptionPane.YES_OPTION){
            try {
                entitas_aplikan ent = new entitas_aplikan();
                ent.setNomor_aplikan(noaplikan.getText());
                iap.updatedafre(ent);
                inp.delete(nodaftar.getText());
                
                take();
            } catch (RemoteException ex) {
                Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            entitas_aplikan ent = daftarApli.get(jTable2.getSelectedRow());
            noaplikan.setText(ent.getNomor_aplikan());
            nama.setText(ent.getNama());
            jDialog_aplikan.setVisible(false);
            noujian.requestFocus();
            nodaftar.setText(ent.getNomor_aplikan()+"/"+ent.getKd_jurusan()+"/"+ent.getThn_ajaran());
            noujian.setText(ent.getThn_ajaran()+"/"+ent.getKd_jurusan()+"/"+ent.getNomor_aplikan());
            thn.requestFocus();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
        jTextField4.setBackground(Color.white);
        jTextField4.setEnabled(true);
        jTextField4.setText("");
        jTextField4.requestFocus();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        jDialog_aplikan.setVisible(false);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            entitas_tahun ent =daftarthn.get(jTable3.getSelectedRow());
            thn.setText(ent.getThn_ajaran());
            biaya.setText(String.valueOf(ent.getBiaya_daftar()));
            jDialog_tahun.setVisible(false);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        jDialog_tahun.setVisible(false);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void thnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thnKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            takeTahun();
            jTable3.setModel(tahun);
            jDialog_tahun.setSize(480, 350);
            jDialog_tahun.setLocationRelativeTo(null);
            jDialog_tahun.setVisible(true);
        }
    }//GEN-LAST:event_thnKeyTyped

    private void quisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quisActionPerformed
        // TODO add your handling code here:
        if(quis.isSelected()){
            entitas_tahun ent =daftarthn.get(jTable3.getSelectedRow());
          int a= Integer.parseInt(biaya.getText());
          int b= ent.getDisk_quis();
          
            diskon.setText(String.valueOf(ent.getDisk_quis()));   
            biaya.setText(String.valueOf(ent.getBiaya_daftar()));
            String c = String.valueOf(a-b);
            bayar.setText(c);
            diskon.setEnabled(false);
            bayar.setEnabled(false);
            terbilang.setEnabled(false);
            String angka = bayar.getText();
            terbilang.setText(new JavaTerbilang(angka)+" Rupiah".toString());
        }
    }//GEN-LAST:event_quisActionPerformed

    private void sekolahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sekolahActionPerformed
        // TODO add your handling code here:
        if(sekolah.isSelected()){
        entitas_tahun ent =daftarthn.get(jTable3.getSelectedRow());
        int a = Integer.parseInt(biaya.getText());
        int b = ent.getDisk_sekolah();
            diskon.setText(String.valueOf(ent.getDisk_sekolah()));  
            biaya.setText(String.valueOf(ent.getBiaya_daftar()));
            bayar.setText(String.valueOf(a-b));
            diskon.setEnabled(false);
            bayar.setEnabled(false);
            terbilang.setEnabled(false);
            String angka = bayar.getText();
            terbilang.setText(new JavaTerbilang(angka)+" rupiah".toString());
        }
    }//GEN-LAST:event_sekolahActionPerformed

    private void undanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undanganActionPerformed
        // TODO add your handling code here:
        entitas_tahun ent =daftarthn.get(jTable3.getSelectedRow());
            diskon.setText(String.valueOf(ent.getUndangan()));   
            biaya.setEnabled(false);
            biaya.setText("0");
            diskon.setEnabled(false);
            bayar.setText("0");
            bayar.setEnabled(false);
            terbilang.setText("-");
            terbilang.setEnabled(false);
            diskon.setEnabled(false);
            bayar.setEnabled(false);
            terbilang.setEnabled(false);
    }//GEN-LAST:event_undanganActionPerformed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_T){
            beda=true;
        buton(false, true);
        enabel(true);
        empt();
        noaplikan.requestFocus();
        diskon.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1KeyTyped

    private void jButton3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_S){
        if(beda==true){
            if(noaplikan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Masukkan Nomor Aplikan yang Akan Mendaftar");
                noaplikan.requestFocus();
            }else{
                try {
                    entitas_pendaftaran ent = new entitas_pendaftaran();
                    entitas_aplikan entt = new entitas_aplikan();
                    entitas_aplikan enttt = new entitas_aplikan();
                    ent.setNo_daftar(nodaftar.getText());
                    ent.setNo_aplikan(noaplikan.getText());
                    ent.setNama(nama.getText());
                    ent.setNo_ujian(noujian.getText());
                    ent.setTgl((Date)tgl.getValue());
                    ent.setThn_ajaran(thn.getText());
                    ent.setBiaya(Integer.valueOf(biaya.getText()));
                    if(quis.isSelected()){
                        ent.setTipe_diskon("Quisioner");
                    }else if(sekolah.isSelected()){
                        ent.setTipe_diskon("Sekolah");
                    }else if(undangan.isSelected()){
                        ent.setTipe_diskon("Undangan");
                    }else {
                        ent.setTipe_diskon("");
                    }
                    ent.setDiskon(Integer.parseInt(diskon.getText()));
                    ent.setBayar(Integer.valueOf(bayar.getText()));
                    ent.setTerbilang(terbilang.getText());
                    entt.setNomor_aplikan(noaplikan.getText());
                    enttt.setNomor_aplikan(noaplikan.getText());
                    enttt.setNo_ujian(noujian.getText());
                    iap.updatedaf(entt);
                    inp.insert(ent);
                    iap.updatenoUjian(enttt);
                    
                    take();
                    takeaplikan();
                    empt();
                    enabel(true);
                    nodaftar.setEnabled(false);
                } catch (RemoteException ex) {
                    Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(beda==false){
            if(noaplikan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Pilih Data Aplikan yang Akan Diubah");
            }else{
                try {
                    entitas_pendaftaran ent = new entitas_pendaftaran();
                    entitas_aplikan entt = new entitas_aplikan();
                    ent.setNo_daftar(nodaftar.getText());
                        ent.setNo_aplikan(noaplikan.getText());
                        ent.setNama(nama.getText());
                        ent.setNo_ujian(noujian.getText());
                        ent.setTgl((Date)tgl.getValue());
                        ent.setThn_ajaran(thn.getText());
                        ent.setBiaya(Integer.valueOf(biaya.getText()));
                        if(quis.isSelected()){
                            ent.setTipe_diskon("Quisioner");
                        }else if(sekolah.isSelected()){
                            ent.setTipe_diskon("Sekolah");
                        }else if(undangan.isSelected()){
                            ent.setTipe_diskon("Undangan");
                        }else {
                            ent.setTipe_diskon("");
                        }
                        ent.setDiskon(Integer.parseInt(diskon.getText()));
                        ent.setBayar(Integer.valueOf(bayar.getText()));
                        ent.setTerbilang(terbilang.getText());
                        entt.setNomor_aplikan(noaplikan.getText());
                        entt.setNo_ujian(noujian.getText());
                        inp.update(ent);
                        iap.updatenoUjian(entt);
                        take();
                        enabel(true);
                        nodaftar.setEnabled(false);
                        noaplikan.requestFocus();
                } catch (RemoteException ex) {
                    Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
    }//GEN-LAST:event_jButton3KeyTyped

    private void jButton4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_B){
                buton(true, false);
        enabel(false);
        }
    }//GEN-LAST:event_jButton4KeyTyped

    private void noaplikanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noaplikanKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            takeaplikan();
            jTable2.setModel(aplikan);
            jDialog_aplikan.setSize(480, 350);
            jDialog_aplikan.setLocationRelativeTo(null);
            jDialog_aplikan.setVisible(true);
        }
    }//GEN-LAST:event_noaplikanKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(nodaftar.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Pilih Data Terlebih Dahulu");
        }else {
        kwintansi();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(noujian.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Pilih Data Terlebih Dahulu");
        }else {
        kartu();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6KeyTyped

    
    void kwintansi(){
        try {
            Properties prop = System.getProperties();
                        String currndir = prop.getProperty("user.dir");
                        File dir = new File(currndir);
                        String nmllap = "kuitansi.jasper";
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
                        daftarkuintasni=kuin.kuitansi(nodaftar.getText());
                        lap_kuitansi lap =new lap_kuitansi();
                        daftarkuintasni.add(lap);
                        
                        JRDataSource datasource = new JRBeanCollectionDataSource(daftarkuintasni);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }
    
    void kartu(){
        try {
            Properties prop = System.getProperties();
                            String currndir = prop.getProperty("user.dir");
                            File dir = new File(currndir);
                            String nmllap = "kartu_ujian.jasper";
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
                    daftarkartu=kuin2.kartuUjian(noujian.getText());
                    lap_kartuUjian lap = new lap_kartuUjian();
                    daftarkartu.add(lap);
                    
                    JRDataSource datasource = new JRBeanCollectionDataSource(daftarkartu);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frm_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JFormattedTextField biaya;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField diskon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog_aplikan;
    private javax.swing.JDialog jDialog_tahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField noaplikan;
    private javax.swing.JTextField nodaftar;
    private javax.swing.JTextField noujian;
    private ace.panelMenu panelMenu1;
    private ace.panelMenuTes panelMenuTes2;
    private ace.panelMenuTes panelMenuTes3;
    private javax.swing.JCheckBox quis;
    private javax.swing.JCheckBox sekolah;
    private javax.swing.JTextField terbilang;
    private javax.swing.JFormattedTextField tgl;
    private javax.swing.JTextField thn;
    private javax.swing.JCheckBox undangan;
    // End of variables declaration//GEN-END:variables
}
