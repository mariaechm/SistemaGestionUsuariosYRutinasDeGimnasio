package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Ejercicio;



public class EjercicioDao extends AdapterDao<Ejercicio> {
    private Ejercicio ejercicio;

    // Constructors ------------------------------------------------------------ 
    public EjercicioDao() {
        super(Ejercicio.class);
    }

    public Ejercicio getEjercicio() {
        if(this.ejercicio == null) {
            this.ejercicio = new Ejercicio();
        }
        return this.ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public LinkedList<Ejercicio> getAllEjercicios() throws Exception {
        return this.listAll();
    }

    public void ejercicioFromJson(String ejercicioJson) {
        this.ejercicio = g.fromJson(ejercicioJson, Ejercicio.class);
    }

    // CRUD Operations ------------------------------------------------------------

    public Ejercicio getEjercicioById(Integer id) throws Exception {
        return get(id);
    }

    public void save() throws Exception {
        Integer id = listAll().getSize() + 1;
        this.getEjercicio().setId(id);
        persist(this.ejercicio);
    }

    public void deleteEjercicio(Integer id) throws Exception {
        remove(id);
    }

    public void updateEjercicio() throws Exception {
        final Integer id = getEjercicio().getId();
        merge(getEjercicio(), id);
    }
}
