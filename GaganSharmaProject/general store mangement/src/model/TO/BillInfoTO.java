package model.TO;

import java.sql.Timestamp;

public class BillInfoTO {
private int billid;
private String contactno;
private String username;
private Timestamp billdate;

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getBilldate() {
        return billdate;
    }

    public void setBilldate(Timestamp billdate) {
        this.billdate = billdate;
    }
}
