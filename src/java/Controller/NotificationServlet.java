/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Notification;
import Model.NotificationDAO;
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
public class NotificationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "NOTIFICATION";
            }
            switch (command) {

                case "NOTIFICATION":
                    notificationList(request, response);
                    break;
                case "CLEAR":
                    clearNotification(request, response);
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
                command = "NOTIFICATION";
            }
            switch (command) {

                case "NOTIFICATION":
                    notificationList(request, response);
                    break;
                case "CLEAR":
                    clearNotification(request, response);
                    break;
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void notificationList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        NotificationDAO dao = new NotificationDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        List<Notification> notis = dao.viewNoti(username);
        request.setAttribute("NOTILIST", notis);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/notficationPage.jsp");
        dispatcher.forward(request, response);
    }

    private void clearNotification(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        NotificationDAO dao = new NotificationDAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        dao.clearNotifications(username);
        notificationList(request,response);
    }

}
