package controller;

import business.Account;
import business.Cart;
import business.Order;
import business.OrderDetail;
import business.Product;
import data.AccountDB;
import data.OrderDB;
import data.ProductDB;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "CartServlet", urlPatterns = {"/cartServlet"})
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action= request.getParameter("action");
        if(action  == null) {
            action = "cart";
        }
        switch (action) {
            case "cart":
                doAddToCart(request,response);
                break;
            case "update":
                doUpdateToCart(request,response);
                break;
            case "shop":
                doShop(request, response);
                break;
            case "check":
                doCheck(request, response);
                break;
            case "checkNoacc":
                doCheck(request, response);
                break;    
            case "checkout":
                doCheckOut(request, response);
                break;
            case "doCheckNoacc":
                doCheckOut(request, response);
                break;     
            default:
                break;
        }
    }
    
    private void doShop(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        String url = "/index.jsp";
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        List<Product> products = ProductDB.getProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    private void doAddToCart(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        
        HttpSession session = request.getSession();//khai bao session
        Cart cart = (Cart)session.getAttribute("cart");
        //do add to cart
        String productID = request.getParameter("productID");
        if(productID == null){
            if(cart == null) {
                cart = new Cart();
            }
            
        }else{
            String quantityString = request.getParameter("quantity");
            Product p = ProductDB.getProduct(productID);
            double price=p.getPrice();

            int quantity = 0;
            try{
                quantity = Integer.parseInt(quantityString);
            }catch(NumberFormatException e){
                quantity = 1;
            }
            OrderDetail orderDetail = new OrderDetail(p, quantity,price);
            if(cart == null) {
                cart = new Cart();
            }
            if(quantity == 0) {
                cart.removeItem(orderDetail);
            }   
            else
            {
                if(cart == null) {
                    cart.addItems(orderDetail);
                }else {
                    cart.updateItem(orderDetail);
                }
            }
        }
        session.setAttribute("cart", cart);
        String url="/cart.jsp";
        String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    private void doUpdateToCart(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        
        HttpSession session = request.getSession();//khai bao session
        Cart cart = (Cart)session.getAttribute("cart");
        //do add to cart
        String productID = request.getParameter("productID");
        String quantityString = request.getParameter("quantity");
        Product p = ProductDB.getProduct(productID);
        double price=p.getPrice();
        int quantity = Integer.parseInt(quantityString);
        OrderDetail orderDetail = new OrderDetail(p, quantity,price);
        cart.updateItemDetail(orderDetail);
        session.setAttribute("cart", cart);
        String url="/cart.jsp";
        String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    private void doCheckOut(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        HttpSession session = request.getSession();//khai bao session
        Cart cart = (Cart)session.getAttribute("cart");
        String email =(String) session.getAttribute("email");
        Account acc=null;
        Order order=null;
        String message="";
        if(email == null){
            request.setAttribute("checkLogin", 0);
            String email1=request.getParameter("email1");
            String firstName=request.getParameter("firstname");
            String lastName=request.getParameter("lastname");
            String address=request.getParameter("address");
            String phone=request.getParameter("phone");
            acc= new Account(firstName, lastName, email, phone, address,null, 0, 0, 0);
            order= new Order(acc, LocalDate.now(), cart);
            if(OrderDB.insertOrderNoName(order)){
             message="Thanh toán thành công";
             request.setAttribute("order",order);
            }else
                 message="Insert False";
        } else {
            acc= AccountDB.getAccount2(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
            order= new Order(acc, LocalDate.now(),0,cart);
            if(OrderDB.insertOrder(order)){
             message="Thanh toán thành công";
             request.setAttribute("order",order);
            }
        }
        String url="/checkOutSuccess.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);  
    }
    private void doCheck(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        HttpSession session = request.getSession();//khai bao session
        Cart cart = (Cart)session.getAttribute("cart");
        String email =(String) session.getAttribute("email");
        session.setAttribute("cart", cart);
        String url="/confirmCheckout.jsp";
        Order order=null;
        if(email == null){
             url="/confirmCheckoutNoacc.jsp";
            request.setAttribute("checkLogin", 0);
            order= new Order(null, LocalDate.now(),0,cart);
            request.setAttribute("order",order);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
            order= new Order(acc, LocalDate.now(),0,cart);
            request.setAttribute("order",order);
        }
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
