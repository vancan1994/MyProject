package controller;

import business.Account;
import business.Product;
import data.AccountDB;
import data.ProductDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        String url="/index.jsp";
        String action=request.getParameter("action");
        if(action==null){
            List<Product> products=ProductDB.getProductsByName("0001");
            List<Product> products1=ProductDB.getProductsByName("0002");
            request.setAttribute("products", products);
            request.setAttribute("products1", products1);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if(action.equals("detail"))
            doDetailProduct(request, response);
    }
    protected void layListSanPham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url="/index.jsp";
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        List<Product> products=ProductDB.getProducts();
        request.setAttribute("products", products);
    }
    protected void doDetailProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url="/details.jsp";
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        String productName=request.getParameter("productName");
        Product p=ProductDB.getProductName(productName);
        request.setAttribute("product",p);
        List<Product> products=ProductDB.getProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher(url).forward(request, response);
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
