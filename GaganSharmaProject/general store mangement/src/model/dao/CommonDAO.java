/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.TO.CompanyInfoTO;

/**
 *
 * @author user
 */
public class CommonDAO {
    private String errormessage;
    public String geterrormessage(){
     return errormessage;   
    }
    public int getAutoIncrement(){
        try{
            String query = "select last_insert_id()";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            int result = -1;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            
            
            return -1;
    
       }
        
}
}
