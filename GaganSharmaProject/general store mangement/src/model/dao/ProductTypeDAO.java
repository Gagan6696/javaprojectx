package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TO.ProductTypeTO;

public class ProductTypeDAO {
    private String errormessage;
    public String geterrormessage(){
     return errormessage;   
    }
    public boolean insertrecord(ProductTypeTO data){
        try{
            String query = "insert into producttype(typeid,typename)values(?,?)";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, data.getTypeid());
            stmt.setString(2, data.getTypename());
            boolean result = stmt.executeUpdate()>0;
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
                        if (errormessage.contains("1")) {
                errormessage = "This Type Id is Already Inserted. So try again with different TypeID";
            } else if (errormessage.contains("2")) {
                errormessage = "This Type Name is Already Used in System.";
            }
            return false;

            
    
       }
        
}
    public boolean updaterecord(ProductTypeTO data){
        try{
            String query = "update producttype set typename=? where typeid=?";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
             stmt.setString(1, data.getTypename());
            stmt.setString(2, data.getTypeid());
           
            boolean result = stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
    
       }
        
}
    public boolean deleterecord(String productid){
        try{
            String query = "delete from producttype where typeid=?";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, productid);
            boolean result = stmt.executeUpdate()>0;
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            if(errormessage.contains("foreign"))
                    {
                        errormessage="this typeid is used in another table";
                    }
            return false;
    
       }
        
}
     public List<ProductTypeTO>getAllRecord() {
        try {
            String query = "select typeid,typename from producttype";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<ProductTypeTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ProductTypeTO res = new ProductTypeTO();
                    res.setTypeid(rs.getString("typeid"));
                    res.setTypename(rs.getString("typename"));
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