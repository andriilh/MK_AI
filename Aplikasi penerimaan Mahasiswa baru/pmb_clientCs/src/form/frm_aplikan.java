/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import ace.model_aplikan;
import ace.model_jurusan;
import ace.model_media;
import ace.model_mgm;
import ace.model_presenter;
import ace.model_sekolah;
import entity.entitas_aplikan;
import entity.entitas_jurusan;
import entity.entitas_media;
import entity.entitas_mgm;
import entity.entitas_presenter;
import entity.entitas_sekolah;
import intface.intface_aplikan;
import intface.intface_jurusan;
import intface.intface_media;
import intface.intface_mgm;
import intface.intface_presenter;
import intface.intface_sekolah;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author radhial22
 */
public class frm_aplikan extends javax.swing.JFrame {
model_aplikan model_aplikan = new model_aplikan();
model_sekolah model_sekolah = new model_sekolah();
model_mgm model_mgm = new model_mgm();
model_media model_media = new model_media();
model_presenter model_presenter = new model_presenter();
model_jurusan model_jurusan = new model_jurusan();


List<entitas_sekolah>daftarSeklah= new ArrayList<entitas_sekolah>();
List<entitas_mgm>daftarMgm= new ArrayList<entitas_mgm>();
List<entitas_media>daftarMedia= new ArrayList<entitas_media>();
List<entitas_presenter>daftarPresenter= new ArrayList<entitas_presenter>();
List<entitas_jurusan>daftarJurusan= new ArrayList<entitas_jurusan>();
List<entitas_aplikan>daftarAplikan= new ArrayList<entitas_aplikan>();

intface_aplikan aplikan;
intface_jurusan jurusan;
intface_media media;
intface_mgm mgm;
intface_presenter presenter;
intface_sekolah sekolah;

boolean beda;
int r;
    /**
     * Creates new form frm_aplikan
     */
    public frm_aplikan(intface_aplikan aplikan,intface_jurusan jurusan,intface_media media,intface_mgm mgm,intface_presenter presenter,intface_sekolah sekolah) {
        this.aplikan=aplikan;
        this.jurusan=jurusan;
        this.media=media;
        this.mgm=mgm;
        this.presenter=presenter;
        this.sekolah=sekolah;
        initComponents();
        
        setLocationRelativeTo(null);
        takeJurusan();
        takeMedia();
        takeMgm();
        takePresenter();
        takeSekolah();
        takeaplikan();
        jTable1.setModel(model_aplikan);
        jTable1.getSelectionModel().addListSelectionListener(new  ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                r=jTable1.getSelectedRow();
                if(r!=-1){
                    entitas_aplikan ent = daftarAplikan.get(r);
                    nm_aplikan.setText(ent.getNomor_aplikan());
                    nama_aplikan.setText(ent.getNama());
                    tpt_lahir.setText(ent.getTmp_lahir());
                    tgl_lahir.setValue(ent.getTgl_lahir());
                    alamat.setText(ent.getAlamat());
                    kode_pos.setText(ent.getKode_pos());
                    tlp.setText(String.valueOf(no_hp.getText()));
                    no_hp.setText(String.valueOf(ent.getHp()));
                    email.setText(ent.getEmail());
                    
                    thn_lulus.setText(ent.getThn_lulus());
                    nama_ortu.setText(ent.getNm_ortu());
                    tgl_datang.setValue(ent.getTgl_datang());
                    txt_presenter.setText(ent.getPrsenter());
                    txt_jur1.setText(ent.getJurusan1());
                    txt_jur2.setText(ent.getJurusan2());
                    txt_sumber.setText(ent.getSumber_info());
                    txt_sma.setText(ent.getSma());
                    thn_ajaran.setText(ent.getThn_ajaran());
                    txt_mgm.setText(ent.getMgm());
                }
            }
        });
    }
