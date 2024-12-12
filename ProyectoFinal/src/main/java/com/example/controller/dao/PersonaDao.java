package com.example.controller.dao;


import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Persona;
import com.example.models.enumerator.Genero;
import com.example.models.enumerator.Rol;
import com.example.models.enumerator.TipoIdentificacion;


public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;

    // Constructors ------------------------------------------------------------
    

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

    public LinkedList<Persona> getAllPersonas() throws Exception {
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
        Integer id = listAll().getSize() + 1;
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
