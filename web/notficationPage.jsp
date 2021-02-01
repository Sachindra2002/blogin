<%-- 
    Document   : notficationPage
    Created on : Dec 22, 2020, 4:09:30 PM
    Author     : Raaid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Notification Dropdown</title>
        <link rel="stylesheet" href="css/notification.css">
        <link type="text/css" rel="stylesheet" href="css/navBar.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        
    </head>
    <body>

        <br>
        <%--navbar--%>
        <div class="topnav" id="mytopnav">
            <a href="HomeRedirect" class="active">Home</a>
            <a href="ContactUs.jsp" id="right">Contact Us</a>
        </div>
        <%--nav--%>

        <div class="wrapper">
            <div class="notification_wrap">
                <div class="notification_icon">
                    <i class="fas fa-bell"></i>
                </div>
                <div class="dropdown">
                   
                    <c:forEach var="tempNoti" items="${NOTILIST}">
                        <div class="notify_item">
                            <div class="notify_img">
                                <img src="${tempNoti.photoUrl}" alt="profile_pic" style="width: 50px">
                            </div>
                            <div class="notify_info">
                                <p>${tempNoti.senderName} ${tempNoti.notiType} on<span>your posts</span></p>
                                <span class="notify_time"> ${tempNoti.date}</span>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="notify_item"  style="margin-left: 120px">
                        <form form action="NotificationServlet" method="POST">
                            <input type="hidden" name="command" value="CLEAR"/>
                            <button type="submit" class="clearBtn">Clear</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>
