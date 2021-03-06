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
import model.TO.CompanyInfoTO;
import model.TO.ProductTypeTO;
import model.dao.CompanyinfoDAO;
import model.dao.ProductTypeDAO;

/**
 *
 * @author user
 */

public class viewcompanyinfo extends javax.swing.JInternalFrame {
 List<CompanyInfoTO> company;
  private JPopupMenu popupmenu;
    int row;
   
    public viewcompanyinfo() {
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
        }); popupmenu.add(jupdateitem);
        row=-1;
        
    }
    private void deleterecord(){
        if(row!=-1 && company!=null && row<company.size()){
            int result=JOptionPane.showConfirmDialog(this, "are you sure to delete  ","message from system",JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION){
            CompanyInfoTO pt=company.get(row);
            String message="";
            CompanyinfoDAO action=new CompanyinfoDAO();
            if(action.deleterecord(pt.getCompanyid())){
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
       private void updaterecord(){
         if(row!=-1 && company!=null && row<company.size()){
             CompanyInfoTO ci=company.get(row);
             addcompanyinfo apt=new addcompanyinfo(ci);
             apt.setVisible(true);
             getDesktopPane().add(apt);
             try{
                 apt.setSelected(true);
                 
             }catch(PropertyVetoException ex){
                 
                 
             }
              
             dispose();
           
             
         }
        
    }
        
        
    
      public void bindcoursetable(){
    company=new CompanyinfoDAO().getAllRecord();
    String[] colnames={"companyid","companyname"};
    Object[][] records=null;
    if(company.size()>0 && company!=null)
    {
        records=new Object[company.size()][colnames.length];
        int i=0;
        for(CompanyInfoTO cit:company)
        {
            records[i]=new Object[]{cit.getCompanyid(),cit.getCompanyname()};
            i++;
        }
        
    }else{
        records=new Object[1][colnames.length];
        records[0]=new Object[]{"no records","no records"};
    }
        DefaultTableModel dtm=new DefaultTableModel(records, colnames){
         

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
            
        
                 
       
      }
      
               
      };
        tablecompanyinfo.setAutoCreateRowSorter(true);
        tablecompanyinfo.getTableHeader().setReorderingAllowed(false);
                 tablecompanyinfo.setModel(dtm);
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
        tablecompanyinfo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("IMS::view company info");

        tablecompanyinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablecompanyinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecompanyinfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablecompanyinfo);

        jButton1.setFont(new java.awt.Font("KodchiangUPC", 1, 36)); // NOI18N
        jButton1.setText("refresh records");
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
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bindcoursetable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablecompanyinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecompanyinfoMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3){
          int rowpos=tablecompanyinfo.rowAtPoint(evt.getPoint());
          tablecompanyinfo.getSelectionModel().setSelectionInterval(rowpos,rowpos);
          popupmenu.show(tablecompanyinfo, getX(), getY());
          row=tablecompanyinfo.getSelectedRow();
          
      }
    }//GEN-LAST:event_tablecompanyinfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablecompanyinfo;
    // End of variables declaration//GEN-END:variables

    
}
