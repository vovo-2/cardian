package A803.cardian.card.repository;

import A803.cardian.card.domain.MyCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MycardRepository extends JpaRepository<MyCard, Integer> {
    List<MyCard> findMyCardsByMemberId(int member_id);

    // 카드아이디로 내카드 찾기
    Optional<MyCard> findByCard_Id(Integer cardId);

}
