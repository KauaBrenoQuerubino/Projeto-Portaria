package com.controleacesso.Model;

public class Visitantes extends Ocupante {

    public Visitantes(String nome, String identificacao, String ApartamentoAssociado) {
        setNome(nome);
        if (identificacao.length() < 11 || identificacao.length() > 18){
            throw new RuntimeException("identificacao invalida");
        }else{
            setIdentificacao(identificacao);
        }
        setApartamentoAssociado(ApartamentoAssociado);
    }






}
