package dev.raniery.estante.mapper;

import dev.raniery.estante.dtos.EditoraDTO;
import dev.raniery.estante.entity.Editora;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EditoraMapper {

    public Editora toEntity(EditoraDTO dto) {
        Editora editora = new Editora();
        editora.setName(dto.name());
        editora.setAliases(dto.aliases());
        editora.setSite(dto.site());
        editora.setPublisherType(dto.publisherType());
        return editora;
    }

    public EditoraDTO toDto(Editora editora) {
        return EditoraDTO.builder()
            .name(editora.getName())
            .aliases(editora.getAliases())
            .site(editora.getSite())
            .publisherType(editora.getPublisherType())
            .build();
    }
}
