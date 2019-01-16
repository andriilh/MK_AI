
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;

public class frmMain extends javax.swing.JFrame {
    
    /** Creates new form frmMain */
    public frmMain() {
       
        initComponents();
        SysUser();
      
    }
    String UserType;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        desktop = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnuExit = new javax.swing.JMenu();
        MnuNewStudent = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuLogout = new javax.swing.JMenuItem();
        mnuEx = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuUserAccount = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        mnuExit.setText("File");
        mnuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuExitMouseClicked(evt);
            }
        });
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });

        MnuNewStudent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MnuNewStudent.setText("New Student");
        MnuNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuNewStudentActionPerformed(evt);
            }
        });
        mnuExit.add(MnuNewStudent);
        mnuExit.add(jSeparator1);

        mnuLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mnuLogout.setText("Logout");
        mnuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogoutActionPerformed(evt);
            }
        });
        mnuExit.add(mnuLogout);

        mnuEx.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnuEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close1.jpg"))); // NOI18N
        mnuEx.setText("Exit");
        mnuEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExActionPerformed(evt);
            }
        });
        mnuExit.add(mnuEx);

        jMenuBar2.add(mnuExit);

        jMenu4.setText("View");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("All Students");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar2.add(jMenu4);

        jMenu3.setText("Admnistrator");

        mnuUserAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mnuUserAccount.setText("User Account");
        mnuUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUserAccountActionPerformed(evt);
            }
        });
        jMenu3.add(mnuUserAccount);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnuNewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuNewStudentActionPerformed
        ShowNew();
    }//GEN-LAST:event_MnuNewStudentActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed

    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuExitMouseClicked

    }//GEN-LAST:event_mnuExitMouseClicked
    public void ShowNew()
    {
        if(!this.desktop.isAncestorOf(frmRegistration.frame))
        {
            this.desktop.add(frmRegistration.frame);
        }
        frmRegistration.frame.setVisible(true);
        frmRegistration.frame.toFront();
    }
    public void FrmShowUser()
    {
        if(!this.desktop.isAncestorOf(frmUserAccount.frame))
        {
            this.desktop.add(frmUserAccount.frame);
        }
        frmUserAccount.frame.setVisible(true);
        frmUserAccount.frame.toFront();
    }
    private void mnuExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExActionPerformed
      int ext;
       ext = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
       if(ext==JOptionPane.YES_OPTION)
       {
           System.exit(0);
       }
    }//GEN-LAST:event_mnuExActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        if(!this.desktop.isAncestorOf(frmShowStudents.frame))
        {
            this.desktop.add(frmShowStudents.frame);
        }
        frmShowStudents.frame.setVisible(true);
        frmShowStudents.frame.toFront();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void mnuUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUserAccountActionPerformed
        FrmShowUser();
    }//GEN-LAST:event_mnuUserAccountActionPerformed

    private void mnuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogoutActionPerformed
        dispose();
        new frmLogin().show();
        new frmLogin().setLocationRelativeTo(null);
        new frmLogin().setAlwaysOnTop(true);
    }//GEN-LAST:event_mnuLogoutActionPerformed

    public void SysUser(){  
        if(UserType.equals("ADMINISTRATOR"))
             mnuUserAccount.setVisible(true);
        else if(UserType.equals("USER"))
             mnuUserAccount.setVisible(false);
         
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MnuNewStudent;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnuEx;
    private javax.swing.JMenu mnuExit;
    private javax.swing.JMenuItem mnuLogout;
    private javax.swing.JMenuItem mnuUserAccount;
    // End of variables declaration//GEN-END:variables
}
