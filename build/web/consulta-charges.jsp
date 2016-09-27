<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Entrada"%>
<%@page import="com.proyectorat.manager.EntradaManagerImpl"%>
<%
    EntradaManagerImpl ne = new EntradaManagerImpl();
    Entrada entrada = new Entrada();
    ArrayList<Entrada> LE = new ArrayList<>();
    LE = ne.getListado();
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
                                        <tr class="gradeC">
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        
                                        </tr>
                                    </tbody>
                                </table>
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
            $(document).ready(function() {
                $('#dataTables-example').DataTable({
                responsive: true
                });
            });
        </script>

    </body>

</html>
