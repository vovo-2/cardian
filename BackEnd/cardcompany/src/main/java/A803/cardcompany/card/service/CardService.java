package A803.cardcompany.card.service;


import com.a803.cardcompany.card.dto.CardDto;
import org.hibernate.annotations.processing.SQL;

import java.sql.SQLException;
import java.util.List;

public interface CardService {

    // 카드 조회 - 카드 아이디
    CardDto getCard(Integer id) throws SQLException;

    // 카드 조회 - 멤버 아이디로 조회
    List<CardDto> getCardOfMember(Integer memberId) throws SQLException;


}
