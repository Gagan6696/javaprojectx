package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TO.CompanyInfoTO;

public class CompanyinfoDAO {

    private String errormessage;
    public String geterrormessage(){
     return errormessage;   
    }
    public boolean insertrecord(CompanyInfoTO data){
        try{
            String query = "insert into companyinfo(companyid,companyname)values(?,?)";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, data.getCompanyid());
            stmt.setString(2, data.getCompanyname());
            boolean result = stmt.executeUpdate()>0;
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            if (errormessage.contains("1")) {
                errormessage = "This company id  is Already Inserted. So try again with different company id";
            } else if (errormessage.contains("2")) {
                errormessage = "This Company Name is Already Used in System.";
            }
            
            return false;
    
       }
        
}
    public boolean updaterecord(CompanyInfoTO data){
        try{
            String query = "update companyinfo set companyname=? where companyid=?";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
             stmt.setString(1, data.getCompanyname());
             stmt.setString(2, data.getCompanyid());
           
            boolean result = stmt.executeUpdate()>0;
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
    
       }
        
}
    public boolean deleterecord(String companyid){
        try{
            String query = "delete from companyinfo where companyid=?";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, companyid);
            boolean result = stmt.executeUpdate()>0;
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            if(errormessage.contains("foreign"))
            {
                errormessage="this company id is used in another system";
            }
            return false;
    
       }
        
}
    public List<CompanyInfoTO>getAllRecord() {
        try {
            String query = "select companyid,companyname from companyinfo";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<CompanyInfoTO> result = null;
             ResultSet rs= stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    CompanyInfoTO res = new CompanyInfoTO();
                    res.setCompanyid(rs.getString("companyid"));
                    res.setCompanyname(rs.getString("companyname"));
                    result.add(res);
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

