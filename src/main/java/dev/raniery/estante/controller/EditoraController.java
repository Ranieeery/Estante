package dev.raniery.estante.controller;

import dev.raniery.estante.dtos.EditoraDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.service.EditoraService;
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
    @PostMapping
    public ResponseEntity<Editora> saveEditora(@RequestBody EditoraDTO editoraDTO) {
        Editora createdEditora = editoraService.createEditora(editoraDTO);
        return ResponseEntity.ok(createdEditora);
    }
}
