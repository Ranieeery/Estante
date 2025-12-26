package dev.raniery.estante.dtos;

import lombok.Builder;

@Builder
public record EditoraResponseObraDTO(
    Long id,
    String name) {
}
