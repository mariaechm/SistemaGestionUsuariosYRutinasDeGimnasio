/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

import com.example.controller.dao.CuentaDao;
import com.example.models.Cuenta;

/**
 *
 * @author Grupo6
 */
public class CuentaServices {
    private CuentaDao obj;

    public CuentaServices() {
        this.obj = new CuentaDao();
    }

    public Cuenta getCuenta() {
        return this.obj.getCuenta();
    }

    public void setCuenta(Cuenta cuenta) {
        this.obj.setCuenta(cuenta);
    }

    public Cuenta getCuentaById(Integer id) throws Exception {
        return this.obj.getCuentaById(id);
    }

    public String getCuentaJsonById(Integer id) throws Exception {
        return this.obj.getCuentaJsonById(id);
    }

    public Boolean save() throws Exception {
        return this.obj.save();
    }

    public void update(Cuenta cuenta) throws Exception {
        this.obj.updateCuenta(cuenta);
    }

    public void delete(Integer id) throws Exception {
        this.obj.deleteCuenta(id);
    }
}
