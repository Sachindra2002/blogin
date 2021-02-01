<%-- 
    Document   : viewBlogs
    Created on : Nov 16, 2020, 8:33:43 AM
    Author     : Raaid
--%>

<%@page import="Model.LikeDao"%>
<%@page import="Model.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/memberHomePage.css">
        <link type="text/css" rel="stylesheet" href="css/navBar.css">
        <link rel="icon" href="Images/Capture.PNG" type="image/icon type">
        <link type="text/css" rel="stylesheet" href="css/searchBox.css">
        <link type="text/css" rel="stylesheet" href="css/profileView.css">
        <!-- Font Awesome -->


        <title>View my blogs</title>
    </head>

    <body>
        <img src="images/home.png" style="margin-left: 650px;" width="150px">
        <div class="topnav" id="mytopnav">
            <a href="BloggerController" class="active">Home</a>
            <a href="createBlog.jsp" id=post>Post Blog</a>
            <div class="search-container">
                <form action="BloggerController" method="GET">
                    <input type="hidden" name="command" value="SEARCH">
                    <input type="text" placeholder="Enter keyword..." name="keyword">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <c:url var="NOTIFY" value="NotificationServlet">
                <c:param name="command" value="NOTIFICATION" />

            </c:url> 
            <c:url var="follow" value="FollowServlet">
                <c:param name="command" value="USERS" />
                <c:param name="username" value='<%=request.getParameter("username")%>'/>
            </c:url> 
            <c:url var="settings" value="MemberController">
                <c:param name="command" value="SETTINGS" />
            </c:url> 
            <a href="ContactUs.jsp" id="right">Contact Us</a>
            <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
        </div>

        <div class="page-wrapper bg-dark p-t-100 p-b-50" >
            <br>
            <br>
            <div class="profile-body tab">
                <h3 id="feed">My Blogs</h3>

                <c:forEach var="tempBlog" items="${BLOGLIST}">
                    <c:url var="Action" value="BloggerController">
                        <c:param name="command" value="ONEBLOG" />
                        <c:param name="blogId" value="${post.blogId}"/> 
                    </c:url>
                    <c:url var="deleteLink" value="BloggerController">
                        <c:param name="command" value="DELETE"/>
                        <c:param name="blogId" value="${tempBlog.blogId}"/>
                    </c:url>
                    <c:url var="viewLink" value="/viewFullBlogPage.jsp">
                        <c:param name="command" value="VIEWFULL"/>
                        <c:param name="blogId" value="${tempBlog.blogId}"/>
                        <c:param name="title" value="${tempBlog.title}"/>
                        <c:param name="body" value="${tempBlog.body}"/>
                        <c:param name="category" value="${tempBlog.category}"/>
                        <c:param name="imageUrl" value="${tempBlog.imageURL}"/>
                        <c:param name="date" value="${tempBlog.date}"/>
                    </c:url>
                    <c:url var="updateLink" value="/updateBlogPage.jsp">
                        <c:param name="command" value="UPDATE"/>
                        <c:param name="blogId" value="${tempBlog.blogId}"/>
                        <c:param name="title" value="${tempBlog.title}"/>
                        <c:param name="body" value="${tempBlog.body}"/>
                    </c:url>

                    <article style='padding-bottom:2%;'>
                        <div class="imageurl">
                            <img src=${tempBlog.imageURL} alt="imageurl" height="160" style="margin-top:4px">
                        </div>

                        <div class="description">
                            <h3>${tempBlog.title}</h3>
                            <span>${tempBlog.date} |  ${tempBlog.category}</span>
                            <p style='width: 250px;'>${tempBlog.body} </p><a style='color: gray; font-size: small;' href = "${viewLink}"> Read more.</a>
                        </div>
                    </article>
                </c:forEach>



            </div>
            <br>
            <br>
            <h2>  Statistics</h2>
            <div class="trending">
                <div class="trendingCards">
                    <br>
                    <br>
                    <h4> Your most liked post</h4>
                    <h4 class="body" style=>${likeBlog.title}
                    </h4>
                    <img src="${likeBlog.imageURL}" width="300" >
                    <h4>${likeBlog.date}</h4>
                </div>
                <div class="trendingCards">
                    <br>
                    <br>
                    <h4> Your most Commented post</h4>
                    <h4 class="body" style=>${likeBlog.title}
                    </h4>
                    <img src="${commentBlog.imageURL}" width="300">
                    <h4>${commentBlog.date}</h4>
                </div>

            </div>
    </body>
</html>
