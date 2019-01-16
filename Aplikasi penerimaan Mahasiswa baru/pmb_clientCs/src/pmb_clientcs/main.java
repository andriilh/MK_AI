/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pmb_clientcs;

import form.*;
import intface.*;
import intface_lap.Intface_laporan;
import intface_lap.intface_lapRekapPlace;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import sun.misc.FpUtils;

/**
 *
 * @author radhial22
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws RemoteException, NotBoundException{
        // TODO code application logic here
        Properties prop =new Properties();
        try {
            prop.load(new FileInputStream("ipserver.properties"));
            
        } catch (IOException ex) {
            
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ip = prop.getProperty("ip");
        
        
         Registry registry = LocateRegistry.getRegistry("localhost", 1122);
        final intface_soal soal = (intface_soal) registry.lookup("soal");
        final intface_jurusan jurusan = (intface_jurusan) registry.lookup("jurusan");
         final intface_kab kab = (intface_kab) registry.lookup("kab");
         final intface_media media = (intface_media) registry.lookup("media");
         final intface_mgm mgm = (intface_mgm) registry.lookup("mgm");
         final intface_petugas_ujian petugasUjian = (intface_petugas_ujian) registry.lookup("petugasUjian");
         final intface_pewawancara pewawancara = (intface_pewawancara) registry.lookup("pewawancara");
         final intface_presenter presenter = (intface_presenter) registry.lookup("presenter");
         final intface_sekolah sekolah = (intface_sekolah) registry.lookup("sekolah");
         final intface_login inputLogin = (intface_login) registry.lookup("inputlogin");
         final intface_inggris inggris = (intface_inggris) registry.lookup("inggris");
         final intface_place place = (intface_place) registry.lookup("place");
         final intface_kelas kelas = (intface_kelas) registry.lookup("kelas");
         final intface_tahun tahun = (intface_tahun) registry.lookup("tahun");
         final intface_pendaftaran pendaftaran = (intface_pendaftaran) registry.lookup("pendaftaran");
         final  intface_registrasi regis = (intface_registrasi) registry.lookup("regis");
         final intface_wawancara wawancara = (intface_wawancara) registry.lookup("wawancara");
         final intface_aplikan aplikan = (intface_aplikan) registry.lookup("aplikan");
         final inface_tes tes = (inface_tes) registry.lookup("test");
         final intface_suratLulus suratlulus = (intface_suratLulus) registry.lookup("suratlulus");
         final Intface_laporan laporan =(Intface_laporan) registry.lookup("laporan");
         final intface_lapRekapPlace rekapplace = (intface_lapRekapPlace) registry.lookup("rekapplace");
         final inface_cekLogin login = (inface_cekLogin) registry.lookup("login");
         
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
         SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
//                frm_laporan flp = new frm_laporan(suratlulus,laporan,rekapplace);
//                flp.setVisible(true);
                
                
//                frm_inggris fi = new frm_inggris(inggris);
//                fi.setVisible(true);
//                
//                NewJFrame nj = new NewJFrame(tes);
//                nj.setVisible(true);
//                
//                frm_registrasi fr = new frm_registrasi(aplikan, regis);
//                fr.setVisible(true);
//                
//                frm_aplikan fa = new frm_aplikan(aplikan, jurusan, media, mgm, presenter, sekolah);
//                fa.setVisible(true);
//                
//                frm_pendaftaran fp = new frm_pendaftaran(pendaftaran,aplikan,tahun);
//                fp.setVisible(true);
//                
//                frm_kelas fk = new frm_kelas(kelas);
//                fk.setVisible(true);
//                
                frm_utama fu = new frm_utama(login, aplikan, inggris, jurusan, kab, kelas, inputLogin, media, mgm, pendaftaran, petugasUjian, pewawancara, place, presenter, regis, sekolah, soal, tahun, wawancara, suratlulus, laporan, rekapplace);
                fu.setExtendedState(JFrame.MAXIMIZED_BOTH);
                fu.setVisible(true);
//                
//                frm_wawancara fw=new frm_wawancara(wawancara,pewawancara,jurusan);
//                fw.setVisible(true);
//                
//                frm_tahun ft = new frm_tahun(tahun);
//                ft.setVisible(true);
//                
//                frm_place fplcae = new frm_place(place);
//                fplcae.setVisible(true);
//                
//                form_soal fs = new form_soal(soal);
//                fs.setVisible(true);
//                                
//                frm_inputLogin fl = new frm_inputLogin(inputLogin);
//                fl.setVisible(true);
//                
////                form_soal fs = new form_soal(soal);
////                fs.setVisible(true);
//                
////                frm_sekolah fs = new frm_sekolah(sekolah, kab);
////                fs.setVisible(true);
//                
//                frm_presenter fpr = new frm_presenter(presenter);
//                fpr.setVisible(true);
//                
//                frm_pewawancara fpw = new frm_pewawancara(pewawancara);
//                fpw.setVisible(true);
//                
//                frm_petugas_ujian fpu=new frm_petugas_ujian(petugasUjian);
//                fpu.setVisible(true);
//                
//                frm_mgm fm=new frm_mgm(mgm);
//                fm.setVisible(true);
//                
//                frm_media fmu = new frm_media(media);
//                fm.setVisible(true);
//                
//                frm_kab fkab = new frm_kab(kab);
//                fk.setVisible(true);
//                
//                frm_jurusan fj = new frm_jurusan(jurusan);
//                fj.setVisible(true);
//                
//                frm_mgm mg= new frm_mgm(mgm);
//                mg.setVisible(true);
            }
        });
    }
}
