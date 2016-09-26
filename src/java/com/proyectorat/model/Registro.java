package com.proyectorat.model;

public class Registro {

    private String id_empleado, cons, id_actividad;
    private String usuario_creador, estado;
    private String fecha;

    public Registro() {

    }

    public Registro(String id_empleado, String cons, String id_actividad, String usuario_creador, String estado, String fecha) {
        this.id_empleado = id_empleado;
        this.cons = cons;
        this.id_actividad = id_actividad;
        this.fecha = fecha;
        this.usuario_creador = usuario_creador;
        this.estado = estado;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public String getCons() {
        return cons;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }
    
    public String getEstado() {
        return estado;
    }
   

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setFecha(String fecha) {
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
