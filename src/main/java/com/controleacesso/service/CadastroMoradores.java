package com.controleacesso.service;


import com.controleacesso.Model.Morador;
import com.controleacesso.Repository.MoradorBD;

import java.sql.SQLException;
import java.util.Date;

public class CadastroMoradores {
    MoradorBD moradorBD = new MoradorBD();

    public void CadastroMorador(Morador morador) throws SQLException {
            Date horario = new Date();
            moradorBD.cadastrarMorador(
                    morador.getNome(),
                    morador.getIdentificacao(),
                    morador.getDataDeNascimento(),
                    morador.getApartamentoAssociado(),
                    morador.getVeiculoAssociado());
        }
}
