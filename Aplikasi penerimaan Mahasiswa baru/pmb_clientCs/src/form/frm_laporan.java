/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import ace.model_aplikan2;
import ace.model_jurusan;
import ace.model_presenter;
import entity.entitas_aplikan;
import entity.entitas_jurusan;
import entity.entitas_lapSuratLulus;
import entity.entitas_presenter;
import entity_laporan.lap_aplikanPerpresenter;
import entity_laporan.lap_grading;
import entity_laporan.lap_grafikMedia;
import entity_laporan.lap_pengumuman_lulus;
import entity_laporan.lap_rekapInter;
import entity_laporan.lap_rekapMgm;
import entity_laporan.lap_rekapPlace;
import intface.intface_aplikan;
import intface.intface_jurusan;
import intface.intface_presenter;
import intface.intface_suratLulus;
import intface_lap.Intface_laporan;
import intface_lap.intface_lapRekapPlace;
import java.awt.event.KeyEvent;
import java.io.File;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author radhial22
 */
public class frm_laporan extends javax.swing.JFrame {
List<entitas_lapSuratLulus>daftar = new ArrayList<entitas_lapSuratLulus>();
    List<lap_aplikanPerpresenter>daftarlap=new ArrayList<lap_aplikanPerpresenter>();
    List<lap_rekapPlace>daftarrek=new ArrayList<lap_rekapPlace>();
    List<lap_rekapInter>daftarrekin=new ArrayList<lap_rekapInter>();
    List<lap_grading>daftargrading=new ArrayList<lap_grading>();
    List<entitas_aplikan>daftaraplikan=new ArrayList<entitas_aplikan>();
    List<entitas_presenter>presenter=new ArrayList<entitas_presenter>();
    List<lap_pengumuman_lulus>pengumumanLulus=new ArrayList<lap_pengumuman_lulus>();
    List<lap_rekapMgm>rekapmgm=new ArrayList<lap_rekapMgm>();
    List<lap_grafikMedia>grafikMedia=new ArrayList<lap_grafikMedia>();
    List<entitas_jurusan>daftarJurusan=new ArrayList<entitas_jurusan>();
    model_aplikan2 aplikan = new model_aplikan2();
    model_presenter modelpresenter=new model_presenter();
    model_jurusan jurusan = new model_jurusan();
    
intface_suratLulus isl;
Intface_laporan perap;
intface_lapRekapPlace irep;
intface_aplikan iap;
intface_presenter pres;
intface_jurusan ijur;
    /**
     * Creates new form frm_laporan
     */
    public frm_laporan(intface_suratLulus isl, Intface_laporan perap, intface_lapRekapPlace irep,intface_aplikan iap,intface_presenter pres,intface_jurusan ijur) {
        this.isl=isl;
        this.perap=perap;
        this.irep=irep;
        this.iap=iap;
        this.pres=pres;
        this.ijur=ijur;
        initComponents();
        takeAplikan();
        takepres();
        takeJur();
        setLocationRelativeTo(null);
        
    }

