/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

/**
 *
 * @author Grupo6
 */
import com.example.controller.dao.PerfilDao;
import com.example.models.Perfil;
import java.sql.SQLException;

public class PerfilServices {
    private final PerfilDao perfilDAO;

    public PerfilServices(PerfilDao PerfilDao) {
        this.perfilDAO = PerfilDao;
    }

    public void crearPerfil(Perfil perfil) throws SQLException {
        // Validaciones
        if (perfil.getPeso() <= 0 || perfil.getAltura() <= 0) {
            throw new IllegalArgumentException("El peso y la altura deben ser mayores que 0");
        }
        perfilDAO.crear(perfil);
    }

    public Perfil obtenerPerfil(Integer id) throws SQLException {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        return perfilDAO.obtenerPorId(id);
    }

    public void actualizarPerfil(Perfil perfil) throws SQLException {
        if (perfil.getId() == null || perfil.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        if (perfil.getPeso() <= 0 || perfil.getAltura() <= 0) {
            throw new IllegalArgumentException("El peso y la altura deben ser mayores que 0");
        }
        perfilDAO.actualizar(perfil);
    }

    public void eliminarPerfil(Integer id) throws SQLException {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        perfilDAO.eliminar(id);
    }
}
