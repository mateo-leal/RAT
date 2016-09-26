<%-- 
    Document   : consulta-user
    Created on : 29/08/2016, 09:57:58 PM
    Author     : RAT
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.pinvalidda.model.Usuario"%>
<%@page import="com.pinvalidda.business.UsuarioManagerImpl"%>
<%
    UsuarioManagerImpl nu = new UsuarioManagerImpl();
    Usuario usuario = new Usuario();
    ArrayList<Usuario> LU = new ArrayList<Usuario>();
    LU = nu.getListado();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="RAT">

        <title>Usuarios</title>

        <link rel="icon" href="../resources/images/favicon128.ico" type="image/x-icon"/>
        <link rel="shorcut icon" href="../resources/images/favicon128.ico" type="image/x-icon"/>

        <link href="../resources/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
        <link href="../resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
        <link href="../resources/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
        <link href="../resources/css/style.css" rel="stylesheet">
        <link href="../resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>

    <body>

        <div id="wrapper">

            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><img src="../resources/images/logo.png" alt="Pinvalidda" width="130"></a>
                </div>

                <ul class="nav navbar-top-links navbar-right">

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">

                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Servidor actualizado
                                        <span class="pull-right text-muted small">Hace cuatro minutos</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>Ver todas las notificaciones</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Cerrar sesión</a>
                            </li>
                        </ul>
                    </li>
                </ul>

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="index.jsp"><i class="fa fa-home fa-fw"></i> Inicio</a>
                            </li>
                            <li >
                                <a href="#"><i class="fa fa-user fa-fw"></i> Usuarios<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="consulta-user.jsp"><i class="fa fa-search fa-fw"></i> Consultar usuarios</a>
                                    </li>
                                    <li>
                                        <a href="registro-user.jsp"><i class="fa fa-user fa-fw"></i> Registro de usuarios</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-male fa-fw"></i> Empleados<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="consulta-employee.jsp"><i class="fa fa-search fa-fw"></i> Consultar empleados</a>
                                    </li>
                                    <li>
                                        <a href="registro-employee.jsp"><i class="fa fa-male fa-fw"></i> Registro de empleados</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#"><i class="fa fa-exchange fa-fw"></i> Entradas y salidas<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="consulta-inandout.jsp"><i class="fa fa-search fa-fw"></i> Consultar entradas y salidas</a>
                                    </li>
                                    <li>
                                        <a href="registro-inandout.jsp"><i class="fa fa-exchange fa-fw"></i> Registro de entrada y salida</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#"><i class="fa fa-suitcase fa-fw"></i> Cargos<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="consulta-charges.jsp"><i class="fa fa-search fa-fw"></i> Consultar cargos</a>
                                    </li>
                                    <li>
                                        <a href="registro-charges.jsp"><i class="fa fa-suitcase fa-fw"></i> Registro de cargos</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-list-ul fa-fw"></i> Actividades<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="consulta-activities.jsp"><i class="fa fa-search fa-fw"></i>Consultar asignación de actividades</a>
                                    </li>
                                    <li>
                                        <a href="registro-activities.jsp"><i class="fa fa-list-ul fa-fw"></i> Asignación de actividades</a>
                                    </li>
                                    <li>
                                        <a href="types-consulta.jsp"><i class="fa fa-search fa-fw"></i> Consultar registro de actividades</a>
                                    </li>
                                    <li>
                                        <a href="registro-types.jsp"><i class="fa fa-send-o fa-fw"></i> Registro de actividades</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Usuarios</h1>
                        </div>

                        <div class="col-lg-12">
                            <div class="panel-body">
                                <div class="dataTable_wrapper">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Nombre de usuario</th>
                                                <th>Nombre</th>
                                                <!--<th>Contraseña</th>-->
                                                <th>Perfil</th>
                                                <th>Correo electrónico</th>
                                                <th>Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <%if (LU != null) {%>
                                            <%for (Usuario user : LU) {%>
                                            <tr class="gradeC">
                                                <td><%=user.getUsuario()%></td>
                                                <td><%=user.getNombre()%></td>
                                                <!--<td><%// =user.getClave()%></td>-->
                                                <td><%=user.getPerfil()%></td>
                                                <td><%=user.getEmail()%></td>
                                                <td><%=user.getEstado()%></td>
                                            </tr>
                                            <%}%>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="../resources/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="../resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>
        <script src="../resources/js/sb-admin-2.js"></script>
        <script src="../resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
        <script src="../resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
        <script src="../resources/bower_components/datatables-responsive/js/dataTables.responsive.js"></script>

        <script src="../resources/dist/js/sb-admin-2.js"></script>

        <script>
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>

    </body>

</html>
