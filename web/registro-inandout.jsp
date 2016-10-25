
<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Entrada"%>
<%@page import="com.proyectorat.manager.EntradaManagerImpl"%>
<%
    EntradaManagerImpl ne = new EntradaManagerImpl();
    ArrayList<Entrada> LE = new ArrayList<>();
    LE = ne.getListado();

    Calendar calendar = Calendar.getInstance();
    String dia = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);

    String men = (String) request.getAttribute("mensajes") != null
            ? (String) request.getAttribute("mensajes") : "";

    Entrada eysVO = new Entrada();
    eysVO = (Entrada) request.getAttribute("datos") != null
            ? (Entrada) request.getAttribute("datos") : null;

    String id = request.getParameter("txtID_Empleado");
    String con = request.getParameter("txtConsecutivo");
    String fec = request.getParameter("dteFecha");
    String ent = request.getParameter("dteHora_E");
    String sal = request.getParameter("dteHora_S");

    if (eysVO != null) {
        id = eysVO.getId_empleado();
        con = eysVO.getCons();
        fec = eysVO.getFecha();
        ent = eysVO.getHora_entrada();
        sal = eysVO.getHora_salida();
    }
%>
<% String Titulo = "Entradas y salidas";%>
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
                            <form role="form" action="EntradaServlet" method="post">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Consecutivo" name="txtConsecutivo" value="<%=con != null ? con : ""%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="ID del empleado" name="txtID_Empleado" value="<%=id != null ? id : ""%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="date" max="<%=dia%>" name="dteFecha" value="<%=fec != null ? fec : ""%>">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Hora de entrada" name="dteHora_E" value="<%=ent != null ? ent : ""%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Hora de salida"  name="dteHora_S" value="<%=sal != null ? sal : ""%>">
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
                                            <th>Identificador</th>
                                            <th>ID del empleado</th>
                                            <th>Nombre del empleado</th>
                                            <th>Fecha</th>
                                            <th>Hora de entrada</th>
                                            <th>Hora de salida</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%if (LE != null) {%>
                                    <%for (Entrada entrada : LE) {%>
                                    <tr class="gradeC">
                                        <td><%=entrada.getCons()%></td>
                                        <td><%=entrada.getId_empleado()%></td>
                                        <td><%=entrada.getNombre()%></td>
                                        <td><%=entrada.getFecha()%></td>
                                        <td><%=entrada.getHora_entrada()%></td>
                                        <td><%=entrada.getHora_salida()%></td>
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