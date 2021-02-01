/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Blog;
import Model.DAO;
import Model.Inquiry;
import Model.Mail;
import Model.SearchModerator;
import Model.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sachindra Rodrigo
 */
public class ModeratorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "HOME";
            }
            switch (command) {
                 case "LIST" : viewAllInquiries(request, response);
                break;
                case "RESPOND": respondInquiries(request, response);
                break;
                case "DELETE": deleteInquiries(request, response);
                break;
                case "RESPOND_Page": respondPage(request, response);
                break;
                case "VIEW":
                    viewPendingBlogs(request, response);
                    break;
                case "ACCEPT":
                    acceptBlogs(request, response);
                    break;
                case "REJECT":
                    rejectBlogs(request, response);
                    break;
                case "VIEWACCEPTED":
                    viewAcceptedBlogs(request, response);
                    break;
                case "VIEWREJECTED":
                    viewRejectedBlogs(request, response);
                    break;
                case"HOME":
                    moderatorHome(request, response);
                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void viewPendingBlogs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        List<Blog> blogs = new ArrayList<>();
        blogs = dao.getAllPendingBlogs();
        request.setAttribute("BLOG_LIST", blogs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/verifyBlogs.jsp");
        dispatcher.forward(request, response);

    }

    private void acceptBlogs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        int blogID = Integer.parseInt(request.getParameter("blogID"));
        String status = "Accepted";
        String username = request.getParameter("username");
        dao.addAcceptedBlogs(blogID, status);
        viewPendingBlogs(request, response);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Mail mail = Mail.getMailInstance();
        
        String reply = "Your post is approved!\n Login to see your new interactions with the post";
        String email = username+"@students.apiit.lk";
        
        mail.sendMail("Blog ID: "+blogID, "Dear user,\n\n"+reply+".\n\nBest Regards, \nBlogin Team", email);
    }

    private void rejectBlogs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        int blogID = Integer.parseInt(request.getParameter("blogID"));
        String username = request.getParameter("username");
        String status = "Rejected";
        dao.addRejectedBlogs(blogID, status);
        viewPendingBlogs(request, response);
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Mail mail = Mail.getMailInstance();
        
        String reply = "Your post was removed because It does not follow our community guidelines";
        String email = username+"@students.apiit.lk";
        
        mail.sendMail("Blog ID: "+blogID, "Dear user,\n\n"+reply+".\n\nBest Regards, \nBlogin Team", email);
        
    }

    private void viewAcceptedBlogs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        List<Blog> blogs = new ArrayList<>();
        blogs = dao.getAllAcceptedBlogs();
        request.setAttribute("ACCEPTEDBLOG_LIST", blogs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/acceptedBlogs.jsp");
        dispatcher.forward(request, response);
    }

    private void viewRejectedBlogs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        List<Blog> blogs = new ArrayList<>();
        blogs = dao.getAllRejectedBlogs();
        request.setAttribute("REJECTEDBLOG_LIST", blogs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/rejectedBlogs.jsp");
        dispatcher.forward(request, response);
    }
     private void viewAllInquiries(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        PrintWriter out =  response.getWriter(); //get an object of printwriter
        response.setContentType("Text/html");//setting the resposne type to html
        DAO dao = new DAO();
        
        List <Inquiry> inquiries = dao.getAllInquiries();
        
        if(inquiries.isEmpty()){
            //check if list is empty  
            out.println("<h2 style= color:white><center>No inquiries to display</center> </h2>");//display error message to user
            request.getRequestDispatcher("/ViewInquiries.jsp").include(request, response);
        }else{
        request.setAttribute("INQ_LIST", inquiries);
        RequestDispatcher rs = request.getRequestDispatcher("ViewInquiries.jsp");
        rs.forward(request, response);
        }
        
    }
    private void respondPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        DAO dao = new DAO();
        HttpSession theSession = request.getSession();
        
        int inquiryId = ( Integer.parseInt(request.getParameter("inquiryId")));//getting the inquiryId from the web page
        theSession.setAttribute("inquiryId", inquiryId);//setting inquiryId to the session
        
        Inquiry inquiry = dao.InquiryRespond(inquiryId);//passing the inquiryid to a DAO class method
        request.setAttribute("INQ", inquiry);//setting the returning inquiry object to the INQ parameter
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/replyInquiries.jsp");
        dispatcher.forward(request, response);
        
    }
   
    
    private void respondInquiries(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        PrintWriter out = response.getWriter(); 
        response.setContentType("text/html");
        Mail mail = Mail.getMailInstance(); 
        
        int inquiryID = Integer.parseInt(request.getParameter("inquiryId"));
        String userEmail = request.getParameter("emailAddress");
        String Reply = request.getParameter("reply");
        String info = request.getParameter("message");
        //getting the required varaibles to String variables
      
        
        
        DAO dao = new DAO(); //initializing an object of the DAO class
        
         mail.sendMail("InquiryID:"+inquiryID+"-"+info,  "Dear User,\n\n Thank you for reaching us\n" +Reply + "\n\nBest Regards,\nTeam Blogin", userEmail);
         
        dao.setInquiryStatus(inquiryID);
        //passing the inquiryId to setInquiryStatus athod in the DAO class
        viewAllInquiries(request, response);
        //calling viewInquiries method
         
    }
    private void deleteInquiries(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException{
        PrintWriter out = response.getWriter(); 
        response.setContentType("text/html");
        Mail mail = Mail.getMailInstance(); 
        
        int inquiryID = Integer.parseInt(request.getParameter("inquiryId"));
        String userEmail = request.getParameter("emailAddress");
        String Reply = request.getParameter("reply");
        String info = request.getParameter("message");
        DAO dao = new DAO();
        
        int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));
        
        mail.sendMail("InquiryID:"+inquiryID+"-"+info,  "Dear User,\n\n Your Inquiry has been deleted.\n" +Reply + "\n\nBest Regards,\nTeam Blogin", userEmail);
        
        dao.deleteInquiries(inquiryId);
        
        viewAllInquiries(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void moderatorHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
         List<SearchModerator> userInfo = dao.userInfoResult(username);
         request.setAttribute("USERINFO", userInfo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ModeratorHomePage.jsp");
        dispatcher.forward(request, response);
        
    }

}
