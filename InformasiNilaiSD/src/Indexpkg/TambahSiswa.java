/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Indexpkg;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andri
 */
public class TambahSiswa extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    char type;
    
    public TambahSiswa() {
        initComponents();
        
        jid.setVisible(false);
        jnama.setEditable(false);
        jtgl.setEditable(false);
        jayah.setEditable(false);
        jibu.setEditable(false);
        jhp.setEditable(false);
    }
    
   
    
    private void kosong(){
        jnis.requestFocus();
        jnis.setText(null);
        jnama.setText(null);
        jtgl.setText(null);
        jayah.setText(null);
        jibu.setText(null);
        jhp.setText(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jnis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtgl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jayah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jibu = new javax.swing.JTextField();
        jhp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        simpan = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        simpan1 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 115, 130));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAMBAH DATA SISWA");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("NIS");

        jnis.setBackground(new java.awt.Color(0, 115, 130));
        jnis.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        jnis.setForeground(new java.awt.Color(0, 255, 255));
        jnis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 255)));
        jnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jnisKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Nama");

        jnama.setBackground(new java.awt.Color(0, 115, 130));
        jnama.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jnama.setForeground(new java.awt.Color(0, 255, 255));
        jnama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 255)));
        jnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jnamaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jLabel4.setText("Tanggal Lahir");

        jtgl.setBackground(new java.awt.Color(0, 115, 130));
        jtgl.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jtgl.setForeground(new java.awt.Color(0, 255, 255));
        jtgl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("Ayah");

        jayah.setBackground(new java.awt.Color(0, 115, 130));
        jayah.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jayah.setForeground(new java.awt.Color(0, 255, 255));
        jayah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 255)));
        jayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jayahActionPerformed(evt);
            }
        });
        jayah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jayahKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Ibu");

        jibu.setBackground(new java.awt.Color(0, 115, 130));
        jibu.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jibu.setForeground(new java.awt.Color(0, 255, 255));
        jibu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 255)));
        jibu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jibuKeyTyped(evt);
            }
        });

        jhp.setBackground(new java.awt.Color(0, 115, 130));
        jhp.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jhp.setForeground(new java.awt.Color(0, 255, 255));
        jhp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 255)));
        jhp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jhpKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 255));
        jLabel7.setText("No. HP");

        simpan.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        simpan.setForeground(new java.awt.Color(64, 224, 208));
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_Save_Archive_30px.png"))); // NOI18N
        simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpanMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(64, 224, 208));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        simpan1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        simpan1.setForeground(new java.awt.Color(64, 224, 208));
        simpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_Erase_30px.png"))); // NOI18N
        simpan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpan1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(71, 71, 71)
                .addComponent(jnis, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(57, 57, 57)
                .addComponent(jnama, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel7)
                    .addGap(50, 50, 50)
                    .addComponent(jhp, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(simpan)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simpan1)
                    .addGap(92, 92, 92)
                    .addComponent(jLabel9)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jayah, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jibu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2))
                    .addComponent(jnis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addComponent(jnama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5))
                    .addComponent(jayah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6))
                    .addComponent(jibu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7))
                    .addComponent(jhp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simpan)
                    .addComponent(jLabel9)
                    .addComponent(simpan1))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jayahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jayahActionPerformed

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
        int id = 0;
        String sql = "INSERT INTO daftarSiswa values('"+id+"',?,?,?,?,?,?)";
        
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jnis.getText());
            stat.setString(2, jnama.getText());
            stat.setString(3, jtgl.getText());
            stat.setString(4, jayah.getText());
            stat.setString(5, jibu.getText());
            stat.setString(6, jhp.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            this.dispose();
            new DaftarNilai().setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }//GEN-LAST:event_simpanMouseClicked

    private void simpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseEntered
        simpan.setText("SIMPAN");
    }//GEN-LAST:event_simpanMouseEntered

    private void simpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseExited
        simpan.setText(null);
    }//GEN-LAST:event_simpanMouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jLabel9.setText("KEMBALI");
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jLabel9.setText(null);
    }//GEN-LAST:event_jLabel9MouseExited

    private void simpan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpan1MouseClicked
        kosong();
    }//GEN-LAST:event_simpan1MouseClicked

    private void simpan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpan1MouseEntered
        simpan1.setText("HAPUS");
    }//GEN-LAST:event_simpan1MouseEntered

    private void simpan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpan1MouseExited
       simpan1.setText(null);
    }//GEN-LAST:event_simpan1MouseExited

    private void jnisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnisKeyTyped
        type = evt.getKeyChar();
        
        if(jnis.getText().length() >= 10){
            evt.consume();
        }
        if(jnis.getText().length() < 10){
        jnama.setEditable(true);
        jtgl.setEditable(true);
        jayah.setEditable(true);
        jibu.setEditable(true);
        jhp.setEditable(true);
        }
        hanyaAngka(evt);
    }//GEN-LAST:event_jnisKeyTyped

    private void jnamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnamaKeyTyped
        hanyaHuruf(evt);
        if(jnama.getText().length() >= 30){
            evt.consume();
        }
    }//GEN-LAST:event_jnamaKeyTyped

    private void jhpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jhpKeyTyped
        if(jhp.getText().length()>13){
            evt.consume();
        }
        hanyaAngka(evt);
    }//GEN-LAST:event_jhpKeyTyped

    private void jibuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jibuKeyTyped
        hanyaHuruf(evt);
        if(jnama.getText().length() >= 30){
            evt.consume();
        }
    }//GEN-LAST:event_jibuKeyTyped

    private void jayahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jayahKeyTyped
        hanyaHuruf(evt);
        if(jnama.getText().length() >= 30){
            evt.consume();
        }
    }//GEN-LAST:event_jayahKeyTyped
    
    void hanyaAngka(KeyEvent evt){
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
        }
    }
    void hanyaHuruf(KeyEvent evt){
        if (Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TambahSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jayah;
    private javax.swing.JTextField jhp;
    private javax.swing.JTextField jibu;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jnama;
    private javax.swing.JTextField jnis;
    private javax.swing.JTextField jtgl;
    private javax.swing.JLabel simpan;
    private javax.swing.JLabel simpan1;
    // End of variables declaration//GEN-END:variables
}
