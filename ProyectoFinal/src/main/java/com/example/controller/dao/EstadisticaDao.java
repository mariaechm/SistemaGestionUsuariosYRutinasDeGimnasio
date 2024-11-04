package com.example.controller.dao;

import com.example.models.Estadistica;
import java.sql.*;

public class EstadisticaDao {
    private Connection connection;

    public EstadisticaDao(Connection connection) {
        this.connection = connection;
    }

    public void crear(Estadistica estadistica) throws SQLException {
        String sql = "INSERT INTO estadistica (medida) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setFloat(1, estadistica.getMedida());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                estadistica.setId(rs.getInt(1));
            }
        }
    }

    public Estadistica obtenerPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM estadistica WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estadistica(
                    rs.getInt("id"),
                    rs.getFloat("medida")
                );
            }
            return null;
        }
    }

    public void actualizar(Estadistica estadistica) throws SQLException {
        String sql = "UPDATE estadistica SET medida = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setFloat(1, estadistica.getMedida());
            stmt.setInt(2, estadistica.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM estadistica WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
