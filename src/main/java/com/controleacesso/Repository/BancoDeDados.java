package com.controleacesso.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BancoDeDados {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/portaria";
    private final String username = "root";
    private final String password = "";
    private Connection conexao = null;

    void conexaoComDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(jdbcURL, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco de dados não localizado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
        }
    }



     String getJdbcURL() {
        return jdbcURL;
    }

     String getUsername() {
        return username;
    }

     String getPassword() {
        return password;
    }

     Connection getConexao() {
        return conexao;
    }

     void setConexao(Connection conexao) {
        this.conexao = conexao;
    }






}
