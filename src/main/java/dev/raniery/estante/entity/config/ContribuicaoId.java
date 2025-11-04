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
public class ContribuicaoId implements Serializable {
    private Long obraId;
    private Long autorId;
}
