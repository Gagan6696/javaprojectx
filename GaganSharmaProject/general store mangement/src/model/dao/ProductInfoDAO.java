package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TO.ProductInfoTO;
import model.TO.ProductSubTypeTO;

public class ProductInfoDAO {

    private String errormessage;

    public String geterrormessage() {
        return errormessage;
    }

    public boolean insertrecord(ProductInfoTO data) {
        try {
            String query = "insert into productinfo(productid,productname,companyid,subtypeid,price) values(?,?,?,?,?)";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setInt(1, data.getProductid());
            stmt.setString(2, data.getProductname());
            stmt.setString(3, data.getCompanyid());
            stmt.setInt(4, data.getSubtypeid());
            stmt.setFloat(5, data.getPrice());
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("1")) {
                errormessage = "This product name is Already Inserted. So try again with different product name";
            } else if (errormessage.contains("2")) {
                errormessage = "This Type Name is Already Used in System.";
            }
            return false;

        }

    }

    public boolean updaterecord(ProductInfoTO data) {
        try {
            String query = "update productinfo set productname=?,companyid=?,subtypeid=?,price=? where productid=?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(2, data.getCompanyid());
            stmt.setInt(3, data.getSubtypeid());
             stmt.setFloat(4, data.getPrice());
             stmt.setString(1, data.getProductname());
              stmt.setInt(5, data.getProductid());
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;

        }

    }

    public boolean deleterecord(String productid) {
        try {
            String query = "delete from productinfo where productid=?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, productid);
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;

        }

    }

    public List<ProductInfoTO> getAllRecord() {
        try {
            String query = "select productid,productname,companyid,subtypeid,price from productinfo";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<ProductInfoTO> result = null;
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

    public List<ProductInfoTO> GetAllRecord() {
        try {
            String query = "select pt.productid,pt.productname,pt.companyid,pt.subtypeid,pt.price from productinfo pt join companyinfo ci on ci.companyid=pt.companyid join productsubtype pst on pst.subtypeid=pt.subtypeid;";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<ProductInfoTO> result = null;
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
