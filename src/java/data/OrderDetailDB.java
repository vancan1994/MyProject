package data;

import business.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class OrderDetailDB {
    public static boolean insertOrderDetail(int OrderID,OrderDetail item) {
        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        String sqlString = "insert into Order_Detail values(?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, OrderID);
            ps.setString(2,item.getProduct().getProductID());
            ps.setDouble(3,item.getPrice());
            ps.setInt(4,item.getQuantity());
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
    public static boolean insertItems(int orderID,List<OrderDetail> orderDetails) {
        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        String sqlString = "insert into Order_Detail values(?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            for(OrderDetail item : orderDetails) {
                ps.setInt(1, orderID);
                ps.setString(2, item.getProduct().getProductID());
                ps.setDouble(3, item.getPrice());
                ps.setInt(4, item.getQuantity());
                ps.executeUpdate();
            }
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
}
