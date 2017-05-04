
package com.proyectorat.servlet;

import com.proyectorat.manager.MD5;
import com.proyectorat.manager.UsuarioManagerImpl;
import com.proyectorat.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author RAT
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Usuario usuarioVO = new Usuario();
    UsuarioManagerImpl nu = new UsuarioManagerImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try {
            boolean existeUsuario = false;
            
            String user = request.getParameter("user");
            String password = MD5.encriptMD5(request.getParameter("password"));
            
            String usuario = "";
            String nombre = "";
            
            try {
                usuarioVO = nu.getUsuario(user);
                if (usuarioVO.getEstado().equals("Activo")) {
                    if (usuarioVO.getClave().equals(password)) {
                        existeUsuario = true;
                        usuario = usuarioVO.getUsuario();
                        nombre = usuarioVO.getNombre();
                    }
                }
            } catch (Exception e) {
            }
            
            if (existeUsuario) {
                request.setAttribute("usuario", usuario);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                request.setAttribute("nombre", nombre);
                
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            out.close();
        } catch(ServletException | IOException e){
            out.println(e.toString());
        }
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
