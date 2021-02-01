<%-- 
    Document   : replyInquiries
    Created on : Nov 16, 2020, 1:17:35 PM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link type="text/css" rel="stylesheet" href="css/replyInquiries.css"/>
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container">
                <h2>Responding to ${INQ.userName}'s Inquiry</h2>
            <form action="ModeratorServlet" method="GET">
                 <input type="hidden" name="command" value="RESPOND">
                 
                    <div class="form">
                        
                        <lable> Inquiry ID: </lable>
                        <input type="text" name="inquiryId" value="${INQ.inquiryId}"  readonly>
                        <br> 
                        <lable> User's Email :</lable>
                        <input type="email" name="emailAddress" value="${INQ.email}"   readonly>
                        <br>
                        <lable> Inquiry Info :</lable>
                        <input type="text" name="message" value="${INQ.message}"   readonly>
                        <br>
                        <lable> Reply :</lable>
                        <textarea type="text"  name ="reply" placeholder="" required></textarea>
                                 <br>
                                 <input  type="submit" class="button" value="SEND" >
                    </div>  
            </form>
            </div>
        
    </body>
    
</html>

