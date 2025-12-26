package dev.raniery.estante.mapper;

import dev.raniery.estante.dtos.EditoraResponseObraDTO;
import dev.raniery.estante.dtos.ObraRequestDTO;
import dev.raniery.estante.dtos.ObraResponseDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.entity.Obra;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ObraMapper {

    //TODO: Implementar staff, genres e relatedWorks
    public Obra toEntity(ObraRequestDTO dto) {
        Obra obra = new Obra();
        obra.setTitle(dto.title());
        obra.setOriginalTitle(dto.originalTitle());
        obra.setAliases(dto.aliases());
        obra.setDescription(dto.description());
        obra.setVolumesBr(dto.volumesBr());
        obra.setVolumesOrig(dto.volumesOrig());
        obra.setPubStatusBr(dto.pubStatusBr());
        obra.setPubStatusOrig(dto.pubStatusOrig());
        obra.setDemographic(dto.demographic());
        obra.setStartDateBr(dto.startDateBr());
        obra.setEndDateBr(dto.endDateBr());
        obra.setPeriodicity(dto.periodicity());
        obra.setType(dto.type());
        obra.setCoverUrl(dto.coverUrl());
        return obra;
    }

    public ObraRequestDTO toDto(Obra obra) {
        return ObraRequestDTO.builder()
            .title(obra.getTitle())
            .originalTitle(obra.getOriginalTitle())
            .aliases(obra.getAliases())
            .description(obra.getDescription())
            .publisherBr(toPublisherDto(obra.getPublisherBr()))
            .publisherOrig(toPublisherDto(obra.getPublisherOrig()))
            .volumesBr(obra.getVolumesBr())
            .volumesOrig(obra.getVolumesOrig())
            .pubStatusBr(obra.getPubStatusBr())
            .pubStatusOrig(obra.getPubStatusOrig())
            .demographic(obra.getDemographic())
            .startDateBr(obra.getStartDateBr())
            .endDateBr(obra.getEndDateBr())
            .periodicity(obra.getPeriodicity())
            .type(obra.getType())
            .coverUrl(obra.getCoverUrl())
            .build();
    }

    public ObraResponseDTO toResponse(Obra obra) {
        return ObraResponseDTO.builder()
            .id(obra.getId())
            .title(obra.getTitle())
            .originalTitle(obra.getOriginalTitle())
            .aliases(obra.getAliases())
            .description(obra.getDescription())
            .publisherBr(toPublisherDto(obra.getPublisherBr()))
            .publisherOrig(toPublisherDto(obra.getPublisherOrig()))
            .volumesBr(obra.getVolumesBr())
            .volumesOrig(obra.getVolumesOrig())
            .pubStatusBr(obra.getPubStatusBr())
            .pubStatusOrig(obra.getPubStatusOrig())
            .demographic(obra.getDemographic())
            .startDateBr(obra.getStartDateBr())
            .endDateBr(obra.getEndDateBr())
            .periodicity(obra.getPeriodicity())
            .type(obra.getType())
            .coverUrl(obra.getCoverUrl())
            .build();
    }

    private static EditoraResponseObraDTO toPublisherDto(Editora publisher) {
        if (publisher == null) {
            return null;
        }

        return EditoraResponseObraDTO.builder()
            .id(publisher.getId())
            .name(publisher.getName())
            .build();
    }
}
