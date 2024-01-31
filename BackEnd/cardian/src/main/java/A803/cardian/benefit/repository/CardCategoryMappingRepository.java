package A803.cardian.benefit.repository;

import A803.cardian.associate.domain.Associate;
import A803.cardian.benefit.domain.CardCategoryMapping;
import A803.cardian.benefit.domain.ExceptionBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CardCategoryMappingRepository extends JpaRepository<CardCategoryMapping, Integer> {
    //카드아이디와 제휴사아이디로 카드카테고리매핑 객체 반환
   Optional<CardCategoryMapping> findByAssociateIdAndCardId(int associateId, int cardId);
}
