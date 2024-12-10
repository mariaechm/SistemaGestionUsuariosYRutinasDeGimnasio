package com.example.controller.dao;

import java.time.LocalDate;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Cuenta;


public class CuentaDao extends AdapterDao<Cuenta> {
    private Cuenta cuenta;

    // Constructors ------------------------------------------------------------ 
    public CuentaDao() {
        super(Cuenta.class);
    }

    // Access Methods ------------------------------------------------------------

    public Cuenta getCuenta() {
        if(this.cuenta == null) {
            this.cuenta = new Cuenta();
        }
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public LinkedList<Cuenta> getAllCuentas() throws Exception {
        return this.listAll();
    }

    public void cuentaFromJson(String cuentaJson) {
        this.cuenta = g.fromJson(cuentaJson, Cuenta.class);
    }

    // CRUD Operations ------------------------------------------------------------

    public Cuenta getCuentaById(Integer id) throws Exception {
        return get(id);
    }

    public void save() throws Exception {
        Integer id = listAll().getSize() + 1; 
        this.getCuenta().setId(id);
        this.getCuenta().setFechaCreacion(LocalDate.now().toString());
        persist(this.cuenta);
    }

    public void deleteCuenta(Integer id) throws Exception {
        remove(id);
    }

    public void updateCuenta() throws Exception {
        Integer id = getCuenta().getId();
        merge(getCuenta(), id);
    }

}
