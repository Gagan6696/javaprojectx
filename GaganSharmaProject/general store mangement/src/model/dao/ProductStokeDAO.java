package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TO.ProductStockTO;
import model.TO.ProductSubTypeTO;
import model.dao.ProductStokeDAO;

public class ProductStokeDAO {

    private String errormessage;

    public String geterrormessage() {
        return errormessage;
    }

    public boolean insertrecord(ProductStockTO data) {
        try {
            String query = "insert into productstock(productid,stockdate,stockid,qty,price,expirydate)values(?,?,?,?,?,?)";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setFloat(1, data.getProductid());
            stmt.setDate(2, data.getStockdate());
            stmt.setInt(3, data.getStockid());
            stmt.setInt(4, data.getQty());
            stmt.setFloat(5, data.getPrice());
            stmt.setDate(6, data.getExpirydate());
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("1")) {
                errormessage = "This product name  is Already Inserted. So try again with different product name";
            } else if (errormessage.contains("2")) {
                errormessage = "This Company Name is Already Used in System.";
            }

            return false;

        }

    }

    public boolean updaterecord(ProductStockTO data) {
        try {
            String query = "update productstoke set stockdate=?,qty=?,price=?,expirydate=? where stockid=?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setDate(1, data.getStockdate());
            stmt.setInt(2, data.getQty());
            stmt.setFloat(3, data.getPrice());
            stmt.setDate(4, data.getExpirydate());
            stmt.setInt(5, data.getStockid());
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;

        }

    }

    public boolean deleterecord(String productid) {
        try {
            String query = "delete from productstock where productid=?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, productid);
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;

        }

    }

    public List<ProductStockTO> getAllRecord() {
        try {
            String query = "select productid,stockdate,stockid,qty,price,expirydate from productstock";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<ProductStockTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ProductStockTO res = new ProductStockTO();
                    res.setProductid(rs.getInt("productid"));
                    res.setStockdate(rs.getDate("stockdate"));
                    res.setStockid(rs.getInt("stockid"));
                    res.setQty(rs.getInt("qty"));
                    res.setPrice(rs.getFloat("price"));
                    res.setExpirydate(rs.getDate("expirydate"));

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
    
    public List<ProductStockTO> getAllRecord(int subtypeid) {
        try {
            String query = "select ps.productid,stockdate,stockid,qty,pi.price,expirydate,productname from productstock ps join ProductInfo pi on ps.productid = pi.productid where pi.subtypeid = ? order by expirydate asc";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setInt(1,subtypeid);
            List<ProductStockTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ProductStockTO res = new ProductStockTO();
                    res.setProductid(rs.getInt("productid"));
                    res.setStockdate(rs.getDate("stockdate"));
                    res.setStockid(rs.getInt("stockid"));
                    res.setQty(rs.getInt("qty"));
                    res.setPrice(rs.getFloat("price"));
                    res.setExpirydate(rs.getDate("expirydate"));
                    res.setProductname(rs.getString("productname"));
                    result.add(res);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ex.printStackTrace();
            return null;
        }
    }

    public List<ProductSubTypeTO> GetAllRecord() {
        try {
            String query = "select pt.subtypeid,pt.subtypename,pt.typeid from productsubtype pt join producttype pst on pst.typeid=pt.typeid;";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            List<ProductSubTypeTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ProductSubTypeTO res = new ProductSubTypeTO();
                    res.setSubtypeid(rs.getInt("subtypeid"));
                    res.setSubtypename(rs.getString("subtypename"));
                    res.setTypeid(rs.getString("typeid"));
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
