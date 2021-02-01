/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comment;
import Model.CommentDao;
import Model.NotificationDAO;

import Model.Database;
import Model.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
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
 * @author kanchana
 */
public class CommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "VIEWALLC";
            }
            switch (command) {

                case "COMMENT":
                    addComment(request, response);
                    break;
                case "DELETE":
                    deleteComment(request, response);
                    break;
                default:

                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(BloggerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    protected void viewAllComments(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        PrintWriter out = response.getWriter();
//        response.setContentType("Text/html");
//
//        CommentDao dao = new CommentDao(Database.getConnection());
//
//        // int BlogId = Integer.parseInt(request.getParameter("blogId"));
//        String BlogId = request.getParameter("blogId");
//
//        List<CommentDate> comments = dao.getAllComments(BlogId);
//        request.setAttribute("COM_LIST", comments);
//
//       // response.sendRedirect("test.jsp");
//        RequestDispatcher rs = request.getRequestDispatcher("/viewcomments.jsp");
//        rs.forward(request, response);
//
//    }
    protected void addComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            CommentDao dao = new CommentDao(Database.getConnection());
            Date submittedDate = new Date(System.currentTimeMillis());
            String Date = submittedDate.toString();
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            String Comment = request.getParameter("comment");
            String BlogId = request.getParameter("blogId");
            session.setAttribute("blogId", BlogId);
            Comment comment = new Comment(username, Comment, BlogId, Date);
            dao.addComment(comment);
            Notification noti = new Notification(username, request.getParameter("Author"), "commented", request.getParameter("PhotoUrl"), Date);
            NotificationDAO notiDao = new NotificationDAO();
            notiDao.notify(noti);
            
            String role = (String) session.getAttribute("role");
            if (role.equalsIgnoreCase("member")) {
                BloggerController.viewSingleBlog(request,response);
            } else if (role.equalsIgnoreCase("blogger")) {
//                response.sendRedirect("BloggerController");
              BloggerController.viewSingleBlog(request,response);
            }

        }
    }

    private void deleteComment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        CommentDao dao = new CommentDao(Database.getConnection());
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        dao.deteteComment(commentId, username);
        String role = (String) session.getAttribute("role");
        String BlogId = request.getParameter("blogId");
        session.setAttribute("blogId", BlogId);
            if (role.equalsIgnoreCase("member")) {
                 BloggerController.viewSingleBlog(request,response);
            } else if (role.equalsIgnoreCase("blogger")) {
                BloggerController.viewSingleBlog(request,response);
//                response.sendRedirect("BloggerController");
            }
    }
}
