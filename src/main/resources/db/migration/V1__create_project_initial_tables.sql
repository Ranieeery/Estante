CREATE TYPE genero_autor AS ENUM ('MASCULINO', 'FEMININO', 'NAO_BINARIO');

CREATE TABLE tb_autores (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    aliases TEXT[],
    gender genero_autor,
    birth_date DATE,
    death_date DATE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ
);

CREATE TYPE tipo_editora AS ENUM ('BRASILEIRA', 'ORIGINAL');

CREATE TABLE tb_editoras (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    aliases TEXT[],
    site VARCHAR(255),
    publisher_type tipo_editora NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ
);