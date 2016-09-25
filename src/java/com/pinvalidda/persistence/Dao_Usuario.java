package com.pinvalidda.persistence;

import com.pinvalidda.model.Usuario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Dao_Usuario {

    public Usuario getUsuario(Connection c, String idusuario) {
        Usuario u = new Usuario();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getUsuario(idusuario));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setUsuario(r.getString(1));
                u.setClave(r.getString(3));
                u.setNombre(r.getString(2));
                u.setEstado(r.getString(4));
                u.setPerfil(r.getString(5));
                u.setEmail(r.getString(6));
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
    
    public Usuario getValidarIngresoSistema(Connection c, String idusuario, String clave) {
        Usuario u = new Usuario();
        u.setUsuario("*");
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getValidarIngreso(idusuario, clave));
            smt.setString(1, idusuario);
            smt.setString(3, clave);
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setUsuario(r.getString(1));
                u.setNombre(r.getString(2));
                u.setClave(r.getString(3));
                u.setEstado(r.getString(4));
                u.setPerfil(r.getString(5));
                u.setEmail(r.getString(6));
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

    public String getGuardarUsuario(Connection c, String usu, String nom, String cla, String est, String per, String corr) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarUsuario());
            stm.setString(1, usu);
            stm.setString(2, nom);
            stm.setString(3, cla);
            stm.setString(4, est);
            stm.setString(5, per);
            stm.setString(6, corr);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Usuario " + usu + "añadido");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario " + usu + " no añadido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                JOptionPane.showMessageDialog(null, "El usuario " + usu + "ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarUsuario(Connection c, String usu, String nom, String cla, String est, String per, String corr) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizar());
            stm.setString(6, usu);
            stm.setString(1, nom);
            stm.setString(2, cla);
            stm.setString(3, est);
            stm.setString(4, per);
            stm.setString(5, corr);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                JOptionPane.showMessageDialog(null, "Usuario " + usu + "actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario " + usu + " no actualizado", "Error", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<Usuario> getListadoUsuarios(Connection c) {
        ArrayList<Usuario> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getUsuario());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Usuario u = new Usuario();
                u.setUsuario(r.getString(1));
                u.setNombre(r.getString(2));
                u.setClave(r.getString(3));
                u.setEstado(r.getString(4));
                u.setPerfil(r.getString(5));
                u.setEmail(r.getString(6));

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

    public ArrayList<Usuario> getListadoUsuarios(Connection c, String campo, String valor) {
        ArrayList<Usuario> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getUsuario(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Usuario u = new Usuario();
                u.setUsuario(r.getString(1));
                u.setNombre(r.getString(2));
                u.setClave(r.getString(3));
                u.setEstado(r.getString(4));
                u.setPerfil(r.getString(5));
                u.setEmail(r.getString(6));

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
    
    public Usuario getEliminarUsuario(Connection c, String usuario) {
        Usuario u = new Usuario();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarUsuario(usuario));
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
