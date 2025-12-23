package dev.raniery.estante.service;

import dev.raniery.estante.dtos.AutorRequestDTO;
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
}
