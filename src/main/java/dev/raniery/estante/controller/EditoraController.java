package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.EditoraRequestDTO;
import dev.raniery.estante.dtos.EditoraResponseDTO;
import dev.raniery.estante.dtos.EditoraUpdateRequestDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.mapper.EditoraMapper;
import dev.raniery.estante.service.EditoraService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/editora")
public class EditoraController {

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    //TODO: Validação de dados (Exception Handler)
    @PostMapping
    public ResponseEntity<EditoraResponseDTO> saveEditora(@RequestBody @Valid EditoraRequestDTO editoraDTO) {
        Editora createdEditora = editoraService.createEditora(editoraDTO);

        return ResponseEntity.created(URI.create("/api/v1/editora/" + createdEditora.getId())).body(EditoraMapper.toResponse(createdEditora));
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<EditoraResponseDTO>>> getEditora(@PageableDefault(sort = {"id"}) Pageable pageable, PagedResourcesAssembler<EditoraResponseDTO> assembler) {
        Page<EditoraResponseDTO> editoraResponseDTOS = editoraService.findAll(pageable);

        return ResponseEntity.ok(assembler.toModel(editoraResponseDTOS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> getEditoraById(@PathVariable Long id) {
        Editora editora = editoraService.findById(id);

        return ResponseEntity.ok(EditoraMapper.toResponse(editora));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> updateEditora(@PathVariable Long id, @RequestBody @Valid EditoraUpdateRequestDTO editoraDTO) {
        Editora updatedEditora = editoraService.updateEditora(id, editoraDTO);

        return ResponseEntity.ok(EditoraMapper.toResponse(updatedEditora));
    }
}
