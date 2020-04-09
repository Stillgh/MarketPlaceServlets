
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/front/loginStyle.css">
    <title>Register Page</title>
</head>


<body>
    <form class="mainBox" action="registerservlet" method="POST">
        <h1>Register</h1>
        <input type="text" pattern="^[a-z0-9_-]{3,16}$" required name="un" placeholder="Username">
        <input type="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,12}$" name="pw" placeholder="Password" id="password" required>
        <input type="password" name="cpw" placeholder="Confirm Password" id="confirm_password" required>
        <input type="text" name="ad" placeholder="Address">
        <input type="text" name="fn" placeholder="Full Name">
        <input type="email" name="em" placeholder="email" required>
        <input type="submit" name="rg" value="Register" >
        <input type="reset" name="rs" value="Reset">

        <p><a href="myservlet">Sign in</p>
    </form>



<script>
    var password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>

</body>


</html>