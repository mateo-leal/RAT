package com.proyectorat.model;

import java.sql.Date;

public class Registro {

    private Integer id_empleado, cons, id_actividad;
    private String usuario_creador, estado;
    private Date fecha;

    public Registro() {

    }

    public Registro(Integer id_empleado, Integer cons, Integer id_actividad, String usuario_creador, String estado, Date fecha) {
        this.id_empleado = id_empleado;
        this.cons = cons;
        this.id_actividad = id_actividad;
        this.fecha = fecha;
        this.usuario_creador = usuario_creador;
        this.estado = estado;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public Integer getCons() {
        return cons;
    }

    public Integer getId_actividad() {
        return id_actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }
    
    public String getEstado() {
        return estado;
    }
   

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setCons(Integer cons) {
        this.cons = cons;
    }

    public void setId_actividad(Integer id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDireccion(String direccion) {
        this.estado = direccion;
    }

    public void setUsuario_creador(String usuario_creador) {
        this.usuario_creador = usuario_creador;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
