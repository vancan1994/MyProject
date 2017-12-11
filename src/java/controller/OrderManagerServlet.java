
package controller;

import business.Order;
import data.OrderDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OrderManagerServlet", urlPatterns = {"/OrderManagerServlet"})
public class OrderManagerServlet extends HttpServlet {

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
            getOrders(request, response);
        }else if(action.equals("duyet")){
            doDuyetOrder(request, response);
        }
        else if(action.equals("huy")){
            doHuyOrder(request, response);
        } else if(action.equals("xem")){
            doViewDetail(request, response);
        }
    }
    protected void doViewDetail(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
           String message="";
           String url="/Admin/orderManagerDetail.jsp";
           try{
                   String orderIDStr=request.getParameter("orderID");
               int orderID=Integer.parseInt(orderIDStr);
               Order order=OrderDB.getOrder(orderID);
               request.setAttribute("order", order);
           }catch(Exception e){
               System.out.println("LOI KHO LAY DC:"+e);
           }
           getServletContext().getRequestDispatcher(url).forward(request, response);
       }
    protected void doHuyOrder(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
           response.setContentType("text/html;charset=UTF-8");
           String url="/Admin/orderManager.jsp";
           String orderIDStr=request.getParameter("orderID");
           int orderID=Integer.parseInt(orderIDStr);
           if(OrderDB.huyDuyetOrder(orderID)){
               try{
                     List<Order> orders=OrderDB.getOrders();
                     request.setAttribute("orders", orders);
               }catch(Exception e){
                    System.out.println("LOI KHO LAY DC:"+e);
                }
           }
           getServletContext().getRequestDispatcher(url).forward(request, response);
     }
      protected void doDuyetOrder(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
           response.setContentType("text/html;charset=UTF-8");
           String url="/Admin/orderManager.jsp";
           String orderIDStr=request.getParameter("orderID");
           int orderID=Integer.parseInt(orderIDStr);
           if(OrderDB.duyetOrder(orderID)){
               try{
                     List<Order> orders=OrderDB.getOrders();
                     request.setAttribute("orders", orders);
               }catch(Exception e){
                    System.out.println("LOI KHO LAY DC:"+e);
                }
           }
           getServletContext().getRequestDispatcher(url).forward(request, response);
     }
     protected void getOrders(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException { 
           String message="";
           String url="/Admin/orderManager.jsp";
           try{
               List<Order> orders=OrderDB.getOrders();
               request.setAttribute("orders", orders);
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
