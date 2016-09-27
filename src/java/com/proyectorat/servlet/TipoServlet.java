package com.proyectorat.servlet;

import com.proyectorat.model.Tipo;
import com.proyectorat.manager.TipoManagerImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoServlet extends HttpServlet {
    
    Tipo tipoVO = new Tipo();
    TipoManagerImpl ne = new TipoManagerImpl();

    public void limpiarCampos(){

        tipoVO.setId_actividad("");
        tipoVO.setActividad("");
        tipoVO.setDescripcion("");
        tipoVO.setEstado("");

        
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String idActividad = request.getParameter("txtIdActividad");
        String actividad = request.getParameter("txtActividad");
        String descripcion = request.getParameter("txtDescripcion");
        String estado = request.getParameter("txtEstado");
         
        String modulo = "registro-types.jsp";
        String men = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("listado", null);
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                tipoVO = ne.getTipo(idActividad);
                if (!"*".equals(tipoVO.getId_actividad())) {
                    request.setAttribute("datos", tipoVO);
                } else {
                    limpiarCampos();
                    request.setAttribute("datos", tipoVO);
                    men = "El tipo de actividad "+ idActividad +" no se encuentra registrado";
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
            tipoVO.setId_actividad(idActividad);
            tipoVO.setActividad(actividad);
            tipoVO.setDescripcion(descripcion);
            tipoVO.setEstado(estado);
            try {
                ne.getGuardarTipo(tipoVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",tipoVO);
                }
            }
        }
        
        if ("editar".equals(request.getParameter("action"))) {
            tipoVO.setId_actividad(idActividad);
            tipoVO.setActividad(actividad);
            tipoVO.setDescripcion(descripcion);
            tipoVO.setEstado(estado);
            try {
                ne.getEditarTipo(tipoVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",tipoVO);
                }
            }
        }
        
        if ("cancelar".equals(request.getParameter("action"))) {
            limpiarCampos();
            request.setAttribute("datos", tipoVO);
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            try{
                ne.getEliminarTipo(idActividad);
            }catch (Exception e){
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",tipoVO);
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