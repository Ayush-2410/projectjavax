

package servlet;

import bean.User;
import crud.UserCRUD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


 

/**
 *
 * @author Priya Yadav
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException   {
        PrintWriter pw = response.getWriter();
        try
        {
          String name = request.getParameter("name");
          String username = request.getParameter("username");
          String email = request.getParameter("email");
          String password = request.getParameter("password");
          String mobile = request.getParameter("mobile");
          int type = 2;    
          System.out.println(name+" : "+username+" : "+email+" : "+password+" : "+mobile+" : "+type);
          
          User user = new User(name, email,username,password,mobile, type);
          UserCRUD uc = new UserCRUD();
       boolean res = uc.insertUser(user);
       if(res)
       {
           System.out.println("Data Inserted...");
           response.sendRedirect("login.html");
       }
       else
       {
           System.out.println("Data Not Inserted...");
           response.sendRedirect("error.html");
       }
        
        }
        catch(Exception ex)
        {
            System.out.println("Register Servlet : "+ex.toString());
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
