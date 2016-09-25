
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.pinvalidda.model.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pinvalidda.model.Cargo"%>
<%@page import="com.pinvalidda.business.CargoManagerImpl"%>
<%
    CargoManagerImpl nc = new CargoManagerImpl();
    Cargo cargo = new Cargo();
    ArrayList<Cargo> LC = new ArrayList<>();
    LC = nc.getListado();

    ArrayList<Empleado> LE = new ArrayList<>();
    LE=(ArrayList<Empleado>) request.getAttribute("listado") != null 
            ? (ArrayList<Empleado>) request.getAttribute("listado"): null;
    
    String men = (String) request.getAttribute("mensajes") !=null 
            ? (String) request.getAttribute("mensajes"):"";
    
    Empleado empVO = new Empleado();
    empVO = (Empleado) request.getAttribute("datos") != null
            ? (Empleado) request.getAttribute("datos"): null;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date uDate;
    String strDate = request.getParameter("dteFecha");
    try {
        uDate = sdf.parse(strDate);
        java.sql.Date fecha_n = new java.sql.Date(uDate.getTime());
        if (empVO != null){
            fecha_n = empVO.getFecha_n();
        }
    } catch (Exception ex) {
    }
    String idempleado = request.getParameter("txtID_Empleado");
    String name = request.getParameter("txtNombre");
    String last = request.getParameter("txtApellidos");
    String tele = request.getParameter("txtTelefono");
    String dire = request.getParameter("txtDireccion");
    String email = request.getParameter("txtCorreo");
    String status = request.getParameter("cmbEstado");
    String carg = request.getParameter("cmbCargo");
 
    if (empVO != null){
        idempleado = empVO.getId_empleado();
        name = empVO.getNombre();
        last = empVO.getApellidos();
        tele = empVO.getTelefono();
        dire = empVO.getDireccion();
        email = empVO.getEmail();
        status = empVO.getEstado();
        carg = empVO.getId_cargo();
    }
%>
<% String Titulo = "Registro de empleados"; %>
<%@include file="includes/header.jsp" %>

            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Registro de empleados</h1>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <form role="form" method="post" action="./EmpleadoServlet">

                                                <div class="form-group">
                                                    <input class="form-control" placeholder="ID del empleado" name="txtID_Empleado" value="<%=idempleado!=null ? idempleado:""%>" size="4">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Nombre" name="txtNombre" value="<%=name!=null ? name:""%>" size="60">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Apellido" name="txtApellidos" size="60" value="<%=last!=null ? last:""%>">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" type="date" name="dteFecha" value="strDate">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Teléfono" name="txtTelefono" size="13" value="<%=tele!=null ? tele:""%>">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Dirección" name="txtDireccion" size="100" value="<%=dire!=null ? dire:""%>">
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control" placeholder="Correo electrónico" type="email" name="txtCorreo" size="60" value="<%=email!=null ? email:""%>">
                                                </div>

                                                <div class="form-group">
                                                    <select class="form-control" name="cmbEstado" value="<%=status!=null ? status:""%>">
                                                        <option>Seleccione estado</option>
                                                        <option value="Activo">Activo</option>
                                                        <option value="Inactivo">Inactivo</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <select class="form-control" name="cmbCargo" value="<%=carg!=null ? carg:""%>">
                                                        <option>Seleccione perfil</option>
                                                        <option>CEO</option>
                                                        <option>Programador</option>
                                                        <option>Diseñador</option>
                                                        <option>Analista</option>
                                                    </select>
                                                </div>
                                                <jsp:include flush="false" page="includes/buttons.jsp"></jsp:include>
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