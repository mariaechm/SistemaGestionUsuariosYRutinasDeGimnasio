package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Serie;


public class SerieDao extends AdapterDao<Serie>{
    private Serie serie;
    private LinkedList<Serie> listAll;

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
