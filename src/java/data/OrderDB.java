package data;
import business.Account;
import business.Cart;
import business.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDB {
    public static boolean insertOrder(Order order) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        boolean t = false;
        List<Order> orders = new ArrayList<>();
                
        String sqlString = "insert into orders values(?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String dateString = dtf.format(order.getDateOrder());
            ps.setInt(1,order.getAccount().getAccountID());
            ps.setString(2,dateString);
            ps.setInt(3,order.getStatus());
            ps.executeUpdate();
            int orderID = getLastOrderID();
                if(!OrderDetailDB.insertItems(orderID,order.getCart().getItems())) {
                    return false;
                }
            
            
        return t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
    public static boolean insertOrderNoName(Order order) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        boolean t = false;
        List<Order> orders = new ArrayList<>();
                
        String sqlString = "insert into orders values(?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String dateString = dtf.format(order.getDateOrder());
            ps.setInt(1,0);
            ps.setString(2,dateString);
            ps.setInt(3,order.getStatus());
            ps.executeUpdate();
            int orderID = getLastOrderID();
                if(!OrderDetailDB.insertItems(orderID,order.getCart().getItems())) {
                    return false;
                }
            
            
        return t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
    
    //get lastOrder
    public static int getLastOrderID() {
        int i = 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        String sqlString = "select Max(orderID) AS LastOrder from Orders";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                i = rs.getInt("LastOrder");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return i;
    }
    public static Order getOrder(int orderID){
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();       
        String sqlString = "select * from orders Where OrderID=?";
        Order order= new Order();
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1,orderID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int accountID = rs.getInt("accountID");
                Account acc=AccountDB.getAccountbyID(accountID);
                int status=rs.getInt("Status");
                Date orderDate = rs.getDate("date");
                String orderDateString = orderDate.toString();
                LocalDate orderDateLocal = LocalDate.parse(orderDateString);
                Cart cart =new Cart(CartDB.getCart(orderID));
                 order = new Order(orderID,acc, orderDateLocal, status, cart);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return order;
    }
    public static List<Order> getOrders(){
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();       
        String sqlString = "select * from orders";
        List<Order> orders =new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int orderID = rs.getInt("orderID");
                int accountID = rs.getInt("accountID");
                Account acc=AccountDB.getAccountbyID(accountID);
                int status=rs.getInt("Status");
                Date orderDate = rs.getDate("date");
                String orderDateString = orderDate.toString();
                LocalDate orderDateLocal = LocalDate.parse(orderDateString);
                Cart cart =new Cart(CartDB.getCart(orderID));
                Order order = new Order(orderID,acc, orderDateLocal, status, cart);
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return orders;
    }
     public static boolean huyDuyetOrder(int orderID){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="";
             sqlString = "Update Orders set Status=0 where orderID=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1,orderID);
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
    public static boolean duyetOrder(int orderID){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="";
             sqlString = "Update Orders set Status=1 where orderID=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1,orderID);
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
}
