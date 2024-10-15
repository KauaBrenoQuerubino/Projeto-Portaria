package com.controleacesso.Model;

public abstract class Ocupante {
    private String nome;
    private String identificacao;
    private String ApartamentoAssociado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getApartamentoAssociado() {
        return ApartamentoAssociado;
    }

    public void setApartamentoAssociado(String apartamentoAssociado) {
        ApartamentoAssociado = apartamentoAssociado;
    }
}
