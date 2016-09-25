package com.proyectorat.servlet;

import com.proyectorat.model.Cargo;
import com.proyectorat.manager.CargoManagerImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CargoServlet extends HttpServlet {
    
    Cargo carVO = new Cargo();
    CargoManagerImpl nc = new CargoManagerImpl();

    public void limpiarCampos(){

        carVO.setId_cargo(null);
        carVO.setNombre("");
        carVO.setSalario("");
        carVO.setEstado("");
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        Integer idcargo = Integer.parseInt(request.getParameter("txtID_Cargo"));
        String name = request.getParameter("txtNombre");
        String salario = request.getParameter("txtSalario");
        String status = request.getParameter("cmbEstado");
        
        String modulo = "registro-charges.jsp";
        String men = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("listado", null);
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                carVO = nc.getCargo(idcargo);
                if (!"*".equals(carVO.getId_cargo())) {
                    request.setAttribute("datos", carVO);
                } else {
                    limpiarCampos();
                    request.setAttribute("datos", carVO);
                    men = "El cargo "+ idcargo +" no se encuentra registrado";
                }
            } catch (Exception e) {
            }
        }
        
        if ("todos".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", nc.getListado());
            } catch (Exception e) {
                request.setAttribute("listado", null);
            }
        }
        
        if ("guardar".equals(request.getParameter("action"))) {
            carVO.setId_cargo(idcargo);
            carVO.setNombre(name);
            carVO.setSalario(salario);
            carVO.setEstado(status);
        }
        
        if ("editar".equals(request.getParameter("action"))) {
            men = "implementar editar";
        }
        
        if ("cancelar".equals(request.getParameter("action"))) {
            limpiarCampos();
            request.setAttribute("datos", carVO);
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