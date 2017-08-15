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
import model.TO.logininfoTO;
import model.dao.LogininfoDAO;

/**
 *
 * @author user
 */
public class viewlogininfo extends javax.swing.JInternalFrame {

     List<logininfoTO> logininfo;
      private JPopupMenu popupmenu;
    int row;
    public viewlogininfo() {
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
        if(row!=-1 && logininfo!=null && row<logininfo.size()){
            int result=JOptionPane.showConfirmDialog(this, "are you sure to delete  ","message from system",JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION){
            logininfoTO pt=logininfo.get(row);
            String message="";
            LogininfoDAO action=new LogininfoDAO();
            if(action.deleterecord(String.valueOf(pt.getUsername()))){
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
                            
            logininfoTO pt = logininfo.get(row);
            addlogininfo apt = new addlogininfo(pt);

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
    logininfo=new LogininfoDAO().getAllRecord();
    String[] colnames={"username","password","rolename","lastlogin"};
    Object[][] records=null;
    if(logininfo.size()>0 && logininfo!=null)
    {
        records=new Object[logininfo.size()][colnames.length];
        int i=0;
        for(logininfoTO pit:logininfo)
        {
            records[i]=new Object[]{pit.getUsername(),pit.getPassword(),pit.getRolename(),pit.getLastlogin()};
            i++;
        }
        
    }else{
        records=new Object[1][colnames.length];
        records[0]=new Object[]{"no records","no records","no records","no records"};
    }
         DefaultTableModel dtm=new DefaultTableModel(records, colnames){
         

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
            
        
                 
       
      }
      
               
      };
          tablelogininfo.setAutoCreateRowSorter(true);
          tablelogininfo.getTableHeader().setReorderingAllowed(false);
                 tablelogininfo.setModel(dtm);
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
        tablelogininfo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("IMS::View login info");

        tablelogininfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablelogininfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablelogininfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablelogininfo);

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
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablelogininfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablelogininfoMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3){
            int rowpos=tablelogininfo.rowAtPoint(evt.getPoint());
            tablelogininfo.getSelectionModel().setSelectionInterval(rowpos,rowpos);
            popupmenu.show(tablelogininfo, getX(), getY());
            row=tablelogininfo.getSelectedRow();

        }
    }//GEN-LAST:event_tablelogininfoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bindcoursetable();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablelogininfo;
    // End of variables declaration//GEN-END:variables
}