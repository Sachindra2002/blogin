<%-- 
    Document   : ContactUs
    Created on : Nov 16, 2020, 1:04:58 PM
    Author     : Lahiru De silva 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/ContactUs.css"/>

        <title>Contact Us</title>
    </head>
    <body>
          <div class="container">
                <div class="row">
                                <h1>contact us</h1>
                </div>
                <div class="row">
                                <h4 style="text-align:center">We'd love to hear from you!</h4>
                </div>
              <form action="ContactServlet" method="POST" >
                <div class="formcontainer">
                                <div class="col-xs-12">
                                        <div class="styled-input wide">
                                                <input type="text" name="username" pattern ="[A-Z]{2}[0-9]{6}" title ="CBXXXXXX" required />
                                                <label>CB number</label> 
                                        </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                        <div class="styled-input">
                                                <input type="email" name="emailAddress" required />
                                                <label>Email</label> 
                                        </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                        <div class="styled-input" style="float:right;">
                                                <input class="inputBox" type="tel" name="phoneNo" max="10"  title="011XXXX111" required>
                                                <label>Phone Number</label> 
                                        </div>
                                </div>
                                <div class="col-xs-12">
                                        <div class="styled-input wide">
                                                <textarea name="message" required></textarea>
                                                <label>Message</label>
                                        </div>
                                </div>
                                <div>
                                       
                                           <input class ="submit" type="submit" value="Send Message" ></div>
                                   
                                    

                                </div>

              </form>
        </div>
           
                                
        
        
</body>
</html>
