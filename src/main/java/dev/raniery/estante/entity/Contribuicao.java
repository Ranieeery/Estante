package dev.raniery.estante.entity;

import dev.raniery.estante.entity.config.ContribuicaoId;
import dev.raniery.estante.entity.enums.TipoContribuicao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_contribuicoes")
@EntityListeners(AuditingEntityListener.class)
public class Contribuicao {

    @EmbeddedId
    private ContribuicaoId id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "tipo_contribuicao", nullable = false)
    private TipoContribuicao tipo;

    @MapsId("obraId")
    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    @MapsId("autorId")
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contribuicao that)) return false;
        return Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
