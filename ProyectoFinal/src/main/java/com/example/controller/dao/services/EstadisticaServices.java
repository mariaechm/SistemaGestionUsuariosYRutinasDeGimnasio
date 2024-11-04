/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

/**
 *
 * @author Grupo6
 */
import com.example.controller.dao.EstadisticaDao;
import com.example.models.Estadistica;
import java.sql.SQLException;
import java.util.List;

public class EstadisticaServices {
    private final EstadisticaDao estadisticaDAO;

    public EstadisticaServices(EstadisticaDao estadisticaDao) {
        this.estadisticaDAO = estadisticaDao;
    }

    public void crearEstadistica(Estadistica estadistica) throws SQLException {
        if (estadistica.getMedida() <= 0) {
            throw new IllegalArgumentException("La medida debe ser mayor que 0");
        }
        estadisticaDAO.crear(estadistica);
    }

    public Estadistica obtenerEstadistica(Integer id) throws SQLException {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        return estadisticaDAO.obtenerPorId(id);
    }

    public void actualizarEstadistica(Estadistica estadistica) throws SQLException {
        if (estadistica.getId() == null || estadistica.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        if (estadistica.getMedida() <= 0) {
            throw new IllegalArgumentException("La medida debe ser mayor que 0");
        }
        estadisticaDAO.actualizar(estadistica);
    }

    public void eliminarEstadistica(Integer id) throws SQLException {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        estadisticaDAO.eliminar(id);
    }
}
