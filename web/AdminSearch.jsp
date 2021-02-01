<%-- 
    Document   : AdminSearch
    Created on : Jan 14, 2021, 11:30:05 AM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <link type="text/css" rel="stylesheet" href="css/ModeratorHome.css">
        <link type="text/css" rel="stylesheet" href="css/adminSearch.css">
        <link type="text/css" rel="stylesheet" href="css/wideSearch.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <script src="https://smtpjs.com/v3/smtp.js"></script>
    </head>
    <body>
        <c:url var="pending" value="ModeratorServlet">
            <c:param name="command" value="VIEW"/>
        </c:url>
        <c:url var="accepted" value="ModeratorServlet">
            <c:param name="command" value="VIEWACCEPTED"/>
        </c:url>
        <c:url var="rejected" value="ModeratorServlet">
            <c:param name="command" value="VIEWREJECTED"/>
        </c:url>
        <c:url var="INQ" value="ModeratorServlet">
            <c:param name="command" value="LIST"/>
        </c:url>
        <c:url var="home" value="ModeratorServlet">
            <c:param name="command" value="HOME"/>
        </c:url>
        <c:url var="logout" value="LogoutController">

        </c:url>  

        <div class="sidebar">
            <img src="images/blogin.png" width="200px">
            <hr class="solid">
            <a  href="${home}">Dashboard</a>
            <a  class="active" href="#">Search </a>
            <a class="dropdown-btn">Blog posts
                <i class="fa fa-caret-down"></i>
            </a>
            <div class="dropdown-container">

                <a class="dropdown-btn"class="active" >Verify posts
                    <i class="fa fa-caret-down"></i>
                </a>
                <div class="dropdown-container">
                    <a href="${pending}">Pending Blogs</a>
                    <a href="${accepted}">Accepted Blogs</a>
                    <a href="${rejected}">Rejected Blogs</a>

                </div>


            </div>

            <a href = "${INQ}">Inquiries</a>
            <a href = "${logout}" style="color:red;">LogOut</a>
        </div>

        <div class="content">
            <div class="search-box">
                <%--search bar--%>
                <div id="box">
                    <form action="SearchController" method="GET">
                        <input  type="hidden" name="command" value="ADMINSEARCH">
                        <input type="text" placeholder="Search.." name="Keyword">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>

                <%--search bar--%>
                <h4 style="color: coral;">Search result for : <%=session.getAttribute("Keyword")%></h4>
                <div style="">
                    <h5 style="color: white;margin-left: 20px;">Blog posts</h5>
                    <c:forEach var="post" items="${search_posts}">
                        <c:url var="readmore" value="BloggerController">
                            <c:param name="command" value="ONEBLOG"/>
                            <c:param name="blogId" value="${post.blogId}"/>
                            <c:param name="imageUrl" value="${post.imageURL}"/>
                        </c:url>
                        <article style="margin-left: 140px;">
                            <div class="imageurl">
                                <img src="${post.imageURL}" height="170">
                            </div>
                            <div class="description">
                                <h3 style="margin-top: 5px">${post.title}</h3>
                                <span>${post.date} | ${post.category}</span>
                                <p>${post.body}</p><a style='color: gray; font-size: small' href="${readmore}">Read more..</a>
                            </div>
                        </article>
                    </c:forEach>
                </div>
                <h5 style="color: white;margin-left: 20px;">Users</h5>

                <%--profile view--%>
                <div class="layoutAdmin">
                    <c:forEach var="Users" items="${users_info}">
                        <c:url var="action" value="BloggerController">
                            <c:param name="command" value="VIEWPROFILE" />
                            <c:param name="username" value="${Users.username}"/>
                            <c:param name="firstName" value="${Users.firstName}"/>
                            <c:param name="lastName" value="${Users.lastName}"/>
                            <c:param name="email" value="${Users.username}"/>
                            <c:param name="photoURL" value="${Users.photoUrl}"/>

                        </c:url>

                        <div class="profileView">

                            <div class="profile__picture"> <img src=${Users.photoUrl}></div>

                            <div class="profile__header">
                                <div class="profile__account">
                                    <h4 class="profile__username">${Users.firstName} ${Users.lastName}</h4>
                                </div>

                                <div class="profile__edit"><a class="profile_button" href = "${action}">View Profile</a></div>
                            </div>
                            <div class="profile__stats">

                                <div class="profile__stat">
                                    <div class="profile__icon profile__icon--blue"><i class="fa fa-user-o" aria-hidden="true"></i></div>
                                    <div class="profile__value">0
                                        <div class="profile__key">Followers</div>
                                    </div>
                                </div>
                                <div class="profile__stat">
                                    <div class="profile__icon profile__icon--pink"><i class="fa fa-pencil" aria-hidden="true"></i></div>
                                    <div class="profile__value">2
                                        <div class="profile__key">Posts</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </body>
    <script>
        var dropdown = document.getElementsByClassName("dropdown-btn");
        var i;

        for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function () {
                this.classList.toggle("active");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                    dropdownContent.style.display = "none";
                } else {
                    dropdownContent.style.display = "block";
                }
            });
        }
    </script>
</html>
