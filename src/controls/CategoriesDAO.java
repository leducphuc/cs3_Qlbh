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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Categories;

/**
 *
 * @author Brother
 */
public class CategoriesDAO {
    private Connection con;
    public CategoriesDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlbh";
            con = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }      
    }
    
    public void Add(Categories cate){
        String sql = "insert into tblCategories values(?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, cate.getID());
            pre.setString(2, cate.getName());
            pre.setString(3, cate.getDescribe());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public void Update(Categories cate){
        String sql = "update tblCategories set name=?, des=? where ID=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, cate.getName());
            pre.setString(2, cate.getDescribe());
            pre.setInt(3, cate.getID());
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        }
    }
    
    public void Delete(int ID){
        String sql = "delete from tblCategories where ID=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, ID);
            pre.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public ResultSet searchName(){
        ResultSet rs = null;
        String sql = "select distinct name from tblCategories";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;     
    }
    
    public ResultSet show(){
        ResultSet rs = null;
        String sql = "select * from tblCategories";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;   
    }
    
    public ResultSet searchID(String name){
        ResultSet rs = null;
        String sql = "select ID from tblCategories where name=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();          
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        }
        return rs;     
    }
    
    public ResultSet searchID(){
        ResultSet rs = null;
        String sql = "select ID from tblCategories";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();          
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        }
        return rs;     
    } 
}
