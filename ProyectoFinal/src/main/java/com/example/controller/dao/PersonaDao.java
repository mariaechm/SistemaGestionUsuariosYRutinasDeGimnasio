package com.example.controller.dao;

import java.lang.reflect.Type;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Persona;
import com.example.models.enumerator.Genero;
import com.example.models.enumerator.Rol;
import com.example.models.enumerator.TipoIdentificacion;
import com.google.gson.reflect.TypeToken;


public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;

    // Constructors ------------------------------------------------------------    
    public PersonaDao() {
        super(Persona.class);
    }

    public PersonaDao(Integer initialId) throws Exception {
        super(Persona.class,initialId);
    }

    // Abstract Methods ------------------------------------------------------------
    protected Integer getIndexToOperate(Integer id) throws Exception {
        Persona[] personas = listAll().toArray();
        for(int i = 0; i < personas.length; i++) {
            if(personas[i].getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("IdNotFound");
    }

    protected JsonData<Persona> readFileAsJsonData() throws Exception {
        Type jsonDataType = new TypeToken<JsonData<Persona>>(){}.getType();
        JsonData<Persona> jsonData = g.fromJson(readFile(), jsonDataType);
        return jsonData;
    }

    // Access Methods ------------------------------------------------------------

    public Persona getPersona() {
        if(this.persona == null) {
            this.persona = new Persona();
        }
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getAllPersonas() {
        System.out.println(this.listAll().toArray());
        return this.listAll();
    }

    public void personaFromJson(String personaJson) {
        this.persona = g.fromJson(personaJson, Persona.class);
    }

    // CRUD Operations ------------------------------------------------------------

    public Persona getPersonaById(Integer id) throws Exception {
        return get(id);
    }

    public void save() throws Exception {
        currentId++;
        Integer id = currentId; // Atribute of AdapterDao
        this.getPersona().setId(id);
        persist(this.persona);
    }

    public void deletePersona(Integer id) throws Exception {
        remove(id);
    }

    public void updatePersona() throws Exception {
        Integer id = getPersona().getId();
        merge(getPersona(), id);
    }

    // Enumerations ------------------------------------------------------------
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
