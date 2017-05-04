
<%@page import="com.proyectorat.manager.UsuarioManagerImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Cargo"%>
<%@page import="com.proyectorat.manager.CargoManagerImpl"%>
<%@page import="com.proyectorat.model.Usuario"%>
<%
    CargoManagerImpl nc = new CargoManagerImpl();
    Cargo cargo = new Cargo();
    ArrayList<Cargo> LC = new ArrayList<>();
    LC = nc.getListado();
%>
<%
    UsuarioManagerImpl nu = new UsuarioManagerImpl();
    Usuario usuario = new Usuario();
    ArrayList<Usuario> LU = new ArrayList<>();
    LU = nu.getListado();
%>
<%
    String username = request.getParameter("txtUsuario");
    String name = request.getParameter("txtNombre");
    String passwd = request.getParameter("txtContrasena");
    String status = request.getParameter("cmbEstado");
    String profile = request.getParameter("cmbPerfil");
    String email = request.getParameter("txtCorreo");
    
    String men = (String) request.getAttribute("mensajes") !=null ? (String) request.getAttribute("mensajes"):"";
    
    Usuario usuVO = new Usuario();
    usuVO = (Usuario) request.getAttribute("datos") != null ? (Usuario) request.getAttribute("datos"): null;
    
    if (usuVO != null){
        username = usuVO.getUsuario();
        name = usuVO.getNombre();
        passwd = usuVO.getClave();
        status = usuVO.getEstado();
        profile = usuVO.getPerfil();
        email = usuVO.getEmail();
    }
%>
<% String Titulo = "Registro de usuarios"; %>
<%@include file="includes/header.jsp" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Registro de usuarios</h1>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <form role="form">

                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Nombre de usuario" name="txtUsuario" value="">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Nombre" name="txtNombre">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Contraseña" type="password" name="txtContrasena">
                                                </div>

                                                <div class="form-group">
                                                    <select class="form-control" name="cmbEstado">
                                                        <option>Seleccione estado</option>
                                                        <option>Activo</option>
                                                        <option>Inactivo</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <select class="form-control" name="cmbPerfil">
                                                        <option value="">Seleccione perfil</option>
                                                        <%if(LC != null){%>
                                                            <%for (Cargo carg:LC) {%>
                                                                <option value="<%=carg.getId_cargo()%>">
                                                                    <%=carg.getNombre()%>
                                                                </option>
                                                            <%}%>
                                                        <%}%>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Correo electrónico" type="email">
                                                </div>

                                                <button type="submit" class="btn btn-default">Guardar</button>
                                                <button type="reset" class="btn btn-default">Limpiar</button>
                                                <button type="submit" class="btn btn-default">Actualizar</button>
                                                <button type="submit" class="btn btn-default">Buscar</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<%@include file="includes/footer.jsp" %>