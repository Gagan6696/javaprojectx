package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TO.ProductInfoTO;
import model.TO.BillInfoTO;

public class billinfoDAO {
    private String errormessage;

    public String geterrormessage() {
        return errormessage;
    }

    public boolean insertrecord(BillInfoTO data) {
        try {
            String query = "insert into billinfo(contactno,billdate,username) values(?,?,?)";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            
            stmt.setString(1, data.getContactno());
            stmt.setString(3, data.getUsername());
            stmt.setTimestamp(2, data.getBilldate());
            
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
 /* public List<BillInfoTO> getAllRecord() {
        try {
            String query = "select contactno from billinfo";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<BillInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    BillInfoTO res = new BillInfoTO();
                   
                    res.setContactno(rs.getString(contactno));
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
    }*/    
}
