/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.TO;

import java.sql.Timestamp;

/**
 *
 * @author user
 */
public class MakebillTO {
    private int qty;
private  int billid;
private float price;
private String contactno;
private String username;
private Timestamp billdate;

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
