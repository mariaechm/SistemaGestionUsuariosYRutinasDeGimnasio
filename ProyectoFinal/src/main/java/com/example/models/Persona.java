package com.example.models;

import com.example.models.enumerator.Genero;
import com.example.models.enumerator.Rol;
import com.example.models.enumerator.TipoIdentificacion;

/**
 *
 * @author Grupo6
 */

public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private TipoIdentificacion tipoIdentificacion;
    private String celular;
    private String fechaNacimiento;
    private String direccion;
    private Rol rol;
    private Genero genero;

    public Persona() {}

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public TipoIdentificacion getTipoIdentificaion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificaion(TipoIdentificacion tipoIdentificaion) {
        this.tipoIdentificacion = tipoIdentificaion;
    }
}
