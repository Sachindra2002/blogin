/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kanchana
 */
public class CommentDao {

    Connection con;

    public CommentDao(Connection con) {
        this.con = con;
    }

    public boolean addComment(Comment comment) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into comments(username,blogId,comment,date)" + "values(?,?,?,?)");

            ps.setString(1, comment.getUsername());
            ps.setString(2, comment.getBlogId());
            ps.setString(3, comment.getComment());
            ps.setString(4, comment.getDate());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
        return false;
    }

    public List<Comment> getAllComments(String BlogId) {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement("select * from comments where blogId = ?");
            statement.setString(1, BlogId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String Username = rs.getString("username");
                String Comment = rs.getString("comment");
                String Date = rs.getString("date");
                int CommentId = rs.getInt("commentId");

                Comment comme = new Comment(Username, Comment, Date, CommentId,BlogId);
                comments.add(comme);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return comments;
    }

    public void deteteComment(int commentId,String username) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from comments where commentId=? and username=?");
            preparedStatement.setInt(1, commentId);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public void deteteComment(int commentId,String username) {
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement("delete from comments where commentId=? and username=?");
//            preparedStatement.setInt(1, commentId);
//            preparedStatement.setString(2, username);
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



}
