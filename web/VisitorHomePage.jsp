<%-- 
    Document   : VisitorHomePage
    Created on : Dec 4, 2020, 12:53:03 AM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/vistorHome.css">
        <link type="text/css" rel="stylesheet" href="css/navBar.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Blogin - Home</title>
    </head>

    <body>
        <h1>Bloƃᴉn.</h1>
        <!--<img src="Images/capture3.png" width="200px">-->
        <div class="topnav" id="mytopnav">
            <a href="#" class="active">Home</a>
            <%--<a href="#">Trending</a>
            <a href="#">Discover </a> 
            <a>&emsp; &emsp; &emsp; </a>--%>

            <a onclick ="window.location.href = 'index.html';" id="signup">Sign Up</a>
            <a onclick ="window.location.href = 'login.html';" id="login">Login</a>
            <a onclick ="window.location.href = 'ContactUs.jsp';" id="right">Contact Us</a>


            <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
        </div>

        <br>
        <br>
        <br>
        <c:url var="readmore" value="index.html">
        </c:url>

        <h3>Trending Today</h3>
        <div class="trending">
            <c:forEach var="post" items="${TRENDING}">
                <div class="trendingCards">
                    <h4>${post.title}</h4>
                    <p class="body">${post.body}</p>
                    <a href="${readmore}" id="readmore">Read More...</a>
                    <img src="${post.imageURL}"width="300" height="170">
                </div>
            </c:forEach>

        </div>

        <h3 id="feed">Popular Categories</h3>
        <h5>Food</h5>
        <!--<div class="following">
            <h4>Following</h4>
        </div>-->
        <div class="trending">
            <c:forEach var="post" items="${FOOD}">
                <div class="trendingCards">
                    <h4>${post.title}</h4>
                    <p class="body">${post.body}</p>
                    <a href="${readmore}" id="readmore">Read More...</a>
                    <img src="${post.imageURL}" width="300" height="170">
                </div>
            </c:forEach>

        </div>

        

        <h5>Travel </h5>

        <div class="trending" style='padding-bottom: 10px;'>
            <c:forEach var="post" items="${TRAVEL}">
                <div class="trendingCards">
                    <h4>${post.title}</h4>
                    <p class="body">${post.body}</p>
                    <a href="${readmore}" id="readmore">Read More...</a>
                    <img src="${post.imageURL}" width="300" height="170">
                    <br>
                    <br>
                </div>
            </c:forEach>

        </div>

        <h5>Music </h5>

        <div class="trending">
            <c:forEach var="post" items="${MUSIC}">
                <div class="trendingCards">
                    <h4>${post.title}</h4>
                    <p class="body">${post.body}</p>
                    <a href="${readmore}" id="readmore">Read More...</a>
                    <img src="${post.imageURL}" width="300" height="170">
                </div>
            </c:forEach>

        </div>
        <h5>Health and Fitness </h5>

        <div class="trending">
            <c:forEach var="post" items="${FITNESS}">
                <div class="trendingCards">
                    <h4>${post.title}</h4>
                    <p class="body">${post.body}</p>
                    <a href="${readmore}" id="readmore">Read More...</a>
                    <img src="${post.imageURL}" width="300" height="170">
                </div>
            </c:forEach>


        </div>

        <script type="text/javascript">
            function myFunction() {
                var x = document.getElementById("myTopnav");
                if (x.className === "topnav") {
                    x.className += " responsive";
                } else {
                    x.className = "topnav";
                }
            }
            window.onscroll = function () {
                myFunction()
            };

            var navbar = document.getElementById("mytopnav");
            var sticky = navbar.offsetTop;

            function myFunction() {
                if (window.pageYOffset >= sticky) {
                    navbar.classList.add("sticky")
                } else {
                    navbar.classList.remove("sticky");
                }
            }
        </script>



    </body> 
    <!--Footer-->
    <%--<%@include file="footer.html"%>--%>




</html>