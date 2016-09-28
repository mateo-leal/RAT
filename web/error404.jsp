<%@page import="java.util.ArrayList"%>
<%@page import="com.proyectorat.model.Entrada"%>
<%@page import="com.proyectorat.manager.EntradaManagerImpl"%>
<%
    EntradaManagerImpl ne = new EntradaManagerImpl();
    Entrada entrada = new Entrada();
    ArrayList<Entrada> LE = new ArrayList<>();
    LE = ne.getListado();
%>
<% String Titulo = "Error 404"; %>
<%@include file="includes/header.jsp" %>

            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Error 404</h1>
                        </div>

                        <div class="col-lg-12">
                        <div class="panel-body">
                            ¡La página que intenta buscar NO EXISTE!
                        </div>
                    </div>
                </div>
            </div>
<%@include file="includes/footer.jsp" %>