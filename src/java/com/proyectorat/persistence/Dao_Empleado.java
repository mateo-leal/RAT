package com.proyectorat.persistence;

import com.proyectorat.model.Empleado;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author RAT
 * @serial v2.0
 * @since 11-07-2016
 *
 */
public class Dao_Empleado {

    public Empleado getEmpleado(Connection c, Integer idempleado) {
        Empleado u = new Empleado();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEmpleado(idempleado));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empleado(r.getString(1));
                u.setNombre(r.getString(2));
                u.setApellidos(r.getString(3));
                u.setFecha_n(r.getString(4));
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

    public String getGuardarEmpleado(Connection c, Integer emp, String nom, String ape, Date fec, Integer tel, String dir, String cor, String est, Integer car) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarEmpleado());
            stm.setInt(1, emp);
            stm.setString(2, nom);
            stm.setString(3, ape);
            stm.setDate(4, fec);
            stm.setInt(5, tel);
            stm.setString(6, dir);
            stm.setString(7, cor);
            stm.setString(8, est);
            stm.setInt(9, car);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                res = "Empleado " + emp + " añadido";
            } else {
                res = "Empleado " + emp + " no añadido";
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                res = "El empleado " + emp + " ya existe.";
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarEmpleado(Connection c, Integer emp, String nom, String ape, Date fec, Integer tel, String dir, String cor, String est, Integer car) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarE());
           /*     return "UPDATE tblempleado SET nombre=?, apellidos=?, fecha_n=?, telefono=?, direccion=?, email=?, estado=?, id_cargo=? WHERE id_empleado=?";
 */
            stm.setInt(9, emp);
            stm.setString(1, nom);
            stm.setString(2, ape);
            stm.setDate(3, fec);
            stm.setInt(4, tel);
            stm.setString(5, dir);
            stm.setString(6, cor);
            stm.setString(7, est);
            stm.setInt(8, car);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                res = "Empleado " + emp + " actualizado";
                
            } else {
               res= "Empleado " + emp + " no actualizado";
            }
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                res = "" + e.getCause();
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
                u.setFecha_n(r.getString(4));
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
                u.setFecha_n(r.getString(4));
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
    
    public Empleado getEliminarEmpleado(Connection c, Integer idempleado) {
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

    public String getCons (Connection c, String tabla, String campo, int Longitud) {
        String u = "1000";
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getConsectivo(tabla, campo, Longitud));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u=r.getString(1);
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
}
