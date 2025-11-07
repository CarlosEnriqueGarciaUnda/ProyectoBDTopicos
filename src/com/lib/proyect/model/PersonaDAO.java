package com.lib.proyect.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {

    private final String INSERT_SQL = "INSERT INTO registros.\"Persona\"(nombre, \"apellidoPaterno\", \"apellidoMaterno\", curp) VALUES (?, ?, ?, ?)";
    public boolean guardarPersona(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT_SQL);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidoPaterno());
            stmt.setString(3, persona.getApellidoMaterno());
            stmt.setString(4, persona.getCURP()); // Se asume que CURP ahora es String

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error al guardar la persona: " + e.getMessage());
            if (e.getMessage().contains("curp_key")) {
                System.err.println("El CURP ya existe en la base de datos.");
            }
            return false;
        } finally {
            if (stmt != null) { try { stmt.close(); } catch (SQLException e) { /* ignored */ } }
            if (conn != null) { try { conn.close(); } catch (SQLException e) { /* ignored */ } }
        }
    }
}