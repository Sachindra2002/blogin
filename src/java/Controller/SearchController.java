/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Blog;
import Model.SearchBlogger;
import Model.SearchDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "SEARCH";
            }
            switch (command) {

                case "SEARCH":
                    WideSearch(request, response);
                    break;
                case "ADMINSEARCH":
                    AdminSearch(request, response);
                    break;
                    

            }
        } catch (Exception ex) {

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void WideSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        SearchDAO dao = new SearchDAO();
        HttpSession theSession = request.getSession();

         String searchKey = "%" + request.getParameter("Keyword") + "%";
        theSession.setAttribute("Keyword", searchKey);

        List<SearchBlogger> userInfo = dao.SearchResult(searchKey);
        List<Blog> searchBlogs = dao.searchBlogs(searchKey);

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

    private void AdminSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        SearchDAO dao = new SearchDAO();
        HttpSession theSession = request.getSession();

         String searchKey = "%" + request.getParameter("Keyword") + "%";
        theSession.setAttribute("Keyword", searchKey);

        List<SearchBlogger> userInfo = dao.SearchResult(searchKey);
        List<Blog> searchBlogs = dao.searchBlogs(searchKey);

        if (userInfo.isEmpty() && searchBlogs.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminSearchNull.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("search_posts", searchBlogs);
            request.setAttribute("users_info", userInfo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminSearch.jsp");
            dispatcher.forward(request, response);
        }
    }

}
