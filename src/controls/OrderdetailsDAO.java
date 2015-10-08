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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Customers;
import model.Orderdetails;

/**
 *
 * @author Brother
 */
public class OrderdetailsDAO {
    private Connection con;
    public OrderdetailsDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlbh";
            con = DriverManager.getConnection(url, "root", "thanhtung1224");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }      
    }
    
    public void Add(Orderdetails admin){
        String sql = "insert into tblOrderdetails(quantity, price, tblProduct_ID, tblOrders_ID) values(?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setDouble(2, admin.getPrice());
            pre.setInt(1, admin.getQuantity());
            pre.setInt(3, admin.getPro_ID());
            pre.setInt(4, admin.getOrder_ID());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
//    public void Update(Customers admin){
//        String sql = "update tblAdmin set name=? where ID=?";
//        try {
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setString(1, admin.getName());
//            pre.setInt(2, admin.getID());
//            pre.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Successfull");
//        } catch (SQLException | HeadlessException e) {
//            System.out.println(e);
//        }
//    }
}
