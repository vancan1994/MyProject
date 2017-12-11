package controller;

import business.Account;
import util.MailUtilGmail;
import data.AccountDB;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String url="Register/RegisterPage.jsp";
        String action=request.getParameter("action");
        if(action==null)
            getServletContext().getRequestDispatcher(url).forward(request, response);
        else if(action.equals("dangky")){
            doRegister(request, response);   
        }else if(action.equals("activation"))
            doActivation(request, response);
        
    }
    protected void doActivation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String email = request.getParameter("email");
            String message="";
            if(AccountDB.activeAccount( email)){
                
                 message ="Tài khoản: "+email+ " đã hoạt động";
            }
            else
                message="Khong set activation duoc";
            request.setAttribute("message", message);
            String url="/Register/thank.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
     }
     protected void doRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fistName=request.getParameter("ho");
        String lastName=request.getParameter("ten");
        String email=request.getParameter("email");
        String password=request.getParameter("matkhau");
        String day=request.getParameter("day");
        String month=request.getParameter("month");
        String year=request.getParameter("year");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = "1-1-2017";
        if(day=="")
            day="1";
        if(month=="")
                month="1";
        if(year=="")
                year="2017";
        int intDay=Integer.parseInt(day);
        int intMonth=Integer.parseInt(month);
        if(intDay<10)
            day="0"+day;
        if(intMonth<10)
            month="0"+month;
        
        date = day+"-"+month+"-"+year;
        LocalDate birthDay = LocalDate.parse(date,formatter);
        String gioitinhString=request.getParameter("gioitinh");
        int gioitinh=1;
        if(gioitinhString.equals("Nam")){   
        }
        else
             gioitinh=0;
         Account acc = new Account(fistName, lastName, email, password, birthDay, gioitinh,2,0);
        String url="";
        String message="";
        int t=AccountDB.insertAccount(acc);
        if(t==-1){
            message="Thông báo! Email đã được sử dụng";
            url="/Register/RegisterPage.jsp";
        }else
        if(t==1){
            // gởi link tới mail
            String subject="Xác nhận tạo tài khoản tài website PetsDaNang";
            String emailFrom="luuvancan.it@gmail.com";
            String applicationPath="http://localhost:8080"+getServletContext().getContextPath();
            String body="<a href="+applicationPath+"/RegisterServlet?action=activation&amp;email="+email+">Click here</a>";
   
            try{
                MailUtilGmail.sendMail(email,emailFrom,subject, body,true);
                message="Chúc mừng. Bạn đăng ký thành công vui lòng vào email để xác nhận";
                url="/Register/thank.jsp";

            }catch(MessagingException e){
                System.out.println(e);
                message="Send mail fail";
                url="/Register/thank.jsp";
            }
            
        }else if(t==0){
            message="Chèn thất bại";
             url="/Register/thank.jsp";
        }
         request.setAttribute("message", message);
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
