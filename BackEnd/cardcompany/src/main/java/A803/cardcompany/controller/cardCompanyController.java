package A803.cardcompany.controller;

import com.a803.cardcompany.card.dto.CardDto;
import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.card.service.CardService;
import com.a803.cardcompany.card.service.CardServiceImpl;
import com.a803.cardcompany.member.dto.MemberDto;
import com.a803.cardcompany.member.mapper.Member;
import com.a803.cardcompany.member.service.MemberServiceImpl;
import com.a803.cardcompany.transaction.dto.TransactionDto;
import com.a803.cardcompany.transaction.service.TransactionService;
import com.a803.cardcompany.transaction.service.TransactionServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
public class cardCompanyController {


    @Autowired
    MemberServiceImpl memberService;

    @Autowired
    CardServiceImpl cardService;

    @Autowired
    TransactionServiceImpl transactionService;


    // 회원 하나 멤버 아이디로
    @GetMapping("/user/{member-id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable("member-id") Integer id){
        MemberDto memberDto = new MemberDto();
        try{
            memberDto = memberService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
    }

    // 회원이 갖고 있는 카드 조회
    @GetMapping("/card/{member-id}")
    public ResponseEntity<List<CardDto>> getCard(@PathVariable("member-id") Integer id){
        List<CardDto> cardList = new ArrayList<>();
        try {
            cardList = cardService.getCardOfMember(id);
            System.out.println("+++++++++++++++++++++++++");
            for (CardDto cardDto : cardList) {
                System.out.println("cardDto = " + cardDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<CardDto>>(cardList, HttpStatus.OK);
    }

    // 거래 내역 조회 - 멤버가 갖고 있는 카드의 거래내역
    @GetMapping("/transaction/{member-id}")
    public ResponseEntity<List<TransactionDto>> getTransaction(@PathVariable("member-id") Integer id){
        List<CardDto> cardList = new ArrayList<>();
        List<TransactionDto> transactions = new ArrayList<>();
//        List<List<TransactionDto>> transactionList = new ArrayList<>();
        try {
            // 멤버가 갖고 있는 카드 내역 조회
            cardList = cardService.getCardOfMember(id);

            // 카드 리스트에 있는 카드아이디로 카드별 거래내역 가져오기

            for (CardDto cardDto : cardList) {
                System.out.println("cardDto = " + cardDto);

                transactions = transactionService.getTransaction(cardDto.getId());  // 카드 거래내역 조회

//                transactionList.add(transactions);  // 거래 내역 담기
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<TransactionDto>>(transactions, HttpStatus.OK);
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
