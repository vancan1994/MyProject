package controller;

import business.Account;
import business.Posting;
import business.Product;
import data.AccountDB;
import data.PostingDB;
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
@WebServlet(name = "PostingServlet", urlPatterns = {"/PostingServlet"})
public class PostingServlet extends HttpServlet {
    String email;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action=request.getParameter("action");
        String url;
        HttpSession session = request.getSession();
        email =(String) session.getAttribute("email");
         String email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
        }
        if(email==null){
            
            if(action==null){
                doListPosting(request, response);
                url="/posting.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            else if(action.equals("timkiem")){
                doListPostingSearch(request, response);
                url="/posting.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }
        else{
            if(null==action){
                doListPosting(request, response);
                url="/posting.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                
            }else {
                switch (action){
                    case "dangtin":
                    {
                        createPosting(request, response);
                        url="/createPosting.jsp";
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                        break;
                    }
                    case "taotin":
                    {
                        session = request.getSession();
                        email =(String) session.getAttribute("email");
                        Account account=AccountDB.getAccount2(email);
                        request.setAttribute("account",account);
                        request.setAttribute("checkLogin", 1);
                        url="/createPosting.jsp";
                        List<Posting>postings=PostingDB.getPostingsOfUser(account.getAccountID());
                        request.setAttribute("postings",postings);
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                        break;
                    }
                    case "timkiem":
                    {
                        doListPostingSearch(request, response);
                        url="/posting.jsp";
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                        break;
                    }
                    case "update":
                    {
                        session = request.getSession();
                        String  postingIDStr=request.getParameter("postingID");
                        int postingID=Integer.parseInt(postingIDStr);
                        
                        email =(String) session.getAttribute("email");
                        Account account=AccountDB.getAccount2(email);
                        request.setAttribute("account",account);
                        request.setAttribute("checkLogin", 1);
                        Posting p=PostingDB.getPostingOfUser(account.getAccountID(), postingID);
                        request.setAttribute("posting", p);
                        url="/updatePosting.jsp";
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                        break;
                    }
                    case "capnhap":
                    {
                        doUpdate(request, response);
                        url="/updatePosting.jsp";
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                        break;
                    }
                    
                }
            }
        }
        
    }
    protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String type=request.getParameter("type");
            String postingIDStr=request.getParameter("postingID");
            int postingID=Integer.parseInt(postingIDStr);
            String categories=request.getParameter("categories");
            String title=request.getParameter("title");
            String description=request.getParameter("description");
            String phone=request.getParameter("phone");
            String address=request.getParameter("address"); 
            Account acc= AccountDB.getAccount(email);
            request.setAttribute("account",acc);
            request.setAttribute("checkLogin", 1);
            String message="";
            Posting p = new Posting(postingID, type, categories, title, description, phone, address,acc.getEmail(), LocalDate.now(), 0,acc);
            if(PostingDB.updatePosting(p)){
               message="Cập nhập thành công";
               request.setAttribute("message",message);
            }
     }
    protected void doListPostingSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String email=request.getParameter("email");
        Account account=AccountDB.getAccount(email);
        request.setAttribute("account",account);
        String message="";
        String title=request.getParameter("title");
        String typePosting=request.getParameter("typePosting");
        if(typePosting.equals("Loại tin"))
            typePosting="";
        String category=request.getParameter("category");
        if(category.equals("Danh mục"))
            category="";
        String address=request.getParameter("address");
        if(address.equals("Quận"))
            address="";
        List<Posting> postings= PostingDB.Search(title, typePosting, category, address);
        if(postings.isEmpty()){
            message="Không tìm thấy tin";
        }
        request.setAttribute("postings", postings);
        try{
            List<Product> products=ProductDB.getProducts();
            request.setAttribute("products", products);
        }catch(Exception e){
            message="lay khong duoc danh sach";
        }
        request.setAttribute("message",message);
        
    }
    protected void doListPosting(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        email =(String) session.getAttribute("email");
        if(email == null){
            request.setAttribute("checkLogin", 0);
        } else {
            getAcount(request, response);
        }
        String message="";
        List<Posting> postings= PostingDB.getPostingsUser();
        request.setAttribute("postings", postings);
        try{
            List<Product> products=ProductDB.getProducts();
            request.setAttribute("products", products);
            
        }catch(Exception e){
            message="lay khong duoc danh sach";
        }
    }
    protected void createPosting(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String email=request.getParameter("email");
        Account account=AccountDB.getAccount2(email);
        request.setAttribute("account",account);
        
        String typePosting=request.getParameter("type");
        String categories=request.getParameter("categories");
        String title=request.getParameter("title");
        String description=request.getParameter("description");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String image="anh2";
        Posting posting = new Posting(typePosting, categories, title, description, phone, address, image, LocalDate.now(),1, account);
        List<Posting>postings=PostingDB.getPostingsOfUser(account.getAccountID());
        request.setAttribute("postings",postings);
        String message="";
        try{
            PostingDB.addPosting(posting);
            request.setAttribute("message", message);           
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    protected void  getAcount(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        email =(String) session.getAttribute("email");
        Account account=AccountDB.getAccount(email);
        request.setAttribute("account",account);
        request.setAttribute("checkLogin", 1);
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
