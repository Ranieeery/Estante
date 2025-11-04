package dev.raniery.estante.entity;

import dev.raniery.estante.entity.converter.StringArrayConverter;
import dev.raniery.estante.entity.enums.GeneroAutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_autores")
@EntityListeners(AuditingEntityListener.class)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Convert(converter = StringArrayConverter.class)
    @Column(columnDefinition = "TEXT[]")
    private Set<String> aliases;

    @Enumerated(EnumType.STRING)
    private GeneroAutor gender;

    private LocalDate birthDate;

    private LocalDate deathDate;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor autor)) return false;
        return Objects.equals(id, autor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}