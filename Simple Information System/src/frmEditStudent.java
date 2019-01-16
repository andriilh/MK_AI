import java.awt.Color;
public class frmEditStudent extends javax.swing.JInternalFrame {

//public static  frmEditStudent frame = new frmEditStudent();
public static frmEditStudent fr = new frmEditStudent();
    public frmEditStudent() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        txtMName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmdUpdate = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();

        setClosable(true);

        txtLName.setFont(new java.awt.Font("Verdana", 0, 12));
        txtLName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLNameFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel1.setText("Last Name :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel2.setText("First Name :");

        txtFName.setFont(new java.awt.Font("Verdana", 0, 12));
        txtFName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFNameFocusLost(evt);
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

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel3.setText("Middle Name :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel4.setText("Gender :");

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Female", "Male" }));
        cmbGender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbGenderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbGenderFocusLost(evt);
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

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel5.setText("Home Address:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel6.setText("Contact No. :");

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
        jLabel7.setText("Update Student Information");

        cmdUpdate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdUpdate.setText("Update");
        cmdUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmdCancel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdCancel.setText("Cancel");
        cmdCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cmdUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdCancel)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
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
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdUpdate)
                    .addComponent(cmdCancel))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdUpdate;
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
