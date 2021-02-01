<%-- 
    Document   : TemperoryDash
    Created on : Nov 18, 2020, 5:48:11 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TEST</title>
    </head>
    <body>
        <form action="MemberController" method="POST">
            <input type="hidden" name="command" value="VIEW"/>
            <input type="submit" value="Update account">
        </form>
    </body>
</html>
