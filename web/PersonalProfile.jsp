<%-- 
    Document   : PersonalProfile
    Created on : Jan 14, 2021, 5:30:50 PM
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-color/2.1.2/jquery.color.min.js"></script>
        <title>Blogin</title>
    </head>
    <body>
        <c:url var="logout" value="LogoutController">

        </c:url>  
        <c:url var="profile" value="BloggerController">
            <c:param name="command" value="PERSONALPROFILE"/>  
            <c:param name="username" value='<%=request.getParameter("username")%>'/>  
        </c:url>


        <img src="images/home.png" style="margin-left: 650px;" width="150px">
        <div class="topnav" id="mytopnav">
            <a href="HomeRedirect" class="active">Home</a>
            <a href="createBlog.jsp" id=post>Post Blog</a>
            <a href="ContactUs.jsp" id="right">Contact Us</a>
            <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
        </div>
        <%--navbar--%>
        <%--userProfile--%>

        <c:url var="followLink" value="FollowServlet">
            <c:param name="command" value="FOLLOW" />   
            <c:param name="follower" value='<%=request.getParameter("email")%>'/>
        </c:url>  
        <c:forEach var="user" items="${USER_LIST}">
            <div class="container">
                <div class="profile-header">
                    <div class="profile-img">
                        <img src="${user.username}" width="200" alt="Profile Image">
                    </div>
                    <div class="profile-nav-info">
                        <h3 class="user-name">${user.lastName} ${user.email}</h3>
                        <div class="address">
                            <p id="state" class="state">${user.photoUrl}</p>
                        </div>

                    </div>

                </div>

                <div class="main-bd">
                    <div class="left-side">
                        <div class="profile-side">

                            <p class="user-mail"><i class="fa fa-envelope"></i>${user.firstName}@students.apiit.lk</p>



                            <div class="links">
                                <div class="social">
                                    <i class="fa fa-twitter-square" aria-hidden="true"></i>
                                    <i class="fa fa-facebook-square" aria-hidden="true"></i>
                                    <i class="fa fa-linkedin-square" aria-hidden="true"></i>
                                    <i class="fa fa-share-square" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>

                <div class="right-side">

                    <div class="nav">
                        <ul>
                            <li onclick="tabs(0)" class="user-post active">Posts</li>

                        </ul>
                    </div>
                    <div class="profile-body tab">
                        <h3 id="feed">Recent Posts</h3>

                        <c:forEach var="post" items="${POST_LIST}">
                            <c:url var="Action" value="BloggerController">
                                <c:param name="command" value="ONEBLOG" />
                                <c:param name="blogId" value="${post.blogId}"/> 
                            </c:url>

                            <article>
                                <div class="imageurl">
                                    <img src=${post.imageURL} alt="imageurl" height="160">
                                </div>

                                <div class="description">
                                    <h3>${post.title}</h3>
                                    <span>${post.date} |  ${post.category}</span>
                                    <p>${post.body} </p><a style='color: gray; font-size: small;' href = "${Action}"> Read more.</a>
                                </div>
                            </article>
                        </c:forEach>



                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>$(document).ready(function iniciar() {

            $(".followbtn").on("click", function () {
                $(".followbtn").css("background-color", "#34CF7A");
                $(".followbtn").html('<div class="fa fa-check" aria-hidden="true"></div> Following');

            });
        });
    </script>

</html>

