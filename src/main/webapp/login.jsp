
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="resources/front/loginStyle.css" rel="stylesheet" type="text/css">
    <title>Login Page</title>
</head>


<body>
    <form class="mainBox" action="myservlet" method="POST">
        <h1>Login</h1>
        <input type="text" name="un" placeholder="Username" required>
        <input type="password" name="pw" placeholder="Password" required>
        <input type="submit" name="lg" value="Login">
        <p><a href="registerservlet">Sign up</p>
        <!-- <input type="submit" name="gt" value="Enter as a guest"> -->
        <!-- <p><a href="itemsservlet">
        Enter as a guest</p> -->
    </form>
    <form class="23" action="myservlet" method="POST">
      <input type= "hidden" name= "gt" value= "Guest">
      <input type="submit" value="Enter as a guest">
    </form>
</body>


</html>