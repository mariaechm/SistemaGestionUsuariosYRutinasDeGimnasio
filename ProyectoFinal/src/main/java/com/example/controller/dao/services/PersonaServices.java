/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

import java.lang.reflect.Array;

import com.example.controller.dao.PersonaDao;
import com.example.models.Persona;
import com.example.models.enumerator.Genero;
import com.example.models.enumerator.Rol;
import com.example.models.enumerator.TipoIdentificacion;


public class PersonaServices {
    private PersonaDao obj;

    // Constructors -----------------------------------------------------

    public PersonaServices() {
        this.obj = new PersonaDao();
    }

    // Model Getters and Setters -----------------------------------------------------

    public Persona getPersona() {
        return this.obj.getPersona();
    }

    public void setPersona(Persona persona) {
        this.obj.setPersona(persona);
    }

    public void personaFromJson(String personaJson) {
        this.obj.personaFromJson(personaJson);
    }

    public Persona[] getAllPersonas() throws Exception {
        try {
            return obj.getAllPersonas().toArray(); 
        } catch (Exception e) {
            return (Persona[])Array.newInstance(Persona.class, 0);
        }
    }

    // CRUD Operations -----------------------------------------------------

    public Persona getPersonaById(Integer id) throws Exception {
        return this.obj.getPersonaById(id);
    }

    public void save() throws Exception {
        this.obj.save();
    }

    public void update() throws Exception {
        this.obj.updatePersona();
    }

    public void deletePersona(Integer id) throws Exception {        
        this.obj.deletePersona(id);
    }

    //Enumerations -----------------------------------------------------

    public Genero[] generos() {
        return this.obj.generos();
    }

    public Rol[] roles() {
        return this.obj.roles();
    }
    
    public TipoIdentificacion[] tiposIdentificacion() {
        return this.obj.tiposIdentificaion();
    }

}
