package A803.cardcompany.card;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/*
*   작성자 : 정여민
*   작성일시 : 2024.01.28
*   내용 : enum 타입을 DB에 저장할 때 convert하는 메서드*
*/


@Converter(autoApply = true)
public class CardTypeConverter implements AttributeConverter<CardType, String> {
    @Override
    public String convertToDatabaseColumn(CardType attribute) {
        return attribute.name();
    }

    @Override
    public CardType convertToEntityAttribute(String dbData) {
        return CardType.valueOf(dbData);
    }
}