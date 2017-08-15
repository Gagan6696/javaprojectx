/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.table.DefaultTableModel;
import model.TO.ProductInfoTO;
import model.dao.ProductInfoDAO;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import model.TO.CompanyInfoTO;
import model.dao.CompanyinfoDAO;

/**
 *
 * @author user
 */
public class viewproductinfo extends javax.swing.JInternalFrame {

    List<ProductInfoTO> productinfo;
      private JPopupMenu popupmenu;
    int row;
    public viewproductinfo() {
        initComponents();
        bindcoursetable();
     popupmenu=new JPopupMenu();
        JMenuItem jdeleteitem=new JMenuItem("delete this record");
      
        jdeleteitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              deleterecord();
            }
        });
        popupmenu.add(jdeleteitem);
        JMenuItem jupdateitem=new JMenuItem("update this record");
        
        jupdateitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updaterecord();

            }
        });
        popupmenu.add(jupdateitem);
        row=-1;
        
    }
    private void deleterecord(){
        if(row!=-1 && productinfo!=null && row<productinfo.size()){
            int result=JOptionPane.showConfirmDialog(this, "are you sure to delete  ","message from system",JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION){
            ProductInfoTO pt=productinfo.get(row);
            String message="";
            ProductInfoDAO action=new ProductInfoDAO();
            if(action.deleterecord(String.valueOf(pt.getProductid()))){
                message="record is deleted";
                bindcoursetable();
                
            }else{
                message=action.geterrormessage();
            }
            JOptionPane.showMessageDialog(this, message);
            }
        }
        
        row=-1;
    }
      private void updaterecord() {
       
        if (row != -1) {
                            
            ProductInfoTO pt = productinfo.get(row);
            addproductinfo apt = new addproductinfo(pt);

            apt.setVisible(true);
            getDesktopPane().add(apt);
            try {
                apt.setSelected(true);

            } catch (PropertyVetoException ex) {

            }

            dispose();   

        }
        row = -1;

    }
      public void bindcoursetable(){
    productinfo=new ProductInfoDAO().GetAllRecord();
    //remove this
   
    String[] colnames={"productid","productname","companyid","subtypeid","price"};
    Object[][] records=null;
    if(productinfo.size()>0 && productinfo!=null)
    {
        records=new Object[productinfo.size()][colnames.length];
        int i=0;
        for(ProductInfoTO pit:productinfo)
        {
            records[i]=new Object[]{pit.getProductid(),pit.getProductname(),pit.getCompanyid(),pit.getSubtypeid(),pit.getPrice()};
            i++;
        }
        
    }else{
        records=new Object[1][colnames.length];
        records[0]=new Object[]{"no records","no records","no records","no records","no records"};
    }
         DefaultTableModel dtm=new DefaultTableModel(records, colnames){
         

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
            
        
                 
       
      }
      
               
      };
          tableproductinfo.setAutoCreateRowSorter(true);
          tableproductinfo.getTableHeader().setReorderingAllowed(false);
                 tableproductinfo.setModel(dtm);
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableproductinfo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("IMS::view productinfo");

        tableproductinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tableproductinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableproductinfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableproductinfo);

        jButton1.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        jButton1.setText("refresh record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bindcoursetable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableproductinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableproductinfoMouseClicked
         if(evt.getButton()==MouseEvent.BUTTON3){
          int rowpos=tableproductinfo.rowAtPoint(evt.getPoint());
          tableproductinfo.getSelectionModel().setSelectionInterval(rowpos,rowpos);
          popupmenu.show(tableproductinfo, evt.getX(), evt.getY());
          row=tableproductinfo.getSelectedRow();
          
      }
    }//GEN-LAST:event_tableproductinfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableproductinfo;
    // End of variables declaration//GEN-END:variables
}
