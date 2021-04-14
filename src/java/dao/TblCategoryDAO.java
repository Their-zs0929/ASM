/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Category;
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
public class TblCategoryDAO implements Serializable{
    public List<Category> getCategoryList() throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Category> list = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String sql = "SELECT CategoryID, Name FROM TblCategory";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {                    
                    int id = rs.getInt("CategoryID");
                    String name = rs.getString("Name");
                    Category c = new Category(id, name);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(c);
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
}
