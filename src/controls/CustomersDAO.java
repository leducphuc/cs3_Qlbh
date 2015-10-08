/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Admin;
import model.Customers;

/**
 *
 * @author Brother
 */
public class CustomersDAO {
    private Connection con;
    public CustomersDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlbh";
            con = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }      
    }
    
    public void Add(Customers admin){
        String sql = "insert into tblCustomers(ID, name) values(?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, admin.getID());
            pre.setString(2, admin.getName());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public void Update(Customers admin){
        String sql = "update tblCustomers set name=? where ID=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, admin.getName());
            pre.setInt(2, admin.getID());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
//    
//    public void Delete(String username){
//        String sql = "delete from tblAdmin where username=?";
//        try {
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setString(1, username);
//            pre.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Successfull");
//        } catch (SQLException | HeadlessException e) {
//            System.out.println(e);
//        }
//    }
    
    public ResultSet searchID_Orders(int ID){
        ResultSet rs = null;
        String sql = "select b.ID as id from tblCustomers as a inner join tblOrders as b on a.ID = b.tblCustomers_ID where a.ID = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, ID);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;  
    }
    
    public ResultSet searchID(){
        ResultSet rs = null;
        String sql = "select ID from tblCustomers";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;  
    }
}
