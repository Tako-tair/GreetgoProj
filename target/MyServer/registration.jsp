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
<script>
    $(function(){
        $('#password_dup_reg').keyup(function () {
            var pas = $('#password_reg').val();
            var con_pas = $(this).val();
            if(pas === con_pas){
                $('.register_inp').css('border-color', 'seagreen');
            }else{
                $('.register_inp').css('border-color', 'red');
                $("button").hide();
            }
        });
    });
</script>
<style>
    .register-block .invalid, .restore-block .invalid {
        padding-left:22px;
        line-height:24px;
        color:#ec3f41;
    }
    .register-block .valid, .restore-block .valid {
        padding-left:22px;
        line-height:24px;
        color:#3a7d34;
    }
    .input-block input{
        padding: 12px;
        margin-bottom: 10px;
        width: 90%;
    }
    .input-block button{
        width:100%;
        border:none;
        background: #b1572f;
        color:#fff;
        padding: 12px;
        text-transform: uppercase;
        border-radius: 6px;
        transition: 0.5s;
        cursor:pointer;
    }
    .input-block button:hover{
        background: #fff;
        color: #b1572f;
    }

</style>
</html>
