package com.pinvalidda.model;

public class Cargo {

    private Integer id_cargo;
    private String nombre;
    private String salario;
    private String estado;

    public Cargo() {
    }

    public Cargo(Integer id_cargo, String nombre, String salario, String estado) {
        this.id_cargo = id_cargo;
        this.nombre = nombre;
        this.salario = salario;
        this.estado = estado;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSalario() {
        return salario;
    }

    public String getEstado() {
        return estado;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
