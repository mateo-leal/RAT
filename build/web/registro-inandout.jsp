
<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Entrada"%>
<%@page import="com.proyectorat.manager.EntradaManagerImpl"%>
<%
    EntradaManagerImpl ne= new EntradaManagerImpl();
    Entrada e= new Entrada();
    ArrayList<Entrada> LE= new ArrayList<>();
    LE = ne.getListado();
    
    String men = (String) request.getAttribute("mensajes") !=null 
            ? (String) request.getAttribute("mensajes"):"";
    
    Entrada eysVO = new Entrada();
    eysVO = (Entrada) request.getAttribute("datos") != null
            ? (Entrada) request.getAttribute("datos"): null;
    
    String id= request.getParameter("txtId");
    String con= request.getParameter("txtConsecutivo");
    String fec = request.getParameter("");
    String ent= request.getParameter("txtEntrada");
    String sal= request.getParameter("txtSalida");
 
    if(e != null){
        id= e.getId_empleado();
        con= e.getCons();
        ent= e.getHora_entrada();
        sal = e.getHora_salida();
    }
%>
<% String Titulo = "Registro de entradas y salidas"; %>
<%@include file="includes/header.jsp" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Entradas y salidas</h1>
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
                                                    <input class="form-control" placeholder="Consecutivo" name="txtConsecutivo" value="<%=con!=null ? con:""   %>">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="ID del empleado" name="txtID_Empleado" value="<%=id!=null ? id:""   %>">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" type="date" value="<%=con!=null ? con:""   %>">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Hora de entrada">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Hora de salida">
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