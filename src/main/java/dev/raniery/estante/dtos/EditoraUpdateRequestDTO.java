package dev.raniery.estante.dtos;

import dev.raniery.estante.entity.enums.TipoEditora;
import lombok.Builder;
import org.springframework.util.StringUtils;

@Builder
public record EditoraUpdateRequestDTO(
    String name,
    String[] aliases,
    String site,
    TipoEditora publisherType) {

    public boolean hasName() {
        return StringUtils.hasText(name);
    }

    public boolean hasAliases() {
        return aliases != null;
    }

    public boolean hasSite() {
        return StringUtils.hasText(site);
    }

    public boolean hasPublisherType() {
        return publisherType != null;
    }
}
