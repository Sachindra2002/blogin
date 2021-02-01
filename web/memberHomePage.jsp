<%-- 
    Document   : memberHomePage
    Created on : Dec 6, 2020, 4:20:57 PM
    Author     : Sachindra Rodrigo
--%>

<%@page import="Model.Database"%>
<%@page import="Model.LikeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/memberHomePage.css">
        <link type="text/css" rel="stylesheet" href="css/navBar.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Blogin - Home</title>
    </head>

    <body>
        <c:url var="logout" value="LogoutController">

        </c:url> 

        <img src="images/home.png" style="margin-left: 650px;" width="150px">
        <div class="topnav" id="mytopnav">
            <a href="HomeRedirect" class="active">Home</a>
            <a href = changeToBlogger.jsp id=post>Post Blog</a>
            <div class="search-container">
                <form action="SearchController" method="GET">
                    <input type="hidden" name="command" value="SEARCH">
                    <input type="text" placeholder="Search.." name="Keyword">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>

            <c:url var="follow" value="FollowServlet">
                <c:param name="command" value="USERS" />
                <c:param name="username" value='<%=request.getParameter("username")%>'/>

            </c:url> 
            <c:url var="NOTIFY" value="NotificationServlet">
                <c:param name="command" value="NOTIFICATION" />

            </c:url> 
            <c:url var="settings" value="MemberController">
                <c:param name="command" value="SETTINGS" />
            </c:url> 
            <c:url var="profile" value="BloggerController">
                <c:param name="command" value="PERSONALPROFILE"/>  
                <c:param name="username" value='<%=request.getParameter("username")%>'/>  
            </c:url>
            <div class="dropdown2">
                <button class="dropbtn">Profile
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="${profile}">My Profile</a>
                    <a href="${follow}">Followers</a>
                    <a href="${settings}">Account Settings</a>
                    <a id="logout" href="${logout}">Log Out</a>
                </div>
            </div>

            <a href="ContactUs.jsp" id="right">Contact Us</a>
            <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
        </div>
        <div class="session">
            <h2 id="Greetings"></h2>
            <h2 id="sessionName" style="color: coral;"><%=session.getAttribute("firstName")%> <%=session.getAttribute("lastName")%></h2>
        </div>
        <br>
        <br>
        <br>
        <h3>Trending Today</h3>
        <div class="trending">
            <c:forEach var="post" items="${TRENDING}">
                <div class="trendingCards">
                    <h4>${post.title}</h4>
                    <p class="body">${post.body}</p>

                    <c:url var="readmore" value="BloggerController">
                        <c:param name="command" value="ONEBLOG" />

                        <c:param name="blogId" value="${post.blogId}"/>
                        <c:param name="imageUrl" value="${post.imageURL}"/>
                    </c:url> 

                    <a href="${readmore}" id="readmore">Read More...</a>
                    <img src="${post.imageURL}"width="300">

                    <div class="footer">
                        <%--  
                                            <% LikeDao ld = new LikeDao(Database.getConnection());%>     

                    <a href="MemberController" class="btn btn-light" onclick="doLike(<%=1%>,<%=2%>)">
                        <% if (ld.isLikedByUser(1, 2)) {%>
                        <i class="fa fa-heart" style="margin: 5px;color: red;"></i> 
                        <span class="like-counter"><%= ld.countLikeOnPost(1)%></span>

                        <%} else {%>
                        <i class="fa fa-heart-o" style="margin: 5px;color: black;"></i> 
                        <span class="like-counter"><%= ld.countLikeOnPost(1)%></span> 
                        <%}%>
                    </a> --%>
                    </div>
                </div>
            </c:forEach>


        </div>

        <h3 id="feed">Your Daily Feed</h3>
        <!--<div class="following">
            <h4>Following</h4>
        </div>-->

        <c:forEach var="post" items="${FOLLOWPOSTS}">
            <c:url var="readmore" value="BloggerController">
                <c:param name="command" value="ONEBLOG" />
                <c:param name="blogId" value="${post.blogId}"/>
                <c:param name="imageUrl" value="${post.imageURL}"/>
            </c:url> 
            <div class="myfeed">
                <h4>${post.title}</h4>
                <p class="body">${post.body}</p>
                <a style="margin-left: 260px;" href="${readmore}" id="readmore">Read More...</a>
                <img style="margin-left: 150px;"src="${post.imageURL}"width="300">

                <%--                  <% LikeDao od = new LikeDao(Database.getConnection());%>     

                    <a href="MemberController" class="btn btn-light" onclick="doLike(<%=1%>,<%=2%>)">
                        <% if (od.isLikedByUser(1, 2)) {%>
                        <i class="fa fa-heart" style="margin: 5px;color: red;"></i> 
                        <span class="like-counter"><%= od.countLikeOnPost(1)%></span>

                        <%} else {%>
                        <i class="fa fa-heart-o" style="margin: 5px;color: black;"></i> 
                        <span class="like-counter"><%= od.countLikeOnPost(1)%></span> 
                        <%}%>
                    </a>
                --%>

            </div>
        </c:forEach>

        <script src = "https://code.jquery.com/jquery-3.5.1.js"
                integrity = "sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin = "anonymous"></script>
        <script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity = "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin = "anonymous"></script>
        <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity = "sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin = "anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <script src="js/myjs.js" type="text/javascript"></script>

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
                var myDate = new Date();
                var hrs = myDate.getHours();

                var greet;

                if (hrs < 12)
                    greet = 'Good Morning';
                else if (hrs >= 12 && hrs <= 14)
                    greet = 'Good Afternoon';
                else if (hrs >= 14 && hrs <= 24)
                    greet = 'Good Evening';

                document.getElementById('Greetings').innerHTML =
                        '<b>' + greet;
        </script>
    </body>

</html>