void takeaplikan(){
        try {
            daftarAplikan=aplikan.getlist();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeJurusan(){
        try {
            daftarJurusan=jurusan.getall();
            model_jurusan.setdata(daftarJurusan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeMedia(){
        try {
            daftarMedia=media.getall();
            model_media.setdata(daftarMedia);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeMgm(){
        try {
            daftarMgm=mgm.getall();
            model_mgm.setdata(daftarMgm);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takePresenter(){
        try {
            daftarPresenter=presenter.getall();
            model_presenter.setdata(daftarPresenter);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeSekolah(){
        try {
            daftarSeklah=sekolah.getall();
            model_sekolah.setdata(daftarSeklah);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void getno(){
        try {
            entitas_aplikan ent = new entitas_aplikan();
            ent=aplikan.no_aplikan();
            nm_aplikan.setText(String.valueOf(ent.getNo()+1)); 
       } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeaplikanbelumdaftar(){
        try {
            daftarAplikan=aplikan.stat();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void taketgldatang(){
        try {
            daftarAplikan=aplikan.getbytgl((Date)tgl_lahir2.getValue());
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void taketanggalbetween(){
        try {
            daftarAplikan=aplikan.getbytglbetween((Date)tgl_lahir3.getValue(), (Date)tgl_lahir4.getValue());
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeAplikansudahDaftar(){
        try {
            daftarAplikan=aplikan.statdafsudah();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeAplikansudahreg(){
        try {
            daftarAplikan=aplikan.regsudah();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeAplikanbelumreg(){
        try {
            daftarAplikan=aplikan.reg();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeAplikanbelumUj(){
        try {
            daftarAplikan=aplikan.ujbelum();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takeAplikanSudahUj(){
        try {
            daftarAplikan=aplikan.ujsudah();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void emp(){
    nm_aplikan.setText("");
    nama_aplikan.setText("");
    tpt_lahir.setText("");
    alamat.setText("");
    kode_pos.setText("");
    email.setText("");
    tlp.setText("");
    no_hp.setText("");
    cbo_pendidikan.setSelectedIndex(0);
    nama_ortu.setText("");
    txt_presenter.setText("");
    txt_jur1.setText("");
    txt_jur2.setText("");
    txt_sma.setText("");
    txt_sumber.setText("");
    txt_mgm.setText("");
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_input = new javax.swing.JDialog();
        panelMenuTes1 = new ace.panelMenuTes();
        jLabel1 = new javax.swing.JLabel();
        nm_aplikan = new javax.swing.JTextField();
        nama_aplikan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tpt_lahir = new javax.swing.JTextField();
        tgl_lahir = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kode_pos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        no_hp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tlp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbo_pendidikan = new javax.swing.JComboBox();
        thn_lulus = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nama_ortu = new javax.swing.JTextField();
        tgl_datang = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_presenter = new javax.swing.JTextField();
        txt_jur2 = new javax.swing.JTextField();
        thn_ajaran = new javax.swing.JFormattedTextField();
        txt_mgm = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_jur1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_sma = new javax.swing.JTextField();
        txt_sumber = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jDialog_jurusan = new javax.swing.JDialog();
        panelMenuTes2 = new ace.panelMenuTes();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jDialog_mgm = new javax.swing.JDialog();
        panelMenuTes3 = new ace.panelMenuTes();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jDialog_presenter = new javax.swing.JDialog();
        panelMenuTes4 = new ace.panelMenuTes();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jDialog_sekolah = new javax.swing.JDialog();
        panelMenuTes5 = new ace.panelMenuTes();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jDialog_sumber = new javax.swing.JDialog();
        panelMenuTes6 = new ace.panelMenuTes();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jDialog_jurusan2 = new javax.swing.JDialog();
        panelMenuTes7 = new ace.panelMenuTes();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        kd_jurusan = new javax.swing.JTextField();
        panelMenu1 = new ace.panelMenu();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tgl_lahir2 = new javax.swing.JFormattedTextField();
        tgl_lahir3 = new javax.swing.JFormattedTextField();
        tgl_lahir4 = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        jDialog_input.setUndecorated(true);

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nomor Aplikan :");

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nama :");

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tempat/Tgl. Lahir :");

        tgl_lahir.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl_lahir.setValue(new java.util.Date());

        jLabel21.setText("/");

        alamat.setColumns(20);
        alamat.setRows(5);
        alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alamatKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(alamat);

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Alamat :");

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Kode Pos :");

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email :");

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("No. Hp :");

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Telp :");

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Pendidikan :");

        cbo_pendidikan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "SMA", " " }));

        thn_lulus.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy"))));
        thn_lulus.setValue(new java.util.Date());

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Tahun Lulus :");

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Nama Ortu :");

        tgl_datang.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl_datang.setValue(new java.util.Date());

        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Tgl. Datang :");

        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Presenter :");

        txt_presenter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_presenterKeyTyped(evt);
            }
        });

        txt_jur2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jur2KeyTyped(evt);
            }
        });

        thn_ajaran.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy"))));
        thn_ajaran.setValue(new java.util.Date());

        txt_mgm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mgmKeyTyped(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("MGM :");

        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Thn. Ajaran :");

        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Jurusan 2 :");

        txt_jur1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jur1KeyTyped(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Jurusan 1 :");

        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("SMA :");

        txt_sma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_smaKeyTyped(evt);
            }
        });

        txt_sumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sumberKeyTyped(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Sumber Informasi :");

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("Simpan");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setText("Batal");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
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

        jLabel29.setText("jLabel29");

        javax.swing.GroupLayout panelMenuTes1Layout = new javax.swing.GroupLayout(panelMenuTes1);
        panelMenuTes1.setLayout(panelMenuTes1Layout);
        panelMenuTes1Layout.setHorizontalGroup(
            panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMenuTes1Layout.createSequentialGroup()
                            .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nm_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                    .addComponent(tpt_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2)
                                .addComponent(nama_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelMenuTes1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel18)
                                            .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15)
                                                .addComponent(jLabel14))))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                    .addComponent(txt_jur1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_jur2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                    .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbo_pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nama_ortu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tgl_datang, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_presenter, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                            .addComponent(txt_sma, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(thn_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                                .addComponent(tlp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(no_hp))
                                            .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                                .addComponent(kode_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                    .addComponent(thn_lulus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29)
                                    .addGap(28, 28, 28)))))
                    .addGroup(panelMenuTes1Layout.createSequentialGroup()
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMenuTes1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sumber, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_mgm, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jLabel23)
                .addContainerGap())
        );
        panelMenuTes1Layout.setVerticalGroup(
            panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes1Layout.createSequentialGroup()
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nm_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tpt_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kode_pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbo_pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(thn_lulus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(nama_ortu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tgl_datang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_presenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuTes1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(94, 94, 94)))
                .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_jur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_jur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_sma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(thn_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txt_mgm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuTes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(30, 30, 30))
            .addGroup(panelMenuTes1Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(0, 563, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog_inputLayout = new javax.swing.GroupLayout(jDialog_input.getContentPane());
        jDialog_input.getContentPane().setLayout(jDialog_inputLayout);
        jDialog_inputLayout.setHorizontalGroup(
            jDialog_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuTes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog_inputLayout.setVerticalGroup(
            jDialog_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_inputLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelMenuTes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDialog_jurusan.setUndecorated(true);

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

        jDialog_jurusan.getContentPane().add(panelMenuTes2, java.awt.BorderLayout.CENTER);

        jDialog_mgm.setUndecorated(true);

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

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("X");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
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
                        .addComponent(jLabel24)))
                .addContainerGap())
        );
        panelMenuTes3Layout.setVerticalGroup(
            panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes3Layout.createSequentialGroup()
                .addGroup(panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_mgmLayout = new javax.swing.GroupLayout(jDialog_mgm.getContentPane());
        jDialog_mgm.getContentPane().setLayout(jDialog_mgmLayout);
        jDialog_mgmLayout.setHorizontalGroup(
            jDialog_mgmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_mgmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_mgmLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_mgmLayout.setVerticalGroup(
            jDialog_mgmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_mgmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_mgmLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog_presenter.setUndecorated(true);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jTextField6.setForeground(new java.awt.Color(102, 102, 102));
        jTextField6.setText("Cari");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("X");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes4Layout = new javax.swing.GroupLayout(panelMenuTes4);
        panelMenuTes4.setLayout(panelMenuTes4Layout);
        panelMenuTes4Layout.setHorizontalGroup(
            panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(panelMenuTes4Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)))
                .addContainerGap())
        );
        panelMenuTes4Layout.setVerticalGroup(
            panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes4Layout.createSequentialGroup()
                .addGroup(panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_presenterLayout = new javax.swing.GroupLayout(jDialog_presenter.getContentPane());
        jDialog_presenter.getContentPane().setLayout(jDialog_presenterLayout);
        jDialog_presenterLayout.setHorizontalGroup(
            jDialog_presenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_presenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_presenterLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_presenterLayout.setVerticalGroup(
            jDialog_presenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_presenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_presenterLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog_sekolah.setUndecorated(true);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jTextField7.setForeground(new java.awt.Color(102, 102, 102));
        jTextField7.setText("Cari");
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("X");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes5Layout = new javax.swing.GroupLayout(panelMenuTes5);
        panelMenuTes5.setLayout(panelMenuTes5Layout);
        panelMenuTes5Layout.setHorizontalGroup(
            panelMenuTes5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(panelMenuTes5Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)))
                .addContainerGap())
        );
        panelMenuTes5Layout.setVerticalGroup(
            panelMenuTes5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes5Layout.createSequentialGroup()
                .addGroup(panelMenuTes5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_sekolahLayout = new javax.swing.GroupLayout(jDialog_sekolah.getContentPane());
        jDialog_sekolah.getContentPane().setLayout(jDialog_sekolahLayout);
        jDialog_sekolahLayout.setHorizontalGroup(
            jDialog_sekolahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_sekolahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_sekolahLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_sekolahLayout.setVerticalGroup(
            jDialog_sekolahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_sekolahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_sekolahLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog_sumber.setUndecorated(true);

        panelMenuTes6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMenuTes6MouseClicked(evt);
            }
        });

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jTextField8.setForeground(new java.awt.Color(102, 102, 102));
        jTextField8.setText("Cari");
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("X");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes6Layout = new javax.swing.GroupLayout(panelMenuTes6);
        panelMenuTes6.setLayout(panelMenuTes6Layout);
        panelMenuTes6Layout.setHorizontalGroup(
            panelMenuTes6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(panelMenuTes6Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)))
                .addContainerGap())
        );
        panelMenuTes6Layout.setVerticalGroup(
            panelMenuTes6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes6Layout.createSequentialGroup()
                .addGroup(panelMenuTes6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_sumberLayout = new javax.swing.GroupLayout(jDialog_sumber.getContentPane());
        jDialog_sumber.getContentPane().setLayout(jDialog_sumberLayout);
        jDialog_sumberLayout.setHorizontalGroup(
            jDialog_sumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_sumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_sumberLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_sumberLayout.setVerticalGroup(
            jDialog_sumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_sumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_sumberLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog_jurusan2.setUndecorated(true);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable7);

        jTextField9.setForeground(new java.awt.Color(102, 102, 102));
        jTextField9.setText("Cari");
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("X");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes7Layout = new javax.swing.GroupLayout(panelMenuTes7);
        panelMenuTes7.setLayout(panelMenuTes7Layout);
        panelMenuTes7Layout.setHorizontalGroup(
            panelMenuTes7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(panelMenuTes7Layout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)))
                .addContainerGap())
        );
        panelMenuTes7Layout.setVerticalGroup(
            panelMenuTes7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes7Layout.createSequentialGroup()
                .addGroup(panelMenuTes7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialog_jurusan2.getContentPane().add(panelMenuTes7, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(kd_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(kd_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/window_delete.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/add.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/delete.png"))); // NOI18N
        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/replay.png"))); // NOI18N
        jButton3.setText("Refresh Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semua", "Aplikan Yang Sudah Mendaftar", "Aplikan Yang Belum Mendaftar", "Aplikan Yang Sudah Registrasi", "Aplikan Yang Belum Registrasi", "Aplikan Yang Sudah Ujian", "Aplikan Yang Belum ujian" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Filter Data :");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Filter Tanggal Datang :");

        tgl_lahir2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl_lahir2.setValue(new java.util.Date());
        tgl_lahir2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tgl_lahir2KeyTyped(evt);
            }
        });

        tgl_lahir3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl_lahir3.setValue(new java.util.Date());
        tgl_lahir3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tgl_lahir3KeyTyped(evt);
            }
        });

        tgl_lahir4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl_lahir4.setValue(new java.util.Date());
        tgl_lahir4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tgl_lahir4KeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Filter Tanggal Datang :");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("-");

        javax.swing.GroupLayout panelMenu1Layout = new javax.swing.GroupLayout(panelMenu1);
        panelMenu1.setLayout(panelMenu1Layout);
        panelMenu1Layout.setHorizontalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tgl_lahir3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tgl_lahir4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tgl_lahir2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelMenu1Layout.setVerticalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(tgl_lahir2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl_lahir3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl_lahir4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        beda=true;
        //jDialog_input.setSize(549, 690);
        jDialog_input.setSize(549, 650);
        jDialog_input.setLocationRelativeTo(null);
        jDialog_input.setVisible(true);
        emp();
        nm_aplikan.setEnabled(true);
        nama_aplikan.requestFocus();
        getno();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void alamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_TAB){
            kode_pos.requestFocus();
            
        }
    }//GEN-LAST:event_alamatKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(beda==true){
            if(nm_aplikan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nomor Aplikan Harus Diisi");
                nm_aplikan.requestFocus();
            }else{
                try {
                    entitas_aplikan ent = new entitas_aplikan();
                    ent.setNomor_aplikan(nm_aplikan.getText());
                    ent.setNama(nama_aplikan.getText());
                    ent.setTmp_lahir(tpt_lahir.getText());
                    ent.setTgl_lahir((Date)tgl_lahir.getValue());
                    ent.setAlamat(alamat.getText());
                    ent.setKode_pos(kode_pos.getText());
                    ent.setTlp(Integer.parseInt(tlp.getText()));
                    ent.setHp(Integer.parseInt(no_hp.getText()));
                    ent.setEmail(email.getText());
                    ent.setPend_terakhir(cbo_pendidikan.getSelectedItem().toString());
                    ent.setThn_lulus(thn_lulus.getText());
                    ent.setNm_ortu(nama_ortu.getText());
                    ent.setTgl_datang((Date)tgl_datang.getValue());
                    ent.setPrsenter(txt_presenter.getText());
                    ent.setJurusan1(txt_jur1.getText());
                    ent.setJurusan2(txt_jur2.getText());
                    ent.setSumber_info(txt_sumber.getText());
                    ent.setSma(txt_sma.getText());
                    ent.setThn_ajaran(thn_ajaran.getText());
                    ent.setMgm(txt_mgm.getText());
                    ent.setKd_jurusan(kd_jurusan.getText());
                    aplikan.insert(ent);
                    emp();
                    nm_aplikan.requestFocus();
                    takeaplikan();
                    jDialog_input.setVisible(false);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(beda==false){
            if(nm_aplikan.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Tentukan Data Yang Akan Diubah");
            }else{
                try {
                    entitas_aplikan ent = new entitas_aplikan();
                        ent.setNomor_aplikan(nm_aplikan.getText());
                        ent.setNama(nama_aplikan.getText());
                        ent.setTmp_lahir(tpt_lahir.getText());
                        ent.setTgl_lahir((Date)tgl_lahir.getValue());
                        ent.setAlamat(alamat.getText());
                        ent.setKode_pos(kode_pos.getText());
                        ent.setTlp(Integer.parseInt(tlp.getText()));
                        ent.setHp(Integer.parseInt(no_hp.getText()));
                        ent.setEmail(email.getText());
                        ent.setPend_terakhir(cbo_pendidikan.getSelectedItem().toString());
                        ent.setThn_lulus(thn_lulus.getText());
                        ent.setNm_ortu(nama_ortu.getText());
                        ent.setTgl_datang((Date)tgl_datang.getValue());
                        ent.setPrsenter(txt_presenter.getText());
                        ent.setJurusan1(txt_jur1.getText());
                        ent.setJurusan2(txt_jur2.getText());
                        ent.setSumber_info(txt_sumber.getText());
                        ent.setSma(txt_sma.getText());
                        ent.setThn_ajaran(thn_ajaran.getText());
                        ent.setMgm(txt_mgm.getText());
                        ent.setKd_jurusan(kd_jurusan.getText());
                        aplikan.update(ent);
                        takeaplikan();
                        nm_aplikan.setEnabled(false);
                        nama_aplikan.requestFocus();
                        jDialog_input.setVisible(false);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            beda=false;
            jDialog_input.setSize(549, 690);
        jDialog_input.setLocationRelativeTo(null);
        jDialog_input.setVisible(true);
            nm_aplikan.setEnabled(false);
            nama_aplikan.requestFocus();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
        jTextField4.setBackground(Color.white);
        jTextField4.setEnabled(true);
        jTextField4.setText("");
        jTextField4.requestFocus();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        jDialog_input.setVisible(false);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        jDialog_jurusan.setVisible(false);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nm = nama_aplikan.getText();
        int pesan = JOptionPane.showConfirmDialog(getRootPane(), "Apakah "+ nm + " Akan Dihapus Dari Data Aplikan ?","konsfirmasi",JOptionPane.YES_NO_OPTION);
        if(pesan==JOptionPane.YES_OPTION){
            try {
                aplikan.delete(nm_aplikan.getText());
                takeaplikan();
            } catch (RemoteException ex) {
                Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        jDialog_mgm.setVisible(false);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        jDialog_presenter.setVisible(false);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        jDialog_sekolah.setVisible(false);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void txt_jur1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jur1KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable2.setModel(model_jurusan);
            jDialog_jurusan.setSize(400, 300);
        jDialog_jurusan.setLocationRelativeTo(null);
        jDialog_jurusan.setVisible(true);
        }
    }//GEN-LAST:event_txt_jur1KeyTyped

    private void txt_jur2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jur2KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable7.setModel(model_jurusan);
            jDialog_jurusan2.setSize(400, 300);
        jDialog_jurusan2.setLocationRelativeTo(null);
        jDialog_jurusan2.setVisible(true);
        }
    }//GEN-LAST:event_txt_jur2KeyTyped

    private void txt_smaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_smaKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable5.setModel(model_sekolah);
            jDialog_sekolah.setSize(480, 350);
        jDialog_sekolah.setLocationRelativeTo(null);
        jDialog_sekolah.setVisible(true);
        }
    }//GEN-LAST:event_txt_smaKeyTyped

    private void txt_sumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sumberKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable6.setModel(model_media);
            jDialog_sumber.setSize(480, 350);
        jDialog_sumber.setLocationRelativeTo(null);
        jDialog_sumber.setVisible(true);
        }
    }//GEN-LAST:event_txt_sumberKeyTyped

    private void txt_mgmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mgmKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable3.setModel(model_mgm);
            jDialog_mgm.setSize(480, 350);
        jDialog_mgm.setLocationRelativeTo(null);
        jDialog_mgm.setVisible(true);
        }
    }//GEN-LAST:event_txt_mgmKeyTyped

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        jDialog_sumber.setVisible(false);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void txt_presenterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_presenterKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable4.setModel(model_presenter);
            jDialog_presenter.setSize(480, 350);
        jDialog_presenter.setLocationRelativeTo(null);
        jDialog_presenter.setVisible(true);
        }
    }//GEN-LAST:event_txt_presenterKeyTyped

    private void panelMenuTes6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuTes6MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_panelMenuTes6MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            entitas_jurusan ent = daftarJurusan.get(jTable2.getSelectedRow());
            txt_jur1.setText(ent.getJurusan());
            kd_jurusan.setText(ent.getKd_jurusan());
            jDialog_jurusan.setVisible(false);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            entitas_mgm ent =daftarMgm.get(jTable3.getSelectedRow());
            txt_mgm.setText(ent.getNama());
            jDialog_mgm.setVisible(false);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            entitas_presenter ent =daftarPresenter.get(jTable4.getSelectedRow());
            txt_presenter.setText(ent.getNama());
            jDialog_presenter.setVisible(false);
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
        entitas_sekolah ent = daftarSeklah.get(jTable5.getSelectedRow());
        txt_sma.setText(ent.getNama());
        jDialog_sekolah.setVisible(false);
        }
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            entitas_media ent =daftarMedia.get(jTable6.getSelectedRow());
            txt_sumber.setText(ent.getMedia_info());
            jDialog_sumber.setVisible(false);
        }
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            entitas_jurusan ent = daftarJurusan.get(jTable7.getSelectedRow());
            txt_jur2.setText(ent.getJurusan());
            jDialog_jurusan2.setVisible(false);
        }
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        jDialog_jurusan2.setVisible(false);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        emp();
        jDialog_input.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
 try {
            daftarAplikan=aplikan.getlist();
            model_aplikan.setdata(daftarAplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_aplikan.class.getName()).log(Level.SEVERE, null, ex);
        }
   }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()==0){
            takeaplikan();
        }else if(jComboBox1.getSelectedIndex()==1){
            takeAplikansudahDaftar();
        }else if(jComboBox1.getSelectedIndex()==2){
           takeaplikanbelumdaftar();
        }else if(jComboBox1.getSelectedIndex()==3){
            takeAplikansudahreg();
        }else if(jComboBox1.getSelectedIndex()==4){
            takeAplikanbelumreg();
        }else if(jComboBox1.getSelectedIndex()==5){
            takeAplikanSudahUj();
        }else if(jComboBox1.getSelectedIndex()==6){
            takeAplikanbelumUj();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void tgl_lahir2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_lahir2KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            taketgldatang();
        }
    }//GEN-LAST:event_tgl_lahir2KeyTyped

    private void tgl_lahir4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_lahir4KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            taketanggalbetween();
        }
    }//GEN-LAST:event_tgl_lahir4KeyTyped

    private void tgl_lahir3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_lahir3KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_TAB){
            tgl_lahir4.requestFocus();
        }
    }//GEN-LAST:event_tgl_lahir3KeyTyped

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JComboBox cbo_pendidikan;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog_input;
    private javax.swing.JDialog jDialog_jurusan;
    private javax.swing.JDialog jDialog_jurusan2;
    private javax.swing.JDialog jDialog_mgm;
    private javax.swing.JDialog jDialog_presenter;
    private javax.swing.JDialog jDialog_sekolah;
    private javax.swing.JDialog jDialog_sumber;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField kd_jurusan;
    private javax.swing.JTextField kode_pos;
    private javax.swing.JTextField nama_aplikan;
    private javax.swing.JTextField nama_ortu;
    private javax.swing.JTextField nm_aplikan;
    private javax.swing.JTextField no_hp;
    private ace.panelMenu panelMenu1;
    private ace.panelMenuTes panelMenuTes1;
    private ace.panelMenuTes panelMenuTes2;
    private ace.panelMenuTes panelMenuTes3;
    private ace.panelMenuTes panelMenuTes4;
    private ace.panelMenuTes panelMenuTes5;
    private ace.panelMenuTes panelMenuTes6;
    private ace.panelMenuTes panelMenuTes7;
    private javax.swing.JFormattedTextField tgl_datang;
    private javax.swing.JFormattedTextField tgl_lahir;
    private javax.swing.JFormattedTextField tgl_lahir2;
    private javax.swing.JFormattedTextField tgl_lahir3;
    private javax.swing.JFormattedTextField tgl_lahir4;
    private javax.swing.JFormattedTextField thn_ajaran;
    private javax.swing.JFormattedTextField thn_lulus;
    private javax.swing.JTextField tlp;
    private javax.swing.JTextField tpt_lahir;
    private javax.swing.JTextField txt_jur1;
    private javax.swing.JTextField txt_jur2;
    private javax.swing.JTextField txt_mgm;
    private javax.swing.JTextField txt_presenter;
    private javax.swing.JTextField txt_sma;
    private javax.swing.JTextField txt_sumber;
    // End of variables declaration//GEN-END:variables
}
