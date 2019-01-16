/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import ace.model_aplikan1;
import ace.model_jurusan;
import ace.model_pewawancara;
import ace.model_wawancara;
import entity.entitas_aplikan;
import entity.entitas_jurusan;
import entity.entitas_pewawancara;
import entity.entitas_wawancara;
import intface.intface_aplikan;
import intface.intface_jurusan;
import intface.intface_pewawancara;
import intface.intface_wawancara;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author radhial22
 */
public class frm_wawancara extends javax.swing.JFrame {
model_wawancara wawan = new model_wawancara();
model_pewawancara pewawan = new model_pewawancara();
model_jurusan jurus = new model_jurusan();
model_aplikan1 aplikan = new model_aplikan1();
intface_wawancara inw;
intface_pewawancara inp;
intface_jurusan inj;
intface_aplikan iap;
List<entitas_pewawancara>daftarpe=new ArrayList<entitas_pewawancara>();
    List<entitas_wawancara>daftar=new ArrayList<entitas_wawancara>();
    List<entitas_jurusan>daftarjur=new ArrayList<entitas_jurusan>();
    List<entitas_aplikan>daftarAplikan=new ArrayList<>();
    int r;
    boolean beda;

    /**
     * Creates new form frm_wawancara
     */
    public frm_wawancara(intface_wawancara inw, intface_pewawancara inp,intface_jurusan inj, intface_aplikan iap) {
        this.inw=inw;
        this.inp=inp;
        this.inj=inj;
        this.iap=iap;
        initComponents();
        setLocationRelativeTo(null);
        enabel(false);
        button(true, false);
        
        take();
        jTable1.setModel(wawan);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                r=jTable1.getSelectedRow();
                if(r!=-1){
                    entitas_wawancara ent = daftar.get(r);
                    no_ujian.setText(ent.getNo_ujian());
                    no_aplikan.setText(ent.getNo_aplikan());
                    nama.setText(ent.getNama());
                    jur1.setText(ent.getJur1());
                    jur2.setText(ent.getJur2());
                    
                    if(ent.getKomu_lisan().equalsIgnoreCase("Utama")){
                        lisan1.setSelected(true);
                    }else if (ent.getKomu_lisan().equalsIgnoreCase("diatas rata-rata")){
                        lisan2.setSelected(true);
                    }else if (ent.getKomu_lisan().equalsIgnoreCase("rata-rata")){
                        lisan3.setSelected(true);
                    }else if (ent.getKomu_lisan().equalsIgnoreCase("dibawah rata-rata")){
                        lisan4.setSelected(true);
                    }else if (ent.getKomu_lisan().equalsIgnoreCase("sangat kurang")){
                        lisan5.setSelected(true);
                    }
                    if(ent.getKomu_tulis().equalsIgnoreCase("utama")){
                        komtu1.setSelected(true);
                    }else if (ent.getKomu_tulis().equalsIgnoreCase("diatas rata-rata")){
                        komtu2.setSelected(true);
                    }else if (ent.getKomu_tulis().equalsIgnoreCase("rata-rata")){
                        komtu3.setSelected(true);
                    }else if (ent.getKomu_tulis().equalsIgnoreCase("dibawah rata-rata")){
                        komtu4.setSelected(true);
                    }else if (ent.getKomu_tulis().equalsIgnoreCase("sangat kurang")){
                        komtu5.setSelected(true);
                    }
                    if(ent.getKem_intelek().equalsIgnoreCase("utama")){
                        intel1.setSelected(true);
                    }else if (ent.getKem_intelek().equalsIgnoreCase("diatas rata-rata")){
                        intel2.setSelected(true);
                    }else if (ent.getKem_intelek().equalsIgnoreCase("rata-rata")){
                        intel3.setSelected(true);
                    }else if (ent.getKem_intelek().equalsIgnoreCase("dibawah rata-rata")){
                        intel4.setSelected(true);
                    }else if (ent.getKem_intelek().equalsIgnoreCase("sangat kurang")){
                        intel5.setSelected(true);
                    }
                    if(ent.getMotivasi().equalsIgnoreCase("utama")){
                        motiv1.setSelected(true);
                    }else if (ent.getMotivasi().equalsIgnoreCase("diatas rata-rata")){
                        motiv2.setSelected(true);
                    }else if (ent.getMotivasi().equalsIgnoreCase("rata-rata")){
                        motiv3.setSelected(true);
                    }else if (ent.getMotivasi().equalsIgnoreCase("dibawah rata-rata")){
                        motiv4.setSelected(true);
                    }else if (ent.getMotivasi().equalsIgnoreCase("sangat kurang")){
                        motiv5.setSelected(true);
                    }
                    if(ent.getKedewasaa().equalsIgnoreCase("utama")){
                        dewasa1.setSelected(true);
                    }else if (ent.getKedewasaa().equalsIgnoreCase("diatas rata-rata")){
                        dewasa2.setSelected(true);
                    }else if (ent.getKedewasaa().equalsIgnoreCase("rata-rata")){
                        dewasa3.setSelected(true);
                    }else if (ent.getKedewasaa().equalsIgnoreCase("dibawah rata-rata")){
                        dewasa4.setSelected(true);
                    }else if (ent.getKedewasaa().equalsIgnoreCase("sangat kurang")){
                        dewasa5.setSelected(true);
                    }
                    if(ent.getKem_kerjasama().equalsIgnoreCase("utama")){
                        kerja1.setSelected(true);
                    }else if (ent.getKem_kerjasama().equalsIgnoreCase("diatas rata-rata")){
                        kerja2.setSelected(true);
                    }else if (ent.getKem_kerjasama().equalsIgnoreCase("rata-rata")){
                        kerja3.setSelected(true);
                    }else if (ent.getKem_kerjasama().equalsIgnoreCase("dibawah rata-rata")){
                        kerja4.setSelected(true);
                    }else if (ent.getKem_kerjasama().equalsIgnoreCase("sangat kurang")){
                        kerja5.setSelected(true);
                    }
                    if(ent.getPd().equalsIgnoreCase("utama")){
                        pd1.setSelected(true);
                    }else if (ent.getPd().equalsIgnoreCase("diatas rata-rata")){
                        pd2.setSelected(true);
                    }else if (ent.getPd().equalsIgnoreCase("rata-rata")){
                        pd3.setSelected(true);
                    }else if (ent.getPd().equalsIgnoreCase("dibawah rata-rata")){
                        pd4.setSelected(true);
                    }else if (ent.getPd().equalsIgnoreCase("sangat kurang")){
                        pd5.setSelected(true);
                    }
                    if(ent.getDaya_analisis().equalsIgnoreCase("utama")){
                        analisis1.setSelected(true);
                    }else if (ent.getDaya_analisis().equalsIgnoreCase("diatas rata-rata")){
                        analisis2.setSelected(true);
                    }else if (ent.getDaya_analisis().equalsIgnoreCase("rata-rata")){
                        analisis3.setSelected(true);
                    }else if (ent.getDaya_analisis().equalsIgnoreCase("dibawah rata-rata")){
                        analisis4.setSelected(true);
                    }else if (ent.getDaya_analisis().equalsIgnoreCase("sangat kurang")){
                        analisis5.setSelected(true);
                    }
                    if(ent.getKem_adm().equalsIgnoreCase("utama")){
                        adm1.setSelected(true);
                    }else if (ent.getKem_adm().equalsIgnoreCase("diatas rata-rata")){
                        adm2.setSelected(true);
                    }else if (ent.getKem_adm().equalsIgnoreCase("rata-rata")){
                        adm3.setSelected(true);
                    }else if (ent.getKem_adm().equalsIgnoreCase("dibawah rata-rata")){
                        adm4.setSelected(true);
                    }else if (ent.getKem_adm().equalsIgnoreCase("sangat kurang")){
                        adm5.setSelected(true);
                    }
                    
                    if(ent.getPenampilan().equalsIgnoreCase("a")){
                    penam1.setSelected(true);    
                    }else if(ent.getPenampilan().equalsIgnoreCase("b")){
                    penam2.setSelected(true);
                }else if(ent.getPenampilan().equalsIgnoreCase("c")){
                    penam3.setSelected(true);
                }else if(ent.getPenampilan().equalsIgnoreCase("d")){
                    penam4.setSelected(true);
                }else if(ent.getPenampilan().equalsIgnoreCase("e")){
                    penam5.setSelected(true);
                }
                    if(ent.getKacamata().equalsIgnoreCase("ya")){
                        mata1.setSelected(true);
                    }else if(ent.getKacamata().equalsIgnoreCase("tidak")){
                        mata2.setSelected(true);
                        ukurankaca.setEnabled(false);
                    }
                    
                    if(ent.getIq().equalsIgnoreCase("a")){
                        iq1.setSelected(true);
                    }else if (ent.getIq().equalsIgnoreCase("b")){
                        iq2.setSelected(true);
                    }else if (ent.getIq().equalsIgnoreCase("c")){
                        iq3.setSelected(true);
                    }else if (ent.getIq().equalsIgnoreCase("d")){
                        iq4.setSelected(true);
                    }else if (ent.getIq().equalsIgnoreCase("e")){
                        iq5.setSelected(true);
                    }
                    if(ent.getKesimpulan().equalsIgnoreCase("lulus")){
                        kes1.setSelected(true);
                    }else if(ent.getKesimpulan().equalsIgnoreCase("lulus percobaan")){
                        kes2.setSelected(true);
                    }else if(ent.getKesimpulan().equalsIgnoreCase("lulus cadangan")){
                        kes3.setSelected(true);
                    }else if(ent.getKesimpulan().equalsIgnoreCase("tidak lulus")){
                        kes4.setSelected(true);
                    }
                    if(ent.getPredikat().equalsIgnoreCase("a")){
                        pedikata.setSelected(true);
                    }else if(ent.getPredikat().equalsIgnoreCase("b")){
                        predikatb.setSelected(true);
                    }else if(ent.getPredikat().equalsIgnoreCase("c")){
                        predikatc.setSelected(true);
                    }
                    kelebihan.setText(ent.getKelebihan());
                    penyakit.setText(ent.getPenyakit());
                    jurusan.setText(ent.getJurusan());
                    petugas.setText(ent.getPetugas());
                }
            }
        });
    }
