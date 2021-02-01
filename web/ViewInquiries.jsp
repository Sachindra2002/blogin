<%-- 
    Document   : ViewInquiries
    Created on : Nov 16, 2020, 1:16:51 PM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/ModeratorHome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <link type="text/css" rel="stylesheet" href="css/viewInquiries.css"/>
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
        <div class="sidebar">
            <img src="images/blogin.png" width="200px">
            <hr class="solid">
            <a  href="${home}">Dashboard</a>
            <a href="AdminSearch.jsp">Search</a>
            <a class="dropdown-btn" >Blog posts
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

            <a href = "${INQ}" class="active">Inquiries</a>
        </div>
        <div class="content">
            <h2 style="text-align: left;
                padding-top: 10px;
                color: white;">Inquiry List</h2>
            <div class="container2">
                <form action="ModeratorServlet" method="GET">
                    <table>
                        <tr>
                            <th> Inquiry ID</th>
                            <th> UserName</th>
                            <th> Email</th>
                            <th> Phone No</th>
                            <th> Message</th>
                            <th> Status</th>
                            <th> Submitted Date</th>
                            <th> Delete</th>
                            <th> Respond</th>
                        </tr>
                        <c:forEach var="tempInq" items="${INQ_LIST}">
                            <c:url var="deleteLink" value="ModeratorServlet">
                                <c:param name ="command" value="DELETE" />
                                <c:param name= "inquiryId" value="${tempInq.inquiryId}"/>
                            </c:url> 
                            <c:url var="respondLink" value ="ModeratorServlet">
                                <c:param name="command" value="RESPOND_Page"/>
                                <c:param name="inquiryId" value="${tempInq.inquiryId}"/>
                            </c:url>
                            <tr>
                                <td> ${tempInq.inquiryId}</td>
                                <td> ${tempInq.userName}</td>
                                <td> ${tempInq.email}</td>
                                <td> ${tempInq.phoneNo}</td>
                                <td> ${tempInq.message}</td>
                                <td> ${tempInq.submittedDate}</td>
                                <td> ${tempInq.status}</td>
                                <td> <a id="delete" onclick=" deleted()" href="${deleteLink}">Delete</a></td>
                                <td> <a id="reject"  href="${respondLink}">Respond</a></td>

                            </tr>
                        </c:forEach>
                    </table>
                </form>
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

