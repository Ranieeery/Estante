package dev.raniery.estante.entity.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Converter(autoApply = false)
public class StringArrayConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        return "{" + String.join(",", attribute.stream()
            .map(s -> "\"" + s.replace("\"", "\\\"") + "\"")
            .toList()) + "}";
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.length() < 2) {
            return new HashSet<>();
        }
        String cleaned = dbData.substring(1, dbData.length() - 1);
        if (cleaned.isBlank()) {
            return new HashSet<>();
        }
        return Arrays.stream(cleaned.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
            .map(s -> s.trim().replace("\"", ""))
            .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }
}
