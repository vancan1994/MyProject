
package data;

import business.OrderDetail;
import business.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDB {
    public static List<OrderDetail> getCart(int orderID){
        List<OrderDetail> orderDetails = new ArrayList<>();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        String sqlString = "select * from Order_Detail  where OrderID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String productID=rs.getString("productID");
                double price=rs.getDouble("price");
                int quantity=rs.getInt("Quantity_Detail");
                Product p= ProductDB.getProduct(productID);
                OrderDetail detail= new OrderDetail(orderID,p, quantity, price);
                orderDetails.add(detail);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return orderDetails;
    }
}
