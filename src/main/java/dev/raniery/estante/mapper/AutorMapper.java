package dev.raniery.estante.mapper;

import dev.raniery.estante.dtos.AutorRequestDTO;
import dev.raniery.estante.dtos.AutorResponseDTO;
import dev.raniery.estante.entity.Autor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AutorMapper {

    public Autor toEntity(AutorRequestDTO dto) {
        Autor autor = new Autor();
        autor.setName(dto.name());
        autor.setAliases(dto.aliases());
        autor.setGender(dto.gender());
        autor.setBirthDate(dto.birthDate());
        autor.setDeathDate(dto.deathDate());
        return autor;
    }

    public AutorRequestDTO toDto(Autor autor) {
        return AutorRequestDTO.builder()
            .name(autor.getName())
            .aliases(autor.getAliases())
            .gender(autor.getGender())
            .birthDate(autor.getBirthDate())
            .deathDate(autor.getDeathDate())
            .build();
    }

    public AutorResponseDTO toResponse(Autor autor) {
        return AutorResponseDTO.builder()
            .id(autor.getId())
            .name(autor.getName())
            .aliases(autor.getAliases())
            .gender(autor.getGender())
            .birthDate(autor.getBirthDate())
            .deathDate(autor.getDeathDate())
            .build();
    }
}
