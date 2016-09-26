package com.proyectorat.persistence;

import com.proyectorat.model.Registro;
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
public class Dao_Registro {

    public Registro getRegistro(Connection c, Integer idempleado) {
        Registro u = new Registro();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getRegistroA_E(idempleado));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empleado(r.getString(1));
                u.setCons(r.getString(2));
                u.setId_actividad(r.getString(3));
                u.setUsuario_creador(r.getString(4));
                u.setFecha(r.getString(5));
                u.setEstado(r.getString(6));
                
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

    public String getGuardarRegistro(Connection c, int emp, int con, int act, String usu, Date fec, String est) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarRegistroA());
            stm.setInt(1, emp);
            stm.setInt(2, con);
            stm.setInt(3, act);
            stm.setString(4, usu);
            stm.setDate(5, fec);
            stm.setString(6, est);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Registro " + act + "añadido");
            } else {
                JOptionPane.showMessageDialog(null, "Registro " + act + " no añadido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                JOptionPane.showMessageDialog(null, "El registro " + act + "ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarRegistro(Connection c, int emp, int con, int act, String usu, Date fec, String est) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarRA());
            stm.setInt(6, emp);
            stm.setInt(1, con);
            stm.setInt(2, act);
            stm.setString(3, usu);
            stm.setDate(4, fec);
            stm.setString(5, est);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Registro " + con + "actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Registro " + con + " no actualizado", "Error", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<Registro> getListadoRegistros(Connection c) {
        ArrayList<Registro> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getRegistroA());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Registro u = new Registro();
                u.setId_empleado(r.getString(1));
                u.setCons(r.getString(2));
                u.setId_actividad(r.getString(3));
                u.setUsuario_creador(r.getString(4));
                u.setFecha(r.getString(5));
                u.setEstado(r.getString(6));

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

    public ArrayList<Registro> getListadoRegistros(Connection c, String campo, String valor) {
        ArrayList<Registro> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getRegistroA(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Registro u = new Registro();
                u.setId_empleado(r.getString(1));
                u.setCons(r.getString(2));
                u.setId_actividad(r.getString(3));
                u.setUsuario_creador(r.getString(4));
                u.setFecha(r.getString(5));
                u.setEstado(r.getString(6));

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
    
    public Registro getEliminarRegistro(Connection c, Integer idempleado) {
        Registro u = new Registro();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarRegistroA(idempleado));
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
