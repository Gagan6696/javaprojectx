package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TO.logininfoTO;

public class LogininfoDAO {
    private String errormessage;
    public String geterrormessage(){
     return errormessage;   
    }
    public boolean insertrecord(logininfoTO data){
        try{
            String query = "insert into logininfo(username,password,rolename)values(?,?,?)";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, data.getUsername());
            stmt.setString(2, data.getPassword());
             stmt.setString(3, data.getRolename());
           
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
    public boolean updaterecord(logininfoTO data){
        try{
            String query = "update logininfo set password=?,rolename=? where username=?";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, data.getUsername());
            stmt.setString(2, data.getPassword());
             stmt.setString(3, data.getRolename());
              //stmt.setTimestamp(4, data.getLastlogin());
           
            boolean result = stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
    
       }
        
}
    public boolean deleterecord(String username){
        try{
            String query = "delete from logininfo where username=?";
            PreparedStatement stmt= dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, username);
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
     public List<logininfoTO>getAllRecord() {
        try {
            String query = "select username,password,rolename,lastlogin from logininfo";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<logininfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    logininfoTO res = new logininfoTO();
                    res.setUsername(rs.getString("username"));
                    res.setPassword(rs.getString("password"));
                    res.setRolename(rs.getString("rolename"));
                    res.setLastlogin(rs.getTimestamp("lastlogin"));
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
      public logininfoTO getRecord(String username) {
        try {
            String query = "select username , password , rolename , lastlogin from logininfo where username = ?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, username);
            logininfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = new logininfoTO();
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setRolename(rs.getString("rolename"));
                result.setLastlogin(rs.getTimestamp("lastlogin"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }
    
    public boolean updateLastLogin(String username) {
        try {
            String query = "update logininfo set lastlogin = sysdate() where username = ?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, username);
            boolean result = stmt.executeUpdate() > 0;            
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    
}
