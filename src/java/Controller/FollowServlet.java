/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Model.Blog;
import Model.Follow;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Lahiru De silva
 */
public class FollowServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String userRole = (String) session.getAttribute("role");
        String follower = request.getParameter("follower");

        FollowDAO fw = new FollowDAO(Database.getConnection());
        if (fw.isFollowing(username, follower)) {
            fw.unfollow(username, follower);

        } else {
            fw.follow1(username, follower);

        }
        if (userRole.equalsIgnoreCase("blogger")) {
            ListUsers(request,response);
//            response.sendRedirect("BloggerController");
        } else if (userRole.equalsIgnoreCase("member")) {
            response.sendRedirect("MemberController");
        }
        // viewBloggerPro(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String command = request.getParameter("command");
            if (command == null) {
                ListUsers(request, response);
            }
            switch (command) {
                case "USERS":
                    ListUsers(request, response);
                    break;
                case "FOLLOW":
                    followUser(request, response);
                    break;
                case "CHECK":
                    processRequest(request, response);
                    break;
                case "VIEWPAGE":
                    viewBloggerPro(request, response);
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(FollowServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ListUsers(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        FollowDAO dao = new FollowDAO();

        List<Users> users = dao.viewAllUsers();
        request.setAttribute("USERLIST", users);

        followers(request, response);
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/followers.jsp");
        //dispatcher.forward(request, response);
    }

    private void followUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        FollowDAO dao = new FollowDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String Follow = request.getParameter("follower");
        String Status = "";

        Follow follow = new Follow(username, Follow, Status);
        dao.follow(follow);
        ListUsers(request, response);

    }

    private void followers(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        FollowDAO dao = new FollowDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        List<Users> followers = dao.viewAllFollowers(username);
        request.setAttribute("FOLLOWERSLIST", followers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/followers.jsp");
        dispatcher.forward(request, response);
    }

    private void viewBloggerPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FollowDAO dao = new FollowDAO();
        String username = request.getParameter("username");
        List<Blog> posts = dao.getAllBloggerPosts(username);
        request.setAttribute("POST_LIST", posts);
        viewUserProfile(request, response);

    }
    private void viewUserProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FollowDAO dao = new FollowDAO(Database.getConnection());
         HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        String u=request.getParameter(user);
       
        String username = request.getParameter("username");
        List<Users> posts = dao.getAllUserDetails(username);
        request.setAttribute("USER_LIST", posts);
        request.setAttribute("user", user);
        if (posts.isEmpty()) {
            RequestDispatcher rs = request.getRequestDispatcher("BloggerProfileViewNull.jsp");
            rs.forward(request, response);
        } else {
            RequestDispatcher rs = request.getRequestDispatcher("BloggerProfileView.jsp");
            rs.forward(request, response);
        }
    }

//    private void viewUserProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        FollowDAO dao = new FollowDAO();
//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("username");
//        String user = request.getParameter("username");
//        List<Users> posts = dao.getAllUserDetails(user);
//        request.setAttribute("USER_LIST", posts);
//        request.setAttribute("user",username);
//        if (posts.isEmpty()) {
//            RequestDispatcher rs = request.getRequestDispatcher("BloggerProfileViewNull.jsp");
//            rs.forward(request, response);
//        } else {
//            RequestDispatcher rs = request.getRequestDispatcher("BloggerProfileView.jsp");
//            rs.forward(request, response);
//        }
//    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
