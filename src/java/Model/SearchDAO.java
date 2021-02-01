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
public class SearchDAO {
     private final Connection connection;

    public SearchDAO() throws SQLException {
        connection = Database.getConnection();
    }

    public List<SearchBlogger> SearchResult(String searchKey) throws SQLException {
        List<SearchBlogger> userInfo = new ArrayList<SearchBlogger>();
         
        PreparedStatement preparedStatement = connection.prepareStatement("select username,firstName,lastName,photoUrl from users where roles like ? and firstName like ? or lastname  like ?  or username like ?");
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

            SearchBlogger theuserInfo = new SearchBlogger(Username,firstName,PhotoUrl,LastName);

            userInfo.add(theuserInfo);

        }
        return userInfo;
    }

    public List<Blog> searchBlogs(String searchKey) throws SQLException {
         List<Blog> posts = new ArrayList<Blog>();
         
        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs where status=? and title like ? or category like ?");
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
            

            Blog postsList = new Blog(BlogId,Category,Title,Body,imageURL,userName,date,likeCount,commentCount);

            posts.add(postsList);

        }
        return posts;
    }
    
    
    
}
