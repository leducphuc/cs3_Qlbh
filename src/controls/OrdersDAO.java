/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.Admin;
import model.Orders;

/**
 *
 * @author Brother
 */
public class OrdersDAO {
    private Connection con;
    public OrdersDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlbh";
            con = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }      
    }
    
    public void Add(Orders admin){
        String sql = "insert into tblOrders(shipdate, totalmoney, tblCustomers_ID) values(?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setTimestamp(1, new Timestamp(admin.getShipdate().getTime()));
            pre.setDouble(2, admin.getTotalmoney());
            pre.setInt(3, admin.getCus_ID());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
//    public void Update(Orders admin){
//        String sql = "update tblAdmin set password=?, email=? where username=?";
//        try {
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setString(1, admin.getPassword());
//            pre.setString(2, admin.getEmail());
//            pre.setString(3, admin.getUsername());
//            pre.executeUpdate();
//        } catch (SQLException | HeadlessException e) {
//            System.out.println(e);
//        }
//    }
//    
//    public void Delete(String username){
//        String sql = "delete from tblAdmin where username=?";
//        try {
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setString(1, username);
//            pre.executeUpdate();
//        } catch (SQLException | HeadlessException e) {
//            System.out.println(e);
//        }
//    }
    
    public ResultSet reportYear(){
        String sql = "select month(shipdate) as thang, sum(totalmoney) as tongtien from tblorders" +
        " where year(shipdate) = year(curdate()) group by thang";
        ResultSet rs = null;
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public ResultSet reportDate(){
        String sql = "select a.ID as id_cus, a.name as name_cus, b.shipdate as date_ship, b.totalmoney as tongtien"
                + " from tblCustomers as a inner join tblOrders as b on a.ID = b.tblCustomers_ID" +
                " where date(shipdate) = date(curdate())";
        ResultSet rs = null;
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;
    }
    
}
