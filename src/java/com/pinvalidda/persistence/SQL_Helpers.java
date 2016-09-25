package com.pinvalidda.persistence;

import java.sql.Date;

public class SQL_Helpers {

    //USUARIO
    public static String getUsuario() {
        return "SELECT us.usuario, us.nombre, us.clave, us.estado, pe.cargo, us.correo FROM tblusuario us INNER JOIN tblcargo pe ON us.perfil = pe.id_cargo GROUP BY us.usuario, pe.cargo";
    }

    public static String getUsuario(Integer id) {
        return "SELECT usuario, nombre, clave, estado, perfil, correo FROM tblusuario WHERE usuario = '" + id + "' ";
    }

    public static String getUsuario(String campo, String valor) {
        return "SELECT usuario, nombre, clave, estado, perfil, correo FROM tblusuario WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizar() {
        return "UPDATE tblusuario SET nombre=?, clave=?, estado=?, perfil=?, correo=? WHERE usuario=?";
    }

    public static String getInsertarUsuario(String usuario, String nombre, String clave, String estado, String perfil, String correo) {
        return "INSERT INTO tblusuario( usuario, nombre, clave, estado, perfil, correo) values (" + usuario + "," + nombre + "," + clave + "," + estado + "," + perfil + "," + correo + ")";
    }

    public static String getInsertarUsuario() {
        return "INSERT INTO tblusuario( usuario, nombre, clave, estado, perfil, correo) values (?,?,?,?,?,?)";
    }

    public static String getValidarIngreso(String usr, String pass) {
        return "SELECT usuario, nombre, clave, estado, perfil, correo \n"
                + " FROM tblusuario "
                + " WHERE usuario='"+ usr +"' AND clave='"+ pass +"'"
                + "AND estado='Activo'";
    }
    
    public static String getEliminarUsuario(Integer id){
        return "DELETE FROM tblusuario WHERE usuario='"+ id +"' ";
    }

    
    //CARGO
    public static String getCargo() {
        return "SELECT id_cargo, nombre, salario, estado FROM tblcargo ";
    }

    public static String getCargo(Integer id) {
        return "SELECT id_cargo, nombre, salario, estado FROM tblcargo WHERE id_cargo = '" + id + "' ";
    }

    public static String getCargo(String campo, String valor) {
        return "SELECT id_cargo, nombre, salario, estado FROM tblcargo WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarC() {
        return "UPDATE tblcargo SET nombre=?, salario=?, estado=? WHERE id_cargo=?";
    }

    public static String getInsertarCargo(Integer id_cargo, String nombre, String salario, String estado) {
        return "INSERT INTO tblcargo( id_cargo, nombre, salario, estado) values (" + id_cargo + "," + nombre + "," + salario + "," + estado + ")";
    }

    public static String getInsertarCargo() {
        return "INSERT INTO tblcargo( id_cargo, nombre, salario, estado) values (?,?,?,?)";
    }
    
    public static String getEliminarCargo(Integer id){
        return "DELETE FROM tblcargo WHERE id_cargo='"+ id +"' ";
    }

    //EMPLEADO
    public static String getEmpleado() {
        return "SELECT em.id_empleado, em.nombre, em.apellidos, em.fecha_n, em.telefono, em.direccion, em.email, em.estado, pe.cargo FROM tblempleado em INNER JOIN tblcargo pe ON em.id_cargo = pe.id_cargo GROUP BY em.id_empleado, pe.id_cargo";
    }

    public static String getEmpleado(Integer id) {
        return "SELECT id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo FROM tblempleado WHERE id_empleado = '" + id + "' ";
    }

    public static String getEmpleado(String campo, String valor) {
        return "SELECT id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo FROM tblempleado WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarE() {
        return "UPDATE tblempleado SET nombre=?, apellidos=?, fecha_n=?, telefono=?, direccion=?, email=?, estado=?, id_cargo=? WHERE id_empleado=?";
    }

    public static String getInsertarEmpleado(Integer id_empleado, String nombre, String apellidos, Date fecha_n, String telefono, String direccion, String email, String estado, Integer id_cargo) {
        return "INSERT INTO tblempleado( id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo) values (" + id_empleado + "," + nombre + "," + apellidos + "," + fecha_n + "," + telefono + "," + direccion + "," + email + "," + estado + "," + id_cargo + ")";
    }

    public static String getInsertarEmpleado() {
        return "INSERT INTO tblempleado( id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo) values (?,?,?,?,?,?,?,?,?)";
    }
    
    public static String getEliminarEmpleado(Integer id){
        return "DELETE FROM tblempleado WHERE id_empleado='"+ id +"' ";
    }
    

    //ENTRADAS
    public static String getEntrada() {
        return "SELECT em.nombre, em.apellidos, es.cons, TIME_FORMAT(es.hora_entrada,'%r') hora_entrada, TIME_FORMAT(es.hora_salida,'%r') hora_salida, es.fecha FROM tblentrada_salida es INNER JOIN tblempleado em ON es.id_empleado = em.id_empleado GROUP BY em.nombre, es.cons";
    }

