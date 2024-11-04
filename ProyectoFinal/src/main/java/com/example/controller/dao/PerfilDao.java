package com.example.controller.dao;

import com.example.models.Perfil;
import java.sql.*;

public class PerfilDao {

    private Connection connection;

    public PerfilDao(Connection connection) {
        this.connection = connection;
    }

    public void crear(Perfil perfil) throws SQLException {
        String sql = "INSERT INTO perfil (peso, imagen, altura, objetivo_cliente) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setFloat(1, perfil.getPeso());
            stmt.setString(2, perfil.getImagen());
            stmt.setFloat(3, perfil.getAltura());
            stmt.setString(4, perfil.getObjetivoCliente());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                perfil.setId(rs.getInt(1));
            }
        }
    }

    public Perfil obtenerPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM perfil WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Perfil(
                        rs.getInt("id"),
                        rs.getFloat("peso"),
                        rs.getString("imagen"),
                        rs.getFloat("altura"),
                        rs.getString("objetivo_cliente")
                );
            }
            return null;
        }
    }

    public void actualizar(Perfil perfil) throws SQLException {
        String sql = "UPDATE perfil SET peso = ?, imagen = ?, altura = ?, objetivo_cliente = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setFloat(1, perfil.getPeso());
            stmt.setString(2, perfil.getImagen());
            stmt.setFloat(3, perfil.getAltura());
            stmt.setString(4, perfil.getObjetivoCliente());
            stmt.setInt(5, perfil.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM perfil WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
