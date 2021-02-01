<%-- 
    Document   : BloggerProfileViewNull
    Created on : Jan 6, 2021, 5:39:57 PM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/profileView.css">
        <link type="text/css" rel="stylesheet" href="css/navBar.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Blogin</title>
    </head>
    <body>
        <h1>Bloƃᴉn.</h1>
        <br>
        <%--navbar--%>
        <div class="topnav" id="mytopnav">
            <a href="#" class="active">Home</a>
            <a href="#">Trending</a>
            <div class="dropdown">
                <button class="dropbtn">Categories
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="#">Travel</a>
                    <a href="#">Food</a>
                    <a href="#">Health and Fitness</a>
                    <a href="#">Technology</a>
                    <a href="#">Fashion</a>
                    <a href="#">Music</a>
                    <a href="#">Sports</a>
                    <a href="#">DIY</a>
                </div>
            </div>
            <a href="#">Discover</a>
            <a onclick ="window.location.href = 'changeToBlogger.jsp';" id=post>Post Blog</a>
            <div class="search-container">
                <form action="MemberController" method="GET">
                    <input type="hidden" name="command" value="SEARCH">
                    <input type="text" placeholder="Search.." name="Keyword">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <div class="dropdown2">
                <button class="dropbtn">Profile
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="#">My Profile</a>
                    <a href="#">Notifications</a>
                    <a href="#">Inquiries</a>
                    <a href="#">Account Settings</a>
                    <a id="logout" href="#">Log Out</a>
                </div>
            </div>
            <a href="#" id="right">About us</a>
            <a href="#" id="right">Contact Us</a>
            <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
        </div>
        <%--navbar--%>
        <%--userProfile--%>
        <div class="container">
            <div class="profile-header">
                <div class="profile-img">
                    <img src=<%=request.getParameter("photoURL")%> width="200" alt="Profile Image">
                </div>
                <div class="profile-nav-info">
                    <h3 class="user-name"><%=request.getParameter("firstName")%> <%=request.getParameter("lastName")%></h3>
                    <div class="address">
                        <p id="state" class="state">Blogger</p>
                    </div>

                </div>

            </div>

            <div class="main-bd">
                <div class="left-side">
                    <div class="profile-side">

                        <p class="user-mail"><i class="fa fa-envelope"></i><%=request.getParameter("email")%>@students.apiit.lk</p>

                        <div class="profile-btn">
                            <button class="followbtn" id="followbtn"><i class="fa fa-rss" aria-hidden="true"></i> Follow</button>
                        </div>

                        <div class="links">
                            <div class="social">
                                <i class="fa fa-twitter-square" aria-hidden="true"></i>
                                <i class="fa fa-facebook-square" aria-hidden="true"></i>
                                <i class="fa fa-linkedin-square" aria-hidden="true"></i>
                                <i class="fa fa-share-square" aria-hidden="true"></i>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="right-side">

                    <div class="nav">
                        <ul>
                            <li  class="user-post active"  >Posts</li>

                        </ul>
                    </div>
                    <div class="profile-body tab">
                        <h3 id="nullfeed" style='margin-right: 900px;' >No posts to show.  </h3>
                        
                        



                    </div>
                </div>
            </div>
        </div>
    </body>

</html>

