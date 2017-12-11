package controller;

import business.Account;
import data.AccountDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //đên trang quản lí account;
        String action=request.getParameter("action");
        if(action==null){
            action="list";
        }
        if(action.equals("list")){
            getAccounts(request, response);
        }else if(action.equals("look")){
            doLookAccount(request, response);
        }
        else if(action.equals("unlook")){
            doUnLookAccount(request, response);
        }
    }
    protected void doUnLookAccount(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
           response.setContentType("text/html;charset=UTF-8");
           String url="/Admin/accountManager.jsp";
           String email=request.getParameter("email");
           if(AccountDB.unLookAccount(email)){
               try{
                    List<Account> accounts=AccountDB.getAccounts();
                    request.setAttribute("accounts", accounts);
               }catch(Exception e){
                    System.out.println("LOI KHO LAY DC:"+e);
                }
           }
           getServletContext().getRequestDispatcher(url).forward(request, response);
       }
     protected void doLookAccount(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
           response.setContentType("text/html;charset=UTF-8");
           String url="/Admin/accountManager.jsp";
           String email=request.getParameter("email");
           if(AccountDB.lookAccount(email)){
               try{
                    List<Account> accounts=AccountDB.getAccounts();
                    request.setAttribute("accounts", accounts);
               }catch(Exception e){
                    System.out.println("LOI KHO LAY DC:"+e);
                }
           }
           getServletContext().getRequestDispatcher(url).forward(request, response);
       }
    protected void getAccounts(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
           response.setContentType("text/html;charset=UTF-8");
           String message="";
           String url="/Admin/accountManager.jsp";
           try{
               List<Account> accounts=AccountDB.getAccounts();
               request.setAttribute("accounts", accounts);
               System.out.println(accounts);
           }catch(Exception e){
               System.out.println("LOI KHO LAY DC:"+e);
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
