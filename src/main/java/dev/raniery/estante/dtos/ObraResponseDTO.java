package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.Demografia;
import dev.raniery.estante.entity.enums.Periodicidade;
import dev.raniery.estante.entity.enums.StatusPublicacao;
import dev.raniery.estante.entity.enums.TipoObra;
import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

@Builder
@Relation(collectionRelation = "obras", itemRelation = "obra")
public record ObraResponseDTO(
    Long id,
    String title,
    String originalTitle,
    String[] aliases,
    String description,
    EditoraResponseObraDTO publisherBr,
    EditoraResponseObraDTO publisherOrig,
    Integer volumesBr,
    Integer volumesOrig,
    StatusPublicacao pubStatusBr,
    StatusPublicacao pubStatusOrig,
    Demografia demographic,
    LocalDate startDateBr,
    LocalDate endDateBr,
    Periodicidade periodicity,
    TipoObra type,
    String coverUrl) {
}
