
<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Cargo"%>
<%@page import="com.proyectorat.manager.CargoManagerImpl"%>
<%
    CargoManagerImpl nc = new CargoManagerImpl();
    Cargo cargo = new Cargo();
    ArrayList<Cargo> LC = new ArrayList<>();
    LC = nc.getListado();
%>
<% String Titulo = "Registro de entradas y salidas"; %>
<%@include file="includes/header.jsp" %>

            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Cargos</h1>
                        </div>

                        <div class="col-lg-12">
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
                                        <%if(LC!=null){%>
                                            <%for(Cargo c:LC){%>
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
<%@include file="includes/footer.jsp" %>