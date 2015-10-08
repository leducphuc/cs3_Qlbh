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
public class Product {
    private int ID;   
    private String name;
    private String image;
    private double price;
    private int quantity;
    private String describe;
    private String status;
    private Date adddate;
    private int cate_ID;

    public Product(int ID, String name, String image, double price, int quantity, String describe, String status, Date adddate) {
        this.ID = ID;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
        this.status = status;
        this.adddate = adddate;
    }

    public Product(int ID, int cate_ID, String name, String image, double price, int quantity, String describe, String status, Date adddate) {
        this.ID = ID;
        this.cate_ID = cate_ID;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
        this.status = status;
        this.adddate = adddate;
    }
    
        public Product() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCate_ID() {
        return cate_ID;
    }

    public void setCate_ID(int cate_ID) {
        this.cate_ID = cate_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }
       
}
