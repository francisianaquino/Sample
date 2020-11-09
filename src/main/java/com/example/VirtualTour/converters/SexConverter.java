package com.example.VirtualTour.converters;

import com.example.VirtualTour.enums.Sex;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SexConverter implements AttributeConverter<Sex, String> {

    @Override
    public String convertToDatabaseColumn(Sex sex) {
        if (sex == null) {
            return null;
        }
        return sex.getLabel();
    }

    @Override
    public Sex convertToEntityAttribute(String label) {
        if (label == null) {
            return null;
        }

        return Stream.of(Sex.values())
                .filter(s -> s.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
