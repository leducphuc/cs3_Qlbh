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
import model.Product;

/**
 *
 * @author Brother
 */
public class ProductDAO {
    private Connection con;
    public ProductDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlbh";
            con = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }      
    }
    
    public void Add(Product pro){
        String sql = "insert into tblProduct values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getID());
            ps.setString(2, pro.getName());
            ps.setString(3, pro.getImage());
            ps.setDouble(4, pro.getPrice());
            ps.setInt(5, pro.getQuantity());
            ps.setString(6, pro.getDescribe());
            ps.setString(7, pro.getStatus());
            ps.setDate(8, new Date(pro.getAdddate().getTime()));
            //ps.setTimestamp(8, new Timestamp(pro.getAdddate().getTime()));
            ps.setInt(9, pro.getCate_ID());
            ps.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public void Update(Product pro){
        String sql = "update tblProduct set name=?, image=?, price=?, quantity=?, des=?, status=?"
                + ", adddate=? tblCategories_ID=? where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getImage());
            ps.setDouble(3, pro.getPrice());
            ps.setInt(4, pro.getQuantity());
            ps.setString(5, pro.getDescribe());
            ps.setString(6, pro.getStatus());
            //ps.setDate(8, new Date(pro.getAdddate().getTime()));
            ps.setTimestamp(8, new Timestamp(pro.getAdddate().getTime()));
            ps.setInt(9, pro.getID());
            ps.executeUpdate();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public void Delete(int ID){
        String sql = "delete from tblProduct where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();          
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }
    
    public ResultSet search(){
        ResultSet rs = null;
        String sql = "select a.*, b.name as type from tblProduct as a inner join tblCategories as b where a.tblCategories_ID = b.ID";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();          
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;     
    }
    
    public ResultSet searchType(String temp){
        ResultSet rs = null;
        String sql = "select a.*, b.name as type from tblProduct as a inner join tblCategories as b on a.tblCategories_ID = b.ID"
                + " where b.name=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, temp);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;     
    }
    
    public ResultSet searchText(String text){
        ResultSet rs = null;
        String sql = "select a.*, b.name as type from tblProduct as a inner join tblCategories as b on a.tblCategories_ID = b.ID"
                + " where a.ID like ? or a.name like ? or a.des like ? or a.status like ? or b.name like ? or b.des like ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, text);
            pre.setString(2, text);
            pre.setString(3, text);
            pre.setString(4, text);
            pre.setString(5, text);
            pre.setString(6, text);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;  
    }
    
    public ResultSet searchTypeText(String type, String text){
        ResultSet rs = null;
        String sql = "select a.*, b.name as type from tblProduct as a inner join tblCategories as b on a.tblCategories_ID = b.ID"
                + " where (a.ID like ? or a.name like ? or a.des like ? or a.status like ? or b.name like ? or b.des like ?)"
                + " and b.name=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, text);
            pre.setString(2, text);
            pre.setString(3, text);
            pre.setString(4, text);
            pre.setString(5, text);
            pre.setString(6, text);
            pre.setString(7, type);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;  
    }
    
    public ResultSet searchID(){
        ResultSet rs = null;
        String sql = "select ID from tblProduct";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        return rs;  
    }
}
