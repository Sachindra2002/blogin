<%-- 
    Document   : viewFullBlogPage
    Created on : Nov 16, 2020, 5:56:42 PM
    Author     : Raaid
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">
        <title>Viewing blog...</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
             <link type="text/css" rel="stylesheet" href="css/navBar.css">
        <link href="css/main.css" rel="stylesheet" media="all">
    </head>
    <body>
        <div class="topnav" id="mytopnav" style='background-color: rgba(0,0,0,0.8)'>
            
        </div>
        <div class="page-wrapper bg-dark p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title"> Blog No: <%=request.getParameter("blogId")%></h2>
                    </div>
                    <div class="card-body">
                        <form form action="BloggerController" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="command" value="UPDATE"/>
                            <div class="form-row">
                                <div class="name"><%=request.getParameter("date")%> </div>
                                <div class="name"><%=request.getParameter("title")%></div>
                                <div class="value" > 

                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name"></div>
                                <div class="value">
                                    <div class="input-group">
                                        <img src="<%=request.getParameter("imageUrl")%>" width="400">
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <p> <%=request.getParameter("body")%></p>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <c:url var="updateLink" value="/updateBlogPage.jsp">
                                    <c:param name="command" value="UPDATE"/>
                                    <c:param name="blogId" value='<%=request.getParameter("blogId")%>'/>
                                    <c:param name="title" value='<%=request.getParameter("title")%>'/>
                                    <c:param name="body" value='<%=request.getParameter("body")%>'/>
                                </c:url>
                                <c:url var="deleteLink" value="BloggerController">
                                    <c:param name="command" value="DELETE"/>
                                    <c:param name="blogId" value='<%=request.getParameter("blogId")%>'/>
                                </c:url>
                        
                                <a   href="${updateLink}">Update</a>
                                <a    href="${deleteLink}">Delete</a>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/global.js"></script>
    </body>
</html>
