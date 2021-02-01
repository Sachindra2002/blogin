<%-- 
    Document   : changeToBlogger
    Created on : Dec 9, 2020, 9:03:04 AM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Bloƃᴉn.</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="css/changeToBlogger.css">
        <link rel="icon" href="images/Capture.PNG" type="image/icon type">
    </head>
    <body>
        <h1>Bloƃᴉn.</h1>
        <hr>
        <h2>Terms and Conditions</h2>
        <div class="container">
            
           
            
            <form action="BloggerController" method="GET">
                <input type="hidden" name="command" value="UPGRADE">
                <input type="hidden" value="CHANGE">
                <input type="checkbox" id="condition1" name="condition1" value="1" required>
                <label for="condition1">I shall not post or share any works that I do not own or have a proper license to use</label><br><br>
                <input type="checkbox" id="condition2" name="condition1" value="1" required>
                <label for="condition2">I shall not post or share any works that contain offensive language or images</label><br><br>
                <input type="checkbox" id="condition3" name="condition1" value="1" required>
                <label for="condition3">I understand and agree to the terms and conditions </label><br><br>
                <input type="submit" class="button" name="submit" value="Become a Blogger">
            </form>
        </div>
    </body>
</html>
