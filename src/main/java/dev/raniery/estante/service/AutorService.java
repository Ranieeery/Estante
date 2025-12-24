package dev.raniery.estante.service;

import dev.raniery.estante.dtos.AutorRequestDTO;
import dev.raniery.estante.dtos.AutorUpdateRequestDTO;
import dev.raniery.estante.entity.Autor;
import dev.raniery.estante.mapper.AutorMapper;
import dev.raniery.estante.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public Autor createAutor(AutorRequestDTO dto) {
        return autorRepository.save(AutorMapper.toEntity(dto));
    }

    @Transactional(readOnly = true)
    public Autor findById(Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor not found with id: " + id));
    }

    @Transactional
    public Autor updateAutor(Long id, AutorUpdateRequestDTO autorDTO) {
        Autor autor = findById(id);

        autor.update(autorDTO);

        return autor;
    }
}
