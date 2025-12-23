package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.EditoraRequestDTO;
import dev.raniery.estante.dtos.EditoraResponseDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.mapper.EditoraMapper;
import dev.raniery.estante.service.EditoraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/editora")
public class EditoraController {

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    //TODO: .created() with URI location
    //TODO: Response sem dados de modificação (data)
    //TODO: Validação de dados
    @PostMapping
    public ResponseEntity<EditoraResponseDTO> saveEditora(@RequestBody EditoraRequestDTO editoraDTO) {
        Editora createdEditora = editoraService.createEditora(editoraDTO);

        return ResponseEntity.ok(EditoraMapper.toResponse(createdEditora));
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<EditoraResponseDTO>>> getEditora(@PageableDefault(sort = {"id"}) Pageable pageable, PagedResourcesAssembler<EditoraResponseDTO> assembler) {
        Page<EditoraResponseDTO> editoraResponseDTOS = editoraService.findAll(pageable);

        return ResponseEntity.ok(assembler.toModel(editoraResponseDTOS));
    }
}
