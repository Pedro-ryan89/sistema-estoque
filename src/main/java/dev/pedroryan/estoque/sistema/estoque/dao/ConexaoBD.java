/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.pedroryan.estoque.sistema.estoque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author preya
 */
public class ConexaoBD {
    private static final String URL = "jdbc:sqlite:estoque.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    
}
