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
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.TO.ProductInfoTO;
import model.dao.ProductInfoDAO;
import model.TO.ProductStockTO;
import model.dao.ProductStokeDAO;

/**
 *
 * @author user
 */
public class viewstockinfo extends javax.swing.JInternalFrame {

   List<ProductStockTO> stockinfo;
      private JPopupMenu popupmenu;
    int row;
    public viewstockinfo() {
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
        if(row!=-1 && stockinfo!=null && row<stockinfo.size()){
            int result=JOptionPane.showConfirmDialog(this, "are you sure to delete  ","message from system",JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION){
            ProductStockTO pt=stockinfo.get(row);
            String message="";
            ProductStokeDAO action=new ProductStokeDAO();
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
                            
            ProductStockTO pt = stockinfo.get(row);
            addproductstoke apt = new addproductstoke(pt);

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
    stockinfo=new ProductStokeDAO().getAllRecord();
          System.out.println(stockinfo);
    String[] colnames={"productid","stockdate","stockid","qty","price","expiry date"};
    Object[][] records=null;
    System.out.println("fhjfhjghgggg");
    if(stockinfo.size()>0 && stockinfo!=null)
    {
        System.out.println("in if");
        records=new Object[stockinfo.size()][colnames.length];
        int i=0;
        for(ProductStockTO pit:stockinfo)
        {
            records[i]=new Object[]{pit.getProductid(),pit.getStockdate(),pit.getStockid(),pit.getQty(),pit.getPrice(),pit.getExpirydate()};
            i++;
        }
        System.out.println("out if");
    }else{
        records=new Object[1][colnames.length];
        records[0]=new Object[]{"no records","no records","no records","no records","no records","no records"};
    }
    System.out.println("outelse");
         DefaultTableModel dtm=new DefaultTableModel(records, colnames){
         

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
            
        
                 
       
      }
      
               
      };
          tablestockinfo.setAutoCreateRowSorter(true);
          tablestockinfo.getTableHeader().setReorderingAllowed(false);
                 tablestockinfo.setModel(dtm);
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
        tablestockinfo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("IMS::view stock info");

        tablestockinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablestockinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablestockinfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablestockinfo);

        jButton1.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        jButton1.setText("Refresh Records");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bindcoursetable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablestockinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablestockinfoMouseClicked
         if(evt.getButton()==MouseEvent.BUTTON3){
          int rowpos=tablestockinfo.rowAtPoint(evt.getPoint());
          tablestockinfo.getSelectionModel().setSelectionInterval(rowpos,rowpos);
          popupmenu.show(tablestockinfo, evt.getX(), evt.getY());
          row=tablestockinfo.getSelectedRow();
          
      }
    }//GEN-LAST:event_tablestockinfoMouseClicked

                  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablestockinfo;
    // End of variables declaration//GEN-END:variables
}
