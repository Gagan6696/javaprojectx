package model.TO;

public class CompanyInfoTO {
    private String companyid;
     private String companyname;

    @Override
    public String toString() {
        return "[" + companyid + "]" + companyname;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
   
    
}
