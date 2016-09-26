package com.proyectorat.manager;

import com.proyectorat.model.Empleado;
import com.proyectorat.persistence.Dao_Empleado;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class EmpleadoManagerImpl {

    Connection c;
    Dao_Empleado dao;

    public EmpleadoManagerImpl() {
        dao = new Dao_Empleado();
    }

    public Empleado getEmpleado(String idempleado) {

        c = new Conexion().getCon();
        return dao.getEmpleado(c, Integer.parseInt(idempleado));
    }

    public ArrayList<Empleado> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoEmpleados(c);
    }

    public void getGuardarEmpleado(Empleado u) throws Exception {
        
        
        
        String emp, tel, car;
        String mensaje, nom, ape, dir, cor, est;
        String fec;
        emp = u.getId_empleado();
        nom = u.getNombre();
        ape = u.getApellidos();
        fec = u.getFecha_n();
        tel = u.getTelefono();
        dir = u.getDireccion();
        cor = u.getEmail();
        est = u.getEstado();
        car = u.getId_cargo();
        
        mensaje = "";
        
        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(dir) || null == dir) {
            dir = "Activo";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(ape) || null == ape) {
            mensaje += "Ingrese clave";
        }
        
        if (null == tel) {
            mensaje += "Ingrese perfil";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getGuardarEmpleado(c, Integer.parseInt(emp), nom, ape, Date.valueOf(fec), Integer.parseInt(tel), dir, cor, est, Integer.parseInt(car));
    }
    
    public void getEditarEmpleado(Empleado u) throws Exception {
        String emp, tel, car;
        String mensaje, nom, ape, dir, cor, est;
        String fec;
        emp = u.getId_empleado();
        nom = u.getNombre();
        ape = u.getApellidos();
        fec = u.getFecha_n();
        tel = u.getTelefono();
        dir = u.getDireccion();
        cor = u.getEmail();
        est = u.getEstado();
        car = u.getId_cargo();
        mensaje = "";
        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(ape) || null == ape) {
            mensaje += "Ingrese clave";
        }
        
        if (null == tel) {
            mensaje += "Ingrese perfil";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getEditarEmpleado(c, Integer.parseInt(emp), nom, ape, Date.valueOf(fec), Integer.parseInt(tel), dir, cor, est, Integer.parseInt(car));
    }
    
    public Empleado getEliminarEmpleado(String idempleado) {

        c = new Conexion().getCon();
        return dao.getEliminarEmpleado(c, Integer.parseInt(idempleado));
    }
    
}
