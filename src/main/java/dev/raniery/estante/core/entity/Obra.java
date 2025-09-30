package dev.raniery.estante.core.entity;

import dev.raniery.estante.core.enums.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Obra {

    private final Long id;
    private String title;
    private String originalTitle;
    private Set<String> aliases;
    private String description;
    private Set<Contribuicao> staff;
    private Editora publisherBr;
    private Editora publisherOrig;
    private Integer volumesBr;
    private Integer volumesOrig;
    private StatusPublicacao pubStatusBr;
    private StatusPublicacao pubStatusOrig;
    private Set<GeneroObra> genres;
    private Demografia demographic;
    private LocalDate startDateBr;
    private LocalDate endDateBr;
    private Set<Long> relatedWorksIds;
    private Periodicidade periodicity;
    private TipoObra type;
    private String coverUrl;
    private String animeUrl;
    private final OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Obra(Long id, String title, String originalTitle, Set<String> aliases,
                String description, Set<Contribuicao> staff, Editora publisherBr,
                Editora publisherOrig, Integer volumesBr, Integer volumesOrig,
                StatusPublicacao pubStatusBr, StatusPublicacao pubStatusOrig,
                Set<GeneroObra> genres, Demografia demographic, LocalDate startDateBr,
                LocalDate endDateBr, Set<Long> relatedWorksIds, Periodicidade periodicity,
                TipoObra type, String coverUrl, String animeUrl) {

        this.id = id;
        setTitle(title);
        setOriginalTitle(originalTitle);
        this.aliases = (aliases != null) ? new HashSet<>(aliases) : new HashSet<>();
        setDescription(description);
        this.staff = (staff != null) ? new HashSet<>(staff) : new HashSet<>();
        this.publisherBr = publisherBr;
        this.publisherOrig = publisherOrig;
        this.volumesBr = volumesBr;
        this.volumesOrig = volumesOrig;
        this.pubStatusBr = pubStatusBr;
        this.pubStatusOrig = pubStatusOrig;
        this.genres = (genres != null) ? new HashSet<>(genres) : new HashSet<>();
        this.demographic = demographic;
        this.startDateBr = startDateBr;
        this.endDateBr = endDateBr;
        this.relatedWorksIds = (relatedWorksIds != null) ? new HashSet<>(relatedWorksIds) : new HashSet<>();
        this.periodicity = periodicity;
        this.type = type;
        this.coverUrl = coverUrl;
        this.animeUrl = animeUrl;
        this.createdAt = null;
        this.updatedAt = null;
    }

    public Obra(Long id, String title, String originalTitle, Set<String> aliases,
                String description, Set<Contribuicao> staff, Editora publisherBr,
                Editora publisherOrig, Integer volumesBr, Integer volumesOrig,
                StatusPublicacao pubStatusBr, StatusPublicacao pubStatusOrig,
                Set<GeneroObra> genres, Demografia demographic, LocalDate startDateBr,
                LocalDate endDateBr, Set<Long> relatedWorksIds, Periodicidade periodicity,
                TipoObra type, String coverUrl, String animeUrl,
                OffsetDateTime createdAt, OffsetDateTime updatedAt) {

        this.id = id;
        setTitle(title);
        setOriginalTitle(originalTitle);
        this.aliases = (aliases != null) ? new HashSet<>(aliases) : new HashSet<>();
        setDescription(description);
        this.staff = (staff != null) ? new HashSet<>(staff) : new HashSet<>();
        this.publisherBr = publisherBr;
        this.publisherOrig = publisherOrig;
        this.volumesBr = volumesBr;
        this.volumesOrig = volumesOrig;
        this.pubStatusBr = pubStatusBr;
        this.pubStatusOrig = pubStatusOrig;
        this.genres = (genres != null) ? new HashSet<>(genres) : new HashSet<>();
        this.demographic = demographic;
        this.startDateBr = startDateBr;
        this.endDateBr = endDateBr;
        this.relatedWorksIds = (relatedWorksIds != null) ? new HashSet<>(relatedWorksIds) : new HashSet<>();
        this.periodicity = periodicity;
        this.type = type;
        this.coverUrl = coverUrl;
        this.animeUrl = animeUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public Set<String> getAliases() {
        return Collections.unmodifiableSet(aliases);
    }

    public String getDescription() {
        return description;
    }

    public Set<Contribuicao> getStaff() {
        return Collections.unmodifiableSet(staff);
    }

    public Editora getPublisherBr() {
        return publisherBr;
    }

    public Editora getPublisherOrig() {
        return publisherOrig;
    }

    public Integer getVolumesBr() {
        return volumesBr;
    }

    public Integer getVolumesOrig() {
        return volumesOrig;
    }

    public StatusPublicacao getPubStatusBr() {
        return pubStatusBr;
    }

    public StatusPublicacao getPubStatusOrig() {
        return pubStatusOrig;
    }

    public Set<GeneroObra> getGenres() {
        return Collections.unmodifiableSet(genres);
    }

    public Demografia getDemographic() {
        return demographic;
    }

    public LocalDate getStartDateBr() {
        return startDateBr;
    }

    public LocalDate getEndDateBr() {
        return endDateBr;
    }

    public Set<Long> getRelatedWorksIds() {
        return Collections.unmodifiableSet(relatedWorksIds);
    }

    public Periodicidade getPeriodicity() {
        return periodicity;
    }

    public TipoObra getType() {
        return type;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getAnimeUrl() {
        return animeUrl;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setTitle(String title) {
        Objects.requireNonNull(title, "Title cannot be null");
        String trimmedTitle = title.trim();
        if (trimmedTitle.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty or blank");
        }
        this.title = trimmedTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        Objects.requireNonNull(originalTitle, "Original Title cannot be null");
        String trimmedOriginalTitle = originalTitle.trim();
        if (trimmedOriginalTitle.isEmpty()) {
            throw new IllegalArgumentException("Original Title cannot be empty or blank");
        }
        this.originalTitle = trimmedOriginalTitle;
    }

    public void setDescription(String description) {
        this.description = (description != null) ? description.trim() : null;
    }

    public void setPublisherBr(Editora publisherBr) {
        this.publisherBr = publisherBr;
    }

    public void setPublisherOrig(Editora publisherOrig) {
        this.publisherOrig = publisherOrig;
    }

    public void setVolumesBr(Integer volumesBr) {
        this.volumesBr = volumesBr;
    }

    public void setVolumesOrig(Integer volumesOrig) {
        this.volumesOrig = volumesOrig;
    }

    public void setPubStatusBr(StatusPublicacao pubStatusBr) {
        this.pubStatusBr = pubStatusBr;
    }

    public void setPubStatusOrig(StatusPublicacao pubStatusOrig) {
        this.pubStatusOrig = pubStatusOrig;
    }

    public void setDemographic(Demografia demographic) {
        this.demographic = demographic;
    }

    public void setStartDateBr(LocalDate startDateBr) {
        this.startDateBr = startDateBr;
    }

    public void setEndDateBr(LocalDate endDateBr) {
        this.endDateBr = endDateBr;
    }

    public void setPeriodicity(Periodicidade periodicity) {
        this.periodicity = periodicity;
    }

    public void setType(TipoObra type) {
        this.type = type;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setAnimeUrl(String animeUrl) {
        this.animeUrl = animeUrl;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void renameBr(String newTitle) {
        setTitle(newTitle);
    }

    public void renameOrig(String newTitle) {
        setOriginalTitle(newTitle);
    }

    public void addAlias(String alias) {
        Objects.requireNonNull(alias, "Alias cannot be null");

        if (!alias.trim().isEmpty()) {
            this.aliases.add(alias.trim());
        }
    }

    public void removeAlias(String alias) {
        this.aliases.remove(alias.trim());
    }

    public void addStaffMember(Contribuicao staffMember) {
        Objects.requireNonNull(staffMember, "Contribuicao cannot be null");

        this.staff.add(staffMember);
    }

    public void removeStaffMember(Contribuicao contribuicao) {
        this.staff.remove(contribuicao);
    }

    public void addGenre(GeneroObra genre) {
        Objects.requireNonNull(genre, "Genre cannot be null");

        this.genres.add(genre);
    }

    public void removeGenre(GeneroObra genre) {
        this.genres.remove(genre);
    }

    public void addRelatedWork(Long obraId) {
        Objects.requireNonNull(obraId, "Obra ID cannot be null");

        this.relatedWorksIds.add(obraId);
    }

    public void removeRelatedWork(Long obraId) {
        this.relatedWorksIds.remove(obraId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obra obra)) return false;
        return Objects.equals(id, obra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Obra{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", originalTitle='" + originalTitle + '\'' +
            ", aliases=" + aliases +
            ", description='" + description + '\'' +
            ", staff=" + staff +
            ", publisherBr=" + publisherBr +
            ", publisherOrig=" + publisherOrig +
            ", volumesBr=" + volumesBr +
            ", volumesOrig=" + volumesOrig +
            ", pubStatusBr=" + pubStatusBr +
            ", pubStatusOrig=" + pubStatusOrig +
            ", genres=" + genres +
            ", demographic=" + demographic +
            ", startDateBr=" + startDateBr +
            ", endDateBr=" + endDateBr +
            ", relatedWorksIds=" + relatedWorksIds +
            ", periodicity=" + periodicity +
            ", type=" + type +
            ", coverUrl='" + coverUrl + '\'' +
            ", animeUrl='" + animeUrl + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
