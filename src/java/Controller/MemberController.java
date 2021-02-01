/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Blog;
import Model.DAO;
import Model.Mail;
import Model.MemberDAO;
import Model.SearchBlogger;
import Model.UserDAO;
import Model.Users;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Raaid
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
/**
 *
 * @author Sachindra Rodrigo
 */
public class MemberController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "VIEW";
            }
            switch (command) {
                case "VIEW":
                    viewMemberHomePage(request, response);
                    break;
                case "SEARCH":
                    searchResult(request, response);
                    break;
                case "SETTINGS":
                    changePersonalInfo(request, response);
                    break;
            }
        } catch (Exception ex) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "VIEW";
            }
            switch (command) {
                case "VIEW":
                    changePersonalInfo(request, response);
                    break;
                case "CHANGEPROFILEPIC":
                    changeProfilePic(request, response);
                    break;
                case "CHANGEDOB":
                    changeDOB(request, response);
                    break;
                case "CHANGEPASSWORD":
                    changePassword(request, response);
                    break;
            }
        } catch (Exception ex) {

        }
    }

    private void changePersonalInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Users user = dao.getPersonalDetails(username);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editMemberDetails.jsp");
        dispatcher.forward(request, response);
    }

    private void changeProfilePic(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            UserDAO dao = new UserDAO();
            Part filePart = request.getPart("photo");
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            String photo = "";
            String path = "D:\\APIIT\\NetBeansProjects\\ApiitBlogging-main\\web\\ProfileImages";
            File file = new File(path);
            file.mkdir();
            //String fileName = getFileName(filePart);

            String fileName = username + ".jpg";

            OutputStream out = null;
            InputStream filecontent = null;

            PrintWriter writer = response.getWriter();
            try {

                out = new FileOutputStream(new File(path + File.separator + fileName));

                filecontent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                    //photo = path + "\\" + fileName;
                    photo = "ProfileImages\\" + fileName;
                }

            } catch (Exception e) {

            }
            dao.updateProfilePic(username, photo);
            writer.print("<script type=\"text/javascript\">");
            writer.print("alert('Profile Picture successfully changed.');");
            writer.print("location='HomeRedirect';");
            writer.print("</script>");
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void changeDOB(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String date = request.getParameter("dob");
        dao.updateDOB(username, date);
        PrintWriter writer = response.getWriter();
        writer.print("<script type=\"text/javascript\">");
        writer.print("alert('Date of birth successfully changed.');");
        writer.print("location='MemberController';");
        writer.print("</script>");
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String passwordChk = request.getParameter("passwordChk");
        String password = request.getParameter("password");
        if (dao.checkPasswordCorrect(username, passwordChk)) {
            dao.updatePassword(username, password);
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            Mail mail = Mail.getMailInstance();

            String reply = "Your password was successfully updated,\n If this activity is not done by you,\n Immediately contact Blogin to safeguard your account";
            String email = "cb" + username + "@students.apiit.lk";
            mail.sendMail("Username: " + username, "Dear user,\n\n" + reply + ".\n\nBest Regards, \nTeam Blogin", email);
            PrintWriter writer = response.getWriter();
            writer.print("<script type=\"text/javascript\">");
            writer.print("alert('Password successfully changed.');");
            writer.print("location='MemberController';");
            writer.print("</script>");
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("<script type=\"text/javascript\">");
            writer.print("alert('Current password was wrong.');");
            writer.print("location='MemberController';");
            writer.print("</script>");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("passwordError.html");
//            dispatcher.forward(request, response);
        }
    }

    private void viewMemberHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        MemberDAO dao = new MemberDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        List<Blog> tendingPosts = dao.getAllTrendingPosts();
        List<Blog> followingPosts = dao.getAllFollowerPosts(username);
        request.setAttribute("TRENDING", tendingPosts);
        request.setAttribute("FOLLOWPOSTS", followingPosts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("memberHomePage.jsp");
        dispatcher.forward(request, response);

    }

    private void searchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        DAO dao = new DAO();
        HttpSession theSession = request.getSession();

        String searchKey = request.getParameter("Keyword");
        theSession.setAttribute("Keyword", searchKey);

        List<SearchBlogger> userInfo = dao.SearchResult(searchKey);
        List<Blog> searchBlogs = dao.getAllBlogPosts(searchKey);

        if (userInfo.isEmpty() && searchBlogs.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("searchBloggersNull.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("search_posts", searchBlogs);
            request.setAttribute("users_info", userInfo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WideSearch.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
