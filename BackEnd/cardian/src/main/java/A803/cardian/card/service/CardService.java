package A803.cardian.card.service;

import A803.cardian.card.data.dto.response.CardCategoryBenefitResponses;
import A803.cardian.card.data.dto.response.MyCardListResponse;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.CardRepository;
import A803.cardian.card.repository.MyCardBenefitRepository;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.member.domain.Member;
import A803.cardian.member.exception.MemberErrorCode;
import A803.cardian.member.exception.MemberException;
import A803.cardian.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CardService {

    @Autowired
    private final CardRepository cardRepository;
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final MycardRepository mycardRepository;

    @Autowired
    private final MyCardBenefitRepository myCardBenefitRepository;

    @Transactional
    //내 카드 전체 조회
    public MyCardListResponse findMyCards(Integer memberId) {
        /*
        member가 실제 존재하는지 확인하는 로직 필요?
         */
        Member member = (Member) memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new MemberException(MemberErrorCode.NO_MEMBER));
        return MyCardListResponse.toResponse(member);
    }

    // 내 카드의 혜택 조회 - 카드의 혜택을 List로 반환
    // 작성자 : 정여민
    // 작성일시 : 2024.01.30
    @Transactional
    public List<CardCategoryBenefitResponses> findMyCardBenefit(Integer cardId){
        List<CardCategoryBenefitResponses> myCardBenefitList = myCardBenefitRepository.findProjectBenefitCodeByCardId(cardId);
        return myCardBenefitList;
    }



}
