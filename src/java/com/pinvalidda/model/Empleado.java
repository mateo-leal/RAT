package com.pinvalidda.model;

import java.sql.Date;

public class Empleado {

    private String id_empleado, telefono, id_cargo;
    private String nombre, apellidos, direccion, email, estado;
    private Date fecha_n;

    public Empleado() {

    }

    public Empleado(String id_empleado, String nombre, String apellidos, String telefono, String direccion, String email, String estado, String id_cargo, Date fecha_n) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_n = fecha_n;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.id_cargo = id_cargo;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFecha_n() {
        return fecha_n;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
    public String getEstado() {
        return estado;
    }

    public String getId_cargo() {
        return id_cargo;
    }


    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFecha_n(Date fecha_n) {
        this.fecha_n = fecha_n;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }
}
