package dev.raniery.estante.entity.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class StringArrayConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }

        return "{" + attribute.stream()
            .map(s -> {
                String escaped = s.replace("\\", "\\\\")
                    .replace("\"", "\\\"");
                return "\"" + escaped + "\"";
            })
            .collect(Collectors.joining(",")) + "}";
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.length() < 2) {
            return Set.of();
        }

        String cleaned = dbData.substring(1, dbData.length() - 1);
        if (cleaned.isBlank()) {
            return Set.of();
        }

        return Arrays.stream(cleaned.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
            .map(s -> s.trim()
                .replaceAll("^\"|\"$", "")
                .replace("\\\"", "\"")
                .replace("\\\\", "\\"))
            .collect(Collectors.toSet());
    }
}
