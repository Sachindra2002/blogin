<%-- 
    Document   : WelcomePage
    Created on : Jan 12, 2021, 4:12:21 PM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
        <link type="text/css" rel="stylesheet" href="css/WelcomePage.css"/>
        <title>Blogin</title>
    </head>
    <div id="home">
        
            <c:url var="visitor" value="VisitorController">
                <c:param name="command" value="GETPOSTS" />
            </c:url>

        <div id="leftbox">
            <h1 style="margin-right:  50px;">  Bloƃᴉn. </h1> 
            <h3 style="margin-right:  50px;">Continue As a</h3>.<br>

            <a  href="${visitor}"><button id="button1">Visitor</button></a>
        </div>
        <div id="rightbox">
            <h1> WELCOME</h1>

            <input id="login" type ="button" value="Login"
                   onclick ="window.location.href = 'login.html';"/>
            <br>

            <input id="register" type ="button" value="Register"
                   onclick ="window.location.href = 'index.html';"/>
            <br>

            <input id="contactUs" type ="button" value="Contact Us"
                   onclick ="window.location.href = 'ContactUs.jsp';" />
            <br>
        </div>
        <div class="or">OR</div>
        
    </div>

    <footer class="site-footer">
        by Team Blogin
    </footer>  

</body>
</html>
