package com.example.controller.dao;



import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Rutina;
import com.example.models.enumerator.Genero;
import com.example.models.enumerator.Rol;
import com.example.models.enumerator.TipoIdentificacion;


public class RutinaDao extends AdapterDao<Rutina> {
    private Rutina Rutina;

    // Constructors ------------------------------------------------------------
    
    public RutinaDao() {
        super(Rutina.class);
    }

    // Access Methods ------------------------------------------------------------

    public Rutina getRutina() {
        if(this.Rutina == null) {
            this.Rutina = new Rutina();
        }
        return this.Rutina;
    }

    public void setRutina(Rutina Rutina) {
        this.Rutina = Rutina;
    }

    public LinkedList<Rutina> getAllRutinas() throws Exception {
        return this.listAll();
    }

    public void RutinaFromJson(String RutinaJson) {
        this.Rutina = g.fromJson(RutinaJson, Rutina.class);
    }

    // CRUD Operations ------------------------------------------------------------

    public Rutina getRutinaById(Integer id) throws Exception {
        return get(id);
    }

    public void save() throws Exception {
        Integer id = listAll().getSize() + 1;
        this.getRutina().setId(id);
        persist(this.Rutina);
    }

    public void deleteRutina(Integer id) throws Exception {
        remove(id);
    }

    public void updateRutina() throws Exception {
        Integer id = getRutina().getId();
        merge(getRutina(), id);
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
