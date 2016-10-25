<%@page import="com.proyectorat.manager.EmpleadoManagerImpl"%>
<%@page import="com.proyectorat.model.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Cargo"%>
<%@page import="com.proyectorat.manager.CargoManagerImpl"%>
<%
    CargoManagerImpl nc = new CargoManagerImpl();
    ArrayList<Cargo> LC = nc.getListado();
    EmpleadoManagerImpl ne = new EmpleadoManagerImpl();
    ArrayList<Empleado> LEm = ne.getListado();

    String men = (String) request.getAttribute("mensajes") != null
            ? (String) request.getAttribute("mensajes") : "";

    Empleado empVO = new Empleado();
    empVO = (Empleado) request.getAttribute("datos") != null
            ? (Empleado) request.getAttribute("datos") : null;

    String idempleado = request.getParameter("txtID_Empleado");
    String name = request.getParameter("txtNombre");
    String last = request.getParameter("txtApellidos");
    String date = request.getParameter("dteFecha");
    String tele = request.getParameter("txtTelefono");
    String dire = request.getParameter("txtDireccion");
    String email = request.getParameter("txtCorreo");
    String status = request.getParameter("cmbEstado");
    String carg = request.getParameter("cmbCargo");

    if (empVO != null) {
        idempleado = empVO.getId_empleado();
        name = empVO.getNombre();
        last = empVO.getApellidos();
        date = empVO.getFecha_n();
        tele = empVO.getTelefono();
        dire = empVO.getDireccion();
        email = empVO.getEmail();
        status = empVO.getEstado();
        carg = empVO.getId_cargo();
    }
%>
<% String Titulo = "Empleados";%>
<%@include file="includes/header.jsp" %>

<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"><%=Titulo%></h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <form role="form" method="post" action="EmpleadoServlet">
                                <div class="col-lg-6">

                                    <div class="form-group">
                                        <input class="form-control" placeholder="ID del empleado" name="txtID_Empleado" value="<%=idempleado != null ? idempleado : ""%>" size="4" required>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Nombre" name="txtNombre" value="<%=name != null ? name : ""%>" size="60">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Apellido" name="txtApellidos" size="60" value="<%=last != null ? last : ""%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="date" name="dteFecha" value="<%=date != null ? date : ""%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Teléfono" name="txtTelefono" size="13" value="<%=tele != null ? tele : ""%>">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Dirección" name="txtDireccion" size="100" value="<%=dire != null ? dire : ""%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Correo electrónico" type="email" name="txtCorreo" size="60" value="<%=email != null ? email : ""%>">
                                    </div>

                                    <div class="form-group">
                                        <select class="form-control" name="cmbEstado">
                                            <option value="">Seleccione estado</option>
                                            <option value="Activo"<%if ("Activo".equals(status)) {%>selected<%}%>>Activo</option>
                                            <option value="Inactivo"<%if ("Inactivo".equals(status)) {%>selected<%}%>>Inactivo</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="cmbCargo">
                                            <option value="">Seleccione perfil</option>
                                            <%if (LC != null) {%>
                                            <%for (Cargo ca : LC) {%>
                                            <option value="<%=ca.getId_cargo()%>"<% if (ca.getId_cargo().equals(carg)) { %> selected <% }%>><%=ca.getNombre()%></option>
                                            <%}%>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <center>
                                        <p><%=men != null ? men : ""%></p>
                                        <jsp:include flush="false" page="includes/buttons.jsp"></jsp:include>
                                    </center>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID del empleado</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Fecha de nacimiento</th>
                                        <th>Teléfono</th>
                                        <th>Dirección</th>
                                        <th>Correo electrónico</th>
                                        <th>Cargo</th>
                                        <th>Estado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%if (LEm != null) {%>
                                    <%for (Empleado e : LEm) {%>
                                    <tr class="gradeC">
                                        <td><%=e.getId_empleado()%></td>
                                        <td><%=e.getNombre()%></td>
                                        <td><%=e.getApellidos()%></td>
                                        <td><%=e.getFecha_n()%></td>
                                        <td><%=e.getTelefono()%></td>
                                        <td><%=e.getDireccion()%></td>
                                        <td><%=e.getEmail()%></td>
                                        <td><%=e.getId_cargo()%></td>
                                        <td><%=e.getEstado()%></td>
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
<%@include file="includes/footer.jsp" %>