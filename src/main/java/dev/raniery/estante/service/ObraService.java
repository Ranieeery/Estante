package dev.raniery.estante.service;

import dev.raniery.estante.dtos.EditoraResponseObraDTO;
import dev.raniery.estante.dtos.ObraRequestDTO;
import dev.raniery.estante.dtos.ObraResponseDTO;
import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.entity.Obra;
import dev.raniery.estante.mapper.ObraMapper;
import dev.raniery.estante.repository.EditoraRepository;
import dev.raniery.estante.repository.ObraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObraService {

    private final ObraRepository obraRepository;
    private final EditoraRepository editoraRepository;

    public ObraService(ObraRepository obraRepository, EditoraRepository editoraRepository) {
        this.obraRepository = obraRepository;
        this.editoraRepository = editoraRepository;
    }

    @Transactional
    public Obra createObra(ObraRequestDTO dto) {
        Obra obra = ObraMapper.toEntity(dto);


        Editora publisherBr = resolvePublisher(dto.publisherBr(), "Publisher (Brazilian edition)");
        Editora publisherOrig = resolvePublisher(dto.publisherOrig(), "Publisher (Origin edition)");

        obra.setPublisherBr(publisherBr);
        obra.setPublisherOrig(publisherOrig);

        return obraRepository.save(obra);
    }

    @Transactional(readOnly = true)
    public Obra findById(Long id) {
        return obraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Obra not found with id: %d".formatted(id)));
    }

    @Transactional(readOnly = true)
    public Page<ObraResponseDTO> findAllByEditoraBr(Long editoraId, Pageable pageable) {
        Page<Obra> obras = obraRepository.findAllByPublisherBrId(editoraId, pageable);
        return obras.map(ObraMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Page<ObraResponseDTO> findAllByEditoraOrig(Long editoraId, Pageable pageable) {
        Page<Obra> obras = obraRepository.findAllByPublisherOrigId(editoraId, pageable);
        return obras.map(ObraMapper::toResponse);
    }

    //TODO: Custom exceptions
    private Editora resolvePublisher(EditoraResponseObraDTO publisher, String fieldName) {

        if (publisher == null || publisher.id() == null) {
            return null;
        }

        return editoraRepository.findById(publisher.id()).orElseThrow(() -> new IllegalArgumentException("Editora (%s) not found with id: %d".formatted(fieldName, publisher.id())));
    }
}
