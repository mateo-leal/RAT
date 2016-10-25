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

    public Empleado getEmpleado(Integer idEmpleado) {

        c = new Conexion().getCon();
        return dao.getEmpleado(c, idEmpleado);
    }

    public String getCons() {

        c = new Conexion().getCon();
        return dao.getCons(c, "tblempleado", "id_empleado", 4);
    }

    public ArrayList<Empleado> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoEmpleados(c);
    }

    public void getGuardarEmpleado(Empleado u) throws Exception {
        String emp, tel, car, mensaje, nom, ape, dir, cor, est, fec;
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
            mensaje += "ID del empleado, ";
        }

        //Campos no obligatorios
        if ("".equals(dir) || null == dir) {
            dir = "dirección, ";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "nombre, ";
        }
        
        if ("".equals(ape) || null == ape) {
            mensaje += "apellidos, ";
        }
        
        if ("".equals(cor) || null == cor) {
            mensaje += "correo electrónico, ";
        }

        if (null == tel) {
            mensaje += "teléfono ,";
        }
        
        if (null == car) {
            mensaje += "cargo, ";
        }
        
        if ("".equals(fec) || null == fec) {
            mensaje += "fecha de nacimiento, ";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*): " + mensaje + "son obligatorios.");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarEmpleado(c, Integer.parseInt(emp), nom, ape, Date.valueOf(fec), Integer.parseInt(tel), dir, cor, est, Integer.parseInt(car));

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarEmpleado(Empleado u) throws Exception {
        String emp, tel, car, mensaje, nom, ape, dir, cor, est, fec;
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
            mensaje += "ID del empleado, ";
        }

        //Campos no obligatorios
        if ("".equals(dir) || null == dir) {
            dir = "dirección, ";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "nombre, ";
        }
        
        if ("".equals(ape) || null == ape) {
            mensaje += "apellidos, ";
        }
        
        if ("".equals(cor) || null == cor) {
            mensaje += "correo electrónico, ";
        }

        if (null == tel) {
            mensaje += "teléfono ,";
        }
        
        if (null == car) {
            mensaje += "cargo, ";
        }
        
        if ("".equals(fec) || null == fec) {
            mensaje += "fecha de nacimiento, ";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*): " + mensaje + "son obligatorios.");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarEmpleado(c, Integer.parseInt(emp), nom, ape, Date.valueOf(fec), Integer.parseInt(tel), dir, cor, est, Integer.parseInt(car));

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Empleado getEliminarEmpleado(Integer idEmpleado) {

        c = new Conexion().getCon();
        return dao.getEliminarEmpleado(c, idEmpleado);
    }
}
