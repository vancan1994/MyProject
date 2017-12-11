package controller;
import business.Account;
import business.Product;
import data.AccountDB;
import data.ProductDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String email;
        String password;
        if(session.getAttribute("email") != null){
            email =(String) session.getAttribute("email");
            password =(String) session.getAttribute("password");
            String message = "";
            String url="/login.jsp";
            if (email != null && password != null) {
                int t=AccountDB.isValid(email,password);
                switch (t) {
                    case 0:
                        message="Email hoặc password không dúng vui lòng nhập lại";
                        request.setAttribute("message", message);
                        break;
                    case -1:
                        message="Tài khoản chưa kích hoạt";
                        request.setAttribute("message", message);
                        break;
                    case 1:
                        url="/Admin/index.jsp";
                        break;
                    case 2:
                        session.setAttribute("email", email);
                        session.setAttribute("password", password);
                        url="/index.jsp";
                        Account acc= AccountDB.getAccount(email);
                        request.setAttribute("checkLogin", 1);
                        request.setAttribute("account",acc);
                        List<Product> products=ProductDB.getProductsByName("0001");
                        List<Product> products1=ProductDB.getProductsByName("0002");
                        request.setAttribute("products", products);
                        request.setAttribute("products1", products1);
                        break;
                    default:
                        break;
                }
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        } else {
            email = request.getParameter("txtUsername");
            password = request.getParameter("txtPassword");
            String message = "";
            String url="/login.jsp";
            Account acc= AccountDB.getAccount(email);
            if (email != null && password != null) {
                int t=AccountDB.isValid(email,password);
                switch (t) {
                    case 0:
                        message="Email hoặc password không dúng vui lòng nhập lại";
                        request.setAttribute("message", message);
                        break;
                    case -1:
                        message="Tài khoản chưa kích hoạt";
                        request.setAttribute("message", message);
                        break;
                    case 1:
                        url="/Admin/index.jsp";
                        break;
                    case 2:
                        session.setAttribute("email", email);
                        session.setAttribute("password", password);
                        url="/index.jsp";
                        request.setAttribute("checkLogin", 1);
                        request.setAttribute("account",acc);
                        List<Product> products=ProductDB.getProductsByName("0001");
                        List<Product> products1=ProductDB.getProductsByName("0002");
                        request.setAttribute("products", products);
                        request.setAttribute("products1", products1);
                        break;
                    default:
                        break;
                }
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } else {
                url="/login.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
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
