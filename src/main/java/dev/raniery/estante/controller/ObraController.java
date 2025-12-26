package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.ObraRequestDTO;
import dev.raniery.estante.dtos.ObraResponseDTO;
import dev.raniery.estante.entity.Obra;
import dev.raniery.estante.mapper.ObraMapper;
import dev.raniery.estante.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
