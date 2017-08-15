package model.TO;

public class BillDetailsTO {

    private int detailsid;
    private int stockid;
    private int qty;
    private int billid;
    private float price;
    private String productname;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    public int getDetailsid() {
        return detailsid;
    }

    public void setDetailsid(int detailsid) {
        this.detailsid = detailsid;
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

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
