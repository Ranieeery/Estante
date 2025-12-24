package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.AutorRequestDTO;
import dev.raniery.estante.dtos.AutorResponseDTO;
import dev.raniery.estante.dtos.AutorUpdateRequestDTO;
import dev.raniery.estante.entity.Autor;
import dev.raniery.estante.mapper.AutorMapper;
import dev.raniery.estante.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> saveAutor(@RequestBody @Valid AutorRequestDTO autorDTO) {
        Autor createdAutor = autorService.createAutor(autorDTO);

        return ResponseEntity.created(URI.create("/api/v1/autor/" + createdAutor.getId())).body(AutorMapper.toResponse(createdAutor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> getAutorById(@PathVariable Long id) {
        Autor autor = autorService.findById(id);

        return ResponseEntity.ok(AutorMapper.toResponse(autor));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> updateAutor(@PathVariable Long id, @RequestBody @Valid AutorUpdateRequestDTO autorDTO) {
        Autor updatedAutor = autorService.updateAutor(id, autorDTO);

        return ResponseEntity.ok(AutorMapper.toResponse(updatedAutor));
    }
}
