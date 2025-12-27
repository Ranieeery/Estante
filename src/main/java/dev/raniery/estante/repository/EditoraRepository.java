package dev.raniery.estante.repository;

import dev.raniery.estante.entity.Editora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EditoraRepository extends JpaRepository<Editora, Long> {

    @Query(value = """
        SELECT *
        FROM tb_editoras e
        WHERE e.name ILIKE CONCAT('%', :name, '%') ESCAPE '\'
           OR EXISTS    (
               SELECT 1
               FROM unnest(e.aliases) alias
               WHERE alias ILIKE CONCAT('%', :name, '%') ESCAPE '\')
        """, nativeQuery = true)
    Page<Editora> findByNameOrAliases(String name, Pageable pageable);
}
