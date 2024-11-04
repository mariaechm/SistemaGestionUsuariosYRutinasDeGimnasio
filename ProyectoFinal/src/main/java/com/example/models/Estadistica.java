package com.example.models;

/**
 *
 * @author Grupo6
 */
public class Estadistica {

    private Integer id;
    private Float medida;

    public Estadistica() {
    }

    public Estadistica(Integer id, Float medida) {
        this.id = id;
        this.medida = medida;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMedida() {
        return medida;
    }

    public void setMedida(Float medida) {
        this.medida = medida;
    }
}
