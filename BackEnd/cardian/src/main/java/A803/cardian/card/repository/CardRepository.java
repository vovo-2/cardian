package A803.cardian.card.repository;

import A803.cardian.card.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

    // 카드사 DB의 카드 아이디로 카드 찾기
    Card findCardByCardDatabaseId(Integer cardDbId);

}
