/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import bean.User;
import crud.UserCRUD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import utils.SystemConstants;
 
/**
 *
 * @author Priya Yadav
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
    {

        try
         {
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           HttpSession session = request.getSession();
         
           
           System.out.println(username +" : "+password);
           UserCRUD uc = new UserCRUD();
           User u = uc.loginUser(username, password);
           if(u != null)
           {
            
               
               if(u.getType() == SystemConstants.ADMIN)
              {
                 
                   response.sendRedirect("adminhome.jsp"); 
                   session.setAttribute("name", u.getName());
                 
                }
              if(u.getType() == SystemConstants.USER)
              {
                
                response.sendRedirect("userhome.jsp");    
                session.setAttribute("name", u.getName());
              }
          }
          else
          {
             response.sendRedirect("error.html");
          }
           
         }
         catch(Exception ex)
         {
             System.out.println("Login Servlet Called..."+ex.toString());
         }
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
