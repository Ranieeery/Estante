package dev.raniery.estante.repository;

import dev.raniery.estante.entity.Editora;
import dev.raniery.estante.entity.enums.TipoEditora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EditoraRepository extends JpaRepository<Editora, Long> {

    @Query("""
        SELECT e
        FROM Editora e
        WHERE e.publisherType = :type
        """)
    Page<Editora> findAllByType(TipoEditora type, Pageable pageable);

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
