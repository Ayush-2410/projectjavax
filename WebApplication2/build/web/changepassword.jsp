 
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         
try{
Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/music_db","root","Aditya@92");
 PreparedStatement ps = con.prepareStatement("update user set password=? where  email=?");
 ps.setString(2,email);
 ps.setString(1,password);
 int i=ps.executeUpdate();
 if(i>0){
 response.sendRedirect("login.html");
            }
            else{
            response.sendRedirect("error.html");
            }
   }
   catch(Exception ex){
            }
        %>
    </body>
</html>