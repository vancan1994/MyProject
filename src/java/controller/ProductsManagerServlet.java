package controller;

import business.Product;
import data.ProductDB;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductsManagerServlet", urlPatterns = {"/ProductsManagerServlet"})
public class ProductsManagerServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action=request.getParameter("action");
        if(action==null){
            getProducts(request, response);
        }else if(action.equals("add")){
            doAdd(request, response);
        }else if(action.equals("delete")){
            doDelete(request, response);
        }else if(action.equals("edit")){
            doEdit(request, response);
        }else if(action.equals("update")){
            doUpdate(request, response);
        }
    }
      protected void doEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
                
                String message="";
                String productID=request.getParameter("productID");
               
                try{
                    Product p=ProductDB.getProduct(productID);
                    request.setAttribute("product",p);
                }catch(Exception e){
                    System.out.println("Loi day: "+e);
                }
                try{
                List<Product> products=ProductDB.getProducts();
                    request.setAttribute("products", products);
                }catch(Exception e){
                    System.out.println("Loi day: "+e);
                }
                request.setAttribute("message",message);
                String url="/Admin/EditProduct.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
    }
      protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String productID=request.getParameter("productID");
            String productName=request.getParameter("productName");
            String priceString=request.getParameter("price");
            double price=Double.parseDouble(priceString);
            String description=request.getParameter("description");
            String image=request.getParameter("image");
            String image1=request.getParameter("image1");
            String image2=request.getParameter("image2");
            String image3=request.getParameter("image3");
            String image4=request.getParameter("image4");
            String categoryID=request.getParameter("categoryID");  
            Product p= new Product(productID,categoryID, productName, price, description, image, image1, image2, image3, image4);
            String message="";
            if(ProductDB.updateProduct(p)){
                message="Cập nhập thành công";
            }
            else
                message="Cập nhập không thành công";
            try{
                List<Product> products=ProductDB.getProducts();
                request.setAttribute("products", products);
            }catch(Exception e){
                System.out.println("Loi day: "+e);
            }
            request.setAttribute("message",message);
            String url="/Admin/productsManager.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

     }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
                
                String message="";
                String productID=request.getParameter("productID");
                if(ProductDB.deleteProduct(productID))
                    message="Xoá thành công";
                else{
                    message="Xoá không thành công";
                } 
                try{
                List<Product> products=ProductDB.getProducts();
                    request.setAttribute("products", products);
                }catch(Exception e){
                    System.out.println("Loi day: "+e);
                }
                request.setAttribute("message",message);
                String url="/Admin/productsManager.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String productName=request.getParameter("productName");
            String priceString=request.getParameter("price");
            double price=Double.parseDouble(priceString);
            String description=request.getParameter("description");
            String image=request.getParameter("image");
            String image1=request.getParameter("image1");
            String image2=request.getParameter("image2");
            String image3=request.getParameter("image3");
            String image4=request.getParameter("image4");
            String categoryID=request.getParameter("categoryID");
            Product p= new Product(categoryID, productName, price, description, image, image1, image2, image3, image4);
            String message="";
            if(ProductDB.addProduct(p)){
                message="Thêm thành công";
            }
            else
                message="Thêm không thành công";
            try{
                List<Product> products=ProductDB.getProducts();
                request.setAttribute("products", products);
            }catch(Exception e){
                System.out.println("Loi day: "+e);
            }
            request.setAttribute("message",message);
            String url="/Admin/productsManager.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

     }
     protected void getProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
                String url="/Admin/productsManager.jsp";
                String message="";
                List<Product> products= new ArrayList<>();
                try{
                    products=ProductDB.getProducts();
                    request.setAttribute("products", products);
                }catch(Exception e){
                    message="lay khong duoc danh sach";
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
