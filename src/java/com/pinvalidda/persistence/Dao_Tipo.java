package com.pinvalidda.persistence;

import com.pinvalidda.model.Tipo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RAT
 * @serial v1.0
 * @since 11-07-2016
 *
 */
public class Dao_Tipo {

    public Tipo getTipoA(Connection c, String idactividad) {
        Tipo u = new Tipo();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getTipoA(idactividad));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_actividad(r.getInt(1));
                u.setActividad(r.getString(2));
                u.setDescripcion(r.getString(3));
                u.setEstado(r.getString(4));
                
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
    
    public String getGuardarTipo(Connection c, int ida, String act, String des, String est) {
        
        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarTipoA());
            stm.setInt(1, ida);
            stm.setString(2, act);
            stm.setString(3, des);
            stm.setString(4, est);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de actividad " + des + " añadido");
            } else {
                JOptionPane.showMessageDialog(null, "Error, tipo de actividad " + des + " no añadido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                JOptionPane.showMessageDialog(null, "El tipo de actividad " + act + " ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarTipo(Connection c, int ida, String act, String des, String est) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarTA());
            stm.setInt(4, ida);
            stm.setString(1, act);
            stm.setString(2, des);
            stm.setString(3, est);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de actividad " + des + " actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error, tipo de actividad " + des + " no actualizado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getCause(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public ArrayList<Tipo> getListadoTipos(Connection c) {
        ArrayList<Tipo> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getTipoA());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Tipo u = new Tipo();
                u.setId_actividad(r.getInt(1));
                u.setActividad(r.getString(2));
                u.setDescripcion(r.getString(3));
                u.setEstado(r.getString(4));

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

    public ArrayList<Tipo> getListadoTipos(Connection c, String campo, String valor) {
        ArrayList<Tipo> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getTipoA(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Tipo u = new Tipo();
                u.setId_actividad(r.getInt(1));
                u.setActividad(r.getString(2));
                u.setDescripcion(r.getString(3));
                u.setEstado(r.getString(4));

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
    
    public Tipo getEliminarTipo(Connection c, String idactividad) {
        Tipo u = new Tipo();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarTipoA(idactividad));
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
