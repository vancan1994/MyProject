package controller;

import util.SortPriceComparator;
import business.Account;
import business.Product;
import data.AccountDB;
import data.ProductDB;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.SortNameComparator;

@WebServlet(name = "searchServlet", urlPatterns = {"/searchServlet"})
public class SearchServlet extends HttpServlet {
    String search;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url="/search.jsp";
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        String action=request.getParameter("action");
        String user=request.getParameter("user");
        search=request.getParameter("search");
        if(search == null){
            search = "";
        }
        String message="";
        if(action==null){
            List<Product> products=ProductDB.getProducts(search);
            if(products.isEmpty()){
                message="không tìm thấy từ khoá '" +search+"'";
                
            }else{
                request.setAttribute("search", search);
            }
            request.setAttribute("message", message);
            request.setAttribute("products", products);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            switch(action){
                case "viewDog":
                {
                    layListSanPhamCho(request, response);
                    url="/search.jsp";
                    request.setAttribute("search", "dog");
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
                case "viewCat":
                {
                    layListSanPhamMeo(request, response);
                    url="/search.jsp";
                    request.setAttribute("search", "cat");
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
                case "viewHamster":
                {
                    layListSanPhamHamster(request, response);
                    url="/search.jsp";
                    request.setAttribute("search", "hamster");
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
                case "viewOther":
                {
                    layListSanPhamOther(request, response);
                    url="/search.jsp";
                    request.setAttribute("search", "other");
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
                case "priceSort":
                {
                    sortPriceImplement(request, response);
                    url="/search.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
                case "nameSort":
                {
                    sortNameImplement(request, response);
                    url="/search.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
            }
        }
    }
    
    protected void layListSanPhamOther(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products=ProductDB.getProductsByName("0004");
        request.setAttribute("products", products);
        request.setAttribute("category",4);
    }
    protected void layListSanPhamHamster(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products=ProductDB.getProductsByName("0003");
        request.setAttribute("products", products);
         request.setAttribute("category",3);
    }
    protected void layListSanPhamCho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products=ProductDB.getProductsByName("0001");
        request.setAttribute("products", products);
        request.setAttribute("category",1);
    }
    protected void layListSanPhamMeo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products=ProductDB.getProductsByName("0002");
        request.setAttribute("products", products);
         request.setAttribute("category",2);
    }
    
    private void sortPriceImplement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if("dog".equals(search)){
            List<Product> products=ProductDB.getDogProducts();
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", "dog");
        } else if("cat".equals(search)){
            List<Product> products=ProductDB.getCatProducts();
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", "cat");
        } else if("hamster".equals(search)){
            List<Product> products=ProductDB.getHamsterProducts();
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", "hamster");
        } else if("other".equals(search)){
            List<Product> products=ProductDB.getOtherProducts();
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", "other");
        } else {
            List<Product> products=ProductDB.getProducts(search);
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", search);
        }
    }
    
    private void sortNameImplement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if("dog".equals(search)){
            List<Product> products=ProductDB.getProductsByName("0001");
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", "dog");
            request.setAttribute("category",1);
        } else if("cat".equals(search)){
            List<Product> products=ProductDB.getProductsByName("0002");
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("category",2);
            request.setAttribute("search", "cat");
        } else if("hamster".equals(search)){
            List<Product> products=ProductDB.getProductsByName("0003");
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", "hamster");
        } else if("other".equals(search)){
            List<Product> products=ProductDB.getProductsByName("0004");
            SortPriceComparator spc = new SortPriceComparator();
            Collections.sort(products,spc);
            request.setAttribute("products", products);
            request.setAttribute("search", "other");
        } else {
            List<Product> products=ProductDB.getProducts(search);
            SortNameComparator spc = new SortNameComparator();
            Collections.sort(products,spc);
            request.setAttribute("search", search);
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

