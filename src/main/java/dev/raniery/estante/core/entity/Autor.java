package dev.raniery.estante.core.entity;

import dev.raniery.estante.core.enums.GeneroAutor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Autor {

    private Long id;
    private String name;
    private Set<String> aliases;
    private GeneroAutor gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    //TODO: obras do autor

    public Autor(Long id, String name, Set<String> aliases, GeneroAutor gender, LocalDate birthDate, LocalDate deathDate) {
        this.id = id;
        setName(name);
        this.aliases = (aliases != null) ? new HashSet<>(aliases) : new HashSet<>();
        this.gender = gender;
        setBirthDate(birthDate);
        setDeathDate(deathDate);
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

    public GeneroAutor getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {

        if (deathDate != null) {
            if (birthDate != null && deathDate.isBefore(birthDate)) {
                throw new IllegalArgumentException("Death date cannot be before birth date");
            }
            if (deathDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Death date cannot be in the future");
            }
        }

        this.deathDate = deathDate;
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
}
