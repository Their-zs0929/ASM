/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Lucires
 */
public class UserError {
    private String UserFloatError;
    private String UserIntegerError;

    public UserError() {
    }

    public UserError(String UserFloatError, String UserIntegerError) {
        this.UserFloatError = UserFloatError;
        this.UserIntegerError = UserIntegerError;
    }

    public String getUserFloatError() {
        return UserFloatError;
    }

    public void setUserFloatError(String UserFloatError) {
        this.UserFloatError = UserFloatError;
    }

    public String getUserIntegerError() {
        return UserIntegerError;
    }

    public void setUserIntegerError(String UserIntegerError) {
        this.UserIntegerError = UserIntegerError;
    }
    
}
