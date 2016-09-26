package com.proyectorat.model;

public class Usuario {

    private String usuario, nombre, clave, perfil, estado, email;

    public Usuario() {

    }

    public Usuario(String usuario, String nombre, String clave, String perfil, String estado, String email) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.perfil = perfil;
        this.estado = estado;
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getEstado() {
        return estado;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
