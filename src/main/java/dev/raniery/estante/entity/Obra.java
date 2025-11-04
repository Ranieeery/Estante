package dev.raniery.estante.entity;

import dev.raniery.estante.entity.config.GeneroObraArrayConverter;
import dev.raniery.estante.entity.config.StringArrayConverter;
import dev.raniery.estante.entity.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_obras")
@EntityListeners(AuditingEntityListener.class)
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String originalTitle;

    @Builder.Default
    @Convert(converter = StringArrayConverter.class)
    @Column(columnDefinition = "TEXT[]")
    private Set<String> aliases = new HashSet<>();

    @Lob
    private String description;

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Contribuicao> staff = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "publisher_br_id")
    private Editora publisherBr;

    @ManyToOne
    @JoinColumn(name = "publisher_orig_id")
    private Editora publisherOrig;

    private Integer volumesBr;

    private Integer volumesOrig;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "status_publicacao")
    private StatusPublicacao pubStatusBr;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "status_publicacao")
    private StatusPublicacao pubStatusOrig;

    @Convert(converter = GeneroObraArrayConverter.class)
    @Column(columnDefinition = "genero_obra[]")
    @Builder.Default
    private Set<GeneroObra> genres = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "demografia")
    private Demografia demographic;

    private LocalDate startDateBr;

    private LocalDate endDateBr;

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<ObraRelacionada> relatedWorks = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "periodicidade")
    private Periodicidade periodicity;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "tipo_obra")
    private TipoObra type;

    private String coverUrl;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obra obra)) return false;
        return Objects.equals(id, obra.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

