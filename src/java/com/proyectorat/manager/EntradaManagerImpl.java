package com.proyectorat.manager;

import com.proyectorat.model.Entrada;
import com.proyectorat.persistence.Dao_Entrada;
import com.proyectorat.util.Conexion;
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
        return dao.getEntrada(c, Integer.parseInt(idempleado));
    }
    
    public Entrada getEntrada_Cons(String cons, String emp) {

        c = new Conexion().getCon();
        return dao.getEntrada_Cons(c, Integer.parseInt(cons), Integer.parseInt(emp));
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
        String emp, con;
        String fec, hoe, hos;
        String mensaje;
        emp = u.getId_empleado();
        con = u.getCons();
        hoe = u.getHora_entrada();
        fec = u.getFecha();
        hos = u.getHora_salida();
        
        mensaje = "";

        //Campos obligatorios
        if ("".equals(emp) || null == emp) {
            mensaje += "usuario, ";
        }
        //Campos no obligatorios
        
        if (null == fec) {
            mensaje += "fecha, ";
        }
        
        if ("".equals(hoe) || null == hoe) {
            mensaje += "hora de entrada, ";
        }
        
        if ("".equals(hos) || null == hos) {
            mensaje += "hora de salida, ";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*): " + mensaje + "son obligatorios");
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getGuardarEntrada(c, Integer.parseInt(emp), Integer.parseInt(con), Date.valueOf(hoe), Date.valueOf(hos), Date.valueOf(fec));
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarEntrada(Entrada u) throws Exception {
        String emp, con;
        String fec, hoe, hos;
        String mensaje;
        emp = u.getId_empleado();
        con = u.getCons();
        hoe = u.getHora_entrada();
        fec = u.getFecha();
        hos = u.getHora_salida();
        
        mensaje = "";

        //Campos obligatorios
        if ("".equals(emp) || null == emp) {
            mensaje += "usuario, ";
        }
        //Campos no obligatorios
        
        if (null == fec) {
            mensaje += "fecha, ";
        }
        
        if ("".equals(hoe) || null == hoe) {
            mensaje += "hora de entrada, ";
        }
        
        if ("".equals(hos) || null == hos) {
            mensaje += "hora de salida, ";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*): " + mensaje + "son obligatorios");
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getEditarEntrada(c, Integer.parseInt(emp), Integer.parseInt(con), Date.valueOf(hoe), Date.valueOf(hos), Date.valueOf(fec));
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Entrada getEliminarEntrada(String cons) {

        c = new Conexion().getCon();
        return dao.getEliminarEntrada(c, Integer.parseInt(cons));
    }
}