    public static String getEntrada(Integer id) {
        return "SELECT id_empleado, cons, hora_entrada, hora_salida, fecha FROM tblentrada_salida WHERE id_empleado = '" + id + "' ";
    }
    
    public static String getEntrada_Cons(Integer id, String emp) {
        return "SELECT id_empleado, cons, hora_entrada, hora_salida, fecha FROM tblentrada_salida WHERE cons = '" + id + "' AND id_empleado='"+ emp +"'";
    }

    public static String getEntrada(String campo, String valor) {
        return "SELECT id_empleado, cons, hora_entrada, hora_salida, fecha FROM tblentrada_salida WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarES() {
        return "UPDATE tblentrada_salida SET hora_entrada=?, hora_salida=?, fecha=? WHERE id_empleado=? AND cons=?";
    }

    public static String getInsertarEntrada(Integer id_empleado, String cons, Date hora_entrada, Date hora_salida, Date fecha) {
        return "INSERT INTO tblentrada_salida( id_empleado, cons, hora_entrada, hora_salida, fecha) values (" + id_empleado + "," + cons + "," + hora_entrada + "," + hora_salida + "," + fecha + ")";
    }

    public static String getInsertarEntrada() {
        return "INSERT INTO tblentrada_salida( id_empleado, cons, hora_entrada, hora_salida, fecha) values (?,?,?,?,?)";
    }
    
    public static String getEliminarEntrada(Integer id, String emp){
        return "DELETE FROM tblentrada_salida WHERE cons='"+ id +"' AND id_empleado='"+ emp +"' ";
    }
    
    
    //REGISTROA
    public static String getRegistroA() {
        return "SELECT em.nombre, em.apellidos, ti.descripcion, us.usuario, ac.fecha_actividad, ac.estado FROM tblregistro_actividades ac INNER JOIN tblempleado em ON ac.id_empleado = em.id_empleado INNER JOIN tbltipo_actividad ti ON ac.id_actividad = ti.id_actividad INNER JOIN tblusuario us ON us.usuario = ac.usuario_creador GROUP BY em.nombre, ti.descripcion, us.usuario, ac.fecha_actividad";
    }

    public static String getRegistroA_E(Integer id) {
        return "SELECT id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado FROM tblregistro_actividades WHERE id_empleado = '" + id + "' ";
    }

    public static String getRegistroA_A(Integer id) {
        return "SELECT id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado FROM tblregistro_actividades WHERE id_actividad = '" + id + "' ";
    }

    public static String getRegistroA(String campo, String valor) {
        return "SELECT id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado FROM tblregistro_actividades WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarRA() {
        return "UPDATE tblregistro_actividades SET cons=?, id_actividad=?, usuario_creador=?, fecha_actividad=?, estado=? WHERE id_empleado=?";
    }

    public static String getInsertarRegistroA(Integer id_empleado, String cons, Integer id_actividad, String usuario_creador, Date fecha_actividad, String estado) {
        return "INSERT INTO tblregistro_actividades( id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado) values (" + id_empleado + "," + cons + "," + id_actividad + "," + usuario_creador + "," + fecha_actividad + "," + estado + ")";
    }

    public static String getInsertarRegistroA() {
        return "INSERT INTO tblregistro_actividades( id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado) values (?,?,?,?,?,?)";
    }
    
    public static String getEliminarRegistroA(Integer id){
        return "DELETE FROM tblregistro_actividades WHERE id_empleado='"+ id +"' ";
    }
    

    //TIPOA
    public static String getTipoA() {
        return "SELECT id_actividad, actividad, descripcion, estado FROM tbltipo_actividad ";
    }

    public static String getTipoA(Integer id) {
        return "SELECT id_actividad, actividad, descripcion, estado FROM tbltipo_actividad WHERE id_actividad = '" + id + "' ";
    }
    
    public static String getTipoA(String campo, String valor) {
        return "SELECT id_actividad, actividad, descripcion, estado FROM tbltipo_actividad WHERE " + campo + " = '" + valor + "' ";
    }
    
    public static String getActualizarTA() {
        return "UPDATE tbltipo_actividad SET actividad=?, descripcion=?, estado=? WHERE id_actividad=?";
    }

    public static String getInsertarTipoA(Integer id_actividad, String actividad, String descripcion, String estado) {
        return "INSERT INTO tbltipo_actividad( id_actividad, actividad, descripcion, estado) values (" + id_actividad + "," + actividad + "," + descripcion + "," + estado + ")";
    }

    public static String getInsertarTipoA() {
        return "INSERT INTO tbltipo_actividad( id_actividad, actividad, descripcion, estado) values (?,?,?,?)";
    }
    
    public static String getEliminarTipoA(Integer id){
        return "DELETE FROM tbltipo_actividad WHERE id_actividad='"+ id +"' ";
    }
    
    
    //GENERACION DE CONSECUTIVO
    
    public static String getConsectivo(String tabla, String campo, int Longitud){
        return "SELECT Lpad( max( cast( "+campo+" AS signed ) ) +1, "+Longitud+", '0' )  FROM "+tabla +"";
    }
}
