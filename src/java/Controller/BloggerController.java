/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Blog;
import Model.BloggerDAO;
import Model.Comment;
import Model.CommentDao;
import Model.DAO;
import Model.Database;
import Model.MemberDAO;
import Model.Users;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
/**
 *
 * @author Raaid
 */
public class BloggerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String command = request.getParameter("command");
            if (command == null) {
                command = "HomePage";
            }
            switch (command) {

                case "DELETE":
                    deleteBlog(request, response);
                    break;
                case "VIEW":
                    viewBlog(request, response);
                    break;
                case "SEARCH":
                    searchBlog(request, response);
                    break;
                case "ONEBLOG":
                    viewSingleBlog(request, response);
                    break;
                case "HomePage":
                    viewHomePage(request, response);
                    break;
                case "VIEWPROFILE":
                    viewBloggerPro(request, response);
                    break;
                case "PERSONALPROFILE":
                    personalProfile(request, response);
                    break;

                case "UPGRADE":
                    accountUpgrade(request, response);
                    break;

                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(BloggerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String command = request.getParameter("command");
            if (command == null) {
                command = "ADD";
            }
            switch (command) {
                case "ADD":
                    createBlog(request, response);
                    break;
                case "UPDATE":
                    editBlog(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(BloggerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createBlog(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            PrintWriter out = response.getWriter();
            DAO dao = new DAO();

            String category = request.getParameter("Category");
            String title = request.getParameter("Title");
            String body = request.getParameter("Body");
            Date submittedDate = new Date(System.currentTimeMillis());
            String date = submittedDate.toString();
            String status = "pending";
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            Part part = request.getPart("fileToUpload");
            String fileName = randomIdentifier() + ".jpg";
            String savePath = "BlogImages" + File.separator + fileName;
            File fileSaveDir = new File(savePath);
            part.write("D:\\APIIT\\NetBeansProjects\\ApiitBlogging-main\\web\\BlogImages\\" + fileName);
            Blog blog = new Blog(username, title, body, savePath, category, date, status);
            if (dao.createBlog(blog)) {
                System.out.println("error");;
            } else {
                PrintWriter writer = response.getWriter();
                writer.print("<script type=\"text/javascript\">");
                writer.print("alert('Blog will be posted after verification');");
                writer.print("location='BloggerController';");
                writer.print("</script>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BloggerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        DAO dao = new DAO();

        String blogId = request.getParameter("blogId");
        dao.deleteBlog(blogId);
        viewBlog(request, response);

    }

    private void viewBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        DAO dao = new DAO();
        List<Blog> blogs = dao.viewBlog(username);
        request.setAttribute("BLOGLIST", blogs);
        int size = blogs.size();
        if (size == 0) {
            out.print("Empty list");
        }
        Blog likeBlog = dao.mostLikedPost(username);
        Blog commentBlog = dao.mostCommentedPost(username);
        request.setAttribute("likeBlog", likeBlog);
        request.setAttribute("commentBlog", commentBlog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewBlogs.jsp");
        dispatcher.forward(request, response);
    }

    private void editBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        DAO dao = new DAO();

        String blogId = request.getParameter("blogId");

        String category = request.getParameter("Category");
        String title = request.getParameter("Title");
        String body = request.getParameter("Body");
        dao.editBlog(title, body, category, blogId);
        viewBlog(request, response);

    }

    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    final java.util.Random rand = new java.util.Random();

    final Set<String> identifiers = new HashSet<String>();

    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public void searchBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String keyword = "%" + request.getParameter("keyword") + "%";
        DAO dao = new DAO();
        List<Blog> blogs = dao.searchBlog(username, keyword);
        request.setAttribute("BLOGLIST", blogs);
        int size = blogs.size();
        if (size == 0) {
            out.print("Empty list");
        }
        Blog likeBlog = dao.mostLikedPost(username);
        Blog commentBlog = dao.mostCommentedPost(username);
        request.setAttribute("likeBlog", likeBlog);
        request.setAttribute("commentBlog", commentBlog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewBlogs.jsp");
        dispatcher.forward(request, response);
    }

    static void viewSingleBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String BlogId = request.getParameter("blogId");
        HttpSession session = request.getSession();

        if (BlogId.equals("")) {
            BlogId = (String) session.getAttribute("blogId");
        }

        String username = (String) session.getAttribute("username");
        DAO doa = new DAO();

        List<Blog> blogs = doa.singleBlog(BlogId);
        request.setAttribute("BLOGLIST", blogs);
        request.setAttribute("user", username);
        viewAllComments(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/singleBlogView.jsp");
        dispatcher.forward(request, response);
    }

    private static void viewAllComments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PrintWriter out = response.getWriter();
        response.setContentType("Text/html");

        CommentDao dao = new CommentDao(Database.getConnection());

        // int BlogId = Integer.parseInt(request.getParameter("blogId"));
        HttpSession session = request.getSession();
        String BlogId = request.getParameter("blogId");
        if (BlogId.equals("")) {
            BlogId = (String) session.getAttribute("blogId");
        }
////
        List<Comment> comments = dao.getAllComments(BlogId);
        request.setAttribute("COM_LIST", comments);

        // response.sendRedirect("singleBlog.jsp");
        RequestDispatcher rs = request.getRequestDispatcher("/singleBlogView.jsp");
        rs.forward(request, response);

    }

    private void viewHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        BloggerDAO dao = new BloggerDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        List<Blog> tendingPosts = dao.getAllTrendingPosts();
        List<Blog> followingPosts = dao.getAllFollowerPosts(username);
        request.setAttribute("TRENDING", tendingPosts);
        request.setAttribute("FOLLOWPOSTS", followingPosts);

        RequestDispatcher rs = request.getRequestDispatcher("/BloggerHomePage.jsp");
        rs.forward(request, response);

    }

    static void viewBloggerPro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        DAO dao = new DAO();

        String username = request.getParameter("username");

        List<Blog> posts = dao.getAllBloggerPosts(username);

        request.setAttribute("POST_LIST", posts);

        if (posts.isEmpty()) {
            RequestDispatcher rs = request.getRequestDispatcher("BloggerProfileViewNull.jsp");
            rs.forward(request, response);
        } else {
            RequestDispatcher rs = request.getRequestDispatcher("BloggerProfileView.jsp");
            rs.forward(request, response);
        }
    }

    private void accountUpgrade(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("Text/html");

        MemberDAO dao = new MemberDAO();
        HttpSession session = request.getSession();
        String role = "blogger";
        String username = (String) session.getAttribute("username");
        session.setAttribute("role", role);

        Boolean isUpdated = dao.upgradeAccount(username, role);

        if (isUpdated) {

            out.print("<p style= color:white>Your account was upgraded to a Blogger account.... </p>");
            viewHomePage(request, response);
        } else {

            out.print("<p style= color:white>Sorry,Account upgrading was unsuccessfull.... </p>");
            request.getRequestDispatcher("login.html").include(request, response);
        }
    }

    private void personalProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        BloggerDAO dao = new BloggerDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        List<Users> userInfo = dao.getUserInfo(username);
        List<Blog> postsInfo = dao.getPostInfo(username);

        request.setAttribute("USER_LIST", userInfo);
        request.setAttribute("POST_LIST", postsInfo);

        RequestDispatcher rs = request.getRequestDispatcher("PersonalProfile.jsp");
        rs.forward(request, response);

    }

}
