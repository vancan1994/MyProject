package data;

import business.Product;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    public static boolean updateProduct(Product p){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Update Products set ProductName=?,Price=?,Description=?,Image=?,Image1=?,Image2=?,Image3=?,Image4=?,DateCreate=getdate() where ProductID=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,p.getProductName());
            ps.setDouble(2,p.getPrice());
            ps.setString(3,p.getDescription());
            ps.setString(4,p.getImage());
            ps.setString(5,p.getImage1());
            ps.setString(6,p.getImage2());
            ps.setString(7,p.getImage3());
            ps.setString(8,p.getImage4());
            ps.setString(9,p.getProductID());
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
    public static Product getProductName(String productName){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Product p=null;
        String sqlString = "Select *from Products where productName=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,productName);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                String categoryID=rs.getString("CategoryID");
                String productID=rs.getString("ProductID");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                p =  new Product(productID, categoryID, productName, price, description, image, image1, image2, image3, image4,date);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return p;
    }
    public static Product getProduct(String productID){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Product p=null;
        String sqlString = "Select *from Products where productID=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,productID);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                p =  new Product(productID, categoryID, productName, price, description, image, image1, image2, image3, image4,date);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return p;
    }
    public static boolean deleteProduct(String productID){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Delete Products where productID=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,productID);
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
    public static boolean addProduct(Product p){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Insert into Products values(?,?,?,?,?,?,?,?,?,getdate(),1)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,p.getCategoryID());
            ps.setString(2,p.getProductName());
            ps.setDouble(3,p.getPrice());
            ps.setString(4,p.getDescription());
            ps.setString(5,p.getImage());
            ps.setString(6,p.getImage1());
            ps.setString(7,p.getImage2());
            ps.setString(8,p.getImage3());
            ps.setString(9,p.getImage4());
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
    
    public static List<Product> getDogProducts(){
        List<Product> products = new ArrayList<>();
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="select *from Products where CategoryID=0001";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int productID=rs.getInt("ProductID");
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                Product p =  new Product(Integer.toString(productID), categoryID, productName, price, description, image, image1, image2, image3, image4,date);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return products;
    }
    public static List<Product> getCatProducts(){
        List<Product> products = new ArrayList<>();
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="select *from Products where CategoryID=0002";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int productID=rs.getInt("ProductID");
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                Product p =  new Product(Integer.toString(productID), categoryID, productName, price, description, image, image1, image2, image3, image4,date);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return products;
    }
    public static List<Product> getHamsterProducts(){
        List<Product> products = new ArrayList<>();
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="select *from Products where CategoryID=0003";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int productID=rs.getInt("ProductID");
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                Product p =  new Product(Integer.toString(productID), categoryID, productName, price, description, image, image1, image2, image3, image4,date);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return products;
    }
    
    public static List<Product> getOtherProducts(){
        List<Product> products = new ArrayList<>();
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="select *from Products where CategoryID=0004";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int productID=rs.getInt("ProductID");
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                Product p =  new Product(Integer.toString(productID), categoryID, productName, price, description, image, image1, image2, image3, image4,date);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return products;
    }
    
     public static List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="select *from Products";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String productID=rs.getString("ProductID");
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                Product p =  new Product(productID, categoryID, productName, price, description, image, image1, image2, image3, image4,date);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return products;
    }
     public static List<Product> getProductsByName(String category){
        List<Product> products = new ArrayList<>();
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString=null;
        if(category.equals("0001")){
             sqlString="select *from Products where CategoryID=0001";
        }else if(category.equals("0002")){
             sqlString="select *from Products where CategoryID=0002";
        }else if(category.equals("0003")){
             sqlString="select *from Products where CategoryID=0003";
        }else if(category.equals("0004")){
             sqlString="select *from Products where CategoryID=0004";
        }
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String productID=rs.getString("ProductID");
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                Product p =  new Product(productID, categoryID, productName, price, description, image, image1, image2, image3, image4,date);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return products;
    }
      public static List<Product> getProducts(String search){
        List<Product> products = new ArrayList<>();
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString="select *from Products where ProductName like ? ";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setString(1,"%"+search+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String productID=rs.getString("ProductID");
                String categoryID=rs.getString("CategoryID");
                String productName=rs.getString("ProductName");
                double price=rs.getFloat("Price");
                String description=rs.getString("Description");
                String image=rs.getString("Image");
                String image1=rs.getString("Image1");
                String image2=rs.getString("Image2");
                String image3=rs.getString("Image3");
                String image4=rs.getString("Image4");
                Date date=rs.getDate("DateCreate");
                Product p =  new Product(productID, categoryID, productName, price, description, image, image1, image2, image3, image4,date);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return products;
    }
}
