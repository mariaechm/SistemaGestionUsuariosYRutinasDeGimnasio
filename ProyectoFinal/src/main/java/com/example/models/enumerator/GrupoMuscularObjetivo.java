package com.example.models.enumerator;

/**
 *
 * @author Grupo6
 */

public enum GrupoMuscularObjetivo {
    PIERNA("PIERNA"), PECHO("PECHO"), ESPALDA("ESPALDA"), BRAZO("BRAZO"), ABDOMEN("ABDOMEN"), FULL_BODY("FULL_BODY");

    private String name;

    private GrupoMuscularObjetivo(String name) {
        this.name = this.name();
    }

    public String getName() {
        return this.name;
    }

}
