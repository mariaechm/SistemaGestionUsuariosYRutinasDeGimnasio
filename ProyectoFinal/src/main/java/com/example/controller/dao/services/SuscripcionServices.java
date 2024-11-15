/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

import com.example.controller.dao.SuscripcionDao;
import com.example.models.Suscripcion;
import com.example.models.enumerator.TipoSuscripcion;
/**
 *
 * @author Grupo6
 */

public class SuscripcionServices {
    private  SuscripcionDao obj;

    @Deprecated   
    public SuscripcionServices() {
        this.obj = new SuscripcionDao();
    }
    
    public Suscripcion getSuscripcion() {
        return this.obj.getSuscripcion();
    }
    
    public void setSuscripcion (Suscripcion suscripcion) {
        this.obj.setSuscripcion(suscripcion);
    }

    public TipoSuscripcion [] tiposSuscripcion() {
        return this.obj.tiposSuscripcion();
    }
        
    public Suscripcion getSuscripcionId(Integer id) throws Exception {
        return this.obj.getSuscripcionId(id);
    }
      
    public Boolean save() throws Exception {
        return this.obj.save();
    }

    public void update(Suscripcion suscripcion) throws Exception {
        this.obj.updateSuscripcion(suscripcion);
    }

    public void delete(Integer id) throws Exception {
            this.obj.deleteSuscripcion(id);
    }

}