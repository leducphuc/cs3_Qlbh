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
public class Customers {
    private int ID;
    private String name;
    private String email;
    private String phone;
    private int codeAcount;
    private int Amount;

    public Customers() {
    }

    public Customers(int ID, String name, String email, String phone, int codeAcount, int Amount) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.codeAcount = codeAcount;
        this.Amount = Amount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCodeAcount() {
        return codeAcount;
    }

    public void setCodeAcount(int codeAcount) {
        this.codeAcount = codeAcount;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }
    
}
