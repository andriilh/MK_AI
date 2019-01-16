/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pmb_client;

import form.form_soal;
import form.frm_menuUjian;
import form.frm_ujian;
import intface.*;
import java.awt.TrayIcon;
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

/**
 *
 * @author radhial22
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // TODO code application logic here
        
        
        
        
        Properties prop =new Properties();
        try {
            prop.load(new FileInputStream("ipserver.properties"));
            
        } catch (IOException ex) {
            
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ip = prop.getProperty("ip");
        
        
        
        
        
        Registry registry = LocateRegistry.getRegistry("10.10.10.89", 1122);
        
        final intface_soal service = (intface_soal) registry.lookup("service");
//        final intface_login login = (intface_login) registry.lookup("login");
        final inface_cekLogin login=(inface_cekLogin) registry.lookup("login");
        final intface_petugas_ujian petugasUjian=(intface_petugas_ujian) registry.lookup("petugasUjian");
        final intface_aplikan aplikan=(intface_aplikan) registry.lookup("aplikan");
        final intface_pendaftaran pendaftaran=(intface_pendaftaran) registry.lookup("pendaftaran");
        final intface_inggris inggris = (intface_inggris) registry.lookup("inggris");
        
        
          try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
//                frm_ujian fu = new frm_ujian(service,petugasUjian,aplikan,inggris);
//                fu.setVisible(true);
                
//                form_soal fs = new form_soal(service);
//                fs.setVisible(true);
                
                frm_menuUjian fu = new frm_menuUjian(login, service, petugasUjian, aplikan, inggris);
                fu.setExtendedState(JFrame.MAXIMIZED_BOTH);
                fu.setVisible(true);
            }
        });
        
        
        
      
    }
}
