/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kanchana
 */
public class LikeDao {
  

    Connection con;

    public LikeDao(Connection con) {
        this.con = con;
    }

    public boolean insertLike(int blogId, String userId) {
        boolean f = false;
        try {
            String q = "insert into likes(blogId,userId)values(?,?)";
            PreparedStatement p = this.con.prepareStatement(q);
            //values set...
            p.setInt(1, blogId);
            p.setString(2, userId);
            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public int countLikeOnPost(int blogId) {
        int count = 0;

        String q = "select count(*) from likes where blogId=?";
        try {
            PreparedStatement p = this.con.prepareStatement(q);
            p.setInt(1, blogId);
            ResultSet set = p.executeQuery();
            if (set.next()) {
                count = set.getInt("count(*)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public boolean isLikedByUser(int blogId, String userId) {
        boolean f = false;
        try {
            PreparedStatement p = this.con.prepareStatement("select * from likes where blogId=? and userId=?");
            p.setInt(1, blogId);
            p.setString(2, userId);
            ResultSet set = p.executeQuery();
            if (set.next()) {
                f = true;
            }

        } catch (Exception e) {
        }
        return f;
    }

    public boolean deleteLike(int blogId,String  userId) {
        boolean f = false;
        try {
            PreparedStatement p = this.con.prepareStatement("delete from likes where blogId=? and userId=? ");
            p.setInt(1, blogId);
            p.setString(2, userId);
            p.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
