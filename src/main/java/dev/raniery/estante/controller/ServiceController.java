package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.AutorRequestDTO;
import dev.raniery.estante.dtos.AutorResponseDTO;
import dev.raniery.estante.entity.Autor;
import dev.raniery.estante.mapper.AutorMapper;
import dev.raniery.estante.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("api/v1/autor")
public class ServiceController {

    private final AutorService autorService;

    public ServiceController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> saveAutor(@RequestBody @Valid AutorRequestDTO autorDTO) {
        Autor createdAutor = autorService.createAutor(autorDTO);

        return ResponseEntity.created(URI.create("/api/v1/editora/" + createdAutor.getId())).body(AutorMapper.toResponse(createdAutor));
    }
}
