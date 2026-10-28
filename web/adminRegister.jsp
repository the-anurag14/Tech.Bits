<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Register - Hospital Management System</title>
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
                    <a class="nav-item nav-link" href="index.jsp">Home</a>
                    <a class="nav-item nav-link" href="adminLogin.jsp">Admin Login</a>
                </div>
            </div>
        </nav>

        <div>
            <h1><b>Hospital Management System</b></h1>
        </div>

        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Admin Sign Up</h2>
                        <form action="<%=request.getContextPath()%>/AdminRegister" method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Admin Email" required/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass" id="pass" placeholder="Password" required/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass" id="re_pass" placeholder="Repeat Password" required/>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register Admin"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="img/signup-image.jpg" alt="Admin Sign up"></figure>
                        <a href="adminLogin.jsp" class="signup-image-link">I am already an Admin</a>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
