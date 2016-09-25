package com.pinvalidda.persistence;

import com.pinvalidda.model.Cargo;
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
 * @serial v2.0
 * @since 11-07-2016
 *
 */
public class Dao_Cargo {

    public Cargo getCargo(Connection c, String idcargo) {
        Cargo u = new Cargo();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getCargo(idcargo));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_cargo(r.getInt(1));
                u.setNombre(r.getString(2));
                u.setSalario(r.getString(3));
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

    public String getGuardarCargo(Connection c, int car, String nom, String sal, String est) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarCargo());
            stm.setInt(1, car);
            stm.setString(2, nom);
            stm.setString(3, sal);
            stm.setString(4, est);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Cargo " + nom + " añadido");
            } else {
                JOptionPane.showMessageDialog(null, "Cargo " + nom + " no añadido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                JOptionPane.showMessageDialog(null, "El cargo " + car + " ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarCargo(Connection c, int car, String nom, String sal, String est) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarC());
            stm.setInt(4, car);
            stm.setString(1, nom);
            stm.setString(2, sal);
            stm.setString(3, est);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Cargo " + nom + " actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Cargo " + nom + " no actualizado", "Error", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<Cargo> getListadoCargos(Connection c) {
        ArrayList<Cargo> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getCargo());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Cargo u = new Cargo();
                u.setId_cargo(r.getInt(1));
                u.setNombre(r.getString(2));
                u.setSalario(r.getString(3));
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

    public ArrayList<Cargo> getListadoCargos(Connection c, String campo, String valor) {
        ArrayList<Cargo> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getCargo(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Cargo u = new Cargo();
                u.setId_cargo(r.getInt(1));
                u.setNombre(r.getString(2));
                u.setSalario(r.getString(3));
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
    
    public Cargo getEliminarCargo(Connection c, String idcargo) {
        Cargo u = new Cargo();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarCargo(idcargo));
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
