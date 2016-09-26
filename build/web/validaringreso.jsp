<%-- 
    Document   : validaringreso
    Created on : 29/08/2016, 08:15:09 PM
    Author     : mateolegi
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.pinvalidda.util.Conexion"%>
<%@page import="com.pinvalidda.persistence.SQL_Helpers"%>
<%

    int b = 0;
    String usu = null;
    String pas = null;

    String usuario = request.getParameter("usuario");
    String pass = request.getParameter("pass");

    try {
        Conexion co = new Conexion();
        ResultSet r = co.getCon().prepareStatement(SQL_Helpers.getUsuario(usuario)).executeQuery();
        while (r.next()) {
            usu = r.getString(1);
            pas = r.getString(3);

            if (usu.equals(usuario) && pas.equals(pass)) {
                b = 1;
            } else {
                b = 0;
            }
        }

        if (b == 1) {
            String ja = usuario;
            HttpSession op = request.getSession();
            op.putValue("varUsuario", ja);
            out.println("<script>alert('Usuario identificado correctamente')</script>");
            out.println("<meta http-equiv='refresh' content='0;url=menu.jsp'");
        } else {
            out.println("<script>alert('"+usuario+"')</script>");
            out.println("<meta http-equiv='refresh' content='0;url=login.jsp'");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

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
                <form role="form" action="validaringreso.jsp">
                    <div class="login-form">
                        <h1><a href="menu.jsp"><img src="../resources/images/logo.png" alt="Pinvalidda" width="250"></a></h1>
                        <div class="form-group log-status ">
                            <input type="text" class="form-control" name="user" placeholder="Nombre de usuario" id="usuario">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="form-group log-status">
                            <input type="password" class="form-control" name="password" placeholder="Contraseña" id="pass">
                            <i class="fa fa-lock"></i>
                        </div>
                        <a class="link" href="#">¿Olvidaste tu contraseña?</a>
                        <button type="submit" class="btn btn-default log-btn" >Iniciar sesión</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
