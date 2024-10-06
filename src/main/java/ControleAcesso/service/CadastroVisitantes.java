package ControleAcesso.service;

import ControleAcesso.Repository.BancoDeDados;


import java.sql.SQLException;

import java.util.Date;

public class CadastroVisitantes {

    BancoDeDados bancoDeDados = new BancoDeDados();

    public void Cadastro(String nome, String identificao, String motivo) throws SQLException {
        Date horario = new Date();
        bancoDeDados.cadastrarVisitante(nome, identificao, horario, motivo);

    }
}
