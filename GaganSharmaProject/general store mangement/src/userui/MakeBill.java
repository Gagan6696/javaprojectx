/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userui;

import java.util.ArrayList;
import model.TO.ProductSubTypeTO;
import model.TO.ProductTypeTO;
import model.dao.ProductTypeDAO;
import java.util.List;
import model.TO.ProductInfoTO;
import model.dao.ProductInfoDAO;
import model.dao.ProductSubtypeDAO;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TO.BillDetailsTO;
import model.TO.BillInfoTO;
import model.TO.MakebillTO;
import model.TO.ProductStockTO;
import model.dao.CommonDAO;
import model.dao.MakeBillDAO;
import model.dao.ProductStokeDAO;
import model.dao.billinfoDAO;
import operations.validations;
import model.TO.BillDetailsTO;
import model.dao.billdetailsDAO;

/**
 *
 * @author user
 */
public class MakeBill extends javax.swing.JInternalFrame {
    
    List<BillDetailsTO> bill;
    private String username;
    
    public MakeBill(String username) {
        this();
        this.username = username;
    }
    
    public MakeBill() {
        initComponents();
        jcb1.removeAllItems();
        jcb1.addItem("Choose type");
        jcb2.removeAllItems();
        jcb2.addItem("choose sub type");
        jcb3.removeAllItems();
        jcb3.addItem("choose product");
        List<ProductTypeTO> type = new ProductTypeDAO().getAllRecord();
        if (type != null && type.size() > 0) {
            for (ProductTypeTO pt : type) {
                jcb1.addItem(pt);
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

        jcb2 = new javax.swing.JComboBox<>();
        jcb1 = new javax.swing.JComboBox<>();
        jtfadditem = new javax.swing.JTextField();
        btnaddlist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepurchase = new javax.swing.JTable();
        jcb3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jtfemailid = new javax.swing.JTextField();
        lblgrandtotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("IMS::Bill Screen");

        jcb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb2ItemStateChanged(evt);
            }
        });

        jcb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb1ItemStateChanged(evt);
            }
        });

        btnaddlist.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        btnaddlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/addd.png"))); // NOI18N
        btnaddlist.setText("Add item to list");
        btnaddlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddlistActionPerformed(evt);
            }
        });

        tablepurchase.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablepurchase);

        jcb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        jLabel1.setText("Enter customer Email ID:");

        lblgrandtotal.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        lblgrandtotal.setText(" Grand total:0");

        jButton1.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        jButton1.setText("Generate bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcb2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jcb3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfemailid, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnaddlist))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jtfadditem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(287, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtfadditem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcb3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcb2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfemailid, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnaddlist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddlistActionPerformed
        try {
            if (jcb3.getSelectedIndex() > 0) {
                int qty = Integer.parseInt(jtfadditem.getText().trim());
                ProductStockTO pst = (ProductStockTO) jcb3.getSelectedItem();
                if (bill == null) {
                    bill = new ArrayList<>();                    
                }
                BillDetailsTO bt = new BillDetailsTO();
                bt.setStockid(pst.getStockid());
                bt.setProductname(pst.getProductname());
                bt.setQty(qty);
                bt.setPrice(pst.getPrice());
                bill.add(bt);
                bindTablePurchase();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please Enter Appropriate Values");
        }
    }//GEN-LAST:event_btnaddlistActionPerformed

    private void jcb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb1ItemStateChanged
        jcb2.removeAllItems();
        jcb2.addItem("choose sub type");
        if (jcb1.getSelectedIndex() > 0) {
            ProductTypeTO pt = (ProductTypeTO) jcb1.getSelectedItem();
            List<ProductSubTypeTO> subtypes = new ProductSubtypeDAO().getAllRecord(pt.getTypeid());
            if (subtypes != null && subtypes.size() > 0) {
                for (ProductSubTypeTO ps : subtypes) {
                    jcb2.addItem(ps);
                }
            }
        }
    }//GEN-LAST:event_jcb1ItemStateChanged

    private void jcb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb2ItemStateChanged
        jcb3.removeAllItems();
        jcb3.addItem("Choose Product");
        if (jcb1.getSelectedIndex() > 0 && jcb2.getSelectedIndex() > 0) {
            ProductSubTypeTO pst = (ProductSubTypeTO) jcb2.getSelectedItem();
            List<ProductStockTO> stocks = new ProductStokeDAO().getAllRecord(pst.getSubtypeid());
            if (stocks != null && stocks.size() > 0) {
                for (ProductStockTO st : stocks) {
                    jcb3.addItem(st);
                }
            }
        }
    }//GEN-LAST:event_jcb2ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String emailid = jtfemailid.getText();
        String message = "";
        boolean allvalid = true;
        if (validations.isEmpty(emailid)) {
            message += "Please Enter Some Value in Email ID Box\n";
            allvalid = false;
        }
        if (bill != null && bill.size() == 0) {
            message += "Please Add Some Item in Table\n";
            allvalid = false;
        }
        System.out.println(bill + "\t" + bill.size());
        if (allvalid) {
            BillInfoTO bit = new BillInfoTO();
            bit.setUsername(username);
            bit.setContactno(emailid);
            bit.setBilldate(new java.sql.Timestamp(new java.util.Date().getTime()));
            billinfoDAO action = new billinfoDAO();
            if (action.insertrecord(bit)) {
                message = "Message is Generation";
                CommonDAO cd = new CommonDAO();
                int billid = cd.getAutoIncrement();
                if (billid != -1) {
                    for (BillDetailsTO bdt : bill) {
                        bdt.setBillid(billid);
                        new billdetailsDAO().insertrecord(bdt);
                    }
                }
            } else {
                message = action.geterrormessage();
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void bindTablePurchase() {
        String[] colnames = {"Product Name", "Product Price", "Quantity", "Total Price"};
        Object[][] records = null;
        double gtotal = 0;
        if (bill != null && bill.size() > 0) {
            records = new Object[bill.size()][colnames.length];
            int i = 0;
            for (BillDetailsTO pit : bill) {
                double total = pit.getQty() * pit.getPrice();
                records[i] = new Object[]{pit.getProductname(), pit.getPrice(), pit.getQty(), total};
                i++;
                gtotal += total;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Item", "No Item", "No Item", "No Item"};
        }
        lblgrandtotal.setText("The Grand Total : " + gtotal);
        DefaultTableModel dtm = new DefaultTableModel(records, colnames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablepurchase.setModel(dtm);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddlist;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Object> jcb1;
    private javax.swing.JComboBox<Object> jcb2;
    private javax.swing.JComboBox<Object> jcb3;
    private javax.swing.JTextField jtfadditem;
    private javax.swing.JTextField jtfemailid;
    private javax.swing.JLabel lblgrandtotal;
    private javax.swing.JTable tablepurchase;
    // End of variables declaration//GEN-END:variables
}
