package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.ObraRequestDTO;
import dev.raniery.estante.dtos.ObraResponseDTO;
import dev.raniery.estante.dtos.ObraUpdateRequestDTO;
import dev.raniery.estante.entity.Obra;
import dev.raniery.estante.mapper.ObraMapper;
import dev.raniery.estante.service.ObraService;
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
@RequestMapping("/api/v1/obra")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @PostMapping
    public ResponseEntity<ObraResponseDTO> saveObra(@RequestBody @Valid ObraRequestDTO obraDTO) {
        Obra obra = obraService.createObra(obraDTO);

        return ResponseEntity.created(URI.create("/api/v1/obra/" + obra.getId())).body(ObraMapper.toResponse(obra));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraResponseDTO> getObraById(@PathVariable Long id) {
        Obra obra = obraService.findById(id);

        return ResponseEntity.ok(ObraMapper.toResponse(obra));
    }

    @GetMapping(params = "editoraBr")
    public ResponseEntity<PagedModel<EntityModel<ObraResponseDTO>>> getObrasByEditoraBrId(@RequestParam(name = "editoraBr") Long editoraId, @PageableDefault(sort = {"id"}) Pageable pageable, PagedResourcesAssembler<ObraResponseDTO> assembler) {
        Page<ObraResponseDTO> obraResponseDTOS = obraService.findAllByEditoraBr(editoraId, pageable);

        return ResponseEntity.ok(assembler.toModel(obraResponseDTOS));
    }

    @GetMapping(params = "editoraOrig")
    public ResponseEntity<PagedModel<EntityModel<ObraResponseDTO>>> getObrasByEditoraOrigId(@RequestParam(name = "editoraOrig") Long editoraId, @PageableDefault(sort = {"id"}) Pageable pageable, PagedResourcesAssembler<ObraResponseDTO> assembler) {
        Page<ObraResponseDTO> obraResponseDTOS = obraService.findAllByEditoraOrig(editoraId, pageable);

        return ResponseEntity.ok(assembler.toModel(obraResponseDTOS));
    }

    @GetMapping("/search")
    public ResponseEntity<PagedModel<EntityModel<ObraResponseDTO>>> searchByObraName(@RequestParam(name = "title") String title, @PageableDefault(sort = {"id"}) Pageable pageable, PagedResourcesAssembler<ObraResponseDTO> assembler) {
        Page<ObraResponseDTO> obraResponseDTOS = obraService.findByTitleOrAlias(title, pageable);

        return ResponseEntity.ok(assembler.toModel(obraResponseDTOS));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ObraResponseDTO> updateObra(@PathVariable Long id, @RequestBody @Valid ObraUpdateRequestDTO obraDTO) {
        Obra updatedObra = obraService.updateObra(id, obraDTO);

        return ResponseEntity.ok(ObraMapper.toResponse(updatedObra));
    }
}
