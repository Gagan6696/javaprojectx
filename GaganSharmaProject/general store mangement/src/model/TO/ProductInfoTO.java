package model.TO;

public class ProductInfoTO {

    private int Productid;
    private String productname;

    @Override
    public String toString() {
        return "[" + productname + "]" + Productid;

    }

    public int getProductid() {
        return Productid;
    }

    public void setProductid(int Productid) {
        this.Productid = Productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public int getSubtypeid() {
        return subtypeid;
    }

    public void setSubtypeid(int subtypeid) {
        this.subtypeid = subtypeid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    private String companyid;
    private int subtypeid;
    private float price;

}
