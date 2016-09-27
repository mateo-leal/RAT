package com.proyectorat.util;

import com.proyectorat.persistence.SQL_Helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    public static boolean ConEstab = false;

    public Connection con;

    public Conexion() {
    }

    public Connection getCon() {
        ConexionBd();
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException" + e.getMessage());
        } catch (InstantiationException e2) {
            System.out.println("InstantiationException" + e2.getMessage());
        } catch (IllegalAccessException e3) {
            System.out.println("IllegalAccessException" + e3.getMessage());
        }
    }

    public void ConexionBd() {
        String host = "localhost";
        String puerto = "3306";
        String mi_db = "db_rat";
        String user = "root";
        String pw = "";
        try {
            setCon(DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + mi_db, user, pw));
            ConEstab = true;
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        } catch (Exception e2) {
            System.out.println("Exception " + e2.getMessage());
        }
    }

    public void cerrarBd() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }

    public boolean verificarBD() {
        return ConEstab;
    }

    public static void main(String[] args) {
        Conexion c = new Conexion();
        try {
            ResultSet r = c.getCon().prepareStatement(SQL_Helpers.getUsuario()).executeQuery();
            if (r.next()) {
                System.out.println("Usuario: " + r.getString(1));
                System.out.println("Nombre: " + r.getString(2));
                System.out.println("Clave: " + r.getString(3));
                System.out.println("Estado: " + r.getString(4));
                System.out.println("Perfil: " + r.getString(5));
                System.out.println("Correo: " + r.getString(6));
                System.out.println("\n");
            } else {
                System.out.println("No hay datos.");
            }

        } catch (Exception e) {
            System.out.println("Error Main " + e.getMessage());
        } finally {
            try {
                c.cerrarBd();
            } catch (Exception e) {
            }
        }
    }
}