void take(){
        try {
            daftar=inw.getall();
            wawan.setdata(daftar);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_wawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
void takewawan(){
        try {
            daftarpe=inp.getall();
            pewawan.setdata(daftarpe);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_wawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void takejurus(){
        try {
            daftarjur=inj.getall();
            jurus.setdata(daftarjur);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_wawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}



void clear(){
    no_aplikan.setText("");
    no_ujian.setText("");
    nama.setText("");
    jur1.setText("");
    jur2.setText("");
    kelebihan.setText("");
    penyakit.setText("");
    ukurankaca.setText("");
    jurusan.setText("");
    petugas.setText("");
    komtu1.setSelected(false);
    komtu2.setSelected(false);
    komtu3.setSelected(false);
    komtu4.setSelected(false);
    komtu5.setSelected(false);
    lisan1.setSelected(false);
    lisan2.setSelected(false);
    lisan3.setSelected(false);
    lisan4.setSelected(false);
    lisan5.setSelected(false);
    intel1.setSelected(false);
    intel2.setSelected(false);
    intel3.setSelected(false);
    intel4.setSelected(false);
    intel5.setSelected(false);
    motiv1.setSelected(false);
    motiv2.setSelected(false);
    motiv3.setSelected(false);
    motiv4.setSelected(false);
    motiv5.setSelected(false);
    dewasa1.setSelected(false);
    dewasa2.setSelected(false);
    dewasa3.setSelected(false);
    dewasa4.setSelected(false);
    dewasa5.setSelected(false);
    kerja1.setSelected(false);
    kerja2.setSelected(false);
    kerja3.setSelected(false);
    kerja4.setSelected(false);
    kerja5.setSelected(false);
    pd1.setSelected(false);
    pd2.setSelected(false);
    pd3.setSelected(false);
    pd4.setSelected(false);
    pd5.setSelected(false);
    analisis1.setSelected(false);
    analisis2.setSelected(false);
    analisis3.setSelected(false);
    analisis4.setSelected(false);
    analisis5.setSelected(false);
    adm1.setSelected(false);
    adm2.setSelected(false);
    adm3.setSelected(false);
    adm4.setSelected(false);
    adm5.setSelected(false);
    penam1.setSelected(false);
    penam2.setSelected(false);
    penam3.setSelected(false);
    penam4.setSelected(false);
    penam5.setSelected(false);
    mata1.setSelected(false);
    mata2.setSelected(false);
    iq1.setSelected(false);
    iq2.setSelected(false);
    iq3.setSelected(false);
    iq4.setSelected(false);
    iq5.setSelected(false);
    kes1.setSelected(false);
    kes2.setSelected(false);
    kes3.setSelected(false);
    kes4.setSelected(false);
    pedikata.setSelected(false);
    predikatb.setSelected(false);
    predikatc.setSelected(false);
}
void enabel(boolean a){
    no_aplikan.setEnabled(a);
    no_ujian.setEnabled(a);
    nama.setEnabled(a);
    jur1.setEnabled(a);
     jur2.setEnabled(a);
     kelebihan.setEnabled(a);
     penyakit.setEnabled(a);
     ukurankaca.setEnabled(a);
     jurusan.setEnabled(a);
     petugas.setEnabled(a);
     komtu1.setEnabled(a);
    komtu2.setEnabled(a);
    komtu3.setEnabled(a);
    komtu4.setEnabled(a);
    komtu5.setEnabled(a);
    lisan1.setEnabled(a);
    lisan2.setEnabled(a);
    lisan3.setEnabled(a);
    lisan4.setEnabled(a);
    lisan5.setEnabled(a);
    intel1.setEnabled(a);
    intel2.setEnabled(a);
    intel3.setEnabled(a);
    intel4.setEnabled(a);
    intel5.setEnabled(a);
    motiv1.setEnabled(a);
    motiv2.setEnabled(a);
    motiv3.setEnabled(a);
    motiv4.setEnabled(a);
    motiv5.setEnabled(a);
    dewasa1.setEnabled(a);
    dewasa2.setEnabled(a);
    dewasa3.setEnabled(a);
    dewasa4.setEnabled(a);
    dewasa5.setEnabled(a);
    kerja1.setEnabled(a);
    kerja2.setEnabled(a);
    kerja3.setEnabled(a);
    kerja4.setEnabled(a);
    kerja5.setEnabled(a);
    pd1.setEnabled(a);
    pd2.setEnabled(a);
    pd3.setEnabled(a);
    pd4.setEnabled(a);
    pd5.setEnabled(a);
    analisis1.setEnabled(a);
    analisis2.setEnabled(a);
    analisis3.setEnabled(a);
    analisis4.setEnabled(a);
    analisis5.setEnabled(a);
    adm1.setEnabled(a);
    adm2.setEnabled(a);
    adm3.setEnabled(a);
    adm4.setEnabled(a);
    adm5.setEnabled(a);
    penam1.setEnabled(a);
    penam2.setEnabled(a);
    penam3.setEnabled(a);
    penam4.setEnabled(a);
    penam5.setEnabled(a);
    mata1.setEnabled(a);
    mata2.setEnabled(a);
    iq1.setEnabled(a);
    iq2.setEnabled(a);
    iq3.setEnabled(a);
    iq4.setEnabled(a);
    iq5.setEnabled(a);
    kes1.setEnabled(a);
    kes2.setEnabled(a);
    kes3.setEnabled(a);
    kes4.setEnabled(a);
    pedikata.setEnabled(a);
    predikatb.setEnabled(a);
    predikatc.setEnabled(a);
}

void button(boolean a, boolean b){
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        jDialog_pewawan = new javax.swing.JDialog();
        panelMenuTes2 = new ace.panelMenuTes();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jDialog1_jurus = new javax.swing.JDialog();
        panelMenuTes3 = new ace.panelMenuTes();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jDialog_aplikan = new javax.swing.JDialog();
        panelMenuTes4 = new ace.panelMenuTes();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        panelMenu1 = new ace.panelMenu();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        no_ujian = new javax.swing.JTextField();
        no_aplikan = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jur1 = new javax.swing.JTextField();
        jur2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        kelebihan = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        penyakit = new javax.swing.JTextArea();
        ukurankaca = new javax.swing.JTextField();
        jurusan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        petugas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        penam1 = new javax.swing.JCheckBox();
        penam2 = new javax.swing.JCheckBox();
        penam3 = new javax.swing.JCheckBox();
        penam4 = new javax.swing.JCheckBox();
        penam5 = new javax.swing.JCheckBox();
        mata1 = new javax.swing.JCheckBox();
        mata2 = new javax.swing.JCheckBox();
        iq1 = new javax.swing.JCheckBox();
        iq2 = new javax.swing.JCheckBox();
        iq3 = new javax.swing.JCheckBox();
        iq4 = new javax.swing.JCheckBox();
        iq5 = new javax.swing.JCheckBox();
        kes1 = new javax.swing.JCheckBox();
        kes2 = new javax.swing.JCheckBox();
        kes3 = new javax.swing.JCheckBox();
        kes4 = new javax.swing.JCheckBox();
        pedikata = new javax.swing.JCheckBox();
        predikatb = new javax.swing.JCheckBox();
        predikatc = new javax.swing.JCheckBox();
        lisan1 = new javax.swing.JCheckBox();
        lisan2 = new javax.swing.JCheckBox();
        lisan3 = new javax.swing.JCheckBox();
        lisan4 = new javax.swing.JCheckBox();
        lisan5 = new javax.swing.JCheckBox();
        komtu1 = new javax.swing.JCheckBox();
        komtu2 = new javax.swing.JCheckBox();
        komtu3 = new javax.swing.JCheckBox();
        komtu4 = new javax.swing.JCheckBox();
        komtu5 = new javax.swing.JCheckBox();
        intel1 = new javax.swing.JCheckBox();
        intel2 = new javax.swing.JCheckBox();
        intel3 = new javax.swing.JCheckBox();
        intel4 = new javax.swing.JCheckBox();
        intel5 = new javax.swing.JCheckBox();
        motiv1 = new javax.swing.JCheckBox();
        motiv2 = new javax.swing.JCheckBox();
        motiv3 = new javax.swing.JCheckBox();
        motiv4 = new javax.swing.JCheckBox();
        motiv5 = new javax.swing.JCheckBox();
        dewasa1 = new javax.swing.JCheckBox();
        dewasa2 = new javax.swing.JCheckBox();
        dewasa3 = new javax.swing.JCheckBox();
        dewasa4 = new javax.swing.JCheckBox();
        dewasa5 = new javax.swing.JCheckBox();
        kerja1 = new javax.swing.JCheckBox();
        kerja2 = new javax.swing.JCheckBox();
        kerja3 = new javax.swing.JCheckBox();
        kerja4 = new javax.swing.JCheckBox();
        kerja5 = new javax.swing.JCheckBox();
        pd1 = new javax.swing.JCheckBox();
        pd2 = new javax.swing.JCheckBox();
        pd3 = new javax.swing.JCheckBox();
        pd4 = new javax.swing.JCheckBox();
        pd5 = new javax.swing.JCheckBox();
        analisis1 = new javax.swing.JCheckBox();
        analisis2 = new javax.swing.JCheckBox();
        analisis3 = new javax.swing.JCheckBox();
        analisis4 = new javax.swing.JCheckBox();
        analisis5 = new javax.swing.JCheckBox();
        adm1 = new javax.swing.JCheckBox();
        adm2 = new javax.swing.JCheckBox();
        adm3 = new javax.swing.JCheckBox();
        adm4 = new javax.swing.JCheckBox();
        adm5 = new javax.swing.JCheckBox();

        jDialog_pewawan.setUndecorated(true);

        jTextField4.setForeground(new java.awt.Color(102, 102, 102));
        jTextField4.setText("Cari");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Kabupaten", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)));
        jPanel2.setOpaque(false);

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
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("X");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes2Layout = new javax.swing.GroupLayout(panelMenuTes2);
        panelMenuTes2.setLayout(panelMenuTes2Layout);
        panelMenuTes2Layout.setHorizontalGroup(
            panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes2Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuTes2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102))))
        );
        panelMenuTes2Layout.setVerticalGroup(
            panelMenuTes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes2Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(16, 16, 16)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog_pewawanLayout = new javax.swing.GroupLayout(jDialog_pewawan.getContentPane());
        jDialog_pewawan.getContentPane().setLayout(jDialog_pewawanLayout);
        jDialog_pewawanLayout.setHorizontalGroup(
            jDialog_pewawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuTes2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        jDialog_pewawanLayout.setVerticalGroup(
            jDialog_pewawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuTes2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog1_jurus.setUndecorated(true);

        jTextField5.setForeground(new java.awt.Color(102, 102, 102));
        jTextField5.setText("Cari");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Kabupaten", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)));
        jPanel3.setOpaque(false);

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
        jScrollPane5.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("X");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes3Layout = new javax.swing.GroupLayout(panelMenuTes3);
        panelMenuTes3.setLayout(panelMenuTes3Layout);
        panelMenuTes3Layout.setHorizontalGroup(
            panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes3Layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuTes3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102))))
        );
        panelMenuTes3Layout.setVerticalGroup(
            panelMenuTes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes3Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addGap(16, 16, 16)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1_jurusLayout = new javax.swing.GroupLayout(jDialog1_jurus.getContentPane());
        jDialog1_jurus.getContentPane().setLayout(jDialog1_jurusLayout);
        jDialog1_jurusLayout.setHorizontalGroup(
            jDialog1_jurusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuTes3, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        jDialog1_jurusLayout.setVerticalGroup(
            jDialog1_jurusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuTes3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog_aplikan.setUndecorated(true);

        jTable4.setForeground(new java.awt.Color(102, 102, 102));
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
        jScrollPane6.setViewportView(jTable4);

        jTextField6.setForeground(new java.awt.Color(102, 102, 102));
        jTextField6.setText("Cari");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("X");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuTes4Layout = new javax.swing.GroupLayout(panelMenuTes4);
        panelMenuTes4.setLayout(panelMenuTes4Layout);
        panelMenuTes4Layout.setHorizontalGroup(
            panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(panelMenuTes4Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)))
                .addContainerGap())
        );
        panelMenuTes4Layout.setVerticalGroup(
            panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes4Layout.createSequentialGroup()
                .addGroup(panelMenuTes4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
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
                    .addComponent(panelMenuTes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_aplikanLayout.setVerticalGroup(
            jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_aplikanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/window_delete.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel2.setText("No. Ujian :");

        jLabel3.setText("No. Aplikan :");

        jLabel4.setText("Nama :");

        jLabel6.setText("Prioritas :");

        jLabel7.setText("Alternatif :");

        jLabel8.setText("Komunikasi Lisan :");

        jLabel9.setText("Komunikasi Tertulis :");

        jLabel10.setText("Kemampuan Intelektual :");

        jLabel11.setText("Motivasi :");

        jLabel12.setText("Kedewasaan :");

        jLabel13.setText("Kemampuan Kerjasama :");

        jLabel14.setText("Percaya Diri :");

        jLabel15.setText("Daya Analisis :");

        jLabel16.setText("Kemampuan Adm :");

        jLabel17.setText(" Kelebihan & Kekurangan :");

        jLabel18.setText("Penampilan :");

        jLabel19.setText("Penyakit yang Pernah di Derita :");

        jLabel20.setText("Berkacamata :");

        jLabel21.setText("Jika Ya, Ukurannya :");

        jLabel22.setText("Kepandaian (IQ) :");

        jLabel23.setText("Kesimpulan Umum :");

        jLabel24.setText("Predikat Lulus :");

        jLabel25.setText("Lulus di Jurusan :");

        no_ujian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                no_ujianKeyTyped(evt);
            }
        });

        kelebihan.setColumns(20);
        kelebihan.setRows(5);
        jScrollPane2.setViewportView(kelebihan);

        penyakit.setColumns(20);
        penyakit.setRows(5);
        jScrollPane3.setViewportView(penyakit);

        jurusan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jurusanKeyTyped(evt);
            }
        });

        jLabel26.setText("Pewawancara :");

        petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petugasActionPerformed(evt);
            }
        });
        petugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                petugasKeyTyped(evt);
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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/arrow_down.png"))); // NOI18N
        jButton3.setText("Simpan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/replay.png"))); // NOI18N
        jButton4.setText("Batal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup10.add(penam1);
        penam1.setText("A");

        buttonGroup10.add(penam2);
        penam2.setText("B");

        buttonGroup10.add(penam3);
        penam3.setText("C");

        buttonGroup10.add(penam4);
        penam4.setText("D");

        buttonGroup10.add(penam5);
        penam5.setText("E");

        buttonGroup11.add(mata1);
        mata1.setText("Ya");
        mata1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mata1ActionPerformed(evt);
            }
        });

        buttonGroup11.add(mata2);
        mata2.setText("Tidak");
        mata2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mata2ActionPerformed(evt);
            }
        });

        buttonGroup12.add(iq1);
        iq1.setText("A");

        buttonGroup12.add(iq2);
        iq2.setText("B");

        buttonGroup12.add(iq3);
        iq3.setText("C");

        buttonGroup12.add(iq4);
        iq4.setText("D");

        buttonGroup12.add(iq5);
        iq5.setText("E");

        buttonGroup13.add(kes1);
        kes1.setText("Lulus");

        buttonGroup13.add(kes2);
        kes2.setText("Lulus Percobaan");

        buttonGroup13.add(kes3);
        kes3.setText("Lulus Cadangan");

        buttonGroup13.add(kes4);
        kes4.setText("Tidak Lulus");

        buttonGroup14.add(pedikata);
        pedikata.setText("A");

        buttonGroup14.add(predikatb);
        predikatb.setText("B");

        buttonGroup14.add(predikatc);
        predikatc.setText("C");

        buttonGroup1.add(lisan1);
        lisan1.setText("Utama");
        lisan1.setOpaque(false);

        buttonGroup1.add(lisan2);
        lisan2.setText("Diatas Rata-rata");
        lisan2.setOpaque(false);

        buttonGroup1.add(lisan3);
        lisan3.setText("Rata-rata");

        buttonGroup1.add(lisan4);
        lisan4.setText("Dibawah Rata-rata");

        buttonGroup1.add(lisan5);
        lisan5.setText("Sangat Kurang");

        buttonGroup2.add(komtu1);
        komtu1.setText("Utama");
        komtu1.setOpaque(false);

        buttonGroup2.add(komtu2);
        komtu2.setText("Diatas Rata-rata");
        komtu2.setOpaque(false);

        buttonGroup2.add(komtu3);
        komtu3.setText("Rata-rata");

        buttonGroup2.add(komtu4);
        komtu4.setText("Dibawah Rata-rata");

        buttonGroup2.add(komtu5);
        komtu5.setText("Sangat Kurang");

        buttonGroup3.add(intel1);
        intel1.setText("Utama");
        intel1.setOpaque(false);

        buttonGroup3.add(intel2);
        intel2.setText("Diatas Rata-rata");
        intel2.setOpaque(false);

        buttonGroup3.add(intel3);
        intel3.setText("Rata-rata");

        buttonGroup3.add(intel4);
        intel4.setText("Dibawah Rata-rata");

        buttonGroup3.add(intel5);
        intel5.setText("Sangat Kurang");

        buttonGroup4.add(motiv1);
        motiv1.setText("Utama");
        motiv1.setOpaque(false);

        buttonGroup4.add(motiv2);
        motiv2.setText("Diatas Rata-rata");
        motiv2.setOpaque(false);

        buttonGroup4.add(motiv3);
        motiv3.setText("Rata-rata");

        buttonGroup4.add(motiv4);
        motiv4.setText("Dibawah Rata-rata");

        buttonGroup4.add(motiv5);
        motiv5.setText("Sangat Kurang");

        buttonGroup5.add(dewasa1);
        dewasa1.setText("Utama");
        dewasa1.setOpaque(false);

        buttonGroup5.add(dewasa2);
        dewasa2.setText("Diatas Rata-rata");
        dewasa2.setOpaque(false);

        buttonGroup5.add(dewasa3);
        dewasa3.setText("Rata-rata");

        buttonGroup5.add(dewasa4);
        dewasa4.setText("Dibawah Rata-rata");

        buttonGroup5.add(dewasa5);
        dewasa5.setText("Sangat Kurang");

        buttonGroup6.add(kerja1);
        kerja1.setText("Utama");
        kerja1.setOpaque(false);

        buttonGroup6.add(kerja2);
        kerja2.setText("Diatas Rata-rata");
        kerja2.setOpaque(false);

        buttonGroup6.add(kerja3);
        kerja3.setText("Rata-rata");

        buttonGroup6.add(kerja4);
        kerja4.setText("Dibawah Rata-rata");

        buttonGroup6.add(kerja5);
        kerja5.setText("Sangat Kurang");

        buttonGroup7.add(pd1);
        pd1.setText("Utama");
        pd1.setOpaque(false);

        buttonGroup7.add(pd2);
        pd2.setText("Diatas Rata-rata");
        pd2.setOpaque(false);

        buttonGroup7.add(pd3);
        pd3.setText("Rata-rata");

        buttonGroup7.add(pd4);
        pd4.setText("Dibawah Rata-rata");

        buttonGroup7.add(pd5);
        pd5.setText("Sangat Kurang");

        buttonGroup8.add(analisis1);
        analisis1.setText("Utama");
        analisis1.setOpaque(false);

        buttonGroup8.add(analisis2);
        analisis2.setText("Diatas Rata-rata");
        analisis2.setOpaque(false);

        buttonGroup8.add(analisis3);
        analisis3.setText("Rata-rata");

        buttonGroup8.add(analisis4);
        analisis4.setText("Dibawah Rata-rata");

        buttonGroup8.add(analisis5);
        analisis5.setText("Sangat Kurang");

        buttonGroup9.add(adm1);
        adm1.setText("Utama");
        adm1.setOpaque(false);

        buttonGroup9.add(adm2);
        adm2.setText("Diatas Rata-rata");
        adm2.setOpaque(false);

        buttonGroup9.add(adm3);
        adm3.setText("Rata-rata");

        buttonGroup9.add(adm4);
        adm4.setText("Dibawah Rata-rata");

        buttonGroup9.add(adm5);
        adm5.setText("Sangat Kurang");

        javax.swing.GroupLayout panelMenu1Layout = new javax.swing.GroupLayout(panelMenu1);
        panelMenu1.setLayout(panelMenu1Layout);
        panelMenu1Layout.setHorizontalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(6, 6, 6)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(intel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(intel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(intel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(intel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(intel5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(komtu1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(komtu2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(komtu3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(komtu4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(komtu5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(lisan1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lisan2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lisan3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lisan4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lisan5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(motiv1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(motiv2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(motiv3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(motiv4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(motiv5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(dewasa1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dewasa2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dewasa3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dewasa4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dewasa5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(pd1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pd2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pd3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pd4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pd5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(kerja1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kerja2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kerja3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kerja4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kerja5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(analisis1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analisis2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analisis3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analisis4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(analisis5))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(adm1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adm2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adm3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adm4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adm5))))
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mata1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mata2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ukurankaca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pedikata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(predikatb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(predikatc))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMenu1Layout.createSequentialGroup()
                                        .addComponent(iq1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iq2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iq3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iq4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iq5))
                                    .addGroup(panelMenu1Layout.createSequentialGroup()
                                        .addComponent(kes1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(kes2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(kes3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(kes4))))))
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penam1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penam2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penam3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penam4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penam5))
                    .addComponent(jLabel19)
                    .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(4, 4, 4)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(jur1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jur2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(no_ujian, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(no_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenu1Layout.setVerticalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu1Layout.createSequentialGroup()
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(no_ujian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(no_aplikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lisan1)
                                    .addComponent(lisan2)
                                    .addComponent(lisan3)
                                    .addComponent(lisan4)
                                    .addComponent(lisan5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(komtu1)
                                    .addComponent(komtu2)
                                    .addComponent(komtu3)
                                    .addComponent(komtu4)
                                    .addComponent(komtu5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(intel1)
                                    .addComponent(intel2)
                                    .addComponent(intel3)
                                    .addComponent(intel4)
                                    .addComponent(intel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(motiv1)
                                    .addComponent(motiv2)
                                    .addComponent(motiv3)
                                    .addComponent(motiv4)
                                    .addComponent(motiv5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(dewasa1)
                                    .addComponent(dewasa2)
                                    .addComponent(dewasa3)
                                    .addComponent(dewasa4)
                                    .addComponent(dewasa5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(kerja1)
                                    .addComponent(kerja2)
                                    .addComponent(kerja3)
                                    .addComponent(kerja4)
                                    .addComponent(kerja5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(pd1)
                                    .addComponent(pd2)
                                    .addComponent(pd3)
                                    .addComponent(pd4)
                                    .addComponent(pd5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(analisis1)
                                    .addComponent(analisis2)
                                    .addComponent(analisis3)
                                    .addComponent(analisis4)
                                    .addComponent(analisis5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(adm1)
                                    .addComponent(adm2)
                                    .addComponent(adm3)
                                    .addComponent(adm4)
                                    .addComponent(adm5))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(penam1)
                                    .addComponent(penam2)
                                    .addComponent(penam3)
                                    .addComponent(penam4)
                                    .addComponent(penam5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(ukurankaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mata1)
                                    .addComponent(mata2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iq1)
                            .addComponent(iq2)
                            .addComponent(iq3)
                            .addComponent(iq4)
                            .addComponent(iq5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(kes1)
                            .addComponent(kes2)
                            .addComponent(kes3)
                            .addComponent(kes4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(pedikata)
                            .addComponent(predikatb)
                            .addComponent(predikatc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void mata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mata2ActionPerformed
        // TODO add your handling code here:
        if(mata2.isSelected()){
            ukurankaca.setEnabled(false);
            ukurankaca.setText("-");
        }
    }//GEN-LAST:event_mata2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        beda=true;
        enabel(true);
        clear();
        no_ujian.requestFocus();
        button(false, true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mata1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mata1ActionPerformed
        // TODO add your handling code here:
        if(mata1.isSelected()){
            ukurankaca.setEnabled(true);
        }
    }//GEN-LAST:event_mata1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        button(true, false);
        enabel(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nm = nama.getText();
        int pesan = JOptionPane.showConfirmDialog(getRootPane(), "Apakah "+ nm + " Akan Dihapus ?","konsfirmasi",JOptionPane.YES_NO_OPTION);
        if(pesan==JOptionPane.YES_OPTION){
            try {
                inw.delete(no_ujian.getText());
                take();
            } catch (RemoteException ex) {
                Logger.getLogger(frm_wawancara.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
        beda=false;
        enabel(true);
        no_ujian.setEnabled(false);
        no_aplikan.requestFocus();
        button(false, true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(beda==true){
            if(no_ujian.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Nomor Ujian Aplikan Wajib Diisi");
                no_ujian.requestFocus();
            }else{
                try {
                    entitas_wawancara ent = new entitas_wawancara();
                    entitas_aplikan entt = new entitas_aplikan();
                    ent.setNo_ujian(no_ujian.getText());
                    ent.setNo_aplikan(no_aplikan.getText());
                    ent.setNama(nama.getText());
                    ent.setJur1(jur1.getText());
                    ent.setJur2(jur2.getText());
                    if(lisan1.isSelected()){
                        ent.setKomu_lisan("Utama");
                    }else if (lisan2.isSelected()){
                        ent.setKomu_lisan("Diatas Rata-rata");
                    }else if (lisan3.isSelected()){
                        ent.setKomu_lisan("Rata-rata");
                    }else if(lisan4.isSelected()){
                        ent.setKomu_lisan("Dibawah Rata-rata");
                    }else if (lisan5.isSelected()){
                        ent.setKomu_lisan("Sangat Kurang");
                    }
                    if(komtu1.isSelected()){
                        ent.setKomu_tulis("Utama");
                    }else if (komtu2.isSelected()){
                        ent.setKomu_tulis("Diatas Rata-rata");
                    }else if(komtu3.isSelected()){
                        ent.setKomu_tulis("Rata-rata");
                    } else if(komtu4.isSelected()){
                        ent.setKomu_tulis("Dibawah Rata-rata");
                    }else if (komtu5.isSelected()){
                        ent.setKomu_tulis("Sangat Kurang");
                    }
                    if(intel1.isSelected()){
                        ent.setKem_intelek("Utama");
                    }else if(intel2.isSelected()){
                        ent.setKem_intelek("Diatas Rata-rata");
                    }else if(intel3.isSelected()){
                        ent.setKem_intelek("Rata-rata");
                    }else if(intel4.isSelected()){
                        ent.setKem_intelek("Dibawah Rata-rata");
                    }else if(intel5.isSelected()){
                        ent.setKem_intelek("Sangat Kurang");
                    }
                    if(motiv1.isSelected()){
                        ent.setMotivasi("Utama");
                    }else if(motiv2.isSelected()){
                        ent.setMotivasi("Diatas Rata-rata");
                    }else if(motiv3.isSelected()){
                        ent.setMotivasi("Rata-rata");
                    }else if(motiv4.isSelected()){
                        ent.setMotivasi("Dibawah Rata-rata");
                    }else if(motiv5.isSelected()){
                        ent.setMotivasi("Sangat Kurang");
                    }
                    if(dewasa1.isSelected()){
                        ent.setKedewasaa("Utama");
                    }else if(dewasa2.isSelected()){
                        ent.setKedewasaa("Diatas Rata-rata");
                    }else if(dewasa3.isSelected()){
                        ent.setKedewasaa("Rata-rata");
                    }else if(dewasa4.isSelected()){
                        ent.setKedewasaa("Dibawah Rata-rata");
                    }else if(dewasa5.isSelected()){
                        ent.setKedewasaa("Sangat Kurang");
                    }
                    if(kerja1.isSelected()){
                        ent.setKem_kerjasama("Utama");
                    }else if(kerja2.isSelected()){
                        ent.setKem_kerjasama("Diatas Rata-rata");
                    }else if(kerja3.isSelected()){
                        ent.setKem_kerjasama("Rata-rata");
                    }else if(kerja4.isSelected()){
                        ent.setKem_kerjasama("Dibawah Rata-rata");
                    }else if(kerja5.isSelected()){
                        ent.setKem_kerjasama("Sangat Kurang");
                    }
                    if(pd1.isSelected()){
                        ent.setPd("Utama");
                    }else if(pd2.isSelected()){
                        ent.setPd("Diatas Rata-rata");
                    }else if(pd3.isSelected()){
                        ent.setPd("Rata-rata");
                    }else if(pd4.isSelected()){
                        ent.setPd("Dibawah Rata-rata");
                    }else if(pd5.isSelected()){
                        ent.setPd("Sangat Kurang");
                    }
                    if(analisis1.isSelected()){
                        ent.setDaya_analisis("Utama");
                    }else if(analisis2.isSelected()){
                        ent.setDaya_analisis("Diatas Rata-rata");
                    }else if(analisis3.isSelected()){
                        ent.setDaya_analisis("Rata-rata");
                    }else if(analisis4.isSelected()){
                        ent.setDaya_analisis("Dibawah Rata-rata");
                    }else if(analisis5.isSelected()){
                        ent.setDaya_analisis("Sangat Kurang");
                    }
                    if(adm1.isSelected()){
                        ent.setKem_adm("Utama");
                    }else if(adm2.isSelected()){
                        ent.setKem_adm("Diatas Rata-rata");
                    }else if(adm3.isSelected()){
                        ent.setKem_adm("Rata-rata");
                    }else if(adm4.isSelected()){
                        ent.setKem_adm("Dibawah Rata-rata");
                    }else if(adm5.isSelected()){
                        ent.setKem_adm("Sangat Kurang");
                    }
                    ent.setKelebihan(kelebihan.getText());
                    if(penam1.isSelected()){
                        ent.setPenampilan("A");
                    }else if(penam2.isSelected()){
                        ent.setPenampilan("B");
                    }else if(penam3.isSelected()){
                        ent.setPenampilan("C");
                    }else if(penam4.isSelected()){
                        ent.setPenampilan("D");
                    }else if(penam5.isSelected()){
                        ent.setPenampilan("E");
                    }
                    ent.setPenyakit(penyakit.getText());
                    if(mata1.isSelected()){
                        ent.setKacamata("Ya");
                    }else if(mata2.isSelected()){
                        ent.setKacamata("Tidak");
                    }
                    ent.setUkuran(ukurankaca.getText());
                    if(iq1.isSelected()){
                        ent.setIq("A");
                    }else if(iq2.isSelected()){
                        ent.setIq("B");
                    }else if(iq3.isSelected()){
                        ent.setIq("C");
                    }else if(iq4.isSelected()){
                        ent.setIq("D");
                    }else if(iq5.isSelected()){
                        ent.setIq("E");
                    }
                    if(kes1.isSelected()){
                        ent.setKesimpulan("Lulus");
                    }else if(kes2.isSelected()){
                        ent.setKesimpulan("Lulus Percobaan");
                    }else if(kes3.isSelected()){
                        ent.setKesimpulan("Lulus Cadangan");
                    }else if(kes4.isSelected()){
                        ent.setKesimpulan("Tidak Lulus");
                    }
                    if(pedikata.isSelected()){
                        ent.setPredikat("A");
                    }else if(predikatb.isSelected()){
                        ent.setPredikat("B");
                    }else if (predikatc.isSelected()){
                        ent.setPredikat("C");
                    }
                    ent.setJurusan(jurusan.getText());
                    ent.setPetugas(petugas.getText());
                    
                    entt.setNomor_aplikan(no_aplikan.getText());
                    inw.insert(ent);
                    iap.updateUj(entt);
                    take();
                    clear();
                    enabel(true);
                    no_ujian.requestFocus();
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    Logger.getLogger(frm_wawancara.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if (beda==false){
            if(no_ujian.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Pilih Data yang Akan Diubah");
            }else{
                try {
                    entitas_wawancara ent = new entitas_wawancara();
                    ent.setNo_ujian(no_ujian.getText());
                    ent.setNo_aplikan(no_aplikan.getText());
                    ent.setNama(nama.getText());
                    ent.setJur1(jur1.getText());
                    ent.setJur2(jur2.getText());
                    if(lisan1.isSelected()){
                        ent.setKomu_lisan("Utama");
                    }else if (lisan2.isSelected()){
                        ent.setKomu_lisan("Diatas Rata-rata");
                    }else if (lisan3.isSelected()){
                        ent.setKomu_lisan("Rata-rata");
                    }else if(lisan4.isSelected()){
                        ent.setKomu_lisan("Dibawah Rata-rata");
                    }else if (lisan5.isSelected()){
                        ent.setKomu_lisan("Sangat Kurang");
                    }
                    if(komtu1.isSelected()){
                        ent.setKomu_tulis("Utama");
                    }else if (komtu2.isSelected()){
                        ent.setKomu_tulis("Diatas Rata-rata");
                    }else if(komtu3.isSelected()){
                        ent.setKomu_tulis("Rata-rata");
                    } else if(komtu4.isSelected()){
                        ent.setKomu_tulis("Dibawah Rata-rata");
                    }else if (komtu5.isSelected()){
                        ent.setKomu_tulis("Sangat Kurang");
                    }
                    if(intel1.isSelected()){
                        ent.setKem_intelek("Utama");
                    }else if(intel2.isSelected()){
                        ent.setKem_intelek("Diatas Rata-rata");
                    }else if(intel3.isSelected()){
                        ent.setKem_intelek("Rata-rata");
                    }else if(intel4.isSelected()){
                        ent.setKem_intelek("Dibawah Rata-rata");
                    }else if(intel5.isSelected()){
                        ent.setKem_intelek("Sangat Kurang");
                    }
                    if(motiv1.isSelected()){
                        ent.setMotivasi("Utama");
                    }else if(motiv2.isSelected()){
                        ent.setMotivasi("Diatas Rata-rata");
                    }else if(motiv3.isSelected()){
                        ent.setMotivasi("Rata-rata");
                    }else if(motiv4.isSelected()){
                        ent.setMotivasi("Dibawah Rata-rata");
                    }else if(motiv5.isSelected()){
                        ent.setMotivasi("Sangat Kurang");
                    }
                    if(dewasa1.isSelected()){
                        ent.setKedewasaa("Utama");
                    }else if(dewasa2.isSelected()){
                        ent.setKedewasaa("Diatas Rata-rata");
                    }else if(dewasa3.isSelected()){
                        ent.setKedewasaa("Rata-rata");
                    }else if(dewasa4.isSelected()){
                        ent.setKedewasaa("Dibawah Rata-rata");
                    }else if(dewasa5.isSelected()){
                        ent.setKedewasaa("Sangat Kurang");
                    }
                    if(kerja1.isSelected()){
                        ent.setKem_kerjasama("Utama");
                    }else if(kerja2.isSelected()){
                        ent.setKem_kerjasama("Diatas Rata-rata");
                    }else if(kerja3.isSelected()){
                        ent.setKem_kerjasama("Rata-rata");
                    }else if(kerja4.isSelected()){
                        ent.setKem_kerjasama("Dibawah Rata-rata");
                    }else if(kerja5.isSelected()){
                        ent.setKem_kerjasama("Sangat Kurang");
                    }
                    if(pd1.isSelected()){
                        ent.setPd("Utama");
                    }else if(pd2.isSelected()){
                        ent.setPd("Diatas Rata-rata");
                    }else if(pd3.isSelected()){
                        ent.setPd("Rata-rata");
                    }else if(pd4.isSelected()){
                        ent.setPd("Dibawah Rata-rata");
                    }else if(pd5.isSelected()){
                        ent.setPd("Sangat Kurang");
                    }
                    if(analisis1.isSelected()){
                        ent.setDaya_analisis("Utama");
                    }else if(analisis2.isSelected()){
                        ent.setDaya_analisis("Diatas Rata-rata");
                    }else if(analisis3.isSelected()){
                        ent.setDaya_analisis("Rata-rata");
                    }else if(analisis4.isSelected()){
                        ent.setDaya_analisis("Dibawah Rata-rata");
                    }else if(analisis5.isSelected()){
                        ent.setDaya_analisis("Sangat Kurang");
                    }
                    if(adm1.isSelected()){
                        ent.setKem_adm("Utama");
                    }else if(adm2.isSelected()){
                        ent.setKem_adm("Diatas Rata-rata");
                    }else if(adm3.isSelected()){
                        ent.setKem_adm("Rata-rata");
                    }else if(adm4.isSelected()){
                        ent.setKem_adm("Dibawah Rata-rata");
                    }else if(adm5.isSelected()){
                        ent.setKem_adm("Sangat Kurang");
                    }
                    ent.setKelebihan(kelebihan.getText());
                    if(penam1.isSelected()){
                        ent.setPenampilan("A");
                    }else if(penam2.isSelected()){
                        ent.setPenampilan("B");
                    }else if(penam3.isSelected()){
                        ent.setPenampilan("C");
                    }else if(penam4.isSelected()){
                        ent.setPenampilan("D");
                    }else if(penam5.isSelected()){
                        ent.setPenampilan("E");
                    }
                    ent.setPenyakit(penyakit.getText());
                    if(mata1.isSelected()){
                        ent.setKacamata("Ya");
                    }else if(mata2.isSelected()){
                        ent.setKacamata("Tidak");
                    }
                    ent.setUkuran(ukurankaca.getText());
                    if(iq1.isSelected()){
                        ent.setIq("A");
                    }else if(iq2.isSelected()){
                        ent.setIq("B");
                    }else if(iq3.isSelected()){
                        ent.setIq("C");
                    }else if(iq4.isSelected()){
                        ent.setIq("D");
                    }else if(iq5.isSelected()){
                        ent.setIq("E");
                    }
                    if(kes1.isSelected()){
                        ent.setKesimpulan("Lulus");
                    }else if(kes2.isSelected()){
                        ent.setKesimpulan("Lulus Percobaan");
                    }else if(kes3.isSelected()){
                        ent.setKesimpulan("Lulus Cadangan");
                    }else if(kes4.isSelected()){
                        ent.setKesimpulan("Tidak Lulus");
                    }
                    if(pedikata.isSelected()){
                        ent.setPredikat("A");
                    }else if(predikatb.isSelected()){
                        ent.setPredikat("B");
                    }else if (predikatc.isSelected()){
                        ent.setPredikat("C");
                    }
                    ent.setJurusan(jurusan.getText());
                    ent.setPetugas(petugas.getText());
                    inw.update(ent);
                    take();
                    enabel(true);
                    no_ujian.setEnabled(false);
                    no_aplikan.requestFocus();
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    Logger.getLogger(frm_wawancara.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
        jTextField4.setBackground(Color.white);
        jTextField4.setEnabled(true);
        jTextField4.setText("");
        jTextField4.requestFocus();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            entitas_pewawancara ent = daftarpe.get(jTable2.getSelectedRow());
            petugas.setText(ent.getNama());
            jDialog_pewawan.setVisible(false);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        jDialog_pewawan.setVisible(false);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void petugasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_petugasKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            takewawan();
            jTable2.setModel(pewawan);
            jDialog_pewawan.setSize(460, 360);
            jDialog_pewawan.setLocationRelativeTo(null);
            jDialog_pewawan.setVisible(true);
        }
    }//GEN-LAST:event_petugasKeyTyped

    private void petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_petugasActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        // TODO add your handling code here:
        jTextField5.setBackground(Color.white);
        jTextField5.setEnabled(true);
        jTextField5.setText("");
        jTextField5.requestFocus();
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
        entitas_jurusan ent = daftarjur.get(jTable3.getSelectedRow());
            jurusan.setText(ent.getJurusan());
            jDialog1_jurus.setVisible(false);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        jDialog1_jurus.setVisible(false);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jurusanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jurusanKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            takejurus();
            jTable3.setModel(jurus);
            jDialog1_jurus.setSize(460, 355);
            jDialog1_jurus.setLocationRelativeTo(null);
            jDialog1_jurus.setVisible(true);
        }
    }//GEN-LAST:event_jurusanKeyTyped

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
  
    }//GEN-LAST:event_jLabel29MouseClicked

    private void no_ujianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_ujianKeyTyped
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
        try {
            // TODO add your handling code here:
            entitas_aplikan ent = new entitas_aplikan();
            ent=iap.getbynoujian(no_ujian.getText());
            no_aplikan.setText(ent.getNomor_aplikan());
            nama.setText(ent.getNama());
            jur1.setText(ent.getJurusan1());
            jur2.setText(ent.getJurusan2());
            jur2.requestFocus();
        } catch (RemoteException ex) {
            Logger.getLogger(frm_wawancara.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_no_ujianKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adm1;
    private javax.swing.JCheckBox adm2;
    private javax.swing.JCheckBox adm3;
    private javax.swing.JCheckBox adm4;
    private javax.swing.JCheckBox adm5;
    private javax.swing.JCheckBox analisis1;
    private javax.swing.JCheckBox analisis2;
    private javax.swing.JCheckBox analisis3;
    private javax.swing.JCheckBox analisis4;
    private javax.swing.JCheckBox analisis5;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JCheckBox dewasa1;
    private javax.swing.JCheckBox dewasa2;
    private javax.swing.JCheckBox dewasa3;
    private javax.swing.JCheckBox dewasa4;
    private javax.swing.JCheckBox dewasa5;
    private javax.swing.JCheckBox intel1;
    private javax.swing.JCheckBox intel2;
    private javax.swing.JCheckBox intel3;
    private javax.swing.JCheckBox intel4;
    private javax.swing.JCheckBox intel5;
    private javax.swing.JCheckBox iq1;
    private javax.swing.JCheckBox iq2;
    private javax.swing.JCheckBox iq3;
    private javax.swing.JCheckBox iq4;
    private javax.swing.JCheckBox iq5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1_jurus;
    private javax.swing.JDialog jDialog_aplikan;
    private javax.swing.JDialog jDialog_pewawan;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jur1;
    private javax.swing.JTextField jur2;
    private javax.swing.JTextField jurusan;
    private javax.swing.JTextArea kelebihan;
    private javax.swing.JCheckBox kerja1;
    private javax.swing.JCheckBox kerja2;
    private javax.swing.JCheckBox kerja3;
    private javax.swing.JCheckBox kerja4;
    private javax.swing.JCheckBox kerja5;
    private javax.swing.JCheckBox kes1;
    private javax.swing.JCheckBox kes2;
    private javax.swing.JCheckBox kes3;
    private javax.swing.JCheckBox kes4;
    private javax.swing.JCheckBox komtu1;
    private javax.swing.JCheckBox komtu2;
    private javax.swing.JCheckBox komtu3;
    private javax.swing.JCheckBox komtu4;
    private javax.swing.JCheckBox komtu5;
    private javax.swing.JCheckBox lisan1;
    private javax.swing.JCheckBox lisan2;
    private javax.swing.JCheckBox lisan3;
    private javax.swing.JCheckBox lisan4;
    private javax.swing.JCheckBox lisan5;
    private javax.swing.JCheckBox mata1;
    private javax.swing.JCheckBox mata2;
    private javax.swing.JCheckBox motiv1;
    private javax.swing.JCheckBox motiv2;
    private javax.swing.JCheckBox motiv3;
    private javax.swing.JCheckBox motiv4;
    private javax.swing.JCheckBox motiv5;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField no_aplikan;
    private javax.swing.JTextField no_ujian;
    private ace.panelMenu panelMenu1;
    private ace.panelMenuTes panelMenuTes2;
    private ace.panelMenuTes panelMenuTes3;
    private ace.panelMenuTes panelMenuTes4;
    private javax.swing.JCheckBox pd1;
    private javax.swing.JCheckBox pd2;
    private javax.swing.JCheckBox pd3;
    private javax.swing.JCheckBox pd4;
    private javax.swing.JCheckBox pd5;
    private javax.swing.JCheckBox pedikata;
    private javax.swing.JCheckBox penam1;
    private javax.swing.JCheckBox penam2;
    private javax.swing.JCheckBox penam3;
    private javax.swing.JCheckBox penam4;
    private javax.swing.JCheckBox penam5;
    private javax.swing.JTextArea penyakit;
    private javax.swing.JTextField petugas;
    private javax.swing.JCheckBox predikatb;
    private javax.swing.JCheckBox predikatc;
    private javax.swing.JTextField ukurankaca;
    // End of variables declaration//GEN-END:variables
}
