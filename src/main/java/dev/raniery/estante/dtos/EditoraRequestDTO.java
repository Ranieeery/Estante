package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.TipoEditora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record EditoraRequestDTO(

    @NotBlank
    String name,

    String[] aliases,

    @NotBlank
    String site,

    @NotNull
    TipoEditora publisherType) {
}
