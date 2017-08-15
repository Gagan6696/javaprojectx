/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import model.TO.BillInfoTO;
import model.TO.BillDetailsTO;
import model.dao.billdetailsDAO;

/**
 *
 * @author user
 */
public class billdetailsDAO {
        private String errormessage;

    public String geterrormessage() {
        return errormessage;
    }

    public boolean insertrecord(BillDetailsTO data) {
        try {
            String query = "insert into billdetails(stockid,qty,price,billid) values(?,?,?,?)";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            
            stmt.setInt(1, data.getStockid());
            stmt.setInt(2, data.getQty());
            stmt.setFloat(3, data.getPrice());
             stmt.setInt(4, data.getBillid());
            
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("1")) {
                errormessage = "This Type Id is Already Inserted. So try again with different TypeID";
            } else if (errormessage.contains("2")) {
                errormessage = "This Type Name is Already Used in System.";
            }
            return false;

        }

    }

    
}
