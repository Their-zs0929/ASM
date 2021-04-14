/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Product;
import helper.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Lucires
 */
public class TblProductsDAO implements Serializable{
    public int getMaxId () throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 1;
        try {
            con = DBUtil.getConnection();
            String sql = "SELECT MAX(ProductID) AS 'MAX' FROM TblProducts";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                if (!"null".equalsIgnoreCase(rs.getString("MAX"))) {
                    result = Integer.parseInt(rs.getString("MAX"));
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public List<Product> getProductsByCateId(int categoryID) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Product> list = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String sql = "SELECT ProductID, Name, Price, Quantity "
                        + "FROM TblProducts "
                        + "WHERE CategoryID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoryID);
                rs = stm.executeQuery();

                while (rs.next()) {                    
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    int quantity = rs.getInt("Quantity");
                    Product p = new Product(id, categoryID, name, price, quantity);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(p);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }
    
    public List<Product> getAllProducts() throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Product> list = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String sql = "SELECT ProductID, CategoryID, Name, Price, Quantity "
                        + "FROM TblProducts";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {                    
                    int id = rs.getInt("ProductID");
                    int cateId = rs.getInt("CategoryID");
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    int quantity = rs.getInt("Quantity");
                    Product p = new Product(id, cateId, name, price, quantity);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(p);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }
    
    public boolean insertProduct (Product p) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtil.getConnection();
            String sql = "INSERT INTO TblProducts(ProductID,CategoryID,"
                    + "Name,Price,Quantity) "
                    + "VALUES(?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, p.getId());
            stm.setInt(2, p.getCategoryId());
            stm.setString(3, p.getName());
            stm.setFloat(4, p.getPrice());
            stm.setInt(5, p.getQuantity());          
            result = stm.executeUpdate()>0?true:false;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean updateProduct (Product p) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtil.getConnection();
            String sql = "UPDATE TblProducts SET Name=?, Price=?, "
                    + "Quantity=? ,CategoryID=?"
                    + "WHERE ProductID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, p.getName());
            stm.setFloat(2, p.getPrice());
            stm.setInt(3, p.getQuantity());
            stm.setInt(4, p.getCategoryId());
            result = stm.executeUpdate()>0?true:false;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean deleteProduct (int id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtil.getConnection();
            String sql = "DELETE FROM TblProducts WHERE ProductID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            result = stm.executeUpdate()>0?true:false;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
