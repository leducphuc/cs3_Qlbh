/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author hoang
 */
public class Orders {
    private int ID;    
    private Date shipdate;
    private double totalmoney;
    private int Cus_ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(int Cus_ID) {
        this.Cus_ID = Cus_ID;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Orders() {
    }

    public Orders(Date shipdate, double totalmoney, int Cus_ID) {
        this.shipdate = shipdate;
        this.totalmoney = totalmoney;
        this.Cus_ID = Cus_ID;
    }
    
}
