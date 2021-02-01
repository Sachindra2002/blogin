<%-- 
    Document   : searchBloggersNull
    Created on : Jan 6, 2021, 10:51:36 PM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/SearchBlogger.css">
        <link type="text/css" rel="stylesheet" href="css/navBar.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <title>Blogger List</title>
    </head>
    <body>
        
        <h1>Bloƃᴉn.</h1>
        <!--<img src="Images/capture3.png" width="200px">-->
        <div class="topnav" id="mytopnav">
            <a href="HomeRedirect" class="active">Home</a>
            <a href="#">Discover</a>
            <div class="search-container">
                <form action="SearchController" method="GET">
                    <input type="hidden" name="command" value="SEARCH">
                    <input type="text" placeholder="Search.." name="Keyword">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <a href="ContactUs.jsp" id="right">Contact Us</a>
            <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
        </div>
        <br>





        <h4 style="color: coral;">Search result for : <%=session.getAttribute("Keyword")%></h4>

        <%--profile view--%>
        <div class="layout">
            <c:forEach var="Users" items="${users_info}">
                <c:url var="action" value="BloggerController">
                    <c:param name="command" value="VIEWPROFILE" />
                    <c:param name="username" value="${Users.username}"/>
                    <c:param name="firstName" value="${Users.firstName}"/>
                    <c:param name="lastName" value="${Users.lastName}"/>
                    <c:param name="email" value="${Users.username}"/>
                    <c:param name="photoURL" value="${Users.photoUrl}"/>

                </c:url>



                <div class="profile">

                    <div class="profile__picture"> <img src=${Users.photoUrl}></div>

                    <div class="profile__header">
                        <div class="profile__account">
                            <h4 class="profile__username">${Users.firstName} ${Users.lastName}</h4>
                        </div>

                        <div class="profile__edit"><a class="profile__button" href = "${action}">View Profile</a></div>
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
            
            <h2 style="font-size: large; text-align: center; font-weight: bold; color: #ffffff; margin-top: 50px; margin-left: 480px;">No Result found!</h2>







        </div>
    </body>
</html>
