package com.pinvalidda.business;

import com.pinvalidda.model.Usuario;
import com.pinvalidda.persistence.Dao_Usuario;
import com.pinvalidda.util.Conexion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class UsuarioManagerImpl {

    Connection c;
    Dao_Usuario dao;

    public UsuarioManagerImpl() {
        dao = new Dao_Usuario();
    }

    public Usuario getUsuario(String idusuario) {

        c = new Conexion().getCon();
        return dao.getUsuario(c, idusuario);
    }

    public ArrayList<Usuario> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoUsuarios(c);
    }
    
    public ArrayList<Usuario> getListadoUsuarios(Connection c, String campo, String valor){
        c = new Conexion().getCon();
        return dao.getListadoUsuarios(c, campo, valor);
    }

    public void getGuardarUsuario(Usuario u) throws Exception {
        String mensaje, usu, nom, cla, per, est, cor;
        usu = u.getUsuario();
        nom = u.getNombre();
        cla = u.getClave();
        per = u.getPerfil();
        est = u.getEstado();
        cor = u.getEmail();
        mensaje = "";
        
        //Campos obligatorios
        if ("".equals(usu) || null == usu) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(cla) || null == cla) {
            mensaje += "Ingrese clave";
        }
        
        if ("".equals(per) || null == per) {
            mensaje += "Ingrese perfil";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getGuardarUsuario(c, usu, nom, cla, est, per, cor);
    }
    
    public void getEditarUsuario(Usuario u) throws Exception {
        String mensaje, usu, nom, cla, per, est, cor;
        usu = u.getUsuario();
        nom = u.getNombre();
        cla = u.getClave();
        per = u.getPerfil();
        est = u.getEstado();
        cor = u.getEmail();
        mensaje = "";
        
        //Campos obligatorios
        if ("".equals(usu) || null == usu) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(cla) || null == cla) {
            mensaje += "Ingrese clave";
        }
        
        if ("".equals(per) || null == per) {
            mensaje += "Ingrese perfil";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getEditarUsuario(c, usu, nom, cla, est, per, cor);
    }
    
    public Usuario getEliminarUsuario(String usuario) {

        c = new Conexion().getCon();
        return dao.getEliminarUsuario(c, usuario);
    }
    
    public Usuario getValidarUsuario(String usuario, String contra){
        c = new Conexion().getCon();
        return dao.getValidarIngresoSistema(c, usuario, contra);
    }
}
