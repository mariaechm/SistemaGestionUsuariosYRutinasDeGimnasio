package com.example.controller.dao;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.dao.implement.JsonData;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Cuenta;
import com.google.gson.reflect.TypeToken;


public class CuentaDao extends AdapterDao<Cuenta> {
    private Cuenta cuenta;

    // Constructors ------------------------------------------------------------ 
    @Deprecated   
    public CuentaDao() {
        super(Cuenta.class);
    }

    public CuentaDao(Integer initialId) throws Exception {
        super(Cuenta.class,initialId);
    }

    // Abstract Methods ------------------------------------------------------------

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
        final Integer personaId = this.getCuenta().getPersonaId();
        if(!existePersonaId(personaId)) {
            throw new Exception("PersonaNotFound");
        } else if(searchPersonaIdInCuentaList(personaId) != null) {
            throw new Exception("CuentaPersonaAlreadyExist");
        }
        currentId++;
        Integer id = currentId;
        this.getCuenta().setId(id);
        this.getCuenta().setFechaCreacion(LocalDate.now().toString());
        persist(this.cuenta);
    }

    public void deleteCuenta(Integer id) throws Exception {
        remove(id);
    }

    public void updateCuenta() throws Exception {
        if(!existePersonaId(this.getCuenta().getPersonaId())) {
            throw new Exception("PersonaNotFound");
        }
        Integer id = getCuenta().getId();
        merge(getCuenta(), id);
    }

    // Auxiliar Methods to Persona Relationship -----------------------------------

    public Boolean existePersonaId(Integer id) throws Exception {
        PersonaDao pd = new PersonaDao(0);
        try {
            if(pd.getIndexToOperate(id) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer searchPersonaIdInCuentaList(Integer personaId) throws Exception {
        Cuenta[] array = readFileAsJsonData().getObjects();
        for(int i = 0; i < array.length; i++) {
            if(array[i].getPersonaId().equals(personaId)) {
                return i;
            }
        }
        return null;
    }

    public void cascade(Integer personaId) throws Exception {
        //        -> Leer Archivo --> ObtenerArray -> Buscar cuenta con persId -> obtener cuentaId
        deleteCuenta(readFileAsJsonData().getObjects()[searchPersonaIdInCuentaList(personaId)].getId());
        // El método deleteCuenta funciona por id
    }

}
