/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
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
public class DAO {

    private final Connection connection;

    public DAO() throws SQLException {
        connection = Database.getConnection();
    }

    public boolean createBlog(Blog blog) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into blogs(title,body,imageUrl,username,category,date,status,likeCount,commentCount)" + "values(?,?,?,?,?,?,?,?,?)");

            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getBody());
            ps.setString(3, blog.getImageURL());
            ps.setString(4, blog.getCategory());
            ps.setString(5, blog.getAuthor());
            ps.setString(6, blog.getDate());
            ps.setString(7, blog.getStatus());
            ps.setInt(8, 2);
            ps.setInt(9, 2);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
        return false;

    }

    public Blog mostLikedPost(String username) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs where username=? ORDER BY likeCount DESC ;");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        rs.next();

        int blogId = rs.getInt("blogId");
        String title = rs.getString("title");
        String body = rs.getString("body");
        String imageUrl = rs.getString("imageUrl");
        String category = rs.getString("category");
        String author = rs.getString("username");
        String date = rs.getString("date");
        Blog myBlog = new Blog(blogId, category, title, body, imageUrl, author, date);
        return myBlog;
    }

    public Blog mostCommentedPost(String username) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM blogs where username=? ORDER BY commentCount DESC ;");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        rs.next();

        int blogId = rs.getInt("blogId");
        String title = rs.getString("title");
        String body = rs.getString("body");
        String imageUrl = rs.getString("imageUrl");
        String category = rs.getString("category");
        String author = rs.getString("username");
        String date = rs.getString("date");
        Blog myBlog = new Blog(blogId, category, title, body, imageUrl, author, date);

        return myBlog;
    }

    public void deleteBlog(String blogId) throws IOException {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from blogs where blogId=?");
            ps.setString(1, blogId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String imageUrl = rs.getString("imageUrl");
            }

            ps = connection.prepareStatement("delete from blogs where blogId=?");
            ps.setString(1, blogId);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Blog> viewBlog(String username) throws SQLException {
        List<Blog> blogs = new ArrayList<Blog>();
        PreparedStatement ps = connection.prepareStatement("select * from blogs where username=?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int blogId = rs.getInt("blogId");
            String title = rs.getString("title");
            String body = rs.getString("body");
            String imageUrl = rs.getString("imageUrl");
            String category = rs.getString("category");
            String author = rs.getString("username");
            String date = rs.getString("date");
            Blog myBlog = new Blog(blogId, category, title, body, imageUrl, author, date);
            blogs.add(myBlog);
        }
        return blogs;
    }

    public void editBlog(String title, String body, String category, String blogId) {
        try {
            PreparedStatement ps = connection.prepareStatement("update blogs set title = ?,body = ?,category = ? where blogId = ?");
            ps.setString(1, title);
            ps.setString(2, body);
            ps.setString(3, category);
            ps.setString(4, blogId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {

            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Blog> searchBlog(String username,String keyword) throws SQLException
       {List<Blog> blogs = new ArrayList<Blog>();
        PreparedStatement ps = connection.prepareStatement("select * from blogs where username= ? and  title like ? or category like ? or date like ?");
        ps.setString(1, username);
        ps.setString(2, keyword);
        ps.setString(3,keyword);
        ps.setString(4,keyword);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int blogId = rs.getInt("blogId");
            String title = rs.getString("title");
            String body = rs.getString("body");
            String imageUrl = rs.getString("imageUrl");
            String category = rs.getString("category");
            String author = rs.getString("username");
            String date = rs.getString("date");
            Blog myBlog = new Blog( blogId, category, title, body,  imageUrl, author,date);
            if (author.equalsIgnoreCase(username))
            {
                blogs.add(myBlog);
            }
            
        }
        return blogs;
           
       }

    public List<Blog> singleBlog(String blogId) throws SQLException {
        List<Blog> blogs = new ArrayList<Blog>();
        PreparedStatement ps = connection.prepareStatement("select * from blogs where blogId=?");
        ps.setString(1, blogId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
//            int blogId = rs.getInt("blogId");
            String title = rs.getString("title");
            String body = rs.getString("body");
            String imageUrl = rs.getString("imageUrl");
            String category = rs.getString("category");
            String author = rs.getString("username");
            String date = rs.getString("date");
            Blog myBlog = new Blog(Integer.parseInt(blogId), category, title, body, imageUrl, author, date);
            blogs.add(myBlog);
        }
        return blogs;
    }

    public boolean addInquiry(Inquiry inquiry) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into inquiry(userName,email, phoneNo, message, submittedDate, status) values(?, ?, ?, ?, ?, ?)");
            //creating an object of the PreparedStatement API and passing the sql INSERT query to it
            ps.setString(1, inquiry.getUserName());//set values into the inquiry table
            ps.setString(2, inquiry.getEmail());
            ps.setInt(3, inquiry.getPhoneNo());
            ps.setString(4, inquiry.getMessage());
            ps.setString(5, inquiry.getSubmittedDate());
            ps.setString(6, inquiry.getStatus());

            ps.executeUpdate();//execute the above setString statements
            return true; //when insertion is done, return true to the calling class

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;//if insertion not done, return false to the calling class

    }

    public List<Inquiry> getAllInquiries() {
        List<Inquiry> inquiries = new ArrayList<Inquiry>();
        try {
            //create sql statement
            PreparedStatement ps = connection.prepareStatement("select inquiryId, userName, email, phoneNo, message, submittedDate, status from inquiry where status=?");

            ps.setString(1, "pending");

            ResultSet rs = ps.executeQuery();//execute query
            while (rs.next()) {
                int InquiryId = rs.getInt("inquiryId");
                String UserName = rs.getString("userName");
                String Email = rs.getString("email");
                int PhoneNo = rs.getInt("phoneNo");
                String Message = rs.getString("message");
                String submittedDate = rs.getString("submittedDate");
                String Status = rs.getString("status");

                Inquiry myInquiry = new Inquiry(InquiryId, UserName, Email, PhoneNo, Message, submittedDate, Status);
                inquiries.add(myInquiry);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inquiries;
    }

    public Inquiry InquiryRespond(int inquiryId) {
        Inquiry inquiry = null;
        //initializing an inquiry object

        try {
            PreparedStatement ps = connection.prepareStatement("select inquiryId,userName,email,phoneNo,message,submittedDate from inquiry where inquiryId=?");
            //creating an object of the PreparedStatement API and passing the sql SELECT query to it to retrieve the details needed
            ps.setInt(1, inquiryId);
            //setting the inquiryId to the preparedStatement variable
            ResultSet rs = ps.executeQuery();
            //executing the preparedStatement and catching the return in a ResultSet object

            while (rs.next()) {

                String UserName = rs.getString("userName");
                String Email = rs.getString("email");
                int PhoneNo = rs.getInt("phoneNo");
                String Message = rs.getString("message");
                String submittedDate = rs.getString("submittedDate");
                int InquiryId = rs.getInt("inquiryId");
                //getting the values from the ResultSet object to String variables

                inquiry = new Inquiry(UserName, Email, PhoneNo, Message, submittedDate, InquiryId);
                //instantiating a Inquiry object with the String varibales

                return inquiry;

            }
        } catch (Exception e) {
            System.out.println(e);
            //printing error(if any)
        }
        return inquiry;
        //returning the inquiry object
    }

    public void setInquiryStatus(int inquiryID) {
        //this method is used to set the status of an inquiry to replied
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update inquiry set status = ? where inquiryId = ?");
            preparedStatement.setString(1, "Replied");
            preparedStatement.setInt(2, inquiryID);
            //setting the necessary values to the PreparedStatement object
            preparedStatement.executeUpdate();
            //executing the preparedStatement

        } catch (Exception ex) {
            System.out.println("employee didn't delete dao" + ex);
        }
    }

    public void deleteInquiries(int inquiryId) {

        try {
            PreparedStatement ps = connection.prepareStatement("delete from inquiry where inquiryId= ?");
            ps.setInt(1, inquiryId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<SearchBlogger> SearchResult(String searchKey) throws SQLException {
        List<SearchBlogger> userInfo = new ArrayList<SearchBlogger>();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from users inner join followers where follower.username!=users.username users.roles=? and users.firstName=? or users.lastname=? or users.username=?");
        //preparedStateement to execute the SQL query

        preparedStatement.setString(1, "blogger");
        preparedStatement.setString(2, searchKey);
        preparedStatement.setString(3, searchKey);
        preparedStatement.setString(4, searchKey);
        ResultSet rs = preparedStatement.executeQuery();
        //executing the preparedStatement objetc

        while (rs.next()) {
            //while the ResultSet object has another value in the set, this while loop will get executed
            String Username = rs.getString("username");
            String LastName = rs.getString("lastName");
            String PhotoUrl = rs.getString("photoUrl");
            String firstName = rs.getString("firstName");
            //getting all the values in the ResultSet object separately into String variables

            SearchBlogger theuserInfo = new SearchBlogger(Username, firstName, PhotoUrl, LastName);

            userInfo.add(theuserInfo);

        }
        return userInfo;

    }

    public List<Blog> getAllBloggerPosts(String username) throws SQLException {
        List<Blog> posts = new ArrayList<Blog>();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where username=?and status=?");
        //preparedStateement to execute the SQL query
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, "Accepted");
        ResultSet rs = preparedStatement.executeQuery();
        //executing the preparedStatement objetc

        while (rs.next()) {
            //while the ResultSet object has another value in the set, this while loop will get executed
            int BlogId = rs.getInt("blogId");
            String Title = rs.getString("title");
            String imageURL = rs.getString("imageUrl");
            String userName = rs.getString("username");
            String Category = rs.getString("category");
            String Body = rs.getString("body");
            String date = rs.getString("date");
            int likeCount = rs.getInt("likeCount");
            int commentCount = rs.getInt("commentCount");

            //getting all the values in the ResultSet object separately into String variables
            Blog postsList = new Blog(Category, Title, Body, imageURL, userName, BlogId, date, likeCount, commentCount);
            //instantiating object with the String varibales

            posts.add(postsList);
            //adding the object to the ArrayList

        }
        return posts;
    }

    public List<SearchModerator> userInfoResult(String username) throws SQLException {
        List<SearchModerator> user = new ArrayList<SearchModerator>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username=? and roles=?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, "moderator");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String Fname = rs.getString("firstName");
            String Lname = rs.getString("lastName");
            String userName = rs.getString("username");
            String Email = rs.getString("email");
            String Photo = rs.getString("photoUrl");
            String role = rs.getString("roles");
            SearchModerator theuser = new SearchModerator(Fname, Lname, userName, Email, Photo, role);
            user.add(theuser);
        }
        return user;
    }

    public List<Blog> getAllBlogPosts(String searchKey) throws SQLException {
        List<Blog> posts = new ArrayList<Blog>();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where status=? and title=? or body=?");
        preparedStatement.setString(1, "Accepted");
        preparedStatement.setString(2, searchKey);
        preparedStatement.setString(3, searchKey);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            //while the ResultSet object has another value in the set, this while loop will get executed
            int BlogId = rs.getInt("blogId");
            String Title = rs.getString("title");
            String imageURL = rs.getString("imageUrl");
            String userName = rs.getString("username");
            String Category = rs.getString("category");
            String Body = rs.getString("body");
            String date = rs.getString("date");
            int likeCount = rs.getInt("likeCount");
            int commentCount = rs.getInt("commentCount");

            Blog postsList = new Blog(Category, Title, Body, imageURL, userName, BlogId, date, likeCount, commentCount);

            posts.add(postsList);

        }
        return posts;
    }

}
