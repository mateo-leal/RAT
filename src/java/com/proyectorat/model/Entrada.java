package com.proyectorat.model;

import java.sql.Date;

public class Entrada {

    private Integer id_empleado, cons;
    private Date hora_entrada, hora_salida, fecha;

    public Entrada() {

    }
    
    public Entrada(Integer id_empleado, Integer cons, Date hora_entrada, Date hora_salida, Date fecha) {
        this.id_empleado = id_empleado;
        this.cons = cons;
        this.hora_entrada = hora_entrada;
        this.fecha = fecha;
        this.hora_salida = hora_salida;
    }
    
    public Integer getId_empleado() {
        return id_empleado;
    }
    
    public Integer getCons() {
        return cons;
    }
    
    public Date getHora_entrada() {
        return hora_entrada;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public Date getHora_salida() {
        return hora_salida;
    }
    

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setCons(Integer cons) {
        this.cons = cons;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora_salida(Date hora_salida) {
        this.hora_salida = hora_salida;
    }
}
