package model.TO;

import java.sql.Date;

public class ProductStockTO {
private int productid;
private int stockid;
private int qty;
private Date stockdate;
private Date expirydate;
private float price;
private String productname;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getStockid() {
        return stockid;
    }

    public void setStockid(int stockid) {
        this.stockid = stockid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getStockdate() {
        return stockdate;
    }

    public void setStockdate(Date stockdate) {
        this.stockdate = stockdate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString(){
        return productname + " [ " + expirydate + " ]";
    }
    
}
