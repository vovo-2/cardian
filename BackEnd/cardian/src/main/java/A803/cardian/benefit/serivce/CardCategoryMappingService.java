package A803.cardian.benefit.serivce;

import A803.cardian.associate.domain.Associate;
import A803.cardian.benefit.domain.CardCategoryMapping;
import A803.cardian.benefit.repository.CardCategoryMappingRepository;
import A803.cardian.card.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CardCategoryMappingService {
    private final CardCategoryMappingRepository cardCategoryMappingRepository;

    //카드카테고리매핑 객체 조회
    public CardCategoryMapping findCardCategoryMapping(Card card, Associate associate){
        CardCategoryMapping cardCategoryMapping = cardCategoryMappingRepository.findByAssociateIdAndCardId(associate.getId(), card.getId())
                .orElseThrow(() ->
                        //추후에 CardCategoryMappingException 구현
                        new RuntimeException());
        return cardCategoryMapping;
    }
}
