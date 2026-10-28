<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Registration - Hospital Management System</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <style type="text/css">
            body {
                background-image: url("img/Medical.jpg");
                background-color: #cccccc;
                background-size: cover;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
            h1 {
                color: white;
                text-align: center;
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-light bg-light">
            <a href="index.jsp" class="navbar-brand">
                <img src="img/2855.jpeg" height="30" width="100" alt="HospitalManagementSystem">
            </a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ml-auto" style="margin-right: 30px;">
                    <a class="nav-item nav-link" href="index.jsp">Home</a>
                    <a class="nav-item nav-link" href="adminLogin.jsp">Admin Portal</a>
                </div>
            </div>
        </nav>
        <div>
            <h1><b>Hospital Management System</b></h1>
        </div>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <h2>User Registration</h2>
                <form action="<%=request.getContextPath()%>/UserRegister" method="post">
                    <input type="text" id="Username" class="fadeIn second" name="Username" placeholder="Enter Username" required> 
                    <input type="password" id="password" class="fadeIn third" name="password" placeholder="Enter Password" required> 
                    <input type="password" id="repassword" class="fadeIn third" name="repassword" placeholder="Confirm Password" required> 
                    <input type="submit" class="fadeIn fourth" value="Create Account">
                </form>
                <div id="formFooter">
                    <a class="underlineHover" href="index.jsp">Already have an account? Log In</a>
                </div>
            </div>
        </div>
    </body>
</html>
