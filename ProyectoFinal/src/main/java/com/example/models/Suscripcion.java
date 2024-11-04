package com.example.models;

import java.util.Date;

import com.example.models.enumerator.TipoSuscripcion;

/**
 *
 * @author Grupo6
 */

public class Suscripcion {
    private Integer id;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private TipoSuscripcion tipoSuscripcion;

    public Suscripcion( Integer id, Date fechaInicio, Date fechaFinalizacion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        
    }
    public Suscripcion(){
        }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(TipoSuscripcion tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }
}
