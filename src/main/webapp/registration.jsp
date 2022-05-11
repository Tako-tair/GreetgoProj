<%--
  Created by IntelliJ IDEA.
  User: tako0
  Date: 09.05.2022
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="style.css" rel="stylesheet" type="text/css">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<form method="POST" action="registration_done">
    <div class="register_main">
        <h2>Register Page</h2>
        <div><p>login:</p><input name="login" id="login" placeholder="Login" required maxlength="15" minlength="3"/> </div>
        <div><p>password:</p><input class="register_inp" name="pass" id="password_reg" placeholder="Password" required maxlength="15" minlength="3" type="password"/> </div>
        <button id="register_but" type="submit" class="button_input">Register</button>
        <a href="/MyServer">I have already account</a>
    </div>
</form>
</body>
</html>
