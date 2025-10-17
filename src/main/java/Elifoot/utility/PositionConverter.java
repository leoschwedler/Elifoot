package Elifoot.utility;

import Elifoot.enums.Position;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionConverter implements AttributeConverter<Position, String> {

    @Override
    public String convertToDatabaseColumn(Position attribute) {
        return attribute != null ? attribute.name() : null;
    }

    @Override
    public Position convertToEntityAttribute(String dbData) {
        return dbData != null ? Position.valueOf(dbData.toUpperCase()) : null;
    }
}