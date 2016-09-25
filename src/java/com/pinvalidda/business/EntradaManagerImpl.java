package com.pinvalidda.business;

import com.pinvalidda.model.Entrada;
import com.pinvalidda.persistence.Dao_Entrada;
import com.pinvalidda.util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class EntradaManagerImpl {

    Connection c;
    Dao_Entrada dao;

    public EntradaManagerImpl() {
        dao = new Dao_Entrada();
    }

    public Entrada getEntrada(String idempleado) {

        c = new Conexion().getCon();
        return dao.getEntrada(c, idempleado);
    }
    
    public Entrada getEntrada_Cons(String cons, String emp) {

        c = new Conexion().getCon();
        return dao.getEntrada_Cons(c, cons, emp);
    }
    
    public String getCons() {

        c = new Conexion().getCon();
        return dao.getCons(c, "tblentrada_salida", "cons", 4);
    }

    public ArrayList<Entrada> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoEntradas(c);
    }

    public void getGuardarEntrada(Entrada u) throws Exception {
        Integer emp, con;
        Date fec, hoe, hos;
        String mensaje;
        emp = u.getId_empleado();
        con = u.getCons();
        hoe = u.getHora_entrada();
        fec = u.getFecha();
        hos = u.getHora_salida();
        
        mensaje = "";

        //Campos obligatorios
        if ("".equals(emp) || null == emp) {
            mensaje += "Ingrese usuario";
        }
        //Campos no obligatorios
        
        if (null == fec) {
            mensaje += "\nIngrese fecha";
        }
        
        if ("".equals(hoe) || null == hoe) {
            mensaje += "\nIngrese hora de entrada";
        }
        
        if ("".equals(hos) || null == hos) {
            mensaje += "\nIngrese hora de salida";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getGuardarEntrada(c, emp, con, hoe, hos, fec);
    }
    
    public void getEditarEntrada(Entrada u) throws Exception {
        Integer emp, con;
        Date fec, hoe, hos;
        String mensaje;
        emp = u.getId_empleado();
        con = u.getCons();
        hoe = u.getHora_entrada();
        fec = u.getFecha();
        hos = u.getHora_salida();
        
        mensaje = "";

        //Campos obligatorios
        if ("".equals(emp) || null == emp) {
            mensaje += "Ingrese usuario";
        }
        //Campos no obligatorios
        
        if (null == fec) {
            mensaje += "\nIngrese fecha";
        }
        
        if ("".equals(hoe) || null == hoe) {
            mensaje += "\nIngrese hora de entrada";
        }
        
        if ("".equals(hos) || null == hos) {
            mensaje += "\nIngrese hora de salida";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getEditarEntrada(c, emp, con, hoe, hos, fec);
    }
    
    public Entrada getEliminarEntrada(String cons, String idempleado) {

        c = new Conexion().getCon();
        return dao.getEliminarEntrada(c, cons, idempleado);
    }
}
