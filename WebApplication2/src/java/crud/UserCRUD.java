
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import bean.User;
import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Priya Yadav
 */
public class UserCRUD {
     Connection con = null;
   int res;
   boolean result;
   ArrayList<User> alUser = null;
   User u = null;
   
   public UserCRUD() 
    {
       con = MyConnection.myConnection();
    }
   public boolean insertUser(User user)
   {
        
      if(con != null)
      {
        try
        {
         String sql = "insert into user(name,email,password,username,mobile,type) values(?,?,?,?,?,?)";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, user.getName());
         ps.setString(2, user.getEmail());
         ps.setString(3, user.getPassword());
         ps.setString(4, user.getUsername());
         ps.setString(5, user.getMobile());
         ps.setInt(6, user.getType());
              
         res = ps.executeUpdate();  
         if(res>0)
         {
             result = true;
         }
         else
         {
             result = false;
         }
        }catch(Exception ex)
        {
            System.out.println("insert User Excep : "+ex.toString());
        }
      }
      else
      {
          System.out.println("Connection Problem...");
      }
      return result;
   }
    
    public User loginUser(String username, String password) {
          if(con != null){
              try{
                  String sql = " select* from user where username = ? and password=?";
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setString(1, username);
                  ps.setString(2, password);
                  
                   ResultSet rs = ps.executeQuery();
                   while(rs.next())
                   {
                       int id = rs.getInt("id");
                       String name = rs.getString("name");
                       String email = rs.getString("email");
                       String pass = rs.getString("password");
                       String uname = rs.getString("username");
                       String mobile = rs.getString("mobile");
                       int type=rs.getInt("type");
                       
                       u = new User(id,name,email,pass,uname,mobile,type);
                       
                   }
              }
              catch(Exception ex){
                  System.out.println("Login Exception:" +ex.toString());
              }
  
          }else
          {
              System.out.println("Connection failed.....");
          }
          return u;
    }
    
  
 }
