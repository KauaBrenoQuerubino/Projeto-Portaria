package com.controleacesso.Repository;

import java.sql.*;
import java.util.Date;

public class VisitanteBD extends BancoDeDados{

    public void cadastrarVisitante(String nome, String identificacao, Date horario, String motivo, String apartamentoAssociado) throws SQLException {
        String sql = "INSERT INTO visitantes (nome, identificacao, horario, situacao, motivacao, apartamentoAssociado) VALUES (?, ?, ?, ?, ?, ?)";
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
        statement.setTimestamp(3, new Timestamp(horario.getTime()));
        statement.setString(4,"entrou" );
        statement.setString(5, motivo);
        statement.setString(6, apartamentoAssociado);
        try {
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Um novo registro foi inserido com sucesso!");
            }
            statement.close();
            getConexao().close();
        }catch (SQLIntegrityConstraintViolationException e){
            System.err.println("Essa Identificao ja esta cadastrada.");
        }

    }

    public void EntradaSaídaVisitantes(String identificacao) throws SQLException {
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
                System.out.println("O visitante saiu");
            }
            statement.close();
            getConexao().close();
        }catch (SQLIntegrityConstraintViolationException e){
            System.err.println("ocorreu um erro");
        }

    }



}
