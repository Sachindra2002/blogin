<%-- 
    Document   : changeProfilePic
    Created on : Nov 18, 2020, 2:29:46 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Test</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="css/changeProfilePic.css">
    </head>
    <body>
        <h3>CHANGE PROFILE PICTURE</h3>
        <div class="container">
            <div class="container">
                <form action="MemberController" method="POST" enctype="multipart/form-data">
                    <input type="hidden" name="command" value="CHANGEPROFILEPIC"/>
                    <div class="profile-pic-div">
                        <img src="<%=request.getParameter("photo")%>" id="previewPhoto">
                        <input type="file" id="file" name="photo" size="50" />
                        <label for="file" id="uploadBtn">Change Photo</label>
                    </div>
                    <input type="submit" class="button" name="submit" value="Save Changes">
                </form>
            </div>
        </div>
        <script src="app.js"></script>
    </body>
</html>
