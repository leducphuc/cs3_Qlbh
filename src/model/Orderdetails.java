/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hoang
 */
public class Orderdetails {
    private int ID;    
    private int quantity;
    private double price;
    private int Pro_ID;
    private int Order_ID;

    public Orderdetails() {
    }

    public Orderdetails(double price, int quantity, int Pro_ID, int Order_ID) {
        this.price = price;
        this.quantity = quantity;
        this.Pro_ID = Pro_ID;
        this.Order_ID = Order_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPro_ID() {
        return Pro_ID;
    }

    public void setPro_ID(int Pro_ID) {
        this.Pro_ID = Pro_ID;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int Order_ID) {
        this.Order_ID = Order_ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
