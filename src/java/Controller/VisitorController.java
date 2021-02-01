/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Blog;
import Model.visitorDAO;
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

/**
 *
 * @author Lahiru De silva
 */
public class VisitorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String command = request.getParameter("command");
            if (command == null) {
                command = "GETPOSTS";
            }
            switch (command) {

                case "GETPOSTS":
                    GetAllPosts(request, response);
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
        

    }

    private void GetAllPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        visitorDAO dao = new visitorDAO();

        List<Blog> tendingPosts = dao.getAllTrendingPosts();
        List<Blog> FoodPosts = dao.getAllFoodPosts();
        List<Blog> MusicPosts = dao.getAllMusicPosts();
        List<Blog> FitnessPosts = dao.getAllFitPosts();
        List<Blog> TravelPosts = dao.getAllTravelPosts();
        request.setAttribute("TRENDING", tendingPosts);
        request.setAttribute("FOOD", FoodPosts);
        request.setAttribute("MUSIC", MusicPosts);
        request.setAttribute("FITNESS", FitnessPosts);
        request.setAttribute("TRAVEL", TravelPosts);

        RequestDispatcher rs = request.getRequestDispatcher("VisitorHomePage.jsp");
        rs.forward(request, response);

    }

}
