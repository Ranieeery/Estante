package dev.raniery.estante.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_volumes")
@EntityListeners(AuditingEntityListener.class)
public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "obra_id", nullable = false)
    private Long obraId;

    @Column(name = "volume_number", nullable = false)
    private String volumeNumber;

    private BigDecimal price;

    @Column(name = "release_date_br")
    private LocalDate releaseDateBr;

    @Column(name = "release_date_orig")
    private LocalDate releaseDateOriginal;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "external_links", columnDefinition = "TEXT[]")
    private List<String> externalLinks = new ArrayList<>();

    @Column(name = "cover_url")
    private String coverUrl;

    @Column(name = "is_purchased")
    private boolean isPurchased;

    @Column(name = "is_read")
    private boolean isRead;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volume volume)) return false;
        return Objects.equals(id, volume.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
