package com.example.controller.dao;

import java.lang.reflect.Type;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Rutina;
import com.example.models.enumerator.GrupoMuscularObjetivo;
import com.google.gson.reflect.TypeToken;


public class RutinaDao extends AdapterDao<Rutina> {
    private Rutina rutina;
    private LinkedList<Rutina> listAll;

    @Deprecated   
    public RutinaDao() {
        super(Rutina.class);
    }

    protected Integer getIndexToOperate(Integer id) throws Exception {
        Rutina[] array = listAll().toArray();
        for(int i = 0; i < array.length; i++) {
            if(array[i].getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("IdNotFound");
    }

    protected JsonData<Rutina> readFileAsJsonData() throws Exception {
        Type jsonDataType = new TypeToken<JsonData<Rutina>>(){}.getType();
        JsonData<Rutina> jsonData = g.fromJson(readFile(), jsonDataType);
        return jsonData;
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



