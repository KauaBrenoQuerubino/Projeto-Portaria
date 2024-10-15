package com.controleacesso.service;

import com.controleacesso.Model.Visitantes;
import com.controleacesso.Repository.VisitanteBD;
import java.sql.SQLException;
import java.util.Date;

public class CadastroVisitantes {

    VisitanteBD bancoDeDados = new VisitanteBD();

    public void CadastroVisitante(Visitantes visitantes, String motivo) throws SQLException {
        Date horario = new Date();
        bancoDeDados.cadastrarVisitante(visitantes.getNome(), visitantes.getIdentificacao(), horario, motivo, visitantes.getApartamentoAssociado());
    }
}
