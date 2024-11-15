package com.example.controller.dao;

import java.lang.reflect.Type;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Ejercicio;
import com.google.gson.reflect.TypeToken;


public class EjercicioDao extends AdapterDao<Ejercicio> {
    private Ejercicio ejercicio;

    // Constructors ------------------------------------------------------------ 
    @Deprecated   
    public EjercicioDao() {
        super(Ejercicio.class);
    }

    public EjercicioDao(Integer initialId) throws Exception {
        super(Ejercicio.class,initialId);
    }

    // Abstract Methods ------------------------------------------------------------

    protected Integer getIndexToOperate(Integer id) throws Exception {
        Ejercicio[] array = listAll().toArray();
        for(int i = 0; i < array.length; i++) {
            if(array[i].getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("IdNotFound");
    }

    protected JsonData<Ejercicio> readFileAsJsonData() throws Exception {
        Type jsonDataType = new TypeToken<JsonData<Ejercicio>>(){}.getType();
        JsonData<Ejercicio> jsonData = g.fromJson(readFile(), jsonDataType);
        return jsonData;
    }

    // Access Methods ------------------------------------------------------------

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
        currentId++;
        Integer id = currentId;
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
