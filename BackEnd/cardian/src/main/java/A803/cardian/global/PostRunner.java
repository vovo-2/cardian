//package A803.cardian.global;
//
//import A803.cardian.card.domain.BenefitCode;
//import A803.cardian.card.domain.Card;
//import A803.cardian.card.domain.Company;
//import A803.cardian.card.domain.Type;
//import A803.cardian.card.repository.CardRepository;
//import A803.cardian.card.repository.CompanyRepository;
//import jakarta.annotation.PostConstruct;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//@RequiredArgsConstructor
//@Component
//@Slf4j
//public class PostRunner {
//
//    private final CardRepository cardRepository;
//    private final CompanyRepository companyRepository;
//
//    @Transactional
//    @PostConstruct
//    public void post() {
//        Company company = companyRepository.save(Company.builder()
//                .name("신한은행")
//                .build());
//        Card 신한카드 = cardRepository.save(Card.builder()
//                .company(company)
//                .type(Type.CHECK)
//                .name("신한카드")
//                .goal(200000)
//                .image("이미지")
//                .annualfee(0)
//                .benefitCode(BenefitCode.ACCUMULATE)
//                .build());
//        log.info("Card : [{}]", 신한카드);
//    }
//}
