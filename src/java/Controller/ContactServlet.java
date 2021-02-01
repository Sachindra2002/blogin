/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.Inquiry;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raaid
 */
public class ContactServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
           
            
            DAO dao = new DAO();
            
            String Username = request.getParameter("username");
            String Email = request.getParameter("emailAddress");
            int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
            String Message = request.getParameter("message");
            Date submittedDate = new Date(System.currentTimeMillis());//generate submitted date for the inquiry
            String status = "pending";
            
            Inquiry inquiry = new Inquiry(phoneNo, Username, Email, Message, submittedDate.toString(), status);//create inquiry object
            boolean isAdded = dao.addInquiry(inquiry);//check if the inquiry is sumbmitted
            
            if (isAdded) {
                RequestDispatcher rs = request.getRequestDispatcher("/inquirySuccess.html");
                rs.forward(request, response);
            } else {
                RequestDispatcher rs = request.getRequestDispatcher("/inquiryUnsuccess.html");
                rs.forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
