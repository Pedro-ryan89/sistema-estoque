/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.pedroryan.estoque.sistema.estoque.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author preya
 */
public class Database {
    private static final String URL = "jdbc:h2:./data/estoque";
    private static final String USER = "sa";
    private static final String PASS = "";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }
    
}
