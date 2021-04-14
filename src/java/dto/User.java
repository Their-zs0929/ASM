/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Lucires
 */
public class User implements Serializable{
    private String ID;
    private String password;
    private String name;
    private String address;
    private String phone;
    private String roleID;

    public User() {
    }

    public User(String ID, String password, String name, String address, String phone, String role) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.roleID = role;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the role
     */
    public String getRoleID() {
        return roleID;
    }

    /**
     * @param role the role to set
     */
    public void setRoleID(String role) {
        this.roleID = role;
    }       
}
