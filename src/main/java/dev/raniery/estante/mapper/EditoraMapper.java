package dev.raniery.estante.mapper;

import dev.raniery.estante.dtos.EditoraRequestDTO;
import dev.raniery.estante.dtos.EditoraResponseDTO;
import dev.raniery.estante.entity.Editora;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EditoraMapper {

    public Editora toEntity(EditoraRequestDTO dto) {
        Editora editora = new Editora();
        editora.setName(dto.name());
        editora.setAliases(dto.aliases());
        editora.setSite(dto.site());
        editora.setPublisherType(dto.publisherType());
        return editora;
    }

    public EditoraRequestDTO toDto(Editora editora) {
        return EditoraRequestDTO.builder()
            .name(editora.getName())
            .aliases(editora.getAliases())
            .site(editora.getSite())
            .publisherType(editora.getPublisherType())
            .build();
    }

    public EditoraResponseDTO toResponse(Editora editora) {
        return EditoraResponseDTO.builder()
            .id(editora.getId())
            .name(editora.getName())
            .aliases(editora.getAliases())
            .site(editora.getSite())
            .publisherType(editora.getPublisherType())
            .build();
    }
}
