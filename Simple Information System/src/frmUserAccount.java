import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * frmUserAccount.java
 *
 * Created on Jul 16, 2011, 4:10:11 PM
 */
/**
 *
 * @author Raul
 */
public class frmUserAccount extends javax.swing.JInternalFrame {

    public static frmUserAccount frame = new frmUserAccount();
    public frmUserAccount() {
        initComponents();
        DisAble();
        ShowUsers();
    }
    Vector userid = new Vector();
    Vector name = new Vector();
    Vector username = new Vector();
    Vector password = new Vector();
    Vector type = new Vector();
    String ID;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        cmbType = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserAccount = new javax.swing.JTable();
        cmdAdd = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdEdit = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdRefresh = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        txtRetype = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cmdCancel = new javax.swing.JButton();

        setClosable(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel7.setText("User's Information Section");
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel1.setText("Complete Name :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel2.setText("Username :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel3.setText("Password :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel4.setText("User Type :");

        txtName.setFont(new java.awt.Font("Verdana", 0, 12));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });

        txtUsername.setFont(new java.awt.Font("Verdana", 0, 12));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });

        cmbType.setFont(new java.awt.Font("Verdana", 0, 12));
        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User", "Administrator" }));
        cmbType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbTypeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbTypeFocusLost(evt);
            }
        });

        tblUserAccount.setFont(new java.awt.Font("Verdana", 0, 12));
        tblUserAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "User ID", "Name", "Username", "Password", "User Type"
            }
        ));
        tblUserAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblUserAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserAccountMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUserAccountMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblUserAccountMouseReleased(evt);
            }
        });
        tblUserAccount.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblUserAccountMouseMoved(evt);
            }
        });
        tblUserAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblUserAccountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblUserAccountKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblUserAccount);

        cmdAdd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdAdd.setText("Add");
        cmdAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdAdd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdAddMouseMoved(evt);
            }
        });
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        cmdAdd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdAddFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmdAddFocusLost(evt);
            }
        });

        cmdSave.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdSave.setText("Save");
        cmdSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSave.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdSaveMouseMoved(evt);
            }
        });
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        cmdEdit.setFont(new java.awt.Font("Verdana", 0, 12));
        cmdEdit.setText("Edit Selected");
        cmdEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdEdit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdEditMouseMoved(evt);
            }
        });
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        cmdDelete.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdDelete.setText("Remove Selected");
        cmdDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdDeleteMouseMoved(evt);
            }
        });
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdRefresh.setFont(new java.awt.Font("Verdana", 0, 12));
        cmdRefresh.setText("Refresh");
        cmdRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRefresh.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdRefreshMouseMoved(evt);
            }
        });
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });

        cmdClose.setFont(new java.awt.Font("Verdana", 0, 12));
        cmdClose.setText("Close");
        cmdClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdClose.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdCloseMouseMoved(evt);
            }
        });
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        txtRetype.setFont(new java.awt.Font("Verdana", 0, 12));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel5.setText("Retype Password :");

        txtPassword.setFont(new java.awt.Font("Verdana", 0, 12));

        cmdCancel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdCancel.setText("Cancel");
        cmdCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdCancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdCancelMouseMoved(evt);
            }
        });
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmdSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRetype, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbType, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdClose))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdEdit)
                            .addComponent(cmdDelete)
                            .addComponent(cmdRefresh)
                            .addComponent(cmdClose)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRetype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdSave)
                            .addComponent(cmdAdd)
                            .addComponent(cmdCancel))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
        // TODO add your handling code here:
}//GEN-LAST:event_jLabel7MouseMoved

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdAddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdAddFocusGained
        
    }//GEN-LAST:event_cmdAddFocusGained

    private void cmdAddFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdAddFocusLost
        cmdAdd.setBackground(Color.WHITE);
    }//GEN-LAST:event_cmdAddFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        txtName.setBackground(Color.YELLOW);
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        txtName.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtNameFocusLost

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        txtUsername.setBackground(Color.YELLOW);
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        txtUsername.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtUsernameFocusLost

    private void cmbTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbTypeFocusGained
        cmbType.setBackground(Color.YELLOW);
    }//GEN-LAST:event_cmbTypeFocusGained

    private void cmbTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbTypeFocusLost
        cmbType.setBackground(Color.WHITE);
    }//GEN-LAST:event_cmbTypeFocusLost

    private void cmdAddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdAddMouseMoved
       cmdAdd.setBackground(Color.YELLOW);
    }//GEN-LAST:event_cmdAddMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
       OriginalColor();
    }//GEN-LAST:event_formMouseMoved

    private void cmdSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSaveMouseMoved
           if(cmdSave.isEnabled()==true)
        cmdSave.setBackground(Color.YELLOW);
       else
           OriginalColor();
    }//GEN-LAST:event_cmdSaveMouseMoved

    private void cmdEditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdEditMouseMoved
           if(cmdEdit.isEnabled()==true)
        cmdEdit.setBackground(Color.YELLOW);
       else
           OriginalColor();
    }//GEN-LAST:event_cmdEditMouseMoved

    private void cmdDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdDeleteMouseMoved
         if(cmdDelete.isEnabled()==true)
        cmdDelete.setBackground(Color.YELLOW);
       else
           OriginalColor();
    }//GEN-LAST:event_cmdDeleteMouseMoved

    private void cmdRefreshMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdRefreshMouseMoved
        cmdRefresh.setBackground(Color.YELLOW);
            cmdSave.setText("Save");
    }//GEN-LAST:event_cmdRefreshMouseMoved

    private void cmdCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCloseMouseMoved
        cmdClose.setBackground(Color.YELLOW);
    }//GEN-LAST:event_cmdCloseMouseMoved

    private void tblUserAccountMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserAccountMouseMoved
       OriginalColor();
    }//GEN-LAST:event_tblUserAccountMouseMoved

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        AddUser2();
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        EnAble();
        txtName.setText("");
        txtPassword.setText("");
        txtRetype.setText("");
        txtUsername.setText("");
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshActionPerformed
        ShowUsers();
    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void tblUserAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserAccountMousePressed
        getID();
    }//GEN-LAST:event_tblUserAccountMousePressed

    private void tblUserAccountMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserAccountMouseReleased
        getID();      
    }//GEN-LAST:event_tblUserAccountMouseReleased

    private void tblUserAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUserAccountKeyPressed
        getID();
        cmdEdit.setEnabled(true);
        cmdDelete.setEnabled(true);
    }//GEN-LAST:event_tblUserAccountKeyPressed

    private void tblUserAccountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUserAccountKeyReleased
        getID();
    }//GEN-LAST:event_tblUserAccountKeyReleased

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed

        cmdSave.setText("Update");
        OriginalColor();
        cmdEdit.setEnabled(false);
        cmdDelete.setEnabled(false);
        cmdSave.setEnabled(true);
        txtName.setEnabled(true);
        txtUsername.setEnabled(true);
        txtPassword.setEnabled(true);
        txtRetype.setEnabled(true);
        cmbType.setEnabled(true);
        cmdAdd.setEnabled(false);
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        cmdSave.setText("Save");
        DisAble();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdCancelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCancelMouseMoved
        cmdCancel.setBackground(Color.YELLOW);
    }//GEN-LAST:event_cmdCancelMouseMoved

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
       DeleteYou();
       
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void tblUserAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserAccountMouseClicked
         getID();
        cmdEdit.setEnabled(true);
        cmdDelete.setEnabled(true);
       
    }//GEN-LAST:event_tblUserAccountMouseClicked
    
        public void DeleteYou()
    {
        try
        {
            int DelMe;
            DelMe = JOptionPane.showConfirmDialog(null, "Are you sure you want to Remove this record?", "Delete?", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(DelMe == JOptionPane.YES_OPTION)
            {
                clsConnection conn = new clsConnection();
                Connection connect = clsConnection.conn;
                Statement stm = connect.createStatement();
                stm.execute("Delete from tblUserAccount where UserID = "+ ID);
                JOptionPane.showMessageDialog(null, "Remove Record Successful.", "Delete", JOptionPane.INFORMATION_MESSAGE);
                ShowUsers();
                 OriginalColor();
                cmdDelete.setEnabled(false);
                cmdEdit.setEnabled(false);
                cmdAdd.setEnabled(false);
                connect.close();
                DisAble();
            }
            
        }catch(SQLException sqlException){
            JOptionPane.showMessageDialog(getContentPane(),"Error in database connection"+sqlException,"sqlException",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    public void getID()
    {
         ID = this.tblUserAccount.getModel().getValueAt(this.tblUserAccount.getSelectedRow(),0).toString();
         txtName.setText(this.tblUserAccount.getModel().getValueAt(this.tblUserAccount.getSelectedRow(),1).toString());
         txtUsername.setText(this.tblUserAccount.getModel().getValueAt(this.tblUserAccount.getSelectedRow(),2).toString());
         txtPassword.setText(this.tblUserAccount.getModel().getValueAt(this.tblUserAccount.getSelectedRow(),3).toString());
         txtRetype.setText(this.tblUserAccount.getModel().getValueAt(this.tblUserAccount.getSelectedRow(),3).toString());
        String typ;
         typ=this.tblUserAccount.getModel().getValueAt(this.tblUserAccount.getSelectedRow(),4).toString();
         if(typ.equals("ADMINISTRATOR"))
             cmbType.setSelectedItem("Administrator");
         else if(typ.equals("USER"))
             cmbType.setSelectedItem("User");
    }
    public void ShowUsers(){
    String sql1 = "";
    String sql2 = "";
    try {
       clsConnection conn = new clsConnection();
       Connection connect = clsConnection.conn;
       Statement stm = connect.createStatement();

       sql1 = "Select count(*) from tblUserAccount order by UserID";
       sql2 = "select * from tblUserAccount order by UserID";
       ResultSet rs1, rs2;

       rs1 = stm.executeQuery(sql1);

       int num = 0;
       if (rs1.next()) {
        num = Integer.parseInt(rs1.getString(1).trim());
       }
       if (num > 0) {
            int i = 0;
            rs2 = stm.executeQuery(sql2);
            name.clear(); username.clear(); password.clear(); type.clear();
            userid.clear();
            int rowStudents = 0;
            while (rs2.next()){
               userid.add(rs2.getString(1).toString());
                name.add(rs2.getString(2).toString()); username.add(rs2.getString(3).toString());
                password.add(rs2.getString(4).toString()); type.add(rs2.getString(5).toString());
                Vector v = new Vector();
                v.add(userid.get(i)); v.add(name.get(i));
                v.add(username.get(i));  v.add(password.get(i)); v.add(type.get(i)); 
                DefaultTableModel tStudents = (DefaultTableModel)tblUserAccount.getModel();
                tStudents.setRowCount(rowStudents);
                tStudents.addRow(v);
                rowStudents++;
               i++;
           }
       }
    connect.close();
    }catch (SQLException sqlException){
     JOptionPane.showMessageDialog(getContentPane(),"Error in database connection"+sqlException,"sqlException",JOptionPane.ERROR_MESSAGE);

    }
    }
    
    public void EditUser()
        {
            int UpdateMe;
            UpdateMe = JOptionPane.showConfirmDialog(null,"Are you sure you want to Update this record?", "Update?", 
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(UpdateMe==JOptionPane.YES_OPTION)
            {
                try
                {
                    clsConnection conn = new clsConnection();
                    Connection connect =  clsConnection.conn;
                    Statement stm =  connect.createStatement();
                    stm.executeUpdate("Update tblUserAccount set Name = '"+ txtName.getText().trim() +"', Username = '"+ txtUsername.getText().trim() +"', UPassword ='"+ String.valueOf(txtPassword.getPassword()).toString().trim()+"' Where UserID ="+ID+"");           
                    JOptionPane.showMessageDialog(null, "Record successfully Update", "Saving", JOptionPane.INFORMATION_MESSAGE);
                    connect.close();
                    ShowUsers();
                    DisAble();
                }catch(SQLException sqlException)
                {JOptionPane.showMessageDialog(getContentPane(),sqlException.toString(),"sqlException",JOptionPane.ERROR_MESSAGE);}
             }
         }
    
        public void AddUser2()
    {
        String sql1 = "";
    try
        {
            if (this.txtName.getText().isEmpty() || this.txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || cmbType.getSelectedItem().equals(""))
            {

                JOptionPane.showMessageDialog(null, "Empty fields is not permitted", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
           else
            {
                if(cmdSave.getText().equals("Save"))
                {
                    if(String.valueOf(txtPassword.getPassword()).toString().trim().equals(String.valueOf(txtRetype.getPassword()).toString().trim()))
                    {
                        int AddMe = JOptionPane.showConfirmDialog(null,"Are you sure you want to save this user?","Save?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                        if(AddMe == JOptionPane.YES_OPTION)
                        {
                            clsConnection conn = new clsConnection();
                            Connection connect = clsConnection.conn;
                            Statement stm = connect.createStatement();
                            sql1 = "INSERT INTO tblUserAccount(Name,Username,UPassword,Role) VALUES('" + txtName.getText().toString().toUpperCase().trim() +"',"
                            + "'" + txtUsername.getText().toString().trim()  +"','" + String.valueOf(this.txtPassword.getPassword()).toString().trim()  +"',"
                            + "'"+ this.cmbType.getSelectedItem().toString().toUpperCase().trim() +"')";      
                            stm.executeUpdate(sql1);
                            JOptionPane.showMessageDialog(null, "Record successfully saved", "Saving", JOptionPane.INFORMATION_MESSAGE);
                            connect.close();
                        }
                        DisAble();
                        ShowUsers();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Password mismatch!", "User", JOptionPane.ERROR_MESSAGE);
                }
                else if(cmdSave.getText().equals("Update"))
                {
                    if(String.valueOf(txtPassword.getPassword()).toString().trim().equals(String.valueOf(txtRetype.getPassword()).toString().trim()))
                    {      
                        EditUser();
                        cmdSave.setText("Save");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Password mismatch!", "User", JOptionPane.ERROR_MESSAGE);
                }
                        
            }
        }catch (SQLException sqlException)
            {
             JOptionPane.showMessageDialog(getContentPane(),sqlException.toString(),"sqlException",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public  void DisAble()
    {
        txtName.setEnabled(false);
        txtUsername.setEnabled(false);
        txtPassword.setEnabled(false);
        cmbType.setEnabled(false);
        txtRetype.setEnabled(false);
        cmdAdd.setEnabled(true);
        cmdSave.setEnabled(false);
        cmdEdit.setEnabled(false);
        cmdDelete.setEnabled(false);
    }
    public void EnAble()
    {
        txtName.setEnabled(true);
        txtRetype.setEnabled(true);
        txtUsername.setEnabled(true);
        txtPassword.setEnabled(true);
        cmbType.setEnabled(true);
        cmdAdd.setEnabled(false);
        cmdSave.setEnabled(true);
    }
            
    public void OriginalColor()
    {
       cmdAdd.setBackground(Color.LIGHT_GRAY);
       cmdSave.setBackground(Color.LIGHT_GRAY);
       cmdEdit.setBackground(Color.LIGHT_GRAY);
       cmdDelete.setBackground(Color.LIGHT_GRAY);
       cmdRefresh.setBackground(Color.LIGHT_GRAY);
       cmdClose.setBackground(Color.LIGHT_GRAY);
        cmdCancel.setBackground(Color.LIGHT_GRAY);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbType;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JButton cmdRefresh;
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUserAccount;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetype;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
