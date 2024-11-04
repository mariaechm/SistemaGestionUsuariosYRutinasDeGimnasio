package com.example.models.enumerator;

/**
 *
 * @author Grupo6
 */

public enum TipoEjercicio {
    COMPUESTO("COMPUESTO"), AISLADO("AISLADO");

    private String name;

    private TipoEjercicio(String name) {
        this.name = this.name();
    }

    public String getName() {
        return this.name;
    }
    
}
