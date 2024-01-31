package A803.cardian.benefit.serivce;

import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
import A803.cardian.benefit.domain.ExceptionBenefit;
import A803.cardian.benefit.repository.ExceptionBenefitRepository;
import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ExceptionBenefitService {
    private final ExceptionBenefitRepository exceptionBenefitRepository;
    private final AssociateRepository associateRepository;

    //카드에 해당 제휴사의 예외 혜택이 있는지 확인
    //있으면 예외혜택이 return되고 없으면 null return 됨
    public Optional<ExceptionBenefit> getExceptionBenefit(Transaction transaction){
        //1. 제휴사 아이디
        Associate associate = associateRepository.findByName(transaction.getStore())
                .orElseThrow(() ->
                        //추후 AssociateException 만들기
                        new RuntimeException());
        int associateId = associate.getId();

        //2. 내 카드아이디로 가져온 카드아이디
        Card card = transaction.getMyCard().getCard();
        int cardId = card.getId();

        return exceptionBenefitRepository.findByAssociateIdAndCardId(associateId, cardId);
    }


    /*
     * 작성자 : 정여민
     * 작성 일시 : 2024.01.31
     * 업데이트 : 2024.01.31
     */
    // 카드에 해당 제휴사의 예외 혜택이 있는지 확인 ->
    // 있으면 예외혜택이 return되고 없으면 null return 됨
    public Optional<ExceptionBenefit> getExceptionBenefit(Integer cardid, Integer companyId, String categoryCode){

        return exceptionBenefitRepository.findByCardIdAndCompanyIdAndCategoryCode(cardid, companyId, categoryCode);
    }
}
