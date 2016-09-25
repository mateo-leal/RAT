package com.proyectorat.servlet;

import com.proyectorat.model.Empleado;
import com.proyectorat.manager.EmpleadoManagerImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpleadoServlet extends HttpServlet {
    
    Empleado empVO = new Empleado();
    EmpleadoManagerImpl ne = new EmpleadoManagerImpl();

    public void limpiarCampos(){

        empVO.setId_empleado(null);
        empVO.setNombre("");
        empVO.setApellidos("");
        empVO.setFecha_n(null);
        empVO.setTelefono(null);
        empVO.setDireccion("");
        empVO.setEmail("");
        empVO.setEstado("");
        empVO.setId_cargo(null);
        
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date uDate;
        String strDate = request.getParameter("dteFecha");
        
        try {
            uDate = sdf.parse(strDate);
            java.sql.Date fecha_n = new java.sql.Date(uDate.getTime());
            if (empVO != null){
                fecha_n = empVO.getFecha_n();
            }
            if ("grabar".equals(request.getParameter("action"))) {
                empVO.setFecha_n(fecha_n);
            }
        } catch (Exception ex) {
        }

        Integer idempleado = Integer.parseInt(request.getParameter("txtID_Empleado"));
        String name = request.getParameter("txtNombre");
        String last = request.getParameter("txtApellidos");
        Integer tele = Integer.parseInt(request.getParameter("txtTelefono"));
        String dire = request.getParameter("txtDireccion");
        String email = request.getParameter("txtCorreo");
        String status = request.getParameter("cmbEstado");
        Integer carg = Integer.parseInt(request.getParameter("cmbCargo"));
        
        String modulo = "registro-employee.jsp";
        String men = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("listado", null);
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                empVO = ne.getEmpleado(idempleado);
                if (!"*".equals(empVO.getId_empleado())) {
                    request.setAttribute("datos", empVO);
                } else {
                    limpiarCampos();
                    request.setAttribute("datos", empVO);
                    men = "El empleado "+ idempleado +" no se encuentra registrado";
                }
            } catch (Exception e) {
            }
        }
        
        if ("todos".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", ne.getListado());
            } catch (Exception e) {
                request.setAttribute("listado", null);
            }
        }
        
        if ("guardar".equals(request.getParameter("action"))) {
            empVO.setId_empleado(idempleado);
            empVO.setNombre(name);
            empVO.setApellidos(last);
            empVO.setTelefono(tele);
            empVO.setDireccion(dire);
            empVO.setEmail(email);
            empVO.setEstado(status);
            empVO.setId_cargo(carg);
            try {
                ne.getGuardarEmpleado(empVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                if (men.substring(0, 3).equals("Pro")) {
                   limpiarCampos();
                   request.setAttribute("datos", empVO);
                }
            }
        }
        
        if ("editar".equals(request.getParameter("action"))) {
            empVO.setId_empleado(idempleado);
            empVO.setNombre(name);
            empVO.setApellidos(last);
            empVO.setTelefono(tele);
            empVO.setDireccion(dire);
            empVO.setEmail(email);
            empVO.setEstado(status);
            empVO.setId_cargo(carg);
            try {
                ne.getEditarEmpleado(empVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                if (men.substring(0, 3).equals("Pro")) {
                   limpiarCampos();
                   request.setAttribute("datos", empVO);
                }
            }
        }
        
        if ("cancelar".equals(request.getParameter("action"))) {
            limpiarCampos();
            request.setAttribute("datos", empVO);
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            try{
                ne.getEliminarEmpleado(idempleado);
            }catch (Exception e){
                men+=""+e.getMessage();
                limpiarCampos();
                request.setAttribute("datos", empVO);
            }
            
        }
        
        request.setAttribute("mensajes", men);
        request.getRequestDispatcher(modulo).forward(request, response);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}