package com.proyectorat.manager;

import com.proyectorat.model.Cargo;
import com.proyectorat.persistence.Dao_Cargo;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author RAT
 */
public class CargoManagerImpl {

    Connection c;
    Dao_Cargo dao;

    public CargoManagerImpl() {
        dao = new Dao_Cargo();
    }

    public Cargo getCargo(Integer idcargo) {

        c = new Conexion().getCon();
        return dao.getCargo(c, idcargo);
    }

    public ArrayList<Cargo> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoCargos(c);
    }

    public void getGuardarCargo(Cargo u) throws Exception {
        Integer car;
        String mensaje, nom, sal, est;
        car = u.getId_cargo();
        nom = u.getNombre();
        sal = u.getSalario();
        est = u.getEstado();
        
        mensaje = "";

        //Campos obligatorios
        if (car == null) {
            mensaje += "Ingrese ID de cargo";
        }

        //Campos no obligatorios
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(sal) || null == sal) {
            mensaje += "Ingrese salario";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese estado";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getGuardarCargo(c, car, nom, sal, est);
    }
    
    public void getEditarCargo(Cargo u) throws Exception {
        Integer car;
        String mensaje, nom, sal, est;
        car = u.getId_cargo();
        nom = u.getNombre();
        sal = u.getSalario();
        est = u.getEstado();
        mensaje = "";

        //Campos obligatorios
        if (null == car) {
            mensaje += "Ingrese ID del cargo";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(sal) || null == sal) {
            mensaje += "Ingrese salario";
        }
        
        //Excepciones
        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
        
        c= new Conexion().getCon();
        
        mensaje = dao.getEditarCargo(c, car, nom, sal, est);
    }
    
    public Cargo getEliminarCargo(Integer idcargo) {

        c = new Conexion().getCon();
        return dao.getEliminarCargo(c, idcargo);
    }
}
