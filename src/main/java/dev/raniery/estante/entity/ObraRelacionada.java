package dev.raniery.estante.entity;

import dev.raniery.estante.entity.config.ObraRelacionadaId;
import dev.raniery.estante.entity.enums.TipoRelacao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_obras_relacionadas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ObraRelacionada {

    @EmbeddedId
    private ObraRelacionadaId id;

    @MapsId("obraId")
    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    @MapsId("relatedId")
    @ManyToOne
    @JoinColumn(name = "related_id")
    private Obra related;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "tipo_relacao")
    private TipoRelacao relationType;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObraRelacionada that)) return false;
        return Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
