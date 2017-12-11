package data;

import business.Account;
import business.Posting;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class PostingDB {
    
     public static List<Posting> Search(String title,String typePosting,String category,String address){
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Select *from Posting where  PostingTitel like ? and TypePosting like ? and category like ? and Address like ?";
        List<Posting> postings=new ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setString(1,"%"+title+"%");
            ps.setString(2,"%"+typePosting+"%");
            ps.setString(3,"%"+category+"%");
             ps.setString(4,"%"+address+"%");

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String typePosting1=rs.getString("TypePosting");
                String Category=rs.getString("Category");
                String PostingTitel=rs.getString("PostingTitel");
                String description=rs.getString("description");
                String phone=rs.getString("phone");
                String address1=rs.getString("address");
                String image=rs.getString("Image");
                Date date=rs.getDate("Date");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate localDate = localDateTime.toLocalDate();
                int status=rs.getInt("Status");
                int accountID=rs.getInt("AccountID");
                Account acc= AccountDB.getAccountbyID(accountID);
                Posting p= new Posting(typePosting1, Category, PostingTitel, description, phone, address1, image, localDate, status, acc);
                postings.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return postings;
    } 
     public static boolean setStatus(int postingID){
        boolean t=false;
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "update Posting set status=1 where postingID=?";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setInt(1,postingID);
            ResultSet rs=ps.executeQuery();
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return t;
    }
     public static boolean setStatusHuy(int postingID){
        boolean t=false;
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "update Posting set status=0 where postingID=?";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setInt(1,postingID);
            ResultSet rs=ps.executeQuery();
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return t;
    }
     public static List<Posting> getPostingsUser(){
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Select *from Posting where Status=1 order by date desc";
        List<Posting> postings=new ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int postingID=rs.getInt("PostingID");
                String typePosting=rs.getString("TypePosting");
                String Category=rs.getString("Category");
                String PostingTitel=rs.getString("PostingTitel");
                String description=rs.getString("description");
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                String image=rs.getString("Image");
                Date date=rs.getDate("Date");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate localDate = localDateTime.toLocalDate();
                int status=rs.getInt("Status");
                int accountID=rs.getInt("AccountID");
                Account acc= AccountDB.getAccountbyID(accountID);
                Posting p= new Posting(postingID,typePosting, Category, PostingTitel, description, phone, address, image, localDate, status, acc);
                postings.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return postings;
    } 
     public static List<Posting> getPostings(){
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Select *from Posting  order by date desc";
        List<Posting> postings=new ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int postingID=rs.getInt("PostingID");
                String typePosting=rs.getString("TypePosting");
                String Category=rs.getString("Category");
                String PostingTitel=rs.getString("PostingTitel");
                String description=rs.getString("description");
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                String image=rs.getString("Image");
                Date date=rs.getDate("Date");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate localDate = localDateTime.toLocalDate();
                int status=rs.getInt("Status");
                int accountID=rs.getInt("AccountID");
                Account acc= AccountDB.getAccountbyID(accountID);
                Posting p= new Posting(postingID,typePosting, Category, PostingTitel, description, phone, address, image, localDate, status, acc);
                postings.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return postings;
    } 
     public static List<Posting> getPostingsOfUser(int accountID){
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Select *from Posting  where AccountID=? order by date desc";
        List<Posting> postings=new ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setInt(1, accountID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int postingID=rs.getInt("PostingID");
                String typePosting=rs.getString("TypePosting");
                String Category=rs.getString("Category");
                String PostingTitel=rs.getString("PostingTitel");
                String description=rs.getString("description");
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                String image=rs.getString("Image");
                Date date=rs.getDate("Date");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate localDate = localDateTime.toLocalDate();
                int status=rs.getInt("Status");
                Account acc= AccountDB.getAccountbyID(accountID);
                Posting p= new Posting(postingID,typePosting, Category, PostingTitel, description, phone, address, image, localDate, status, acc);
                postings.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return postings;
    } 
     public static Posting getPostingOfUser(int accountID,int postingID){
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Select *from Posting  where AccountID=? and postingID=? order by date desc";
        Posting p=null;
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setInt(1, accountID);
            ps.setInt(2, postingID);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String typePosting=rs.getString("TypePosting");
                String Category=rs.getString("Category");
                String PostingTitel=rs.getString("PostingTitel");
                String description=rs.getString("description");
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                String image=rs.getString("Image");
                Date date=rs.getDate("Date");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate localDate = localDateTime.toLocalDate();
                int status=rs.getInt("Status");
                Account acc= AccountDB.getAccountbyID(accountID);
                 p= new Posting(postingID,typePosting, Category, PostingTitel, description, phone, address, image, localDate, status, acc);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return p;
    } 
    public static boolean addPosting(Posting p){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Insert into posting values(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,p.getTypePosting());
            ps.setString(2,p.getCategory());
            ps.setString(3,p.getPostingTitle());
            ps.setString(4,p.getDescription());
            ps.setString(5,p.getPhone());
            ps.setString(6,p.getAddress());
            ps.setString(7,p.getImage());
            Date dateLocal = java.sql.Date.valueOf(p.getLocalDate());
            ps.setDate(8,dateLocal);
            ps.setInt(9,p.getStatus());
            Account acc= p.getAccount();
            int accountID=acc.getAccountID();
            ps.setInt(10,accountID);
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
    public static boolean updatePosting(Posting p){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Update  posting set TypePosting=?,Category=?,PostingTitle=?,Description=?,Phone=?,Address=?,Image=?,Date=?,Status=?,accountID=?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,p.getTypePosting());
            ps.setString(2,p.getCategory());
            ps.setString(3,p.getPostingTitle());
            ps.setString(4,p.getDescription());
            ps.setString(5,p.getPhone());
            ps.setString(6,p.getAddress());
            ps.setString(7,p.getImage());
            Date dateLocal = java.sql.Date.valueOf(p.getLocalDate());
            ps.setDate(8,dateLocal);
            ps.setInt(9,p.getStatus());
            Account acc= p.getAccount();
            int accountID=acc.getAccountID();
            ps.setInt(10,accountID);
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
