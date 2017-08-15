package model.dao;

import java.sql.PreparedStatement;
import model.TO.ProductSubTypeTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductSubtypeDAO {

    private String errormessage;

    public String geterrormessage() {
        return errormessage;
    }

    public boolean insertrecord(ProductSubTypeTO data) {
        try {
            String query = "insert into productsubtype(subtypeid,subtypename,typeid)values(?,?,?)";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setInt(1, data.getSubtypeid());
            stmt.setString(2, data.getSubtypename());
            stmt.setString(3, data.getTypeid());
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("1")) {
                errormessage = "This company id is Already Inserted. So try again with different company id";
            } else if (errormessage.contains("2")) {
                errormessage = "This subtype is Already Used in System.";
            }

            return false;

        }

    }

    public boolean updaterecord(ProductSubTypeTO data) {
        try {
            String query = "update productsubtype set subtypename=?,typeid=? where subtypeid=?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(2, data.getTypeid());
            stmt.setString(1, data.getSubtypename());
            stmt.setInt(3, data.getSubtypeid());

            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;

        }

    }

    public boolean deleterecord(String subtypeid) {
        try {
            String query = "delete from productsubtype where subtypeid=?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1, subtypeid);
            boolean result = stmt.executeUpdate() > 0;
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("foreign")) {
                errormessage = "this subtypeid is used in another system";
            }
            return false;

        }

    }

    public List<ProductSubTypeTO> getAllRecord() {
        try {
            String query = "select subtypeid,subtypename,typeid  from productsubtype";
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

    public List<ProductSubTypeTO> getAllRecord(String typeid) {
        try {
            String query = "select subtypeid,subtypename,typeid  from productsubtype where typeid = ?";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setString(1,typeid);
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

    public ProductSubTypeTO GetRecord(int subtypeid) {
        try {
            String query = "select pt.subtypeid,pt.subtypename,pt.typeid from productsubtype pt join producttype pst on pst.typeid=pt.typeid where subtypeid=?;";
            PreparedStatement stmt = dataconnection.Getconnection().prepareStatement(query);
            stmt.setInt(1, subtypeid);
            ProductSubTypeTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ProductSubTypeTO();
                result.setSubtypeid(rs.getInt("subtypeid"));
                result.setSubtypename(rs.getString("subtypename"));
                result.setTypeid(rs.getString("typeid"));

            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<ProductSubTypeTO> getRecord() {
        try {
            String query = "select ps.stockid,ps.productid from productstock ps join productinfo pi on ps.productid=pi.productid where pi.subtypeid=? order by ps.expirydate;";
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
