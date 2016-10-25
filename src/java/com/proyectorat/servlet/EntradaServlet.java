package com.proyectorat.servlet;

import com.proyectorat.model.Entrada;
import com.proyectorat.manager.EntradaManagerImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntradaServlet extends HttpServlet {
    
    Entrada eysVO = new Entrada();
    EntradaManagerImpl ne = new EntradaManagerImpl();

    public void limpiarCampos(){

        eysVO.setId_empleado(null);
        eysVO.setCons(null);
        eysVO.setHora_entrada(null);
        eysVO.setHora_salida(null);
        eysVO.setFecha(null);
        
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String idempleado = request.getParameter("txtID_Empleado");
        String consecutivo =request.getParameter("txtConsecutivo");
        String date = request.getParameter("dteFecha");
        String strHora_E = request.getParameter("dteHora_E");
        String strHora_S = request.getParameter("dteHora_S");
        
        String modulo = "registro-inandout.jsp";
        String men = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("listado", null);
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                eysVO = ne.getEntrada(consecutivo);
                if (null != eysVO.getCons()) {
                    request.setAttribute("datos", eysVO);
                } else {
                    limpiarCampos();
                    request.setAttribute("datos", eysVO);
                    men = "El registro "+ consecutivo +" no existe";
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
            eysVO.setCons(consecutivo);
            eysVO.setId_empleado(idempleado);
            eysVO.setFecha(date);
            eysVO.setHora_entrada(strHora_E);
            eysVO.setHora_salida(strHora_S);
            
            try {
                ne.getGuardarEntrada(eysVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",eysVO);
                }
            }
        }
        
        if ("editar".equals(request.getParameter("action"))) {
            eysVO.setCons(consecutivo);
            eysVO.setId_empleado(idempleado);
            eysVO.setFecha(date);
            eysVO.setHora_entrada(strHora_E);
            eysVO.setHora_salida(strHora_S);
            
            try {
                ne.getEditarEntrada(eysVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",eysVO);
                }
            }
        }
        
        if ("cancelar".equals(request.getParameter("action"))) {
            limpiarCampos();
            request.setAttribute("datos", eysVO);
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            try{
                ne.getEliminarEntrada(consecutivo);
                        
            }catch (Exception e){
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",eysVO);
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