package dev.raniery.estante.core.entity;

import dev.raniery.estante.core.enums.TipoContribuicao;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Contribuicao {
    private Autor autor;
    private TipoContribuicao tipo;
    private final OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Contribuicao(Autor autor, TipoContribuicao tipo) {
        setAutor(autor);
        setTipo(tipo);
        this.createdAt = null;
        this.updatedAt = null;
    }

    public Contribuicao(Autor autor, TipoContribuicao tipo, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        setAutor(autor);
        setTipo(tipo);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Autor getAutor() {
        return autor;
    }

    public TipoContribuicao getTipo() {
        return tipo;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setAutor(Autor autor) {
        this.autor = Objects.requireNonNull(autor, "Autor cannot be null");
    }

    public void setTipo(TipoContribuicao tipo) {
        this.tipo = Objects.requireNonNull(tipo, "TipoContribuicao cannot be null");
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contribuicao that)) return false;
        return Objects.equals(autor, that.autor) && tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, tipo);
    }

    @Override
    public String toString() {
        return "Contribuicao{" +
            "autor=" + autor +
            ", tipo=" + tipo +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
