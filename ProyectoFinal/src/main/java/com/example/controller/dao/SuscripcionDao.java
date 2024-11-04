package com.example.controller.dao;
/**
 * 
 * @autor Grupo6
 */

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Suscripcion;
import com.example.models.enumerator.TipoSuscripcion;

public class SuscripcionDao extends AdapterDao<Suscripcion> {
    private  Suscripcion suscripcion;
    
    public SuscripcionDao() {
        super(Suscripcion.class);
    }
    
    public Suscripcion getSuscripcion() {
        if (this.suscripcion == null) {
            this.suscripcion = new Suscripcion();
        }

        return this.suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public void getSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }
    
    public Suscripcion getSuscripcionId(Integer id) throws Exception {
        return get(id);
    }
    public void SuscripcionFromJson(String suscripcionJson) {
        this.suscripcion= g.fromJson(suscripcionJson, Suscripcion.class);
    }

    public Suscripcion SuscripcionId(Integer id) throws Exception {
        return get(id);
    }

    public String getSuscripcionJsonId(Integer id) throws Exception {
        return g.toJson(this.SuscripcionId(id));
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize() + 1;
        this.getSuscripcion().setId(id);
        persist(this.suscripcion);
        return true;
    }

    public void deleteSuscripcion(Integer id) throws Exception {
        LinkedList<Suscripcion> suscripciones = listAll();
        suscripciones.delete(id);
        String data = g.toJson(suscripciones.toArray());
        saveFile(data); 
    }

    public void updateSuscripcion(Suscripcion suscripcion) throws Exception {
        Integer id = suscripcion.getId();
        LinkedList<Suscripcion> suscripciones = listAll();
        suscripciones.update(suscripcion, id);
        String data = g.toJson(suscripciones.toArray());
        saveFile(data);
    }

    public TipoSuscripcion[] tiposSuscripcion() {
        return TipoSuscripcion.values();
    }

}
    