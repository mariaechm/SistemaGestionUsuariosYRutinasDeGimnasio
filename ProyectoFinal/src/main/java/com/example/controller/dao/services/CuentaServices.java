/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

import java.lang.reflect.Array;

import com.example.controller.dao.CuentaDao;
import com.example.models.Cuenta;

public class CuentaServices {
    private CuentaDao obj;

    // Constructors -----------------------------------------------------
    @Deprecated
    public CuentaServices() {
        this.obj = new CuentaDao();
    }

    public CuentaServices(Integer initialId) throws Exception {
        this.obj = new CuentaDao(initialId);
    }


    // Model Getters and Setters -----------------------------------------------------

    public Cuenta getCuenta() {
        return this.obj.getCuenta();
    }

    public void setCuenta(Cuenta cuenta) {
        this.obj.setCuenta(cuenta);
    }

    public void cuentaFromJson(String cuentaJson) {
        this.obj.cuentaFromJson(cuentaJson);
    }

    public Cuenta[] getAllCuentas() throws Exception {
        try {
            return obj.getAllCuentas().toArray(); 
        } catch (Exception e) {
            return (Cuenta[])Array.newInstance(Cuenta.class, 0);
        }
    }

    // CRUD Operations -----------------------------------------------------

    public Cuenta getCuentaById(Integer id) throws Exception {
        return this.obj.getCuentaById(id);
    }

    public void save() throws Exception {
        this.obj.save();
    }

    public void update() throws Exception {
        this.obj.updateCuenta();
    }

    public void deleteCuenta(Integer id) throws Exception {
        this.obj.deleteCuenta(id);
    }    

    // Persona Relationship -----------------------------------------------

    public void cascade(Integer personaId) throws Exception {
        this.obj.cascade(personaId);
    }

}
