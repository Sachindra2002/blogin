<%-- 
    Document   : rejectedBlogs
    Created on : Nov 15, 2020, 9:08:01 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Blog</title>
        <link type="text/css" rel="stylesheet" href="css/verifyBlogs.css">
        <link type="text/css" rel="stylesheet" href="css/ModeratorHome.css">
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
            <h1>Bloƃᴉn.</h1>
            <hr class="solid">
            <a  href="${home}">Dashboard</a>
            <a href="AdminSearch.jsp">Search</a>
            <a class="dropdown-btn" class="active">Blog posts
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
            <h2 style="text-align: left;
                padding-top: 10px;
                color: white;">Rejected Blogs</h2>
        <c:forEach var="post" items="${REJECTEDBLOG_LIST}">
            <c:url var="accept" value="ModeratorServlet">
                <c:param name="command" value = "ACCEPT"/>
                <c:param name="blogID" value="${post.blogId}"/>
            </c:url>
            <div class="post">
                <h3>${post.title}</h3>
                <div class="category">${post.category}</div>
                <div class="category">By ${post.author}</div>
                
                <c:url var="readmore" value="BloggerController">
                        <c:param name="command" value="ONEBLOG" />
                        <c:param name="blogId" value="${post.blogId}"/>
                        <c:param name="imageUrl" value="${post.imageURL}"/>
                    </c:url>
                <div class="body">${post.body}<a id="readmore" href="${readmore}"> read more..</a></div>
                <img src="${post.imageURL}" width="400">
                <a href="${accept}" onclick="fireSweetAlert()" >
                    <button class="button button4">Accept</button>
                </a>

            </div>
        </c:forEach>
            <%-- <script type="text/javascript">

            function fireSweetAlert() {
                Swal.fire(
                        'Post Accepted!',
                        'Post was Sucessfully Accepted!',
                        'success'
                        );
            }

            function fireSweetAlert1() {
                Swal.fire(
                        'Post Rejected!',
                        'Post was Rejected Sucessfully!',
                        'warning'
                        );
            }

        </script>--%>
        
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
        <%--<input type="button" value="Accept" onclick="
                window.location.href = '${accept}';
                return false;" class="button button1" />
                <input type="button" value="Reject" onclick="
                window.location.href = '${accept}';
                return false;" class="button button2" onclick="fireSweetAlert1()"/>--%>
    </body>
</html>
