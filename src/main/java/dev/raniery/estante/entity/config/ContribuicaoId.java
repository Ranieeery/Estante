package dev.raniery.estante.entity.config;

import dev.raniery.estante.entity.enums.TipoContribuicao;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column(name = "obra_id")
    private Long obraId;

    @Column(name = "autor_id")
    private Long autorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "tipo_contribuicao")
    private TipoContribuicao type;
}
