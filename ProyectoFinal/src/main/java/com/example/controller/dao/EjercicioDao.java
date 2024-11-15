package com.example.controller.dao;

import java.lang.reflect.Type;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Ejercicio;
import com.example.models.enumerator.TipoEjercicio;
import com.google.gson.reflect.TypeToken;

public class EjercicioDao extends AdapterDao<Ejercicio>{
    private Ejercicio ejercicio;
    private LinkedList<Ejercicio> listAll;

    @Deprecated
    public EjercicioDao() {
        super(Ejercicio.class);
    }

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

    public Ejercicio getEjercicio() {
        if(this.ejercicio == null) {
            this.ejercicio = new Ejercicio();
        }
        return this.ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public LinkedList<Ejercicio> getListAll() {
        if(this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Ejercicio getIdEjercicio(Integer id) throws Exception {
        return get(id);
    }

    public String getIdEjercicioJson(Integer id) throws Exception {
        return g.toJson(getIdEjercicioJson(id));
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize()+1;
        getEjercicio().setId(id);
        this.persist(this.ejercicio);
        this.listAll = listAll();
        return true;
    }

    public void updateEjercicio(Integer id) throws Exception {
        this.merge(this.ejercicio, id);
    }

    public String toJson() {
        return g.toJson(getEjercicio());
    }

    public Ejercicio EjercicioFromJson(String json) {
        return g.fromJson(json, Ejercicio.class);
    }

    public TipoEjercicio getTipoEjercicio(String tipo) {
        return TipoEjercicio.valueOf(tipo);
    }

    public TipoEjercicio[] getTipos() {
        return TipoEjercicio.values();
    }

}

