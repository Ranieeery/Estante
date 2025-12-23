package dev.raniery.estante.service;

import dev.raniery.estante.dtos.EditoraRequestDTO;
import dev.raniery.estante.dtos.EditoraResponseDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.mapper.EditoraMapper;
import dev.raniery.estante.repository.EditoraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public Editora createEditora(EditoraRequestDTO dto) {
        return editoraRepository.save(EditoraMapper.toEntity(dto));
    }

    public Page<EditoraResponseDTO> findAll(Pageable pageable) {
        Page<Editora> editoras = editoraRepository.findAll(pageable);

        return editoraRepository.findAll(pageable).map(EditoraMapper::toResponse);
    }
}
