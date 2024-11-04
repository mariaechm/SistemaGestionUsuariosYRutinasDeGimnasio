package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Persona;
import com.example.models.enumerator.Genero;
import com.example.models.enumerator.Rol;
import com.example.models.enumerator.TipoIdentificacion;


public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;
    
    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if(this.persona == null) {
            this.persona = new Persona();
        }
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void personaFromJson(String personaJson) {
        this.persona = g.fromJson(personaJson, Persona.class);
    }

    public Persona getPersonaById(Integer id) throws Exception {
        return get(id);
    }

    public String getPersonaJsonById(Integer id) throws Exception {
        return g.toJson(this.getPersonaById(id));
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize() + 1;
        this.getPersona().setId(id);
        persist(this.persona);
        return true;
    }

    public void deletePersona(Integer id) throws Exception {
        LinkedList<Persona> personas = listAll();
        personas.delete(id);
        String data = g.toJson(personas.toArray());
        saveFile(data); 
    }

    public void updatePersona(Persona persona) throws Exception {
        Integer id = persona.getId();
        LinkedList<Persona> personas = listAll();
        personas.update(persona, id);
        String data = g.toJson(personas.toArray());
        saveFile(data);
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
