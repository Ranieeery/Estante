package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.TipoEditora;
import lombok.Builder;

import java.util.Set;

@Builder
public record EditoraDTO(
    String name,
    String[] aliases,
    String site,
    TipoEditora publisherType) {
}
