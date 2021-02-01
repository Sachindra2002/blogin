<%-- 
    Document   : Discover
    Created on : Jan 13, 2021, 9:55:05 PM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/discover.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Blogin - Home</title>
    </head>
    <body>
        <h1>Bloƃᴉn.</h1>
        <!--<img src="Images/capture3.png" width="200px">-->
        <div class="topnav" id="mytopnav">
            <a href="#" >Home</a>
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
            <a href="#" class="active">Discover</a>
            <a href="changeToBlogger.html" id=post>Post Blog</a>
            <div class="search-container">
                <form action="#">
                    <input type="text" placeholder="Search.." name="search">
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
                    <a href="#">Bookmarks</a>
                    <a href="#">Inquiries</a>
                    <a href="#">Account Settings</a>
                    <a href="#">Help</a>
                    <a id="logout" href="#">Log Out</a>
                </div>
            </div>
            <a href="#" id="right">About us</a>
            <a href="#" id="right">Contact Us</a>
            <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
        </div>

        <h2 class="topic">Discover</h2>
        <h2 class="bloggerlisttopic">Popular Bloggers</h2>
        <div class="bloggerlist">
            <div class="blogger">
                <img class="profilepic" src="images/avatar.png">
                <a class="name" href="#"><p>Name Here</p></a>
            </div>
            <div class="blogger">
                <img class="profilepic" src="images/avatar.png">
                <a class="name" href="#"><p>Name Here</p></a>
            </div>
            <div class="blogger">
                <img class="profilepic" src="images/avatar.png">
                <a class="name" href="#"><p>Name Here</p></a>
            </div>
            <div class="blogger">
                <img class="profilepic" src="images/avatar.png">
                <a class="name" href="#"><p>Name Here</p></a>
            </div>
            <div class="blogger">
                <img class="profilepic" src="images/avatar.png">
                <a class="name" href="#"><p>Name Here</p></a>
            </div>
        </div>
        <h2 class="bloggerlisttopic">Popular Categories</h2>
    </body>
</html>
