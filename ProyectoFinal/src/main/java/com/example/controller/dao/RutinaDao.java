package com.example.controller.dao;

import java.util.LinkedList;

import org.glassfish.grizzly.ConnectionProbe.Adapter;

import com.example.controller.dao.implement.AdapterDao;
import com.example.models.Rutina;
import com.example.models.enumerator.GrupoMuscularObjetivo;


public class RutinaDao extends AdapterDao<Rutina> {
    private Rutina rutina;
    private LinkedList<Rutina> listAll;

    public RutinaDao() {
        super(Rutina.class);
    }

    public Rutina getRutina() {
        if(this.rutina == null) {
            this.rutina = new Rutina();
        }
        return this.rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public LinkedList<Rutina> getListAll() {
        if(this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Rutina getIdRutina(Integer id) throws Exception {
        return get(id);
    }

    public String getIdRutinaJson(Integer id) throws Exception {
        return g.toJson(getIdRutinaJson(id));
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize()+1;
        getRutina().setId(id);
        this.persist(this.rutina);
        this.listAll = listAll();
        return true;
    }

    public void updateRutina(Integer id) throws Exception {
        this.merge(this.rutina, id);
    }

    public void deleteRutina(Integer id) throws Exception {
        this.listAll = listAll();
        delete(id, g.toJson(listAll.toArray()));
    }

    public String toJson() {
        return g.toJson(getRutina());
    }

    public Rutina RutinaFromJson(String json) {
        return g.fromJson(json, Rutina.class);
    }

    public GrupoMuscularObjetivo getGrupoMuscularObjetivo(String grupo) {
        return GrupoMuscularObjetivo.valueOf(grupo);
    }

    public GrupoMuscularObjetivo[] getGrupos() {
        return GrupoMuscularObjetivo.values();
    }

}



