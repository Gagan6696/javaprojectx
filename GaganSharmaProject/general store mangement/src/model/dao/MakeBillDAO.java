/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TO.ProductInfoTO;


public class MakeBillDAO {
       private String errormessage;

    public String geterrormessage() {
        return errormessage;
    }
     public List<MakeBillDAO> GetAllRecord() {
        try {
            String query = "select pt.productid,pt.productname,pt.companyid,pt.subtypeid,pt.price from productinfo pt join companyinfo ci on ci.companyid=pt.companyid join productsubtype pst on pst.subtypeid=pt.subtypeid;";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<MakeBillDAO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ProductInfoTO res = new ProductInfoTO();
                    res.setProductid(rs.getInt("productid"));
                    res.setProductname(rs.getString("productname"));
                    res.setCompanyid(rs.getString("companyid"));
                    res.setSubtypeid(rs.getInt("subtypeid"));
                    res.setPrice(rs.getFloat("price"));
                    //result.add(res);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    
}
