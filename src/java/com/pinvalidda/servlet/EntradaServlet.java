package com.pinvalidda.servlet;

import com.pinvalidda.model.Entrada;
import com.pinvalidda.business.EntradaManagerImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
        eysVO.setHora_E(null);
        eysVO.setHora_S(null);
        eysVO.setFecha_n(null);
        
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        java.util.Date uDate;
        String strDate = request.getParameter("dteFecha");
        String strHora_E = request.getParameter("dteHora_E");
        String strHora_S = request.getParameter("dteHora_S");
        
        try {
            uDate = sdf.parse(strDate);
            java.sql.Date fecha_n = new java.sql.Date(uDate.getTime());
            uDate = sdf2.parse(strHora_E);
            java.util.Date hora_e = java.sql.Date(uDate.getTime());
            uDate = sdf2.parse(strHora_S);
            java.util.Date hora_s = java.sql.Date(uDate.getTime());
            if (eysVO != null){
                hora_e = eysVO.getHora_entrada();
                hora_s = eysVO.getHora_salida();
                fecha_n = eysVO.getFecha_n();
            }
            if ("grabar".equals(request.getParameter("action"))) {
                eysVO.setHora_entrada(hora_e);
                eysVO.setHora_salida(hora_s);
                eysVO.setFecha_n(fecha_n);
            }
        } catch (Exception ex) {
        }

        Integer idempleado = Integer.parseInt(request.getParameter("txtID_Empleado"));
        Integer cons = Integer.parseInt(request.getParameter("txtCons"));
        
        String modulo = "registro-inandout.jsp";
        String men = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("listado", null);
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                eysVO = ne.getEntrada(idempleado);
                if (!"*".equals(eysVO.getId_empleado())) {
                    request.setAttribute("datos", eysVO);
                } else {
                    limpiarCampos();
                    request.setAttribute("datos", eysVO);
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
            eysVO.setId_empleado(idempleado);
            eysVO.setCons(cons);
            eysVO.setHora_E(last);
            eysVO.setTelefono(tele);
            eysVO.setDireccion(dire);
            eysVO.setEmail(email);
            eysVO.setEstado(status);
            eysVO.setId_cargo(carg);
        }
        
        if ("editar".equals(request.getParameter("action"))) {
            men = "implementar editar";
        }
        
        if ("cancelar".equals(request.getParameter("action"))) {
            limpiarCampos();
            request.setAttribute("datos", eysVO);
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            men = "implementar eliminar";
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