    void takeAplikan(){
        try {
            daftaraplikan=iap.ujsudah();
            aplikan.setdata(daftaraplikan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void takepres(){
        try {
            presenter=pres.getall();
            modelpresenter.setdata(presenter);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void takeJur(){
        try {
            daftarJurusan=ijur.getall();
            jurusan.setdata(daftarJurusan);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void suratLulus(){
        try {
            Properties prop = System.getProperties();
                String currndir = prop.getProperty("user.dir");
                File dir = new File(currndir);
                String nmllap = "surat_lulus.jasper";
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
                daftar=isl.daftar(jTextField1.getText());
                entitas_lapSuratLulus ent1 = new entitas_lapSuratLulus();
                //entitas_suratLulus ent2 = new entitas_suratLulus();
//                ent2.setNo_ujian(ent1.getNo_ujian());
//                ent2.setNama(ent1.getNama());
//                ent2.setJurusan(ent1.getJurusan());
//                ent2.setTest1(ent1.getTest1());
//                ent2.setWaktu1(ent1.getWaktu1());
//                ent2.setTest2(ent1.getTest2());
//                ent2.setWaktu2(ent1.getWaktu2());
//                ent2.setTest3(ent1.getTest3());
//                ent2.setWaktu3(ent1.getWaktu3());
//                ent2.setGrade(ent1.getGrade());
                daftar.add(ent1);
                
                JRDataSource datasource = new JRBeanCollectionDataSource(daftar);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false);
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    void aplikanPerpresenter(){
        try {
            Properties prop = System.getProperties();
                    String currndir = prop.getProperty("user.dir");
                    File dir = new File(currndir);
                    String nmllap = "daftar-aplikanper.jasper";
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
                    
                    daftarlap=perap.aplikanPerpresenter(jTextField2.getText());
                    lap_aplikanPerpresenter lap = new lap_aplikanPerpresenter();
                    daftarlap.add(lap);
                    
                    JRDataSource datasource = new JRBeanCollectionDataSource(daftarlap);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false);
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    void rekapplace(){
        try {
            Properties prop = System.getProperties();
                    String currndir = prop.getProperty("user.dir");
                    File dir = new File(currndir);
                    String nmllap = "rekap_place.jasper";
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
                    daftarrek=irep.daftarplace();
                    lap_rekapPlace lap = new lap_rekapPlace();
                    daftarrek.add(lap);
                    
                    JRDataSource datasource = new JRBeanCollectionDataSource(daftarrek);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false);
                    
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void rekapInter(){
        
        try {
            Properties prop = System.getProperties();
                        String currndir = prop.getProperty("user.dir");
                        File dir = new File(currndir);
                        String nmllap = "rekap_interview.jasper";
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
                        daftarrekin=irep.daftarInter();
                        lap_rekapInter lap = new lap_rekapInter();
                        daftarrekin.add(lap);
                        
                        JRDataSource datasource = new JRBeanCollectionDataSource(daftarrekin);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false);
            
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    
                    
    }
    
    void grading(){
        try {
            Properties prop = System.getProperties();
                            String currndir = prop.getProperty("user.dir");
                            File dir = new File(currndir);
                            String nmllap = "daftar_grading.jasper";
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
                            daftargrading=perap.grading(grading_jurusan.getText());
                            lap_grading lapgrade=new lap_grading();
                            daftargrading.add(lapgrade);
                            
                            JRDataSource datasource = new JRBeanCollectionDataSource(daftargrading);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false);
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void pengumumanUjian(){
        try {
            Properties prop = System.getProperties();
                                String currndir = prop.getProperty("user.dir");
                                File dir = new File(currndir);
                                String nmllap = "pengumuman_lulus.jasper";
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
                                
                                pengumumanLulus=perap.pengumumanlulus((Date)tgl1.getValue(), (Date)tgl2.getValue());
                                lap_pengumuman_lulus lap = new lap_pengumuman_lulus();
                               pengumumanLulus.add(lap);
                               
                               JRDataSource datasource = new JRBeanCollectionDataSource(pengumumanLulus);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false); 
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
                            
    }
    
    
    void rekapMgm(){
        try {
            Properties prop = System.getProperties();
                                    String currndir = prop.getProperty("user.dir");
                                    File dir = new File(currndir);
                                    String nmllap = "rekap_mgm.jasper";
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
                                    rekapmgm=perap.rekapMgm();
                                    lap_rekapMgm lap = new lap_rekapMgm();
                                    rekapmgm.add(lap);
            JRDataSource datasource = new JRBeanCollectionDataSource(rekapmgm);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false);
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
                                
    }
    
    void grafikmedia(){
        try {
            Properties prop = System.getProperties();
                               String currndir = prop.getProperty("user.dir");
                               File dir = new File(currndir);
                               String nmllap = "grafikmedia.jasper";
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
                               grafikMedia=perap.grafikMedia();
                               lap_grafikMedia lap = new lap_grafikMedia();
                               grafikMedia.add(lap);
                               
            JRDataSource datasource = new JRBeanCollectionDataSource(grafikMedia);
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, datasource);
            JasperPrint print = JasperFillManager.fillReport(fupath, map);
            
            JasperViewer.viewReport(print,false);
                               
        } catch (JRException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frm_laporan.class.getName()).log(Level.SEVERE, null, ex);
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

        jDialog_pewawancara = new javax.swing.JDialog();
        jDialog_presenter = new javax.swing.JDialog();
        panelMenuTes4 = new ace.panelMenuTes();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jDialog_aplikan = new javax.swing.JDialog();
        panelMenuTes6 = new ace.panelMenuTes();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jDialog_jurusan = new javax.swing.JDialog();
        panelMenuTes7 = new ace.panelMenuTes();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jDialog_mgm = new javax.swing.JDialog();
        jDialog1 = new javax.swing.JDialog();
        tgl11 = new javax.swing.JTextField();
        tgl12 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jDialog = new ace.panelMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        grading_jurusan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        tgl1 = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        tgl2 = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        jDialog_pewawancara.setUndecorated(true);

        javax.swing.GroupLayout jDialog_pewawancaraLayout = new javax.swing.GroupLayout(jDialog_pewawancara.getContentPane());
        jDialog_pewawancara.getContentPane().setLayout(jDialog_pewawancaraLayout);
        jDialog_pewawancaraLayout.setHorizontalGroup(
            jDialog_pewawancaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog_pewawancaraLayout.setVerticalGroup(
            jDialog_pewawancaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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

        jDialog_aplikan.setUndecorated(true);

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

        javax.swing.GroupLayout jDialog_aplikanLayout = new javax.swing.GroupLayout(jDialog_aplikan.getContentPane());
        jDialog_aplikan.getContentPane().setLayout(jDialog_aplikanLayout);
        jDialog_aplikanLayout.setHorizontalGroup(
            jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_aplikanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_aplikanLayout.setVerticalGroup(
            jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_aplikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_aplikanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialog_jurusan.setUndecorated(true);

        panelMenuTes7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMenuTes7MouseClicked(evt);
            }
        });

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

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("X");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
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
                        .addComponent(jLabel32)))
                .addContainerGap())
        );
        panelMenuTes7Layout.setVerticalGroup(
            panelMenuTes7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuTes7Layout.createSequentialGroup()
                .addGroup(panelMenuTes7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuTes7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_jurusanLayout = new javax.swing.GroupLayout(jDialog_jurusan.getContentPane());
        jDialog_jurusan.getContentPane().setLayout(jDialog_jurusanLayout);
        jDialog_jurusanLayout.setHorizontalGroup(
            jDialog_jurusanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jDialog_jurusanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_jurusanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog_jurusanLayout.setVerticalGroup(
            jDialog_jurusanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jDialog_jurusanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog_jurusanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMenuTes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jDialog_mgmLayout = new javax.swing.GroupLayout(jDialog_mgm.getContentPane());
        jDialog_mgm.getContentPane().setLayout(jDialog_mgmLayout);
        jDialog_mgmLayout.setHorizontalGroup(
            jDialog_mgmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog_mgmLayout.setVerticalGroup(
            jDialog_mgmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(tgl11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tgl12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/suratLulus.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Surat Kelulusan");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel3.setText("Nomor Ujian :");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/aplikanperpresenter.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Laporan Aplikan Perpresenter");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel6.setText("Nama Presenter :");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/rekap_place.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Laporan Rekapitulasi Placementtest");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Cetak langsung");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/rekap_place.png"))); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setText("Cetak langsung");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Laporan Rekapitulasi Interview");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/window_delete.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/layout_squares.png"))); // NOI18N

        grading_jurusan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        grading_jurusan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                grading_jurusanKeyTyped(evt);
            }
        });

        jLabel15.setText("Jurusan :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Laporan Grading Bahasa Inggris");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/rekap_place.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Laporan Rekapitulasi MGM");

        jLabel19.setText("Cetak langsung");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/rekap_place.png"))); // NOI18N

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Laporan Pengumuman Ujian");

        tgl1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tgl1.setValue(new java.util.Date());

        jLabel21.setText("Tanggal :");

        tgl2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        tgl2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tgl2.setValue(new java.util.Date());

        jLabel23.setText("Tanggal :");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/rekap_place.png"))); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel26.setText("Cetak langsung");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Laporan Rekapitulasi MGM");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/pie_chart.png"))); // NOI18N

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/print.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel30.setText("Cetak langsung");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Laporan Pemilihan Media Informasi");

        javax.swing.GroupLayout jDialogLayout = new javax.swing.GroupLayout(jDialog);
        jDialog.setLayout(jDialogLayout);
        jDialogLayout.setHorizontalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13))
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialogLayout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addGroup(jDialogLayout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(26, 26, 26)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26)))
                                    .addGroup(jDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19)))
                                    .addGroup(jDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addGroup(jDialogLayout.createSequentialGroup()
                                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel21))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel23)
                                                    .addGroup(jDialogLayout.createSequentialGroup()
                                                        .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(jDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30))))
                                .addGap(0, 259, Short.MAX_VALUE))))
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(jDialogLayout.createSequentialGroup()
                                        .addComponent(grading_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel15)))
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDialogLayout.setVerticalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(4, 4, 4)
                                .addComponent(jButton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8)
                                    .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35))))
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)))
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addGroup(jDialogLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addGap(4, 4, 4)
                            .addComponent(jButton4)))
                    .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel24)
                        .addGroup(jDialogLayout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26)
                            .addGap(4, 4, 4)
                            .addComponent(jButton9))))
                .addGap(29, 29, 29)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(4, 4, 4)
                                .addComponent(jButton5)))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDialogLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(grading_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel29)
                        .addGroup(jDialogLayout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30)
                            .addGap(4, 4, 4)
                            .addComponent(jButton10))))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        getContentPane().add(jDialog, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        suratLulus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        aplikanPerpresenter();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        rekapplace();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        rekapInter();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
          if(grading_jurusan.getText().isEmpty()){
              JOptionPane.showMessageDialog(this, "Masukkan Jurusan");
          }else {
        grading();
          }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        rekapMgm();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            entitas_aplikan ent = daftaraplikan.get(jTable6.getSelectedRow());
            jTextField1.setText(ent.getNo_ujian());
            jDialog_aplikan.setVisible(false);
        }
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        jDialog_aplikan.setVisible(false);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void panelMenuTes6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuTes6MouseClicked
        // TODO add your handling code here:

   }//GEN-LAST:event_panelMenuTes6MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable6.setModel(aplikan);
            jDialog_aplikan.setSize(480, 350);
        jDialog_aplikan.setLocationRelativeTo(null);
        jDialog_aplikan.setVisible(true);
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            entitas_presenter ent = presenter.get(jTable4.getSelectedRow());
            jTextField2.setText(ent.getNama());
            jDialog_presenter.setVisible(false);
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        jDialog_presenter.setVisible(false);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            jTable4.setModel(modelpresenter);
            jDialog_presenter.setSize(480, 350);
        jDialog_presenter.setLocationRelativeTo(null);
        jDialog_presenter.setVisible(true);
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        pengumumanUjian();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        rekapMgm();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        grafikmedia();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void grading_jurusanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grading_jurusanKeyTyped
        // TODO add your handling code here:
      if(evt.getKeyChar()==KeyEvent.VK_ENTER)
            jTable7.setModel(jurusan);
            jDialog_jurusan.setSize(480, 350);
        jDialog_jurusan.setLocationRelativeTo(null);
        jDialog_jurusan.setVisible(true);
         
    }//GEN-LAST:event_grading_jurusanKeyTyped

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
          if (evt.getClickCount() == 2) {
            entitas_jurusan ent = daftarJurusan.get(jTable7.getSelectedRow());
            grading_jurusan.setText(ent.getJurusan());
            jDialog_jurusan.setVisible(false);
        }
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseClicked

    private void panelMenuTes7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuTes7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMenuTes7MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField grading_jurusan;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private ace.panelMenu jDialog;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog_aplikan;
    private javax.swing.JDialog jDialog_jurusan;
    private javax.swing.JDialog jDialog_mgm;
    private javax.swing.JDialog jDialog_pewawancara;
    private javax.swing.JDialog jDialog_presenter;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private ace.panelMenuTes panelMenuTes4;
    private ace.panelMenuTes panelMenuTes6;
    private ace.panelMenuTes panelMenuTes7;
    private javax.swing.JFormattedTextField tgl1;
    private javax.swing.JTextField tgl11;
    private javax.swing.JTextField tgl12;
    private javax.swing.JFormattedTextField tgl2;
    // End of variables declaration//GEN-END:variables
}
