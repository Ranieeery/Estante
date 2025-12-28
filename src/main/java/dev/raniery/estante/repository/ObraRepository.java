package dev.raniery.estante.repository;

import dev.raniery.estante.entity.Obra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    Page<Obra> findAllByPublisherBrId(Long publisherBrId, Pageable pageable);

    Page<Obra> findAllByPublisherOrigId(Long publisherOrigId, Pageable pageable);

    @Query(value = """
        SELECT *
        FROM tb_obras o
        WHERE o.title ILIKE CONCAT('%', :title, '%') ESCAPE '\'
           OR o.original_title ILIKE CONCAT('%', :title, '%') ESCAPE '\'
           OR EXISTS (
               SELECT 1
               FROM UNNEST(o.aliases) alias
               WHERE alias ILIKE CONCAT('%', :title, '%') ESCAPE '\')
        """, nativeQuery = true)
    Page<Obra> findByTitleOrAliases(String title, Pageable pageable);

    /*
    TODO: GIN index para o campo aliases (array)
    CREATE EXTENSION IF NOT EXISTS pg_trgm;

    CREATE INDEX idx_obras_title_trgm
    ON tb_obras USING GIN (title gin_trgm_ops);

    CREATE INDEX idx_obras_aliases_trgm
    ON tb_obras USING GIN (aliases gin_trgm_ops);

     */
}
