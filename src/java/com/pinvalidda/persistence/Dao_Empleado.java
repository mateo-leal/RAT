package com.pinvalidda.persistence;

import com.pinvalidda.model.Empleado;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RAT
 * @serial v2.0
 * @since 11-07-2016
 *
 */
public class Dao_Empleado {

    public Empleado getEmpleado(Connection c, String idempleado) {
        Empleado u = new Empleado();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEmpleado(idempleado));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empleado(r.getString(1));
                u.setNombre(r.getString(2));
                u.setApellidos(r.getString(3));
                u.setFecha_n(r.getDate(4));
                u.setTelefono(r.getString(5));
                u.setDireccion(r.getString(6));
                u.setEmail(r.getString(7));
                u.setEstado(r.getString(8));
                u.setId_cargo(r.getString(9));
                
            }
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return u;
    }

    public String getGuardarEmpleado(Connection c, String emp, String nom, String ape, Date fec, String tel, String dir, String cor, String est, String car) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarEmpleado());
            stm.setString(1, emp);
            stm.setString(2, nom);
            stm.setString(3, ape);
            stm.setDate(4, fec);
            stm.setString(5, tel);
            stm.setString(6, dir);
            stm.setString(7, cor);
            stm.setString(8, est);
            stm.setString(9, car);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Empleado " + emp + " añadido");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado " + emp + " no añadido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                JOptionPane.showMessageDialog(null, "El empleado " + emp + " ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarEmpleado(Connection c, String emp, String nom, String ape, Date fec, String tel, String dir, String cor, String est, String car) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarE());
            stm.setString(9, emp);
            stm.setString(1, nom);
            stm.setString(2, ape);
            stm.setDate(3, fec);
            stm.setString(4, tel);
            stm.setString(5, dir);
            stm.setString(6, cor);
            stm.setString(7, est);
            stm.setString(8, car);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Empleado " + emp + " actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado " + emp + " no actualizado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getCause(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return res;
    }

    public ArrayList<Empleado> getListadoEmpleados(Connection c) {
        ArrayList<Empleado> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEmpleado());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Empleado u = new Empleado();
                u.setId_empleado(r.getString(1));
                u.setNombre(r.getString(2));
                u.setApellidos(r.getString(3));
                u.setFecha_n(r.getDate(4));
                u.setTelefono(r.getString(5));
                u.setDireccion(r.getString(6));
                u.setEmail(r.getString(7));
                u.setEstado(r.getString(8));
                u.setId_cargo(r.getString(9));

                Listado.add(u);

            }
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return Listado;
    }

    public ArrayList<Empleado> getListadoEmpleados(Connection c, String campo, String valor) {
        ArrayList<Empleado> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEmpleado(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Empleado u = new Empleado();
                u.setId_empleado(r.getString(1));
                u.setNombre(r.getString(2));
                u.setApellidos(r.getString(3));
                u.setFecha_n(r.getDate(4));
                u.setTelefono(r.getString(5));
                u.setDireccion(r.getString(6));
                u.setEmail(r.getString(7));
                u.setEstado(r.getString(8));
                u.setId_cargo(r.getString(9));

                Listado.add(u);

            }
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return Listado;
    }
    
    public Empleado getEliminarEmpleado(Connection c, String idempleado) {
        Empleado u = new Empleado();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarEmpleado(idempleado));
            smt.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return u;
    }
}
