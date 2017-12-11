package data;

import business.Account;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import util.PasswordUtil;

public class AccountDB {
     public static boolean updateAccount(Account acc){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Update Accounts set fistName=?,lastName=?,Birthday=?,Sex=?,RoleID=?,Status=?,Phone=?,Address=? where email=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,acc.getFirstName());
            ps.setString(2,acc.getLastName());
            LocalDate localDate=acc.getBirthday();
            Date birthday = Date.valueOf(localDate); 
            ps.setDate(3,birthday);
            ps.setInt(4,acc.getSex());
            ps.setInt(5,acc.getRoleID());
            ps.setInt(6,acc.getStatus());
            ps.setString(7,acc.getPhone());
            ps.setString(8,acc.getAddress());
            ps.setString(9,acc.getEmail());
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
      public static boolean updatePassword(String email,String password){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Account acc=getAccount(email);
        String sqlString="";

             sqlString = "Update Accounts set password=? where email=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
             String passwordHash="";
            try{
                passwordHash=PasswordUtil.hashPassword(password);
            }catch(NoSuchAlgorithmException e){
                    System.out.println(e);
            }
            ps.setString(1,passwordHash);
            ps.setString(2,email);
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
    public static boolean unLookAccount(String email){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Account acc=getAccount(email);
        String sqlString="";
             sqlString = "Update Accounts set Status=1 where email=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,email);
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
    public static boolean lookAccount(String email){
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Account acc=getAccount(email);
        String sqlString="";
             sqlString = "Update Accounts set Status=0 where email=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,email);
            ps.executeUpdate();
            t=true;
        }catch(SQLException e){
             System.out.println("Xem LOI sql" +e);
         }finally{
             pool.freeConnection(con);
         }
        return t;
    }
     public static Account getAccount1(String email){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Account acc=null;
        String sqlString = "Select *from Accounts where email=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String firstName=rs.getString("fistName");
                String lastName=rs.getString("lastName");
                Date date=rs.getDate("birthday");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate birthday = localDateTime.toLocalDate();
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                int sex=rs.getInt("sex");
                int roleID=rs.getInt("roleID");
                int status=rs.getInt("Status");
                String password=rs.getString("Password");
                acc= new Account(firstName, lastName, email,password,phone,address, birthday,sex,roleID,status);               
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return acc;
    }
    
    public static Account getAccountbyID(int accountID){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Account acc=null;
        String sqlString = "Select *from Accounts where AccountID=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1,accountID);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String firstName=rs.getString("fistName");
                String lastName=rs.getString("lastName");
                String email = rs.getString("email");
                Date date=rs.getDate("birthday");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate birthday = localDateTime.toLocalDate();
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                int sex=rs.getInt("sex");
                int roleID=rs.getInt("roleID");
                int status=rs.getInt("Status");
                acc= new Account(accountID, firstName, lastName, email, phone, phone, address, birthday, sex, roleID, status);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return acc;
    }
    public static Account getAccount2(String email){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Account acc=null;
        String sqlString = "Select *from Accounts where email=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int accountID=rs.getInt("AccountID");
                String firstName=rs.getString("fistName");
                String lastName=rs.getString("lastName");
                Date date=rs.getDate("birthday");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate birthday = localDateTime.toLocalDate();
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                int sex=rs.getInt("sex");
                int roleID=rs.getInt("roleID");
                int status=rs.getInt("Status");
                acc= new Account(accountID, firstName, lastName, email, phone, phone, address, birthday, sex, roleID, status);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return acc;
    }
     
    public static Account getAccount(String email){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        Account acc=null;
        String sqlString = "Select *from Accounts where email=?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String firstName=rs.getString("fistName");
                String lastName=rs.getString("lastName");
                Date date=rs.getDate("birthday");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate birthday = localDateTime.toLocalDate();
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                int sex=rs.getInt("sex");
                int roleID=rs.getInt("roleID");
                int status=rs.getInt("Status");
                acc= new Account(firstName, lastName, email,phone,address, birthday,sex,roleID,status);               
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return acc;
    }
    public static List<Account> getAccounts(){
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Select *from Accounts where roleID=2";
        List<Account> accounts= new  ArrayList<>();
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String firstName=rs.getString("fistName");
                String lastName=rs.getString("lastName");
                String email=rs.getString("email");
                String password=rs.getString("password");
                Date date=rs.getDate("birthday");
                Instant instant = Instant.ofEpochMilli(date.getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate birthday = localDateTime.toLocalDate();
                int sex=rs.getInt("sex");
                int roleID=rs.getInt("roleID");
                int status=rs.getInt("Status");
                Account acc= new Account(firstName, lastName, email, password, birthday,sex,roleID,status);
                accounts.add(acc);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return accounts;
    }
    public static boolean checkEmail(String email){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Select *from Accounts where email=?";
        boolean t=true;
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
               t=false;
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
             pool.freeConnection(con);
         }
        return t;
    }
     public static int insertAccount(Account acc){
        int t=0;
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Insert into Accounts values(?,?,?,?,?,?,?,?,2,0)";
        if(checkEmail(acc.getEmail())){
            try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setString(1,acc.getFirstName());
            ps.setString(2,acc.getLastName());  
            ps.setString(3,acc.getEmail());
            String password=acc.getPassword();
            String passwordHash="";
            try{
                passwordHash=PasswordUtil.hashPassword(password);
            }catch(NoSuchAlgorithmException e){
                    System.out.println(e);
            }
            ps.setString(4,passwordHash);
            ps.setString(5,"");
            ps.setString(6,"");
            Date date = java.sql.Date.valueOf(acc.getBirthday());
            ps.setDate(7,date);
            ps.setInt(8,acc.getSex());     
            ps.executeUpdate();
            t=1;
            }catch(SQLException e){
               System.out.println(e);
           }finally{
                pool.freeConnection(con);
           }
        }else{
            t=-1;
        }
         return t;
    }
        public static boolean activeAccount(String email){
         boolean t= false;
         ConnectionPool pool = ConnectionPool.getInstance();
         Connection con= pool.getConnection();
         String sqlString ="Update Accounts set Status=1 where email=?";
         try{
            PreparedStatement ps= con.prepareStatement(sqlString);
            ps.setString(1,email);
            ps.executeUpdate();
            t=true;
         }catch(SQLException e){
             System.out.println(e);
         }finally{
             pool.freeConnection(con);
         }
         return t;
    }
        public static int isValid(String email,String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
            int index = 0;
        String sqlString = "select email, [password],roleID,Status from accounts where email =? and password=?";
        try {
            ps = con.prepareStatement(sqlString);
            ps.setString(1,email);
            String passwordHash="";
            try{
                passwordHash=PasswordUtil.hashPassword(password);
            }catch(NoSuchAlgorithmException e){
                    System.out.println(e);
            }
            ps.setString(2,passwordHash);
            ResultSet rs = ps.executeQuery();
             if(rs.next()) {
                if(rs.getInt("Status")==1){
                    if(rs.getInt("roleID")==1)
                        index=1;
                    else if(rs.getInt("roleID")==2)
                            index=2;
                }
                else{
                    index=-1;
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             pool.freeConnection(con);
         }
        return index;
    }
}
