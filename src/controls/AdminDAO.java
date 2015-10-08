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

/**
 *
 * @author Brother
 */
public class AdminDAO {
    private Connection con;
    public AdminDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlbh";
            con = DriverManager.getConnection(url, "root", "thanhtung1224");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }      
    }
    
    public void Add(Admin admin){
        String sql = "insert into tblAdmin values(?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, admin.getID());
            pre.setString(2, admin.getUsername());
            pre.setString(3, admin.getPassword());
            pre.setString(4, admin.getEmail());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public void Update(Admin admin){
        String sql = "update tblAdmin set password=?, email=? where username=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, admin.getPassword());
            pre.setString(2, admin.getEmail());
            pre.setString(3, admin.getUsername());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public void Delete(String username){
        String sql = "delete from tblAdmin where username=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public ResultSet Search(String temp){
        ResultSet rs = null;
        String sql = "select * from where";
        return rs;     
    }
}
