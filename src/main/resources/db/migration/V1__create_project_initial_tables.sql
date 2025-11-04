CREATE TYPE genero_autor AS ENUM ('MASCULINO', 'FEMININO', 'NAO_BINARIO');

CREATE TABLE tb_autores (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    aliases    TEXT[],
    gender     genero_autor,
    birth_date DATE,
    death_date DATE,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ
);

CREATE TYPE tipo_editora AS ENUM ('BRASILEIRA', 'ORIGINAL');

CREATE TABLE tb_editoras (
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    aliases        TEXT[],
    site           VARCHAR(255),
    publisher_type tipo_editora NOT NULL,
    created_at     TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at     TIMESTAMPTZ
);

CREATE TYPE status_publicacao AS ENUM ('ANUNCIADO', 'EM_ANDAMENTO', 'FINALIZADO', 'HIATO', 'CANCELADO');

CREATE TYPE genero_obra AS ENUM (
    'ACAO', 'AVENTURA', 'BOYS_LOVE', 'COMEDIA', 'DRAMA',
    'ECCHI', 'ESCOLAR', 'ESPORTE', 'FANTASIA', 'FICCAO_CIENTIFICA',
    'GIRLS_LOVE', 'HISTORICO', 'HORROR', 'MAHOU_SHOUJO', 'MECHA',
    'MISTERIO', 'MUSICA', 'PSICOLOGICO', 'ROMANCE', 'SLICE_OF_LIFE',
    'SOBRENATURAL', 'SUSPENSE'
    );

CREATE TYPE demografia AS ENUM ('SHOUNEN', 'SHOUJO', 'SEINEN', 'JOSEI', 'KODOMO');

CREATE TYPE periodicidade AS ENUM ('MENSAL', 'BIMESTRAL', 'TRIMESTRAL', 'IRREGULAR');

CREATE TYPE tipo_obra AS ENUM ('MANGA', 'NOVEL', 'MANHWA', 'MANHUA', 'DATABOOK', 'ARTBOOK', 'FANBOOK', 'OUTRO');

CREATE TABLE tb_obras (
    id                BIGSERIAL PRIMARY KEY,
    title             VARCHAR(255) NOT NULL,
    original_title    VARCHAR(255) NOT NULL,
    aliases           TEXT[],
    description       TEXT,
    publisher_br_id   BIGINT REFERENCES tb_editoras (id),
    publisher_orig_id BIGINT REFERENCES tb_editoras (id),
    volumes_br        INT,
    volumes_orig      INT,
    pub_status_br     status_publicacao,
    pub_status_orig   status_publicacao,
    genres            genero_obra[],
    demographic       demografia,
    start_date_br     DATE,
    end_date_br       DATE,
    periodicity       periodicidade,
    type              tipo_obra,
    cover_url         TEXT,
    created_at        TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMPTZ
);

CREATE TYPE tipo_relacao AS ENUM ('PREQUEL', 'SEQUEL', 'ALTERNATIVE', 'SIDE_STORY', 'SPIN_OFF', 'ADAPTATION', 'OTHER');

CREATE TABLE tb_obras_relacionadas (
    obra_id       BIGINT REFERENCES tb_obras (id) ON DELETE CASCADE,
    related_id    BIGINT REFERENCES tb_obras (id) ON DELETE CASCADE,
    relation_type tipo_relacao,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ,
    PRIMARY KEY (obra_id, related_id)
);

CREATE TYPE tipo_contribuicao AS ENUM ('AUTOR', 'COAUTOR', 'ILUSTRADOR', 'AUTOR_ORIGINAL', 'ILUSTRADOR_ORIGINAL', 'ASSISTENTE');

CREATE TABLE tb_contribuicoes (
    obra_id    BIGINT REFERENCES tb_obras (id) ON DELETE CASCADE,
    autor_id   BIGINT REFERENCES tb_autores (id) ON DELETE CASCADE,
    type       tipo_contribuicao NOT NULL,
    created_at TIMESTAMPTZ       NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ,
    PRIMARY KEY (obra_id, autor_id, tipo)
);

CREATE TABLE tb_volumes
(
    id                BIGSERIAL PRIMARY KEY,
    obra_id           BIGINT REFERENCES tb_obras (id) ON DELETE CASCADE,
    volume_number     VARCHAR(5)  NOT NULL,
    price             NUMERIC(5, 2),
    release_date_br   DATE,
    release_date_orig DATE,
    external_links    TEXT[],
    cover_url         TEXT,
    is_purchased      BOOLEAN              DEFAULT FALSE,
    is_read           BOOLEAN              DEFAULT FALSE,
    created_at        TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMPTZ
);

CREATE OR REPLACE FUNCTION set_updated_at()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_autores_updated
    BEFORE UPDATE
    ON tb_autores
    FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_editoras_updated
    BEFORE UPDATE
    ON tb_editoras
    FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_obras_updated
    BEFORE UPDATE
    ON tb_obras
    FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_obras_relacionadas_updated
    BEFORE UPDATE
    ON tb_obras_relacionadas
    FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_contribuicoes_updated
    BEFORE UPDATE
    ON tb_contribuicoes
    FOR EACH ROW
EXECUTE FUNCTION set_updated_at();

CREATE TRIGGER trg_volumes_updated
    BEFORE UPDATE
    ON tb_volumes
    FOR EACH ROW
EXECUTE FUNCTION set_updated_at();