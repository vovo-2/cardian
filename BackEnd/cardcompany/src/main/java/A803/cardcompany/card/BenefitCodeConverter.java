package A803.cardcompany.card;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BenefitCodeConverter implements AttributeConverter<BenefitCode, String> {

    @Override
    public String convertToDatabaseColumn(BenefitCode attribute) {

        return attribute.name();
    }

    @Override
    public BenefitCode convertToEntityAttribute(String dbData) {
        return BenefitCode.valueOf(dbData);
    }
}
