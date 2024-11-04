package com.example.models;

import com.example.models.enumerator.GrupoMuscularObjetivo;

/**
 *
 * @author Grupo6
 */

public class Rutina {
    private Integer id;
    private String nombreRutina;
    private String objetivoRutina;
    private int nroEjercicios;

    private GrupoMuscularObjetivo grupoMuscularObjetivo;

    private Ejercicio ejercicio;

    public Rutina() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRutina() {
        return this.nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public String getObjetivoRutina() {
        return this.objetivoRutina;
    }

    public void setObjetivoRutina(String objetivoRutina) {
        this.objetivoRutina = objetivoRutina;
    }

    public int getNroEjercicios() {
        return this.nroEjercicios;
    }

    public void setNroEjercicios(int nroEjercicios) {
        this.nroEjercicios = nroEjercicios;
    }

    public GrupoMuscularObjetivo getGrupoMuscularObjetivo() {
        return this.grupoMuscularObjetivo;
    }

    public void setGrupoMuscularObjetivo(GrupoMuscularObjetivo grupoMuscularObjetivo) {
        this.grupoMuscularObjetivo = grupoMuscularObjetivo;
    }

    public Ejercicio getEjercicio() {
        return this.ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

}
