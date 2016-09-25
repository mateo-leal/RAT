package com.proyectorat.persistence;

import com.proyectorat.model.Entrada;
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
 * @since 22-07-2016
 *
 */
public class Dao_Entrada {

    public Entrada getEntrada(Connection c, Integer idempleado) {
        Entrada u = new Entrada();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEntrada(idempleado));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empleado(r.getInt(1));
                u.setCons(r.getInt(2));
                u.setHora_entrada(r.getDate(3));
                u.setHora_salida(r.getDate(4));
                u.setFecha(r.getDate(5));
                
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
    
    public Entrada getEntrada_Cons(Connection c, Integer cons, Integer emp) {
        Entrada u = new Entrada();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEntrada_Cons(cons, emp));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empleado(r.getInt(1));
                u.setCons(r.getInt(2));
                u.setHora_entrada(r.getDate(3));
                u.setHora_salida(r.getDate(4));
                u.setFecha(r.getDate(5));
                
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
    
    public String getGuardarEntrada(Connection c, int emp, int con, Date hoe, Date hos, Date fec) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarEntrada());
            stm.setInt(1, emp);
            stm.setInt(2, con);
            stm.setDate(3, hoe);
            stm.setDate(4, hos);
            stm.setDate(5, fec);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Registro " + con + " añadido");
            } else {
                JOptionPane.showMessageDialog(null, "Registro " + con + " no añadido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                JOptionPane.showMessageDialog(null, "El registro " + con + " ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarEntrada(Connection c, int emp, int con, Date hoe, Date hos, Date fec) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarES());
            stm.setInt(4, emp);
            stm.setInt(5, con);
            stm.setDate(1, hoe);
            stm.setDate(2, hos);
            stm.setDate(3, fec);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Registro " + con + " actualizado");
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

    public ArrayList<Entrada> getListadoEntradas(Connection c) {
        ArrayList<Entrada> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEntrada());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Entrada u = new Entrada();
                u.setId_empleado(r.getInt(1));
                u.setCons(r.getInt(2));
                u.setHora_entrada(r.getDate(3));
                u.setHora_salida(r.getDate(4));
                u.setFecha(r.getDate(5));

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

    public ArrayList<Entrada> getListadoEntradas(Connection c, String campo, String valor) {
        ArrayList<Entrada> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEntrada(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Entrada u = new Entrada();
                u.setId_empleado(r.getInt(1));
                u.setCons(r.getInt(2));
                u.setHora_entrada(r.getDate(3));
                u.setHora_salida(r.getDate(4));
                u.setFecha(r.getDate(5));

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
    
    public Entrada getEliminarEntrada(Connection c, Integer cons, Integer idempleado) {
        Entrada u = new Entrada();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarEntrada(cons, idempleado));
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
