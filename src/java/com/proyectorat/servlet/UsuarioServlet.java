package com.proyectorat.servlet;

import com.proyectorat.manager.UsuarioManagerImpl;
import com.proyectorat.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioServlet extends HttpServlet {
    
    Usuario usuVO = new Usuario();
    UsuarioManagerImpl nu = new UsuarioManagerImpl();

    public void limpiarCampos(){

        usuVO.setUsuario("");
        usuVO.setNombre("");
        usuVO.setClave("");
        usuVO.setEstado("");
        usuVO.setPerfil("");
        usuVO.setEmail("");
        
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String usuario = request.getParameter("txtUsuario");
        String nombre = request.getParameter("txtNombre");
        String contrasena = request.getParameter("txtContrasena");
        String estado = request.getParameter("cmbEstado");
        String perfil = request.getParameter("cmbPerfil");
        String correo = request.getParameter("txtCorreo");
        
        String modulo = "registro-user.jsp";
        String men = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("listado", null);
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                usuVO = nu.getUsuario(usuario);
                if (!"*".equals(usuVO.getUsuario())) {
                    request.setAttribute("datos", usuVO);
                } else {
                    limpiarCampos();
                    request.setAttribute("datos", usuVO);
                    men = "El usuario "+ usuario +" no se encuentra registrado";
                }
            } catch (Exception e) {
            }
        }
        
        if ("todos".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", nu.getListado());
            } catch (Exception e) {
                request.setAttribute("listado", null);
            }
        }
        
        if ("guardar".equals(request.getParameter("action"))) {
            usuVO.setUsuario(usuario);
            usuVO.setNombre(nombre);
            usuVO.setClave(contrasena);
            usuVO.setEstado(estado);
            usuVO.setPerfil(perfil);
            usuVO.setEmail(correo);
            try {
                nu.getGuardarUsuario(usuVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",usuVO);
                }
            }
        }
        
        if ("editar".equals(request.getParameter("action"))) {
            usuVO.setUsuario(usuario);
            usuVO.setNombre(nombre);
            usuVO.setClave(contrasena);
            usuVO.setEstado(estado);
            usuVO.setPerfil(perfil);
            usuVO.setEmail(correo);
            try {
                nu.getEditarUsuario(usuVO);
            } catch (Exception e) {
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",usuVO);
                }
            }
        }
        
        if ("cancelar".equals(request.getParameter("action"))) {
            limpiarCampos();
            request.setAttribute("datos", usuVO);
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            try{
                nu.getEliminarUsuario(usuario);
            }catch (Exception e){
                men+=""+e.getMessage();
                int tam= men.length();
                if(men.substring(tam-1, tam).equals("!")){
                    limpiarCampos();
                    request.setAttribute("datos",usuVO);
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