<%-- 
    Document   : changePassword
    Created on : Nov 18, 2020, 6:52:56 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/changePassword.css">

        <title>Test</title>
    </head>
    <body>
        <h3>CHANGE PASSWORD</h3>
        <div class="container">
            <form action="MemberController" method="POST">
                <input type="hidden" name="command" value="CHANGEPASSWORD"/>
                <label for="passwordChk">Enter Current Password</label>
                <input id="passwordChk" type="password" name="passwordChk"  required>
                <label for="password">Password</label>
                <input id="password" type="password" name="password" required onkeyup="checkPass();">
                <label for="password0">Re-Enter Password</label>                    
                <input id="password0" type="password" name="password0" required onkeyup="checkPass();">
                <span id="confirm-message2" class="confirm-message"></span>
                <input type="submit" class="button" name="submit" value="Save Changes" onclick="return validate()">
            </form>
        </div>
        <script type="text/javascript">

            function validate()
            {
                var password = document.getElementById('password').value;
                var confirmPassword = document.getElementById('password0').value;

                if (password != confirmPassword)
                {
                    alert("Passwords entered do not match!");
                    return false;
                }
                return true;
            }
            
            function checkPass()
            {
                var password = document.getElementById('password');
                var confirm  = document.getElementById('password0');
                var message = document.getElementById('confirm-message2');
                
                var good_color = "#00ff00";
                var bad_color  = "#ff0000";
                
                if(password.value == confirm.value)
                {
                    message.style.color           = good_color;
                    message.innerHTML = "Passwords Match!";
                }
                else
                {
                    message.style.color = bad_color;
                    message.innerHTML = "Passwords Do Not Match!";
                }
                
            }
        </script>
    </body>
</html>
