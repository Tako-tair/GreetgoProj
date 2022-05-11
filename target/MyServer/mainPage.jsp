<%@ page import="java.util.ArrayList" %>
<%@ page import="user.User" %>
<%@ page import="db_engine.Db_controller" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: tako0
  Date: 07.05.2022
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<% ArrayList<User> arr = new Db_controller().get_users(); %>
<link href="style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Main Page Information</title>
</head>
<body>
    <h1>Main Page</h1> <br><br>
    <p class="user_info">User information</p>

    <div id="zatemnenie">
        <div id="okno">
            <form action="add_user" method="post">
                Form registration <br><br>
                name: <input name="name" placeholder="Name" required maxlength="15" minlength="3"/> <br><br>
                surname: <input name="surname" placeholder="Surname" required maxlength="20" minlength="3"/> <br><br>
                school: <input name="school" placeholder="School" required maxlength="30" minlength="3"/> <br><br>
                degree: <input name="degree" id="degree" placeholder="Degree" required maxlength="10" minlength="3"/> <br><br>
                average ball: <input name="avr_ball" id="avr_ball" placeholder="Average point" required maxlength="10" minlength="3"/> <br><br>
                <input type="Submit" value="Submit" class="button_input">
            </form>
        </div>
    </div>

    <a href="#zatemnenie" class="add" >Add user</a>

    <div class="main_info">
        <% for (int i = 0; i < arr.size(); i++) { %>
        <form action="delete_servlet" method="post">
            <div class="box">
                <p> <%= (i+1) + ": " + arr.get(i).toString() %></p>
                <input value="delete" type="submit">
                <input class="button_input" type="hidden" name="id" value="<%= arr.get(i).getId() %>">
            </div>
        </form>
        <% } %>
    </div>
</body>
</html>
