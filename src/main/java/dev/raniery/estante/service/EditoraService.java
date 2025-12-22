package dev.raniery.estante.service;

import dev.raniery.estante.dtos.EditoraDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.mapper.EditoraMapper;
import dev.raniery.estante.repository.EditoraRepository;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public Editora createEditora(EditoraDTO dto) {
        return editoraRepository.save(EditoraMapper.toEntity(dto));
    }
}
