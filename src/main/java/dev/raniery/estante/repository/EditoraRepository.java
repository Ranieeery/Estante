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
        WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))
           OR EXISTS (
               SELECT 1
               FROM UNNEST(e.aliases) alias
               WHERE LOWER(alias) LIKE LOWER(CONCAT('%', :name, '%')))
        """, nativeQuery = true)
    Page<Editora> findByNameOrAliases(String name, Pageable pageable);

    /*
    TODO: GIN index para o campo aliases (array)
    CREATE INDEX idx_editoras_aliases_gin
    ON tb_editoras
    USING GIN (aliases);
     */
}
