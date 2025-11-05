package dev.raniery.estante.entity.config;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class ObraRelacionadaId implements Serializable {

    @Column(name = "obra_id")
    private Long obraId;

    @Column(name = "related_id")
    private Long relatedId;
}
