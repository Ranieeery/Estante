package dev.raniery.estante.core.entity;

import dev.raniery.estante.core.enums.TipoContribuicao;

import java.util.Objects;

public class Contribuicao {
    private Autor autor;
    private TipoContribuicao tipo;

    public Contribuicao(Autor autor, TipoContribuicao tipo) {
        setAutor(autor);
        setTipo(tipo);
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = Objects.requireNonNull(autor, "Autor cannot be null");
    }

    public TipoContribuicao getTipo() {
        return tipo;
    }

    public void setTipo(TipoContribuicao tipo) {
        this.tipo = Objects.requireNonNull(tipo, "TipoContribuicao cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contribuicao that = (Contribuicao) o;
        return Objects.equals(autor, that.autor) && tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, tipo);
    }

    @Override
    public String toString() {
        return "Contribuicao{autor=" + autor.getName() + ", tipo=" + tipo + '}';
    }
}
