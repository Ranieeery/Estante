package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.GeneroAutor;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AutorResponseDTO(
    Long id,
    String name,
    String[] aliases,
    GeneroAutor gender,
    LocalDate birthDate,
    LocalDate deathDate) {
}
