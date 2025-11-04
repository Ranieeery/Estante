package dev.raniery.estante.entity.config;

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
    private Long obraId;
    private Long relatedId;
}
