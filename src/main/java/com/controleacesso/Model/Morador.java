package com.controleacesso.Model;

import java.time.LocalDate;


public class Morador extends Ocupante {

    private String VeiculoAssociado;
    private LocalDate DataDeNascimento;

    public Morador(String nome, String identificacao, LocalDate DataDeNascimento, String ApartamentoAssociado, String veiculoAssociado) {
        setNome(nome);
        if (identificacao.length() < 11 || identificacao.length() > 18){
            throw new RuntimeException("identificacao invalida");

        }else {
            setIdentificacao(identificacao);
        }
        setApartamentoAssociado(ApartamentoAssociado);
        this.DataDeNascimento = DataDeNascimento;
        VeiculoAssociado = veiculoAssociado;
    }

    public String getVeiculoAssociado() {
        return VeiculoAssociado;
    }

    public void setVeiculoAssociado(String veiculoAssociado) {
        VeiculoAssociado = veiculoAssociado;
    }

    public LocalDate getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }
}
