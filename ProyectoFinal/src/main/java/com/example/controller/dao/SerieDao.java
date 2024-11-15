package com.example.controller.dao;

import java.lang.reflect.Type;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Serie;
import com.google.gson.reflect.TypeToken;

public class SerieDao extends AdapterDao<Serie>{
    private Serie serie;
    private LinkedList<Serie> listAll;

    @Deprecated   
    public SerieDao() {
        super(Serie.class);
    }
    
     protected Integer getIndexToOperate(Integer id) throws Exception {
        Serie[] array = listAll().toArray();
        for(int i = 0; i < array.length; i++) {
            if(array[i].getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("IdNotFound");
    }

    protected JsonData<Serie> readFileAsJsonData() throws Exception {
        Type jsonDataType = new TypeToken<JsonData<Serie>>(){}.getType();
        JsonData<Serie> jsonData = g.fromJson(readFile(), jsonDataType);
        return jsonData;
    }

    public Serie getSerie() {
        if(this.serie == null) {
            this.serie = new Serie();
        }
        return this.serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public LinkedList<Serie> getListAll() {
        if(this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Serie getIdSerie(Integer id) throws Exception {
        return get(id);
    }

    public String getIdSerieJson(Integer id) throws Exception {
        return g.toJson(getIdSerieJson(id));
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize()+1;
        getSerie().setId(id);
        this.persist(this.serie);
        this.listAll = listAll();
        return true;
    }

    public void updateSerie(Integer id) throws Exception {
        this.merge(this.serie, id);
    }

    public String toJson() {
        return g.toJson(getSerie());
    }
    
}
