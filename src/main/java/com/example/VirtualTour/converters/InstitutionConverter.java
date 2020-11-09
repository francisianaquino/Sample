package com.example.VirtualTour.converters;

import com.example.VirtualTour.enums.Institution;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class InstitutionConverter implements AttributeConverter<Institution, String> {

    @Override
    public String convertToDatabaseColumn(Institution institution) {
        if (institution == null) {
            return null;
        }
        return institution.getLabel();
    }

    @Override
    public Institution convertToEntityAttribute(String label) {
        if (label == null) {
            return null;
        }

        return Stream.of(Institution.values())
                .filter(i -> i.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
