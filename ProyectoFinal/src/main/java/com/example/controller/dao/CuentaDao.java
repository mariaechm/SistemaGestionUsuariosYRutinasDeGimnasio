package com.example.controller.dao;

import java.lang.reflect.Type;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Cuenta;
import com.google.gson.reflect.TypeToken;

public class CuentaDao extends AdapterDao<Cuenta> {
     private Cuenta cuenta;
    
    public CuentaDao() {
        super(Cuenta.class);
    }

    protected Integer getIndexToOperate(Integer id) throws Exception {
        Cuenta[] array = listAll().toArray();
        for(int i = 0; i < array.length; i++) {
            if(array[i].getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("IdNotFound");
    }

    protected JsonData<Cuenta> readFileAsJsonData() throws Exception {
        Type jsonDataType = new TypeToken<JsonData<Cuenta>>(){}.getType();
        JsonData<Cuenta> jsonData = g.fromJson(readFile(), jsonDataType);
        return jsonData;
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
        data.toCharArray();
        //saveFile(data); 
    }

    public void updateCuenta(Cuenta Cuenta) throws Exception {
        Integer id = cuenta.getId();
        LinkedList<Cuenta> cuentas = listAll();
        cuentas.update(Cuenta, id);
        String data = g.toJson(cuentas);
        data.toCharArray();
        //saveFile(data);
    }

}
