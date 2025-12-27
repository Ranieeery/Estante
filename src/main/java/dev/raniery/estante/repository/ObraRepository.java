package dev.raniery.estante.repository;

import dev.raniery.estante.entity.Obra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    Page<Obra> findAllByPublisherBrId(Long publisherBrId, Pageable pageable);

    Page<Obra> findAllByPublisherOrigId(Long publisherOrigId, Pageable pageable);
}
