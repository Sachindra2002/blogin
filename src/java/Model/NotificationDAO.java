/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
 * @author Lahiru De silva
 */
public class NotificationDAO {
     private final Connection connection;

    public NotificationDAO() throws SQLException {
        connection = Database.getConnection();
    }

    public List<Notification> viewNoti(String username) throws SQLException {
        List<Notification> notiList = new ArrayList<Notification>();
        PreparedStatement ps = connection.prepareStatement("select * from notifications where receiverName=? ");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String senderName = rs.getString("senderName");
            String receiverName = rs.getString("receiverName");
            String notiType = rs.getString("notiType");
            String photoUrl = rs.getString("photoUrl");
            String date=rs.getString("date");
           Notification noti = new Notification(senderName,receiverName,notiType,photoUrl,date);
            notiList.add(noti);
        }
        if(notiList.isEmpty())
        {
           Date currentDate = new Date(System.currentTimeMillis());
            
            String senderName = "";
            String receiverName ="";
            String notiType = "You have no new notifications";
            String photoUrl = "ProfileImages/stop.jpg";
            String date= currentDate.toString();
           Notification noti = new Notification(senderName,receiverName,notiType,photoUrl,date);
           notiList.add(noti);
        }
        return notiList;
    }

    public void clearNotifications(String username) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete  from  notifications where receiverName=?;");
        ps.setString(1, username);
        ps.executeUpdate();
    }
    
    public boolean notify(Notification noti) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into notifications(senderName,receiverName,notiType,photoUrl,date)" + "values(?,?,?,?,?)");
            ps.setString(1, noti.getSenderName());
            ps.setString(2, noti.getReceiverName());
            ps.setString(3, noti.getNotiType());
            ps.setString(4, noti.getPhotoUrl());
            ps.setString(5, noti.getDate());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
        return false;

    }
    
    
}
