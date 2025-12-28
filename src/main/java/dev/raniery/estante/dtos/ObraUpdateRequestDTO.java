package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.Demografia;
import dev.raniery.estante.entity.enums.Periodicidade;
import dev.raniery.estante.entity.enums.StatusPublicacao;
import dev.raniery.estante.entity.enums.TipoObra;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public record ObraUpdateRequestDTO(
    String title,
    String originalTitle,
    String[] aliases,
    String description,
    //TODO: Add staff
    EditoraResponseObraDTO publisherBr,
    EditoraResponseObraDTO publisherOrig,

    @PositiveOrZero
    Integer volumesBr,

    @Positive
    Integer volumesOrig,
    StatusPublicacao pubStatusBr,
    StatusPublicacao pubStatusOrig,
    //TODO: Add Gêneros
    Demografia demographic,
    LocalDate startDateBr,
    LocalDate endDateBr,
    //TODO: Add Obras relacionadas
    Periodicidade periodicity,
    TipoObra type
    /*TODO: Add coverUrl*/) {

    public boolean hasPublisherBr() {
        return publisherBr != null;
    }

    public boolean hasPublisherOrig() {
        return publisherOrig != null;
    }
}
