/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pmb_server;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import form.frm_utama_server;
import implement.*;
import implement_lap.implement_laporan;
import implement_lap.implement_rekapPlace;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author radhial22
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        try {
            // TODO code application logic here
            Registry server = LocateRegistry.createRegistry(1122);
            implement_soal ims = new implement_soal();
            implement_jurusan imj = new implement_jurusan();
            implement_kab imk = new implement_kab();
            implement_media imm = new implement_media();
            implement_mgm igm = new implement_mgm();
            implement_petugas_ujian ipu = new implement_petugas_ujian();
            implement_pewawancara ipw =new implement_pewawancara();
            implement_presenter ipr = new implement_presenter();
            implement_sekolah isk = new implement_sekolah();
            implement_soal isl = new implement_soal();
           // implement_login ipl = new implement_login();
            implement_cekLogin imc = new implement_cekLogin();
            implement_aplikan imp = new implement_aplikan();
            implement_login ipl = new implement_login();
            implement_inggris ing = new implement_inggris();
            implement_place inpl = new implement_place();
            implement_kelas ikl = new implement_kelas();
            implement_tahun ith = new implement_tahun();
            implement_pendaftaran ipn = new implement_pendaftaran();
            implement_registrasi irg = new implement_registrasi();
            implement_wawancara iwc = new implement_wawancara();
            imple_test ites = new imple_test();
            implement_lapSuratLulus suratlulus = new implement_lapSuratLulus();
            implement_laporan laporan = new implement_laporan();
            implement_rekapPlace rekapplace = new implement_rekapPlace();
            
            server.rebind("service", ims);
            server.rebind("jurusan", imj);
            server.rebind("kab", imk);
            server.rebind("media", imm);
            server.rebind("mgm", igm);
            server.rebind("petugasUjian", ipu);
            server.rebind("pewawancara", ipw);
            server.rebind("presenter", ipr);
            server.rebind("sekolah", isk);
            server.rebind("soal", isl);
            //server.rebind("login", ipl);
            server.rebind("login", imc);
            server.rebind("aplikan", imp);
            server.rebind("inputlogin", ipl);
            
            server.rebind("inggris", ing);
            server.rebind("place", inpl);
            server.rebind("kelas", ikl);
            server.rebind("tahun", ith);
            server.rebind("pendaftaran", ipn);
            server.rebind("regis", irg);
            server.rebind("wawancara", iwc);
            server.rebind("test", ites);
            server.rebind("inggris", ing);
            server.rebind("suratlulus", suratlulus);
            server.rebind("laporan", laporan);
            server.rebind("rekapplace", rekapplace);
            
            System.out.println("server started"); 
            
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                frm_utama_server fus = new frm_utama_server();
                fus.setVisible(true);
            }
        });
    }
    }


