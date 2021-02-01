/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.UserDAO;
import Model.Users;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
/**
 *
 * @author Sachindra Rodrigo
 */
public class UserController extends HttpServlet {

//    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
//
//final java.util.Random rand = new java.util.Random();
//
//// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
//final Set<String> identifiers = new HashSet<String>();
//public String randomIdentifier() {
//    StringBuilder builder = new StringBuilder();
//    while(builder.toString().length() == 0) {
//        int length = rand.nextInt(5)+5;
//        for(int i = 0; i < length; i++) {
//            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
//        }
//        if(identifiers.contains(builder.toString())) {
//            builder = new StringBuilder();
//        }
//    }
//    return builder.toString();
//}
//    private String getFileName(final Part part) {
//    final String partHeader = part.getHeader("content-disposition");
//    
//    for (String content : part.getHeader("content-disposition").split(";")) {
//        if (content.trim().startsWith("filename")) {
//            return content.substring(
//                    content.indexOf('=') + 1).trim().replace("\"", "");
//        }
//    }
//    return null;
//}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UserDAO dao = new UserDAO();
            PrintWriter writer = response.getWriter();
            String username = "cb" + request.getParameter("username");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String password = request.getParameter("password");
            Part filePart = request.getPart("photo");
            String role = "member";

            if (dao.checkUserExists(username)) {
                writer.print("<script type=\"text/javascript\">");
                writer.print("alert('User already exists');");
                writer.print("</script>");
//                RequestDispatcher rs = request.getRequestDispatcher("index.html");
//                rs.forward(request, response);
                request.getRequestDispatcher("index.html").include(request, response);
            } else {
                String fileName = null;
                String photo = "";
                String path = "D:\\APIIT\\NetBeansProjects\\ApiitBlogging-main\\web\\ProfileImages";
                File file = new File(path);
                file.mkdir();
                //String fileName = getFileName(filePart);
                if (filePart == null) {
                    fileName = null;
                } else {
                    fileName = username + ".jpg";
                }

                OutputStream out = null;
                InputStream filecontent = null;

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

                Users user = new Users(username, firstName, lastName, dob, email, password, photo, role);
                dao.addUser(user);
                writer.print("<script type=\"text/javascript\">");
                writer.print("alert('Account Successfully Created');");
                writer.print("</script>");
                request.getRequestDispatcher("login.html").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
