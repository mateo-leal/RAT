package com.proyectorat.manager;

import com.proyectorat.model.Registro;
import com.proyectorat.persistence.Dao_Registro;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class RegistroManagerImpl {

    Connection c;
    Dao_Registro dao;

    public RegistroManagerImpl() {
        dao = new Dao_Registro();
    }

    public Registro getRegistro(String idempleado) {

        c = new Conexion().getCon();
        return dao.getRegistro(c, Integer.parseInt(idempleado));
    }
    
    public String getCons() {

        c = new Conexion().getCon();
        return dao.getCons(c, "tblregistro_actividades", "cons", 4);
    }

    public ArrayList<Registro> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoRegistros(c);
    }

    public void getGuardarRegistro(Registro u) throws Exception {
        String emp, con, act;
        String mensaje, usu, est;
        String fec;
        emp = u.getId_empleado();
        con = u.getCons();
        act = u.getId_actividad();
        fec = u.getFecha();
        usu = u.getUsuario_creador();
        est = u.getEstado();
        
        mensaje = "";

        //Campos obligatorios
        if ("".equals(emp) || null == emp) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(con) || null == con) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(act) || null == act) {
            mensaje += "Ingrese clave";
        }
        
        if ("".equals(usu) || null == usu) {
            mensaje += "Ingrese perfil";
        }
        
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getGuardarRegistro(c, Integer.parseInt(emp), Integer.parseInt(con), Integer.parseInt(act), usu, Date.valueOf(fec), est);
    }
    
    public void getEditarRegistro(Registro u) throws Exception {
        String emp, con, act;
        String mensaje, usu, est;
        String fec;
        emp = u.getId_empleado();
        con = u.getCons();
        act = u.getId_actividad();
        fec = u.getFecha();
        usu = u.getUsuario_creador();
        est = u.getEstado();
        mensaje = "";

        //Campos obligatorios
        if ("".equals(emp) || null == emp) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }
        
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getEditarRegistro(c, Integer.parseInt(emp), Integer.parseInt(con), Integer.parseInt(act), usu, Date.valueOf(fec), est);
    }
    
    public Registro getEliminarRegistro(String idempleado) {

        c = new Conexion().getCon();
        return dao.getEliminarRegistro(c, Integer.parseInt(idempleado));
    }
}
