package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.ObraRequestDTO;
import dev.raniery.estante.dtos.ObraResponseDTO;
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

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ObraResponseDTO>>> getObrasByEditoraBrId(@RequestParam(name = "editora") Long editoraId, @PageableDefault(sort = {"id"}) Pageable pageable, PagedResourcesAssembler<ObraResponseDTO> assembler) {
        Page<ObraResponseDTO> obraResponseDTOS = obraService.findAllByEditoraBr(editoraId, pageable);

        return ResponseEntity.ok(assembler.toModel(obraResponseDTOS));
    }
}
