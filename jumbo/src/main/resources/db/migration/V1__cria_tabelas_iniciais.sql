CREATE SCHEMA IF NOT EXISTS jumpo;

-- Tabela Usuário
CREATE TABLE jumpo.usuario (
    id BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    data_cadastro TIMESTAMP
);

-- Tabela Avaliado
CREATE TABLE jumpo.avaliado (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    sexo VARCHAR(10),
    peso DOUBLE PRECISION,
    tamanho_perna_flexionada DOUBLE PRECISION,
    tamanho_perna_estendida DOUBLE PRECISION,
    data_cadastro TIMESTAMP,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES jumpo.usuario(id)
);

-- Tabela Salto
CREATE TABLE jumpo.salto (
    id BIGINT PRIMARY KEY,
    altura_salto DOUBLE PRECISION,
    tempo_voo DOUBLE PRECISION,
    forca_media DOUBLE PRECISION,
    potencia_media DOUBLE PRECISION,
    velocidade_media DOUBLE PRECISION,
    data_cadastro TIMESTAMP,
    avaliado_id BIGINT,
    FOREIGN KEY (avaliado_id) REFERENCES jumpo.avaliado(id)
);
