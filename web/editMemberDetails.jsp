<%-- 
    Document   : editMemberDetails
    Created on : Nov 18, 2020, 3:20:02 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Test</title><link type="text/css" rel="stylesheet" href="CSS/editMemberDetails.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="css/editMemberDetails.css">
    </head>
    <body>
        <c:url var="changeImage" value="/changeProfilePic.jsp">
            <c:param name="photo" value="${user.photoUrl}"/>
        </c:url>
        <c:url var="changeDOB" value="/changeDob.jsp">
            <c:param name="dob" value="${user.dob}"/>
        </c:url>
        <c:url var="changePassword" value="/changePassword.jsp">
            <c:param name="password" value="${user.password}"/>
        </c:url>
        <h3>CHANGE ACCOUNT DETAILS</h3>
        <div class="container">
            <a href="${changeImage}"><button class="button">Change Profile Picture</button></a>
            <a href="${changeDOB}"><button class="button">Change Date of Birth</button></a>
            <a href="${changePassword}"><button class="button">Change Password</button></a>
        </div>
    </body>
</html>