<%-- 
    Document   : changeDob
    Created on : Nov 18, 2020, 6:08:29 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/changedob.css">
        <title>Test</title>
    </head>
    <body>
        <h3>CHANGE DATE OF BIRTH</h3>
        <div class="container">
            <form action="MemberController" method="POST">
                <input type="hidden" name="command" value="CHANGEDOB"/>
                <div class="text">Date Of Birth : <%=request.getParameter("dob")%></div>
                <label for="dob">Updated Date Of Birth</label>
                <input type="date" name="dob" required pattern="\d{4}-\d{2}-\d{2}">
                <input type="submit" class="button" name="submit" value="Save Changes">
            </form>
        </div>
    </body>
</html>
