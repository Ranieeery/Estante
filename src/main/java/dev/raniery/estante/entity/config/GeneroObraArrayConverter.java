package dev.raniery.estante.entity.config;

import dev.raniery.estante.entity.enums.GeneroObra;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = false)
public class GeneroObraArrayConverter implements AttributeConverter<Set<GeneroObra>, String> {

    @Override
    public String convertToDatabaseColumn(Set<GeneroObra> attribute) {
        if (attribute == null || attribute.isEmpty()) return null;
        return "{" + attribute.stream()
            .map(Enum::name)
            .map(s -> "\"" + s + "\"")
            .collect(Collectors.joining(",")) + "}";
    }

    @Override
    public Set<GeneroObra> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.length() < 2) return new HashSet<>();
        String cleaned = dbData.substring(1, dbData.length() - 1);
        if (cleaned.isBlank()) return new HashSet<>();
        return Arrays.stream(cleaned.split(","))
            .map(s -> s.trim().replaceAll("^\"|\"$", ""))
            .map(GeneroObra::valueOf)
            .collect(Collectors.toSet());
    }
}
