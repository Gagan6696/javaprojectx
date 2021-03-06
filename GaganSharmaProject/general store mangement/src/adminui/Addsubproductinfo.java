/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.TO.ProductSubTypeTO;
import model.TO.ProductTypeTO;
import model.dao.ProductSubtypeDAO;
import model.dao.ProductTypeDAO;
import operations.validations;

public class Addsubproductinfo extends javax.swing.JInternalFrame {

    int subtypeid;

    public Addsubproductinfo() {
        initComponents();
        jcbtypeid.removeAllItems();
        jcbtypeid.addItem("Choose Type ID");
        List<ProductTypeTO> type = new ProductTypeDAO().getAllRecord();
        if (type != null && type.size() > 0) {
            for (ProductTypeTO pt : type) {
                jcbtypeid.addItem(pt);
            }
        }
    }


    public Addsubproductinfo(ProductSubTypeTO pt) {
        this();

        if (pt != null) {

            jtfsubtypename.setText(pt.getSubtypename());
            subtypeid = pt.getSubtypeid();
            btnaddspi.setText("update record");
            setTitle("IMS::update productsubtype");
            for (int i = 1; i < jcbtypeid.getItemCount(); i++) {
                ProductTypeTO cit = (ProductTypeTO) jcbtypeid.getItemAt(i);
                if (cit.getTypeid().equals(pt.getTypeid())) {
                    jcbtypeid.setSelectedIndex(i);
                    break;
                }

            }

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbtypeid = new javax.swing.JComboBox<>();
        jtfsubtypename = new javax.swing.JTextField();
        btnaddspi = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("IMS::AddSubproductInfo");

        jLabel1.setFont(new java.awt.Font("KodchiangUPC", 1, 29)); // NOI18N
        jLabel1.setText("Enter Subtype Name:");

        jLabel2.setFont(new java.awt.Font("KodchiangUPC", 1, 29)); // NOI18N
        jLabel2.setText("Choose Type Id:");

        jcbtypeid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbtypeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbtypeidActionPerformed(evt);
            }
        });

        jtfsubtypename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfsubtypenameActionPerformed(evt);
            }
        });
        jtfsubtypename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfsubtypenameKeyTyped(evt);
            }
        });

        btnaddspi.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        btnaddspi.setText("Add Subproduct Info");
        btnaddspi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddspiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jcbtypeid, 0, 356, Short.MAX_VALUE)
                    .addComponent(jtfsubtypename))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 205, Short.MAX_VALUE)
                .addComponent(btnaddspi, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbtypeid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfsubtypename, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(btnaddspi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddspiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddspiActionPerformed
        String message = "";
        String subtypename = jtfsubtypename.getText().trim();
        boolean allvalid = true;
        if (validations.isEmpty(subtypename)) {
            message = "Enter SubType Name";
            allvalid = false;
        }
        if (jcbtypeid.getSelectedIndex() == 0) {
            message = "Choose Type ID";
            allvalid = false;
        }
        if (allvalid) {
            ProductTypeTO pt = (ProductTypeTO) jcbtypeid.getSelectedItem();
            ProductSubTypeTO pct = new ProductSubTypeTO();
            pct.setSubtypename(subtypename);
            pct.setTypeid(pt.getTypeid());
            ProductSubtypeDAO action = new ProductSubtypeDAO();
            if (btnaddspi.getText().contains("Add")) {
                if (action.insertrecord(pct)) {
                    message = "This Type id is assigned to subproduct";
                    JInternalFrame[] jif = getDesktopPane().getAllFrames();
                    if (jif != null) {
                        for (JInternalFrame jf : jif) {
                            if (jf instanceof viewproductsubtype) {
                                viewproductsubtype vpt = (viewproductsubtype) jf;
                                vpt.bindcoursetable();
                                break;
                            }

                        }
                    }

                } else {
                    message = action.geterrormessage();

                }
            } else if (btnaddspi.getText().contains("update")) {
                pct.setSubtypeid(subtypeid);
                if (action.updaterecord(pct)) {
                    message = "product subtype is updated in system";
                } else {
                    message = action.geterrormessage();
                }
                viewproductsubtype vpt = new viewproductsubtype();
                vpt.setVisible(true);
                getDesktopPane().add(vpt);
                try {
                    vpt.setSelected(true);
                } catch (PropertyVetoException ex) {

                }

            }

        }

        JOptionPane.showMessageDialog(this, message);


    }//GEN-LAST:event_btnaddspiActionPerformed

    private void jtfsubtypenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfsubtypenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfsubtypenameActionPerformed

    private void jtfsubtypenameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfsubtypenameKeyTyped
        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
    }//GEN-LAST:event_jtfsubtypenameKeyTyped
    }
    private void jcbtypeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbtypeidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbtypeidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddspi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<Object> jcbtypeid;
    private javax.swing.JTextField jtfsubtypename;
    // End of variables declaration//GEN-END:variables
}
