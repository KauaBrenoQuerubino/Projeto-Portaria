package com.controleacesso.Repository;

import java.sql.*;
import java.time.LocalDate;

public class MoradorBD extends BancoDeDados {
    public void cadastrarMorador(String nome, String identificacao, LocalDate dataDeNascimento, String apartamentoAssociadol, String placaVeiculo) throws SQLException {
        String sql = "INSERT INTO moradores (nome, identificacao, dataDeNascimento, apartamentoAssociado, placaVeiculo, Situacao) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        if (getConexao() == null || getConexao().isClosed()) {
            try {
                setConexao(DriverManager.getConnection(getJdbcURL(), getUsername(), getPassword()));
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }
        statement = getConexao().prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, identificacao);
        statement.setDate(3, Date.valueOf(dataDeNascimento));
        statement.setString(4, apartamentoAssociadol);
        statement.setString(5, placaVeiculo);
        statement.setString(6, "Entrou");

        try {
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Um novo registro foi inserido com sucesso!");
            }
            statement.close();
            getConexao().close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Essa Identificao ja esta cadastrada.");
        }
    }

    public void EntradaSaídaMorador(String identificacao) throws SQLException {
        String sql = "UPDATE `portaria`.`visitantes` SET `situacao` = 'saiu' WHERE (`identificacao` = ?);";
        PreparedStatement statement = null;

        if (getConexao() == null || getConexao().isClosed()) {
            try {
                setConexao(DriverManager.getConnection(getJdbcURL(), getUsername(), getPassword()));
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }

        statement = getConexao().prepareStatement(sql);
        statement.setString(1, identificacao);

        try {
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("O morador saiu");
            }
            statement.close();
            getConexao().close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("ocorreu um erro");
        }
    }
}
