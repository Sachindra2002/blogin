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

/**
 *
 * @author Lahiru De silva
 */
public class visitorDAO {
    private final Connection connection;

    public visitorDAO() throws SQLException {
        connection = Database.getConnection();
    }

    

    public List<Blog> getAllTrendingPosts() throws SQLException {
        List<Blog> Trendingposts = new ArrayList<Blog>();
         
        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where likeCount>=? and commentCount>=? ORDER BY date DESC");
        //preparedStateement to execute the SQL query
        preparedStatement.setInt(1, 50);
        preparedStatement.setInt(2, 20);
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

            Blog postsList = new Blog(Category,Title,Body,imageURL,userName,BlogId,date,likeCount,commentCount);
            //instantiating object with the String varibales

            Trendingposts.add(postsList);
            //adding the object to the ArrayList

        }
        return Trendingposts;
    }

    public List<Blog> getAllFoodPosts() throws SQLException {
        List<Blog> Foodposts = new ArrayList<Blog>();
         
        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where category=? and status=? ORDER BY date DESC");
        //preparedStateement to execute the SQL query
        preparedStatement.setString(1, "Food");
        preparedStatement.setString(2, "accepted");
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

            Blog postsList = new Blog(Category,Title,Body,imageURL,userName,BlogId,date,likeCount,commentCount);
            //instantiating object with the String varibales

            Foodposts.add(postsList);
            //adding the object to the ArrayList

        }
        return Foodposts;
    }

    public List<Blog> getAllMusicPosts() throws SQLException {
        List<Blog> Musicposts = new ArrayList<Blog>();
         
        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where category=? and status=? ORDER BY date DESC");
        //preparedStateement to execute the SQL query
        preparedStatement.setString(1, "Music");
        preparedStatement.setString(2, "accepted");
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

            Blog postsList = new Blog(Category,Title,Body,imageURL,userName,BlogId,date,likeCount,commentCount);
            //instantiating object with the String varibales

            Musicposts.add(postsList);
            //adding the object to the ArrayList

        }
        return Musicposts;
    }

    public List<Blog> getAllFitPosts() throws SQLException {
        List<Blog> Fitnessposts = new ArrayList<Blog>();
         
        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where category=? and status=? ORDER BY date DESC");
        //preparedStateement to execute the SQL query
        preparedStatement.setString(1, "Sports");
        preparedStatement.setString(2, "accepted");
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

            Blog postsList = new Blog(Category,Title,Body,imageURL,userName,BlogId,date,likeCount,commentCount);
            //instantiating object with the String varibales

            Fitnessposts.add(postsList);
            //adding the object to the ArrayList

        }
        return Fitnessposts;
    }

    public List<Blog> getAllTravelPosts() throws SQLException {
         List<Blog> Travelposts = new ArrayList<Blog>();
         
        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where category=? and status=? ORDER BY date DESC");
        //preparedStateement to execute the SQL query
        preparedStatement.setString(1, "Travel");
        preparedStatement.setString(2, "accepted");
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

            Blog postsList = new Blog(Category,Title,Body,imageURL,userName,BlogId,date,likeCount,commentCount);
            //instantiating object with the String varibales

            Travelposts.add(postsList);
            //adding the object to the ArrayList

        }
        return Travelposts;
    }
    
    
    
}
