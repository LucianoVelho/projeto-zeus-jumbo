CREATE SCHEMA IF NOT EXISTS jumbo;

CREATE SEQUENCE IF NOT EXISTS jumbo.sq_usuario	        INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE IF NOT EXISTS jumbo.sq_avaliado	        INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE IF NOT EXISTS jumbo.sq_salto       INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

-- Tabela Usuário
CREATE TABLE usuario (
    id BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    data_cadastro TIMESTAMP
);

-- Tabela Avaliado
CREATE TABLE avaliado (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    sexo VARCHAR(10),
    peso DOUBLE PRECISION,
    tamanho_perna_flexionada DOUBLE PRECISION,
    tamanho_perna_estendida DOUBLE PRECISION,
    data_cadastro TIMESTAMP,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Tabela Salto
CREATE TABLE salto (
    id BIGINT PRIMARY KEY,
    altura_salto DOUBLE PRECISION,
    tempo_voo DOUBLE PRECISION,
    forca_media DOUBLE PRECISION,
    potencia_media DOUBLE PRECISION,
    velocidade_media DOUBLE PRECISION,
    data_cadastro TIMESTAMP,
    avaliado_id BIGINT NOT NULL,
    FOREIGN KEY (avaliado_id) REFERENCES avaliado(id)
);