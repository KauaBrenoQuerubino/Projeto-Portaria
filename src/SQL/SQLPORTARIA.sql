-- Active: 1728949478412@@127.0.0.1@3306@portaria
DROP SCHEMA portaria;

create schema if not exists portaria;

use portaria;

CREATE TABLE Visitantes (
    nome VARCHAR(255) NOT NULL,
    identificacao VARCHAR(18) NOT NULL PRIMARY KEY,
    Horario TIMESTAMP NOT NULL,
    situacao ENUM('entrou', 'saiu') NOT NULL,
    motivacao VARCHAR(255),
    apartamentoAssociado varchar(5) not null
);

create table Moradores(
	nome varchar(255) not null,
    identificacao varchar(255) not null unique,
    dataDeNascimento date not null,
    apartamentoAssociado varchar(5) not null,
    placaVeiculo varchar(7) unique,
    situacao enum("Entrou", "Saiu") not null
);

SELECT * FROM moradores;
SELECT * FROM visitantes;