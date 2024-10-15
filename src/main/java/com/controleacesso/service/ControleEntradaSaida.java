package com.controleacesso.service;

import com.controleacesso.Model.Morador;
import com.controleacesso.Model.Visitantes;
import com.controleacesso.Repository.MoradorBD;
import com.controleacesso.Repository.VisitanteBD;

import java.sql.SQLException;

public class ControleEntradaSaida {

    VisitanteBD visitanteBD = new VisitanteBD();
    MoradorBD moradorBD = new MoradorBD();

    public void saidaVisitantes(Visitantes visitantes) throws SQLException {
        visitanteBD.EntradaSaídaVisitantes(visitantes.getIdentificacao());
    }

    public void saidaMorador(Morador morador) throws SQLException {
        moradorBD.EntradaSaídaMorador(morador.getIdentificacao());
    }

}
