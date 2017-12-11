package controller;

import business.Posting;
import business.Product;
import data.PostingDB;
import data.ProductDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostingManagerServlet", urlPatterns = {"/PostingManagerServlet"})
public class PostingManagerServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action=request.getParameter("action");
        if(action==null){
            getPostings(request, response);
            String url="/Admin/postingManager.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if(action.equals("duyet")){
            setStatusDuyet(request, response);
            String url="/Admin/postingManager.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equals("huy")){
            setStatusHuy(request, response);
            String url="/Admin/postingManager.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
            
    }
    protected void getPostings(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
                
                String message="";
                try{
                  List<Posting>  postings=PostingDB.getPostings();
                  request.setAttribute("postings", postings);
                }catch(Exception e){
                    message="lay khong duoc danh sach";
                }
                
    }
     protected void setStatusDuyet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
                String postingIdString=request.getParameter("id");
                int postingID=Integer.parseInt(postingIdString);
                PostingDB.setStatus(postingID);
                String message="";
                try{
                  List<Posting>  postings=PostingDB.getPostings();
                  request.setAttribute("postings", postings);
                }catch(Exception e){
                    message="lay khong duoc danh sach";
                }
                
    }
     protected void setStatusHuy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
                String postingIdString=request.getParameter("id");
                int postingID=Integer.parseInt(postingIdString);
                PostingDB.setStatusHuy(postingID);
                String message="";
                try{
                  List<Posting>  postings=PostingDB.getPostings();
                  request.setAttribute("postings", postings);
                }catch(Exception e){
                    message="lay khong duoc danh sach";
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
