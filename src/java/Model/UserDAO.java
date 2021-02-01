/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raaid
 */
public class UserDAO {
    
    private Connection connection;

    public UserDAO() throws SQLException {
        connection = Database.getConnection();
    }

    public boolean checkUserExists(String username) {
        boolean st = false;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }

    public void addUser(Users user) {
        try {
            PreparedStatement ps = connection.prepareStatement(" insert into users (username,firstName,lastName,dob,email,password,photoUrl,roles)" + " values (?,?,?,?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getDob());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getPhotoUrl());
            ps.setString(8, user.getRole());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Blog> getAllPendingBlogs() {
        List<Blog> blogs = new ArrayList<Blog>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs where status=?");
            ps.setString(1, "pending");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String category = rs.getString("category");
                String title = rs.getString("title");
                String body = rs.getString("body");
                String image = rs.getString("imageUrl");
                String status = rs.getString("status");
                String username = rs.getString("username");
                int blogID = rs.getInt("blogId");
                Blog allblogs = new Blog(category, title, body, image, status, username, blogID);
                blogs.add(allblogs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return blogs;
    }

    public void addAcceptedBlogs(int blogId, String status) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE blogs SET status=? WHERE blogId=?");
            ps.setString(1, status);
            ps.setInt(2, blogId);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();   
        }
    }

    public void addRejectedBlogs(int blogID, String status) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE blogs SET status=? WHERE blogID=?");
            ps.setString(1, status);
            ps.setInt(2, blogID);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Blog> getAllAcceptedBlogs() {
        List<Blog> blogs = new ArrayList<Blog>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs where status=?");
            ps.setString(1, "Accepted");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String category = rs.getString("category");
                String title = rs.getString("title");
                String body = rs.getString("body");
                String image = rs.getString("imageUrl");
                String status = rs.getString("status");
                String username = rs.getString("username");
                int blogID = rs.getInt("blogId");
                Blog allblogs = new Blog(category, title, body, image, status, username, blogID);
                blogs.add(allblogs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return blogs;
    }

    public List<Blog> getAllRejectedBlogs() {
        List<Blog> blogs = new ArrayList<Blog>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs where status=?");
            ps.setString(1, "Rejected");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String category = rs.getString("category");
                String title = rs.getString("title");
                String body = rs.getString("body");
                String image = rs.getString("imageUrl");
                String status = rs.getString("status");
                String username = rs.getString("username");
                int blogID = rs.getInt("blogId");
                Blog allblogs = new Blog(category, title, body, image, status, username, blogID);
                blogs.add(allblogs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return blogs;
    }

    public Users getPersonalDetails(String username) {
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT username, firstname, lastname, email, dob, photourl, password FROM users WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String USERNAME = rs.getString("username");
                String FIRSTNAME = rs.getString("firstName");
                String LASTNAME = rs.getString("lastName");
                String EMAIL = rs.getString("email");
                String DOB = rs.getString("dob");
                String IMAGE = rs.getString("photoUrl");
                String PASSWORD = rs.getString("password");
                Users user = new Users(USERNAME,FIRSTNAME,LASTNAME,DOB,EMAIL,PASSWORD, IMAGE);
                return user;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateProfilePic(String username, String photo) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET photoUrl=? WHERE username=?");
            ps.setString(1, photo);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateDOB(String username, String date) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET dob=? WHERE username=?");
            ps.setString(1, date);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkPasswordCorrect(String username, String password) {
        boolean st = false;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }

    public void updatePassword(String username, String password) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET password=? WHERE username=?");
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public Users authenticateUser(Users user) {
        Users validatedUser;
        try{
            PreparedStatement ps = connection.prepareStatement("select username,firstName, lastName, password, roles from users where username=? and password=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                String username = rs.getString("username");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String password = rs.getString("password");
                String role = rs.getString("roles");
                
                if(username.equalsIgnoreCase(user.getUsername()) && password.equalsIgnoreCase(user.getPassword()) && role.equals("member"))
                {
                    validatedUser = new Users(firstName, lastName, role);
                    return validatedUser;
                }
                else if(username.equalsIgnoreCase(user.getUsername()) && password.equalsIgnoreCase(user.getPassword()) && role.equals("blogger"))
                {
                    validatedUser = new Users(firstName, lastName, role);
                    return validatedUser;
                }
                else if(username.equalsIgnoreCase(user.getUsername()) && password.equalsIgnoreCase(user.getPassword()) && role.equals("moderator"))
                {
                    validatedUser = new Users(firstName, lastName, role);
                    return validatedUser;
                }
            }
        }catch(Exception ex){
            System.out.println("Error Authenticating User: " + ex);
        }
        return null;
   }
    
}
