package dev.raniery.estante.core.entity;

import dev.raniery.estante.core.enums.TipoEditora;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Editora {
    private final Long id;
    private String name;
    private Set<String> aliases;
    private String site;
    private final TipoEditora publisherType;

    public Editora(Long id, String name, Set<String> aliases, String site, TipoEditora publisherType) {
        this.id = id;
        setName(name);
        this.aliases = (aliases != null) ? new HashSet<>(aliases) : new HashSet<>();
        setSite(site);
        this.publisherType = Objects.requireNonNull(publisherType, "TipoEditora cannot be null");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or blank");
        }
        this.name = trimmedName;
    }

    public Set<String> getAliases() {
        return Collections.unmodifiableSet(aliases);
    }

    public String getSite() {
        return site;
    }

    public TipoEditora getPublisherType() {
        return publisherType;
    }

    public void setSite(String site) {
        this.site = (site != null) ? site.trim() : null;
    }

    public void rename(String newName) {
        setName(newName);
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

    @Override
    public String toString() {
        return "Editora{ id=" + id + ", name='" + name + '\'' + ", aliases=" + aliases + ", site='" + site + '\'' + ", publisherType=" + publisherType + "}";
    }
}
