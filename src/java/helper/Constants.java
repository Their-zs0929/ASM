/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.Serializable;

/**
 *
 * @author Lucires
 */
public class Constants implements Serializable{
    public static String GOOGLE_CLIENT_ID = "790938449510-2fqps74ckvvs6tk4ll9jduo81bnmrlnh.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "MDWb3ls6FUSmw0GzCsEKapB1";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8084/ASM/LoginGoogleServlet";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
