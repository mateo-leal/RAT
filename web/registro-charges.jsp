<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Cargo"%>
<%@page import="com.proyectorat.manager.CargoManagerImpl"%>
<%
    CargoManagerImpl nc = new CargoManagerImpl();
    ArrayList<Cargo> LC = nc.getListado();

    String men = (String) request.getAttribute("mensajes") != null
            ? (String) request.getAttribute("mensajes") : "";

    Cargo carVO = new Cargo();
    carVO = (Cargo) request.getAttribute("datos") != null
            ? (Cargo) request.getAttribute("datos") : null;

    String idCargo = request.getParameter("txtIdCargo");
    String cargo = request.getParameter("txtNombre");
    String salario = request.getParameter("txtSalario");
    String estado = request.getParameter("cmbEstado");
    if (carVO != null) {
        idCargo = carVO.getId_cargo();
        cargo = carVO.getNombre();
        salario = carVO.getSalario();
        estado = carVO.getEstado();
    }
%>
<% String Titulo = "Cargos";%>
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
                            <form role="form" action="CargoServlet" method="post">
                                <div class="col-lg-6">

                                    <div class="form-group">
                                        <input class="form-control" name="txtIdCargo" placeholder="ID del cargo" value="<%=idCargo != null ? idCargo : ""%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="txtNombre" placeholder="Nombre" value="<%=cargo != null ? cargo : ""%>">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input class="form-control" name="txtSalario" placeholder="Salario" value="<%=salario != null ? salario : ""%>">
                                    </div>

                                    <div class="form-group">
                                        <select class="form-control" name="cmbEstado">
                                            <option value="">Seleccione estado</option>
                                            <option value="Activo"<%if ("Activo".equals(estado)) {%>selected<%}%>>Activo</option>
                                            <option value="Inactivo"<%if ("Inactivo".equals(estado)) {%>selected<%}%>>Inactivo</option>
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
                                            <th>ID del cargo</th>
                                            <th>Nombre</th>
                                            <th>Salario</th>
                                            <th>Estado</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%if (LC != null) {%>
                                    <%for (Cargo c : LC) {%>
                                    <tr class="gradeC">
                                        <td><%=c.getId_cargo()%></td>
                                        <td><%=c.getNombre()%></td>
                                        <td><%=c.getSalario()%></td>
                                        <td><%=c.getEstado()%></td>
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
<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>
<script src="resources/js/sb-admin-2.js"></script>

</body>

</html>
