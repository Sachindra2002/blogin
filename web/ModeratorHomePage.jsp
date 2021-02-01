<%-- 
    Document   : ModeratorHomePage
    Created on : Dec 7, 2020, 10:55:50 AM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/ModeratorHome.css">
        <link type="text/css" rel="stylesheet" href="css/card.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <title>Blogin</title>
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
            <h1>Bloƃᴉn.</h1>
            <hr class="solid">
            <a class="active" href="${Home}">Dashboard</a>
            <a href="AdminSearch.jsp">Search</a>
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
            <h2>Dashboard</h2>
            <c:forEach var="userInfo" items="${USERINFO}">
            <div class="card">
                <img src="${userInfo.photoUrl}" alt="Avatar" style="width:100%">
                <div class="container">
                    <h4><b>${userInfo.firstName} ${userInfo.lastName}</b></h4> 
                    <p>${userInfo.role}</p> 
                </div>
            </div>
            </c:forEach>
            <HR COLOR="coral" WIDTH="98%">

            <h2>Website Statistics</h2>




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
