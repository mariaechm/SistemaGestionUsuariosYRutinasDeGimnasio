package com.example.models;

/**
 *
 * @author Grupo6
 */

public class Serie {
   private Integer id;
    private int nroRepeticiones;

    public Serie() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNroRepeticiones() {
        return this.nroRepeticiones;
    }

    public void setNroRepeticiones(int nroRepeticiones) {
        this.nroRepeticiones = nroRepeticiones;
    }

}