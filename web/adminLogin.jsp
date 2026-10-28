<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Login - Hospital Management System</title>
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/register.css" type="text/css" />
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
                    <a class="nav-item nav-link" href="index.jsp">User Login</a>
                    <a class="nav-item nav-link active" href="adminLogin.jsp">Admin Portal</a>
                </div>
            </div>
        </nav>

        <div>
            <h1><b>Hospital Management System</b></h1>
        </div>

        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="img/signin-image.jpg" alt="Admin Sign in"></figure>
                        <a href="adminRegister.jsp" class="signup-image-link">Create an Admin Account</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Admin Sign In</h2>
                        <form action="<%=request.getContextPath()%>/AdminLogin" method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="your_name" id="your_name" placeholder="Admin Email / Username" required/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="Password" required/>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
