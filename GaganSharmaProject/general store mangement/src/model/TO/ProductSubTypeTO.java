package model.TO;

public class ProductSubTypeTO {
private int subtypeid;
private String subtypename;
private String typeid;

    @Override
    public String toString() {
        return "[" + subtypeid + "]" + subtypename;
    }

   
    public int getSubtypeid() {
        return subtypeid;
    }

    public void setSubtypeid(int subtypeid) {
        this.subtypeid = subtypeid;
    }

    public String getSubtypename() {
        return subtypename;
    }

    public void setSubtypename(String subtypename) {
        this.subtypename = subtypename;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
    
    
    
}
