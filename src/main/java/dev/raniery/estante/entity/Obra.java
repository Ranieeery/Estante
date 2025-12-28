package dev.raniery.estante.entity;

import dev.raniery.estante.entity.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

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

    @Column(name = "original_title", nullable = false)
    private String originalTitle;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(columnDefinition = "TEXT[]")
    private String[] aliases;

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

    @Column(name = "volumes_br")
    private Integer volumesBr;

    @Column(name = "volumes_orig")
    private Integer volumesOrig;

    @Enumerated(EnumType.STRING)
    @Column(name = "pub_status_br", columnDefinition = "status_publicacao")
    private StatusPublicacao pubStatusBr;

    @Enumerated(EnumType.STRING)
    @Column(name = "pub_status_orig", columnDefinition = "status_publicacao")
    private StatusPublicacao pubStatusOrig;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(columnDefinition = "genero_obra[]")
    private GeneroObra[] genres;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "demografia")
    private Demografia demographic;

    @Column(name = "start_date_br")
    private LocalDate startDateBr;

    @Column(name = "end_date_br")
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

    @Column(name = "cover_url")
    private String coverUrl;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
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

    public void update(String title,
                       String originalTitle,
                       String[] aliases,
                       String description,
                       Integer volumesBr,
                       Integer volumesOrig,
                       StatusPublicacao pubStatusBr,
                       StatusPublicacao pubStatusOrig,
                       Demografia demographic,
                       LocalDate startDateBr,
                       LocalDate endDateBr,
                       Periodicidade periodicity,
                       TipoObra type) {
        if (StringUtils.hasText(title)) this.title = title;
        if (StringUtils.hasText(originalTitle)) this.originalTitle = originalTitle;
        if (aliases != null) this.aliases = aliases;
        if (StringUtils.hasText(description)) this.description = description;
        if (volumesBr != null) this.volumesBr = volumesBr;
        if (volumesOrig != null) this.volumesOrig = volumesOrig;
        if (pubStatusBr != null) this.pubStatusBr = pubStatusBr;
        if (pubStatusOrig != null) this.pubStatusOrig = pubStatusOrig;
        if (demographic != null) this.demographic = demographic;
        if (startDateBr != null) this.startDateBr = startDateBr;
        if (endDateBr != null) this.endDateBr = endDateBr;
        if (periodicity != null) this.periodicity = periodicity;
        if (type != null) this.type = type;
    }
}