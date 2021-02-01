/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raaid
 */
public class HomeRedirect extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
       String userRole = (String) session.getAttribute("role");
       if(userRole.equalsIgnoreCase("blogger"))
       {
           response.sendRedirect("BloggerController");
       }
       else if(userRole.equalsIgnoreCase("member"))
       {
           response.sendRedirect("MemberController");
       }
       else if(userRole.equalsIgnoreCase("moderator"))
       {
           response.sendRedirect("ModeratorServlet");
       }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
