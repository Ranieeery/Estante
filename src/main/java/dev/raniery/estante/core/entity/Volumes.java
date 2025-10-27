package dev.raniery.estante.core.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

//TODO: AmazonLinks to externalLinks ???
public class Volumes {
    private final Long id;
    private final Long obraId;
    private String volumeNumber;
    private BigDecimal price;
    private LocalDate releaseDateBr;
    private LocalDate releaseDateOriginal;
    private List<String> externalLinks;
    private String coverUrl;
    private boolean isPurchased;
    private boolean isRead;
    private final OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Volumes(Long id, Long obraId, String volumeNumber, BigDecimal price,
                   LocalDate releaseDateBr, LocalDate releaseDateOriginal,
                   List<String> externalLinks, String coverUrl, boolean isPurchased,
                   boolean isRead) {
        this.id = id;
        this.obraId = obraId;
        this.volumeNumber = volumeNumber;
        this.price = price;
        this.releaseDateBr = releaseDateBr;
        this.releaseDateOriginal = releaseDateOriginal;
        setExternalLinks(externalLinks);
        this.coverUrl = coverUrl;
        this.isPurchased = isPurchased;
        this.isRead = isRead;
        this.createdAt = null;
        this.updatedAt = null;
    }

    public Volumes(Long id, Long obraId, String volumeNumber, BigDecimal price,
                   LocalDate releaseDateBr, LocalDate releaseDateOriginal,
                   List<String> externalLinks, String coverUrl, boolean isPurchased,
                   boolean isRead, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.obraId = obraId;
        this.volumeNumber = volumeNumber;
        this.price = price;
        this.releaseDateBr = releaseDateBr;
        this.releaseDateOriginal = releaseDateOriginal;
        setExternalLinks(externalLinks);
        this.coverUrl = coverUrl;
        this.isPurchased = isPurchased;
        this.isRead = isRead;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getObraId() {
        return obraId;
    }

    public String getVolumeNumber() {
        return volumeNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getReleaseDateBr() {
        return releaseDateBr;
    }

    public LocalDate getReleaseDateOriginal() {
        return releaseDateOriginal;
    }

    public List<String> getAmazonLink() {
        return externalLinks;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public boolean isRead() {
        return isRead;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }


    public void setVolumeNumber(String volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setReleaseDateBr(LocalDate releaseDateBr) {
        this.releaseDateBr = releaseDateBr;
    }

    public void setReleaseDateOriginal(LocalDate releaseDateOriginal) {
        this.releaseDateOriginal = releaseDateOriginal;
    }

    public void setExternalLinks(List<String> externalLinks) {
        this.externalLinks.addAll(externalLinks);
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void addExternalLink(String link) {
        this.externalLinks.add(link);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volumes volumes)) return false;
        return Objects.equals(id, volumes.id) && Objects.equals(obraId, volumes.obraId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, obraId);
    }

    @Override
    public String toString() {
        return "Volumes{" +
            "id=" + id +
            ", obraId=" + obraId +
            ", volumeNumber='" + volumeNumber + '\'' +
            ", price=" + price +
            ", releaseDateBr=" + releaseDateBr +
            ", releaseDateOriginal=" + releaseDateOriginal +
            ", externalLinks=" + externalLinks +
            ", coverUrl='" + coverUrl + '\'' +
            ", isPurchased=" + isPurchased +
            ", isRead=" + isRead +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
