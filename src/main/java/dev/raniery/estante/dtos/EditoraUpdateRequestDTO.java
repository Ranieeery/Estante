package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.TipoEditora;
import lombok.Builder;

@Builder
public record EditoraUpdateRequestDTO(
    String name,
    String[] aliases,
    String site,
    TipoEditora publisherType) {
}
