
<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Empleado"%>
<%@page import="com.proyectorat.manager.EmpleadoManagerImpl"%>
<%
    EmpleadoManagerImpl ne = new EmpleadoManagerImpl();
    Empleado empleado = new Empleado();
    ArrayList<Empleado> LE = new ArrayList<>();
    LE = ne.getListado();
%>
<% String Titulo = "Registro de empleados"; %>
<%@include file="includes/header.jsp" %>

            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Empleados</h1>
                        </div>

                        <div class="col-lg-12">
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
                                            <th>Estado</th>
                                            <th>Cargo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%if(LE!=null){%>
                                            <%for(Empleado e:LE){%>
                                                <tr class="gradeC">
                                                    <td><%=e.getId_empleado()%></td>
                                                    <td><%=e.getNombre()%></td>
                                                    <td><%=e.getApellidos()%></td>
                                                    <td><%=e.getFecha_n()%></td>
                                                    <td><%=e.getTelefono()%></td>
                                                    <td><%=e.getDireccion()%></td>
                                                    <td><%=e.getEmail()%></td>
                                                    <td><%=e.getEstado()%></td>
                                                    <td><%=e.getId_cargo()%></td>
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
<%@include file="includes/footer.jsp" %>