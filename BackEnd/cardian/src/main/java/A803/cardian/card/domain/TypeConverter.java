package A803.cardian.card.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {
    @Override
    public String convertToDatabaseColumn(Type attribute) {
        return attribute.name();
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        return Type.valueOf(dbData);
    }
}
