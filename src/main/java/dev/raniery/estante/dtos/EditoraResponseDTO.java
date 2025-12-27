package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.TipoEditora;
import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Relation(collectionRelation = "editoras", itemRelation = "editora")
public record EditoraResponseDTO(
    Long id,
    String name,
    String[] aliases,
    String site,
    TipoEditora publisherType) {
}
