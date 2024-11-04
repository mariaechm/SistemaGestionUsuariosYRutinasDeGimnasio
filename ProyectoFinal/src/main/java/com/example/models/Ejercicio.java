package com.example.models;

import com.example.models.enumerator.TipoEjercicio;

/**
 *
 * @author Grupo6
 */

public class Ejercicio {
    private Integer id;
    private String nombreEjercicio;
    private int nroSeries;

    private TipoEjercicio tipoEjercicio;

    private Serie serie;

    public Ejercicio() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEjercicio() {
        return this.nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public int getNroSeries() {
        return this.nroSeries;
    }

    public void setNroSeries(int nroSeries) {
        this.nroSeries = nroSeries;
    }

    public TipoEjercicio getTipoEjercicio() {
        return this.tipoEjercicio;
    }

    public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public Serie getSerie() {
        return this.serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

}
