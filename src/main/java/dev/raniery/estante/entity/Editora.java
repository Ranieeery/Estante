package dev.raniery.estante.entity;

import dev.raniery.estante.entity.config.StringArrayConverter;
import dev.raniery.estante.entity.enums.TipoEditora;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_editoras")
@EntityListeners(AuditingEntityListener.class)
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Convert(converter = StringArrayConverter.class)
    @Column(columnDefinition = "TEXT[]")
    private Set<String> aliases = new HashSet<>();

    private String site;

    @Enumerated(EnumType.STRING)
    @Column(name = "publisher_type", nullable = false)
    private TipoEditora publisherType;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Editora editora)) return false;
        return Objects.equals(id, editora.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}