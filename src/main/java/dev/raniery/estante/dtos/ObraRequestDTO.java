package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.Demografia;
import dev.raniery.estante.entity.enums.Periodicidade;
import dev.raniery.estante.entity.enums.StatusPublicacao;
import dev.raniery.estante.entity.enums.TipoObra;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ObraRequestDTO(

    @NotBlank
    String title,

    @NotBlank
    String originalTitle,

    String[] aliases,

    String description,

    //TODO:Contribuições

    EditoraResponseObraDTO publisherBr,

    EditoraResponseObraDTO publisherOrig,

    //TODO: Adicionar automaticamente em Obras a quantidade de volumes cadastrados com dados vazios? Fazer o contrário?
    //TODO: Existem volumes com 0.1, 0.5 etc? Salvo engano tem Paradise alguma coisa da Conrad...
    @PositiveOrZero
    Integer volumesBr,

    @Positive
    Integer volumesOrig,

    StatusPublicacao pubStatusBr,

    StatusPublicacao pubStatusOrig,

    //TODO: Gêneros
    //TODO: Rota para voltar gêneros? Salvar no front?

    Demografia demographic,

    LocalDate startDateBr,

    LocalDate endDateBr,

    //TODO: Obras relacionadas

    Periodicidade periodicity,

    TipoObra type,

    String coverUrl) {
}
