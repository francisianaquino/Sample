package com.example.VirtualTour.converters;

import com.example.VirtualTour.enums.Category;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getLabel();
    }

    @Override
    public Category convertToEntityAttribute(String label) {
        if (label == null) {
            return null;
        }

        return Stream.of(Category.values())
                .filter(i -> i.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
