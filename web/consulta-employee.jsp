

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
                                        <tr class="gradeC">
                                            <td>0001</td>
                                            <td>Mateo</td>
                                            <td>Leal</td>
                                            <td>15/12/1999</td>
                                            <td>2937152</td>
                                            <td>Cra 16b #32-50</td>
                                            <td>mateolegi@gmail.com</td>
                                            <td>Activo</td>
                                            <td>CEO</td>
                                        </tr>
                                        <tr class="gradeC">
                                            <td>0002</td>
                                            <td>Daniel</td>
                                            <td>Arboleda</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>Activo</td>
                                            <td>Diseñador</td>
                                        </tr>
                                        <tr class="gradeC">
                                            <td>0003</td>
                                            <td>Julián</td>
                                            <td>Castaño</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>Activo</td>
                                            <td>Programador</td>
                                        </tr>
                                        <tr class="gradeC">
                                            <td>0004</td>
                                            <td>Mateo</td>
                                            <td>Ortiz</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>Activo</td>
                                            <td>Programador</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<%@include file="includes/footer.jsp" %>