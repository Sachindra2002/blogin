/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.UserDAO;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raaid
 */
public class LoginServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            UserDAO dao = new UserDAO();
            Users user = new  Users(username, password);
            
            Users authenticatedUser = dao.authenticateUser(user);
            
            if(authenticatedUser == null)
            {
                out.print("<script type=\"text/javascript\">");
                out.print("alert('User does not exist');");
                out.print("</script>");
                request.getRequestDispatcher("login.html").include(request, response);
            }
            else
            {
                switch(authenticatedUser.getRole())
                {
                    case "member":{
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        session.setAttribute("firstName", authenticatedUser.getFirstName()); //set session attributes (First Name)
                        session.setAttribute("lastName", authenticatedUser.getLastName());
                        session.setAttribute("role","member");
                        response.sendRedirect("MemberController");
                        break;
                    }
                    case "blogger":{
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        session.setAttribute("firstName", authenticatedUser.getFirstName()); //set session attributes (First Name)
                        session.setAttribute("lastName", authenticatedUser.getLastName());
                        session.setAttribute("role","blogger");
                        response.sendRedirect("BloggerController");
                        break;
                    }
                    case "moderator":{
                        HttpSession session = request.getSession();
                        session.setAttribute("firstName", authenticatedUser.getFirstName()); //set session attributes (First Name)
                        session.setAttribute("lastName", authenticatedUser.getLastName());
                        session.setAttribute("username", username);
                        session.setAttribute("role","moderator");
                        response.sendRedirect("ModeratorServlet");
                        break;
                        
                    }
                }
                
            }   } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
