<%-- 
    Document   : login
    Created on : 29/08/2016, 05:56:04 PM
    Author     : RAT
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Registro de actividades y tiempos</title>

        <link rel="icon" href="../resources/images/favicon128.ico" type="image/x-icon"/>
        <link rel="shorcut icon" href="../resources/images/favicon128.ico" type="image/x-icon"/>

        <link href="../resources/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="../resources/css/style_login.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <form action="validaringreso.jsp" method="post">
                    <div class="login-form">
                        <h1><a href="menu.jsp"><img src="../resources/images/logo.png" alt="Pinvalidda" width="250"></a></h1>
                        <div class="form-group log-status ">
                            <input type="text" class="form-control" name="user" placeholder="Nombre de usuario" name="usuario" required>
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="form-group log-status">
                            <input type="password" class="form-control" name="password" placeholder="Contraseña" name="pass" required>
                            <i class="fa fa-lock"></i>
                        </div>
                        <span class="alert">Nombre de usuario y/o contraseña incorrecta</span>
                        <a class="link" href="#">¿Olvidaste tu contraseña?</a>
                        <button type="submit" class="btn btn-default log-btn" >Iniciar sesión</button>
                    </div>
                </form>
            </div>
        </div>

        <script src="../resources/js/login.js"></script>

    </body>
</html>
