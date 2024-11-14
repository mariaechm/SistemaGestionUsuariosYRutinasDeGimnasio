package com.example.controller.dao;

import java.lang.reflect.Type;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Gimnasio;
import com.example.models.enumerator.Genero;
import com.example.models.enumerator.Rol;
import com.example.models.enumerator.TipoIdentificacion;
import com.google.gson.reflect.TypeToken;


public class GimnasioDao extends AdapterDao<Gimnasio> {
    private Gimnasio gimnasio;
    
    public GimnasioDao() {
        super(Gimnasio.class);
    }

    protected Integer getIndexToOperate(Integer id) throws Exception {
        Gimnasio[] array = listAll().toArray();
        for(int i = 0; i < array.length; i++) {
            if(array[i].getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("IdNotFound");
    }

    protected JsonData<Gimnasio> readFileAsJsonData() throws Exception {
        Type jsonDataType = new TypeToken<JsonData<Gimnasio>>(){}.getType();
        JsonData<Gimnasio> jsonData = g.fromJson(readFile(), jsonDataType);
        return jsonData;
    }

    public Gimnasio getGimnasio() {
        if(this.gimnasio == null) {
            this.gimnasio = new Gimnasio();
        }
        return this.gimnasio;
    }

    public void setGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    public void GimnasioFromJson(String GimnasioJson) {
        this.gimnasio = g.fromJson(GimnasioJson, Gimnasio.class);
    }

    public Gimnasio getGimnasioById(Integer id) throws Exception {
        return get(id);
    }

    public String getGimnasioJsonById(Integer id) throws Exception {
        return g.toJson(this.getGimnasioById(id));
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize() + 1;
        this.getGimnasio().setId(id);
        persist(this.gimnasio);
        return true;
    }

    public void deleteGimnasio(Integer id) throws Exception {
        LinkedList<Gimnasio> gimnasios = listAll();
        gimnasios.delete(id);
        String data = g.toJson(gimnasios.toArray());
        g.toJson(data);
       // saveFile(data); 
    }

    public void updateGimnasio(Gimnasio gimnasio) throws Exception {
        Integer id = gimnasio.getId();
        LinkedList<Gimnasio> Gimnasios = listAll();
        Gimnasios.update(gimnasio, id);
        String data = g.toJson(Gimnasios.toArray());
        g.toJson(data);
       // saveFile(data);
    }

    public Genero[] generos() {
        return Genero.values();
    }
   
    public Rol[] roles() {
        return Rol.values();
    }

    public TipoIdentificacion[] tiposIdentificaion() {
        return TipoIdentificacion.values();
    }
}
