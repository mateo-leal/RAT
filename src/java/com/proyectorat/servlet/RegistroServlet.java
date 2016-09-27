package com.proyectorat.servlet;

import com.proyectorat.model.Registro;
import com.proyectorat.manager.RegistroManagerImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroServlet extends HttpServlet {
    
    Registro regVO = new Registro();
    RegistroManagerImpl nr = new RegistroManagerImpl();

    public void limpiarCampos(){

        regVO.setId_empleado("");
        regVO.setCons(nr.getCons());
        regVO.setId_actividad("");
        regVO.setUsuario_creador("");
        regVO.setFecha("");
        regVO.setEstado("");
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String idEmpleado = request.getParameter("txtIdEmpleado");
        String cons = request.getParameter("txtCons");
        String idActividad = request.getParameter("txtIdActividad");
        String usuarioCreador = request.getParameter("txtUsuario");
        String fecha = request.getParameter("dteFecha");
        String estado = request.getParameter("cmbEstado");
        
        String modulo = "registro-activities.jsp";
        String men = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("listado", null);
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                regVO = nr.getRegistro(idEmpleado);
                if (!"*".equals(regVO.getId_empleado())) {
                    request.setAttribute("datos", regVO);
                } else {
                    limpiarCampos();
                    request.setAttribute("datos", regVO);
                    men = "El empleado "+ idEmpleado +" no se encuentra registrado";
                }
            } catch (Exception e) {
            }
        }
        
        if ("todos".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", nr.getListado());
            } catch (Exception e) {
                request.setAttribute("listado", null);
            }
        }
        
        if ("guardar".equals(request.getParameter("action"))) {
            regVO.setId_empleado(idEmpleado);
            regVO.setCons(nr.getCons());
            regVO.setId_actividad(idActividad);
            regVO.setUsuario_creador(usuarioCreador);
            regVO.setFecha(fecha);
            regVO.setEstado(estado);
            try {
                nr.getGuardarRegistro(regVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",regVO);
                }
            }
        }
        
        if ("editar".equals(request.getParameter("action"))) {
            regVO.setId_empleado(idEmpleado);
            regVO.setCons(nr.getCons());
            regVO.setId_actividad(idActividad);
            regVO.setUsuario_creador(usuarioCreador);
            regVO.setFecha(fecha);
            regVO.setEstado(estado);
            try {
                nr.getEditarRegistro(regVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",regVO);
                }
            }
        }
        
        if ("cancelar".equals(request.getParameter("action"))) {
            limpiarCampos();
            request.setAttribute("datos", regVO);
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            try{
                nr.getEliminarRegistro(idEmpleado);
            }catch (Exception e){
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",regVO);
                }
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