package dev.raniery.estante.service;

import dev.raniery.estante.dtos.EditoraRequestDTO;
import dev.raniery.estante.dtos.EditoraResponseDTO;
import dev.raniery.estante.dtos.EditoraUpdateRequestDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.entity.enums.TipoEditora;
import dev.raniery.estante.mapper.EditoraMapper;
import dev.raniery.estante.repository.EditoraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    @Transactional
    public Editora createEditora(EditoraRequestDTO dto) {
        return editoraRepository.save(EditoraMapper.toEntity(dto));
    }

    @Transactional(readOnly = true)
    public Page<EditoraResponseDTO> findAll(TipoEditora type, Pageable pageable) {

        Page<Editora> editoras = Optional.ofNullable(type)
            .map(t -> editoraRepository.findAllByType(t, pageable))
            .orElseGet(() -> editoraRepository.findAll(pageable));

        return editoras.map(EditoraMapper::toResponse);
    }

    //TODO: Exception Handler
    //TODO: Custom NotFoundException
    @Transactional(readOnly = true)
    public Editora findById(Long id) {
        return editoraRepository.findById(id).orElseThrow(() -> new RuntimeException("Editora not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public Page<EditoraResponseDTO> findByNameOrAlias(String name, Pageable pageable) {

        if (name == null || name.isBlank()) {
            return Page.empty(pageable);
        }

        String escapedName = escapeLike(name);

        Page<Editora> editoras = editoraRepository.findByNameOrAliases(escapedName, pageable);

        return editoras.map(EditoraMapper::toResponse);
    }

    @Transactional
    public Editora updateEditora(Long id, EditoraUpdateRequestDTO editoraDTO) {
        Editora editora = findById(id);

        editora.update(editoraDTO);

        return editora;
    }

    private String escapeLike(String value) {
        return value
            .replace("\\", "\\\\")
            .replace("%", "\\%")
            .replace("_", "\\_");
    }

}
