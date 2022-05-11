<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lOGIN</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login_main">
    <h2>Login Page</h2>
    <form action="login" method="post">
        <div><p>Login:</p><input name="login" autofocus placeholder="Login" required/></div>
        <div><p>Password:</p> <input name="password" placeholder="Password" required type="password"/></div>
        <input type="submit" value="login" class="button_input" style="width: 300px"/>
    </form>
    <form action="registration" method="post"><input  class="button_input" type="submit" value="Registration" style="width: 300px; margin-top:10px"></form>
</div>
</body>
</html>