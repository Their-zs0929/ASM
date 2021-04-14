/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.TblCategoryDAO;
import dao.TblProductsDAO;
import dto.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucires
 */
public class MainController extends HttpServlet {

    private static final String SHOPPING_PAGE = "shopping.jsp";
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH = "SearchController";
    private static final String ADD_ITEM = "addItem.jsp";
    private static final String DELETE_ITEM = "DeleteController";
    private static final String ADD_CONFIRM = "AddItemController";
    private static final String ADD_CART = "AddToCartController";
    private static final String VIEW_CART = "viewCart.jsp";
    private static final String UPDATE_CART = "UpdateToCartController";
    private static final String DELETE_CART = "RemoveFromCartController";
    private static final String PAY_CONFIRM = "PayConfirmController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            TblProductsDAO dao1 = new TblProductsDAO();
            int maxItem = dao1.getMaxId();
            HttpSession session = request.getSession();
            session.setAttribute("MAX", maxItem);
            if (action == null) {
                TblCategoryDAO dao2 = new TblCategoryDAO();
                List<Category> list = dao2.getCategoryList();
                session.setAttribute("CATE_LIST", list);
                url = SHOPPING_PAGE;
            } else if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("Add Item".equals(action)) {
                url = ADD_ITEM;
            } else if ("Add Confirm".equals(action)) {
                url = ADD_CONFIRM;
            } else if ("Delete Item".equals(action)) {
                url = DELETE_ITEM;
            } else if ("Add Cart".equals(action)) {
                url = ADD_CART;
            } else if ("View Cart".equals(action)) {
                url = VIEW_CART;
            } else if ("Update cart".equals(action)) {
                url = UPDATE_CART;
            } else if ("Remove from cart".equals(action)) {
                url = DELETE_CART;
            } else if ("Confirm Payment".equals(action)) {
                url = PAY_CONFIRM;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
