import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class frmRegistration extends javax.swing.JInternalFrame {

    public static frmRegistration frame = new frmRegistration();
    
    public frmRegistration() {
        initComponents();
        OriginalColor();
        this.DisAble();
    }
    
     public void AddStudent()
    {
    String sql1 = "";
    try
        {
            if (this.txtLName.getText().isEmpty() || this.txtFName.getText().isEmpty() || txtAddress.getText().isEmpty() || txtContact.getText().isEmpty() || cmbGender.getSelectedItem().equals(""))
            {

                JOptionPane.showMessageDialog(null, "Empty fields is not permitted", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
           else
            {
                int AddMe = JOptionPane.showConfirmDialog(null,"Are you sure you want to save this record?","Save?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(AddMe == JOptionPane.YES_OPTION)
                {
                clsConnection conn = new clsConnection();
                Connection connect = clsConnection.conn;
                Statement stm = connect.createStatement();
                sql1 = "INSERT INTO tblStudents(LName,FNmae,MName,Gender,Address,ContactNo) VALUES('" + txtLName.getText().toString().toUpperCase().trim() +"','" + txtFName.getText().toString().toUpperCase().trim()  +"','" + this.txtMName.getText().toString().toUpperCase().trim()  +"','"+ this.cmbGender.getSelectedItem().toString().toUpperCase().trim() +"','"+ txtAddress.getText().toString().toUpperCase().trim() +"','"+ txtContact.getText().toString().toUpperCase().trim() +"')";      
                stm.executeUpdate(sql1);
                JOptionPane.showMessageDialog(null, "Record successfully saved", "Saving", JOptionPane.INFORMATION_MESSAGE);
                connect.close();
                this.DisAble();

                }
            }
        }catch (SQLException sqlException)
            {
             JOptionPane.showMessageDialog(getContentPane(),sqlException.toString(),"sqlException",JOptionPane.ERROR_MESSAGE);
            }
}// end of Add
    public void DisAble()
    {
        txtLName.setText("");
        txtLName.setBackground(Color.lightGray);
        txtFName.setText("");
        txtFName.setBackground(Color.lightGray);
        txtMName.setText("");
        txtMName.setBackground(Color.lightGray);
        txtAddress.setText("");
        txtAddress.setBackground(Color.lightGray);
        txtContact.setText("");
        txtContact.setBackground(Color.lightGray);
        txtLName.enable(false);
        txtFName.enable(false);
        txtMName.enable(false);
        txtAddress.enable(false);
        txtContact.enable(false);
        cmbGender.enable(false);
        cmbGender.setBackground(Color.lightGray);
        cmdSave.setEnabled(false);
        cmdAdd.setEnabled(true);
        
    }
    public void EnAble()
    {
        cmdSave.setEnabled(true);
        cmdAdd.setEnabled(false);
        txtLName.setText("");
        txtLName.setBackground(Color.WHITE);
        txtFName.setText("");
        txtFName.setBackground(Color.WHITE);
        txtMName.setText("");
        txtMName.setBackground(Color.WHITE);
        txtAddress.setText("");
        txtAddress.setBackground(Color.WHITE);
        txtContact.setText("");
        txtContact.setBackground(Color.WHITE);
        txtLName.enable(true);
        txtFName.enable(true);
        txtMName.enable(true);
        txtAddress.enable(true);
        txtContact.enable(true);
        cmbGender.enable(true);
        cmbGender.setBackground(Color.WHITE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        txtMName = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmdAdd = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        cmdReset = new javax.swing.JButton();
        cmbGender = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("New Student Registration");
        setName(""); // NOI18N
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel1.setText("Last Name :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel2.setText("First Name :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel3.setText("Middle Name :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel4.setText("Gender :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel5.setText("Home Address:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel6.setText("Contact No. :");

        txtLName.setFont(new java.awt.Font("Verdana", 0, 12));
        txtLName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLNameFocusLost(evt);
            }
        });

        txtMName.setFont(new java.awt.Font("Verdana", 0, 12));
        txtMName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMNameFocusLost(evt);
            }
        });

        txtFName.setFont(new java.awt.Font("Verdana", 0, 12));
        txtFName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFNameFocusLost(evt);
            }
        });

        txtAddress.setFont(new java.awt.Font("Verdana", 0, 12));
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });

        txtContact.setFont(new java.awt.Font("Verdana", 0, 12));
        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
        jLabel7.setText("Student Registration Form");

        cmdAdd.setFont(new java.awt.Font("Verdana", 0, 12));
        cmdAdd.setText("Add New");
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

        cmdSave.setFont(new java.awt.Font("Verdana", 0, 12));
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
        cmdSave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdSaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmdSaveFocusLost(evt);
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
        cmdClose.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdCloseFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmdCloseFocusLost(evt);
            }
        });

        cmdReset.setFont(new java.awt.Font("Verdana", 0, 12));
        cmdReset.setText("Reset");
        cmdReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdReset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdResetMouseMoved(evt);
            }
        });
        cmdReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdResetActionPerformed(evt);
            }
        });
        cmdReset.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmdResetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmdResetFocusLost(evt);
            }
        });

        cmbGender.setFont(new java.awt.Font("Verdana", 0, 12));
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Female", "Male" }));
        cmbGender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbGenderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbGenderFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGender, 0, 202, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtMName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdReset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmdClose))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
      this.EnAble();
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
       this.AddStudent();
        
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
      //  this.DisAble();
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdResetActionPerformed
        this.DisAble();
    }//GEN-LAST:event_cmdResetActionPerformed

    private void txtLNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLNameFocusGained
        txtLName.setBackground(Color.YELLOW);
    }//GEN-LAST:event_txtLNameFocusGained

    private void txtLNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLNameFocusLost
        txtLName.setBackground(Color.white);
    }//GEN-LAST:event_txtLNameFocusLost

    private void txtFNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFNameFocusGained
        txtFName.setBackground(Color.YELLOW);
    }//GEN-LAST:event_txtFNameFocusGained

    private void txtFNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFNameFocusLost
        txtFName.setBackground(Color.white);
    }//GEN-LAST:event_txtFNameFocusLost

    private void txtMNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMNameFocusGained
        txtMName.setBackground(Color.YELLOW);
    }//GEN-LAST:event_txtMNameFocusGained

    private void txtMNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMNameFocusLost
        txtMName.setBackground(Color.white);
    }//GEN-LAST:event_txtMNameFocusLost

    private void cmbGenderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGenderFocusGained
        cmbGender.setBackground(Color.YELLOW);
    }//GEN-LAST:event_cmbGenderFocusGained

    private void cmbGenderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGenderFocusLost
        cmbGender.setBackground(Color.white); 
    }//GEN-LAST:event_cmbGenderFocusLost

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        txtAddress.setBackground(Color.YELLOW);
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        txtAddress.setBackground(Color.white); 
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusGained
         txtContact.setBackground(Color.YELLOW);
    }//GEN-LAST:event_txtContactFocusGained

    private void txtContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusLost
        txtContact.setBackground(Color.white);
    }//GEN-LAST:event_txtContactFocusLost

    private void cmdAddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdAddFocusGained
        
    }//GEN-LAST:event_cmdAddFocusGained

    private void cmdAddFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdAddFocusLost
        
    }//GEN-LAST:event_cmdAddFocusLost

    private void cmdSaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdSaveFocusGained
        
    }//GEN-LAST:event_cmdSaveFocusGained

    private void cmdSaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdSaveFocusLost
        
    }//GEN-LAST:event_cmdSaveFocusLost

    private void cmdResetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdResetFocusGained
        
    }//GEN-LAST:event_cmdResetFocusGained

    private void cmdResetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdResetFocusLost
        
    }//GEN-LAST:event_cmdResetFocusLost

    private void cmdCloseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdCloseFocusGained
        
    }//GEN-LAST:event_cmdCloseFocusGained

    private void cmdCloseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmdCloseFocusLost
        
    }//GEN-LAST:event_cmdCloseFocusLost

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
       OriginalColor();
    }//GEN-LAST:event_formMouseMoved

    private void cmdAddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdAddMouseMoved
       if(cmdAdd.isEnabled()==true)
            cmdAdd.setBackground(Color.YELLOW);
       else
           OriginalColor();
    }//GEN-LAST:event_cmdAddMouseMoved

    private void cmdSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSaveMouseMoved
        if(cmdSave.isEnabled()==true)
            cmdSave.setBackground(Color.YELLOW);
        else
            OriginalColor();
    }//GEN-LAST:event_cmdSaveMouseMoved

    private void cmdResetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdResetMouseMoved
        cmdReset.setBackground(Color.YELLOW);
    }//GEN-LAST:event_cmdResetMouseMoved

    private void cmdCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCloseMouseMoved
        cmdClose.setBackground(Color.YELLOW);
    }//GEN-LAST:event_cmdCloseMouseMoved

        public void OriginalColor()
        {
          cmdClose.setBackground(Color.LIGHT_GRAY);
          cmdReset.setBackground(Color.LIGHT_GRAY);
          cmdSave.setBackground(Color.LIGHT_GRAY);
          cmdAdd.setBackground(Color.LIGHT_GRAY);
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdReset;
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtMName;
    // End of variables declaration//GEN-END:variables
}
