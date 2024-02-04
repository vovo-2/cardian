package A803.cardian.card.service;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDiscountAmountUsingSignWithDiscount() {
        // 테스트에 필요한 데이터 설정
        int price = 15220;
        int discountLine = 15600;
        int discountAmount = 3;
        String sign = "%";

        // 테스트 대상 메서드 호출
        int result = transactionService.getDiscountAmountUsingSignWithDiscount(price, discountLine, discountAmount, sign);

        // 예상 결과와 실제 결과 비교
        assertEquals(470, result);
    }

    // 다른 테스트 메서드들도 유사한 방식으로 작성할 수 있습니다.
    // 예를 들어, testCalculateDiscountAmountWithExceptionBenefit, testCalculateDiscountAmountWithCategoryBenefit 등...

}
