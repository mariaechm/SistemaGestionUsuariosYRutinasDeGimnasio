package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Cuenta;

public class CuentaDao extends AdapterDao<Cuenta> {
     private Cuenta cuenta;
    
    public CuentaDao() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if(this.cuenta == null) {
            this.cuenta = new Cuenta();
        }
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void cuentaFromJson(String cuentaJson) {
        this.cuenta = g.fromJson(cuentaJson, Cuenta.class);
    }

    public Cuenta getCuentaById(Integer id) throws Exception {
        return get(id);
    }

    public String getCuentaJsonById(Integer id) throws Exception {
        return g.toJson(this.getCuentaById(id));
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize() + 1;
        this.getCuenta().setId(id);
        persist(this.cuenta);
        return true;
    }

    public void deleteCuenta(Integer id) throws Exception {
        LinkedList<Cuenta> cuentas = listAll();
        cuentas.delete(id);
        String data = g.toJson(cuentas);
        saveFile(data); 
    }

    public void updateCuenta(Cuenta Cuenta) throws Exception {
        Integer id = cuenta.getId();
        LinkedList<Cuenta> cuentas = listAll();
        cuentas.update(Cuenta, id);
        String data = g.toJson(cuentas);
        saveFile(data);
    }

}
