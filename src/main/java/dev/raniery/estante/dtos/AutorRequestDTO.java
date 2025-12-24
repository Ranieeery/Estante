package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.GeneroAutor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AutorRequestDTO(

    @NotBlank
    String name,

    String[] aliases,

    GeneroAutor gender,

    @Past
    LocalDate birthDate,

    @PastOrPresent
    LocalDate deathDate
) {
}
