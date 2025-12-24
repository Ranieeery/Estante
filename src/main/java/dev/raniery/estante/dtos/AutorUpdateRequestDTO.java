package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.GeneroAutor;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Builder
public record AutorUpdateRequestDTO(
    String name,
    String[] aliases,
    GeneroAutor gender,

    @Past
    LocalDate birthDate,

    @PastOrPresent
    LocalDate deathDate) {

    public boolean hasName() {
        return StringUtils.hasText(name);
    }

    public boolean hasAliases() {
        return aliases != null;
    }

    public boolean hasGender() {
        return gender != null;
    }

    public boolean hasBirthDate() {
        return birthDate != null;
    }

    public boolean hasDeathDate() {
        return deathDate != null;
    }
}
