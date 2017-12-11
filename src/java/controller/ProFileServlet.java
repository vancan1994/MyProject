
package controller;
import business.Account;
import data.AccountDB;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.PasswordUtil;

@WebServlet(name = "ProFileServlet", urlPatterns = {"/ProFileServlet"})
public class ProFileServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action=request.getParameter("action");
        if(action==null)
            doViewProFile(request, response);
        else if(action.equals("update")){
            updateProFile(request, response);
        }else if(action.equals("changePassword")){
            String email=request.getParameter("email");
            Account account=AccountDB.getAccount1(email);
            request.setAttribute("email", email);
            request.setAttribute("account", account);
            String url="/changePassword.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equals("doChange")){
            doChangePassword(request, response);
        }
    }
    protected void doChangePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String url="/changePassword.jsp";
            String email=request.getParameter("email");
            String oldPassword=request.getParameter("oldPassword");
            String newPassword=request.getParameter("newPassword");
            String newPassword2=request.getParameter("newPassword2");
            String message="";
            String message1="";
            String passwordHash="";
            try{
                passwordHash=PasswordUtil.hashPassword(oldPassword);
            }catch(NoSuchAlgorithmException e){
                    System.out.println(e);
            }
            if(passwordHash.equalsIgnoreCase(AccountDB.getAccount1(email).getPassword())){
                if(newPassword.equalsIgnoreCase(newPassword2)){
                    AccountDB.updatePassword(email, newPassword);
                    message1="Thông báo, Đổi mật khẩu thành công";
                    Account account=AccountDB.getAccount1(email);
                    request.setAttribute("email", email);
                    request.setAttribute("account", account);
                }
                else{
                    message="Mật khẩu mới không trùng, vui lòng nhập lại";
                }
            }
            else{
                message="Mật khẩu cũ không đúng, Nhập lại mật khẩu cũ";
                
            }
            request.setAttribute("email", email);
            Account account=AccountDB.getAccount1(email);
            request.setAttribute("account", account);
            request.setAttribute("message",message);
            request.setAttribute("message1",message1);
            getServletContext().getRequestDispatcher(url).forward(request, response);

     }
    protected void updateProFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            String email=request.getParameter("email");
            String firstName=request.getParameter("firstname");
            String lastName=request.getParameter("lastname");
            String date=request.getParameter("birthday");
            LocalDate birthday = LocalDate.parse(date);
            String address=request.getParameter("address");
            String phone=request.getParameter("phone");
            String sexString=request.getParameter("sex");
            int sex=-1;
            if(sexString.equalsIgnoreCase("Nam")){
                sex=1;
            }else{
                sex=0;
            }
            Account account = new Account(firstName, lastName, email, phone,address,birthday, sex,2,1);
            String message="";
            if(AccountDB.updateAccount(account)){
                message="Cập nhập thành công";
            }
            else
                message="Cập nhập không thành công";
            request.setAttribute("message",message);
            doViewProFile(request, response);

     }
     protected void doViewProFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
                response.setContentType("text/html;charset=UTF-8");
                String message="";
                String email=request.getParameter("email");
                Account account=AccountDB.getAccount1(email);
                request.setAttribute("email", email);
                request.setAttribute("account", account);
                String url="/proFile.jsp";
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
