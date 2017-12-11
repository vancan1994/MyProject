package controller;

import data.AccountDB;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MailUtilGmail;
import util.PasswordUtil;

@WebServlet(name = "ForgetServlet", urlPatterns = {"/ForgetServlet"})
public class ForgetServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action=request.getParameter("action");
        String email=request.getParameter("email");
        String url="";
        if(action==null){
            String emailFrom="luuvancan.it@gmail.com";
        String subject="Xác nhận tạo tài khoản tài website PetsDaNang";
        String message="";
        String applicationPath="http://localhost:8080"+getServletContext().getContextPath();
        String body="<a href="+applicationPath+"/ForgetServlet?action=activation&amp;email="+email+">Click here</a>";
         try{
                MailUtilGmail.sendMail(email,emailFrom,subject, body,true);
                message="Bạn hãy vào email để xác nhận đổi mật khẩu";
                url="/thank.jsp";

            }catch(MessagingException e){
                System.out.println(e);
                message="Send mail fail";
                url="/thank.jsp";
            } 
          request.setAttribute("message", message);
         getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if(action.equals("activation")){
             url="/setPassword.jsp";
             request.setAttribute("email", email);
             getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if(action.equals("set")){
            String message="";
            String password=request.getParameter("password");
            String password1=request.getParameter("password1");
            if(password1.equalsIgnoreCase(password)){
                String passwordHash="";
                try{
                    passwordHash=PasswordUtil.hashPassword(password);
                    AccountDB.updatePassword(email, password);
                    message="Đổi mật khẩu thành công";
                }catch(NoSuchAlgorithmException e){
                        System.out.println(e);
                }
            }
            else{
                message="Mật khẩu phải trùng với nhau";
            }
            url="/setPassword.jsp";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher(url).forward(request, response);
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
