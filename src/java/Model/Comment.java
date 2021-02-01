/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kanchana
 */
public class Comment {
   String username,comment,blogId,date;
   int commentId;

    public Comment(String username, String comment, String blogId, String date) {
        this.username = username;
        this.comment = comment;
        this.blogId = blogId;
        this.date = date;
    }

    public Comment(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }

    public Comment(String username, String comment, String date) {
        this.username = username;
        this.comment = comment;
        this.date = date;
    }

    public Comment( String username, String comment,  String date,int commentId,String blogId) {
        this.username = username;
        this.comment = comment;
       
        this.date = date;
        this.commentId = commentId;
        this.blogId=blogId;
    }

  

  

    
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
   
}
