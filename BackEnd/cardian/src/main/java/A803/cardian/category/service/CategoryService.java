package A803.cardian.category.service;

import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
import A803.cardian.benefit.data.dto.BenefitStore;
import A803.cardian.benefit.domain.CategoryBenefit;
import A803.cardian.benefit.domain.ExceptionBenefit;
import A803.cardian.benefit.repository.CategoryBenefitRepository;
import A803.cardian.benefit.repository.ExceptionBenefitRepository;
import A803.cardian.card.data.dto.response.CardBenefitCategoryResponse;
import A803.cardian.card.data.dto.response.MyCardDetails;
import A803.cardian.card.data.dto.response.MyCardInfoResponse;
import A803.cardian.card.data.dto.response.MyCardListResponse;
import A803.cardian.card.service.BenefitService;
import A803.cardian.card.service.CardService;
import A803.cardian.category.data.dto.reponse.CategoryCardRecommend;
import A803.cardian.category.data.dto.reponse.CategoryList;
import A803.cardian.category.data.dto.reponse.CategoryListImage;
import A803.cardian.category.domain.SubCommonCode;
import A803.cardian.category.repository.CategoryIconRepository;
import A803.cardian.category.repository.SubCommonCodeRepository;
import A803.cardian.goal.service.GoalService;
import A803.cardian.statistic.domain.AccumulateBenefit;
import A803.cardian.statistic.repository.AccumulateBenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {
    private final SubCommonCodeRepository subCommonCodeRepository;
    private final CategoryIconRepository categoryIconRepository;
    private final CardService cardService;
    private final BenefitService benefitService;
    private final CategoryBenefitRepository categoryBenefitRepository;
    private final AccumulateBenefitRepository accumulateBenefitRepository;
    private final GoalService goalService;
    private final AssociateRepository associateRepository;
    private final ExceptionBenefitRepository exceptionBenefitRepository;
    public List<CategoryList> findAllCategory(){
        List<SubCommonCode> cate= subCommonCodeRepository.findAll();
        List<CategoryList> cateList= new ArrayList<>();
        for(SubCommonCode sub : cate){
            CategoryList category=CategoryList.builder()
                    .categoryCode(sub.getDetailCode())
                    .categoryName(sub.getName())
                    .build();
            cateList.add(category);
        }
        return cateList;
    }

    public List<CategoryListImage> findAllCategoryImage(){
        List<SubCommonCode> cate= subCommonCodeRepository.findAll();

        List<CategoryListImage> cateList= new ArrayList<>();
        for(SubCommonCode sub : cate){
            String categoryCode=sub.getDetailCode();
            String url=categoryIconRepository.findIconImageByCategoryCode(categoryCode).orElse(null);

            CategoryListImage category=CategoryListImage.builder()
                    .categoryCode(sub.getDetailCode())
                    .categoryName(sub.getName())
                    .categoryImage(url)
                    .build();
            cateList.add(category);
        }
        return cateList;
    }

    public List<List<CategoryCardRecommend>> categoryCardRecommend(Integer memberId,Integer associateId){
        List<MyCardDetails> cardDetails = cardService.findMyCards(memberId).getMyCardDetailList();

        List<CategoryCardRecommend> percentCardList= new ArrayList<>();
        List<CategoryCardRecommend> plusCardList=new ArrayList<>();
        List<List<CategoryCardRecommend>> list=new ArrayList<>();

        for(MyCardDetails c:cardDetails){
            MyCardInfoResponse info = cardService.getMyCardInfo(c.getMycardId());
            Integer cardId= cardService.getCardId(c.getMycardId());

            Optional<Associate> associate = associateRepository.findById(associateId);
            String associateName= associate.get().getName();
            String categoryCode=associate.get().getCategoryCode();

            System.out.println("associateName: "+associateName);

            Optional<AccumulateBenefit> accumulateBenefit = accumulateBenefitRepository.findAccumulateBenefitByCardIdAndCategoryCode(c.getMycardId(), categoryCode);
            boolean tf= goalService.getCardGoalAchieve(c.getMycardId());
            boolean thisMonthAchieve=false;
            if(info.getMyCardInfoDetails().getGoal()-info.getMyCardInfoDetails().getAccumulate()<=0){
                thisMonthAchieve=true;
            }
            int accumulateBenefitAmount =0;
            if(accumulateBenefit.isPresent()){
                accumulateBenefitAmount = accumulateBenefit.get().getBenefitAmount();
            }


            CardBenefitCategoryResponse benefits=benefitService.recommendCategoryCard(c.getMycardId(),associateId,categoryCode);
            System.out.println("benefitAmount: "+benefits.getExceptionBenefitStore().getDiscountAmount());
            if(benefits.getExceptionBenefitStore().getDiscountAmount()!=0){
                if(benefits.getExceptionBenefitStore().getStoreName().equals(associateName)){
                    Optional<ExceptionBenefit> categoryBenefit=exceptionBenefitRepository.findByCardIdAndCategoryCode(cardId,categoryCode);
                    System.out.println("associateName: "+associateName);
                    System.out.println("benefitAmount: "+categoryBenefit.get().getDiscountAmount());
                    int discountAmount=benefits.getExceptionBenefitStore().getDiscountAmount();
                    String discountSign=benefits.getExceptionBenefitStore().getSign();

                    boolean benefitRemain=false;
                    if(categoryBenefit.get().getDiscountLimit()-accumulateBenefitAmount>0){
                        benefitRemain=true;
                    }
                    CategoryCardRecommend card=CategoryCardRecommend.builder()
                            .myCardId(info.getMyCardId())
                            .cardImage(info.getMyCardInfoDetails().getCardImage())
                            .cardCompany(info.getMyCardInfoDetails().getCompanyName())
                            .cardName(info.getMyCardInfoDetails().getCardName())
                            .associateName(associateName)
                            .goal(info.getMyCardInfoDetails().getGoal())
                            .consume(info.getMyCardInfoDetails().getAccumulate())
                            .thisMonthAchieve(thisMonthAchieve)
                            .cardType(info.getMyCardInfoDetails().getType())
                            .benefitCode(info.getMyCardInfoDetails().getBenefitCode())
                            .benefitLimitation(categoryBenefit.get().getDiscountLimit())
                            .currentBenefit(accumulateBenefitAmount)
                            .benefitRemain(benefitRemain)
                            .discountAmount(discountAmount)
                            .discountSign(discountSign)
                            .goalAchieve(tf)
                            .build();
                    if(discountSign.equals("%")){
                        percentCardList.add(card);
                    }else{
                        plusCardList.add(card);
                    }
                }

            }else {
                List<BenefitStore> bList= benefits.getStoreList();
                for(BenefitStore b:bList){
                    if(b.getDiscountAmount()!=0 && b.getStoreName().equals(associateName)){
                        Optional<CategoryBenefit> categoryBenefit=categoryBenefitRepository.findCategoryBenefitByCardIdAndCategoryCode(cardId,categoryCode);

                        int discountAmount=b.getDiscountAmount();
                        String discountSign=b.getSign();

                        boolean benefitRemain=false;
                        if(categoryBenefit.get().getDiscountLimit()-accumulateBenefitAmount>0){
                            benefitRemain=true;
                        }
                        CategoryCardRecommend card=CategoryCardRecommend.builder()
                                .myCardId(info.getMyCardId())
                                .cardImage(info.getMyCardInfoDetails().getCardImage())
                                .cardCompany(info.getMyCardInfoDetails().getCompanyName())
                                .cardName(info.getMyCardInfoDetails().getCardName())
                                .associateName(associateName)
                                .goal(info.getMyCardInfoDetails().getGoal())
                                .consume(info.getMyCardInfoDetails().getAccumulate())
                                .thisMonthAchieve(thisMonthAchieve)
                                .cardType(info.getMyCardInfoDetails().getType())
                                .benefitCode(info.getMyCardInfoDetails().getBenefitCode())
                                .benefitLimitation(categoryBenefit.get().getDiscountLimit())
                                .currentBenefit(accumulateBenefitAmount)
                                .benefitRemain(benefitRemain)
                                .discountAmount(discountAmount)
                                .discountSign(discountSign)
                                .goalAchieve(tf)
                                .build();
                        if(discountSign.equals("%")){
                            percentCardList.add(card);
                        }else{
                            plusCardList.add(card);
                        }
                    }
                }
            }
        }

        Collections.sort(percentCardList);
        Collections.sort(plusCardList);
        list.add(percentCardList);
        list.add(plusCardList);

        return list;
    }



}
