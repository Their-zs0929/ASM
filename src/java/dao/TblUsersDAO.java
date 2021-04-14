/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.DBUtil;
import dto.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Lucires
 */
public class TblUsersDAO implements Serializable{
    public User login(String id, String pwd) throws NamingException, SQLException{
        User user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String sql = "SELECT Name, Address, Phone, RoleID "
                        + "FROM TblUsers "
                        + "WHERE UserID='"+ id + "' AND Password='" + pwd +"'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                if (rs.next()) {
                    String name = rs.getString("Name");
                    String addr = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    String roleID = rs.getString("roleID");
                    user = new User(id, pwd, name, addr, phone, roleID);
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
        return user;
    }
}
