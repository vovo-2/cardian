package com.a803.cardcompany.controller;

import com.a803.cardcompany.card.dto.CardDto;
import com.a803.cardcompany.card.service.CardService;
import com.a803.cardcompany.member.dto.MemberDto;
import com.a803.cardcompany.member.service.MemberService;
import com.a803.cardcompany.transaction.dto.TransactionDto;
import com.a803.cardcompany.transaction.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
public class cardCompanyController {

    @Autowired
    MemberService memberService;

    @Autowired
    CardService cardService;

    @Autowired
    TransactionService transactionService;

    // 회원 하나 멤버 아이디로
    @GetMapping("/user/{member-id}")
    public ResponseEntity<Map<String, MemberDto>> getMember(@PathVariable("member-id") Integer id){

        return ResponseEntity.ok(memberService.getUser(id));
    }

    // 회원이 갖고 있는 카드 조회
    @GetMapping("/card/{member-id}")
    public ResponseEntity<List<CardDto>> getCard(@PathVariable("member-id") Integer id){

        return ResponseEntity.ok(cardService.getCardOfMember(id));
    }

    // 거래 내역 조회 - 멤버가 갖고 있는 카드의 거래내역
    @GetMapping("/transaction/{member-id}")
    public ResponseEntity<Map<String, List<TransactionDto>>> getTransaction(@PathVariable("member-id") Integer id){

        return ResponseEntity.ok(transactionService.getTransaction(id));
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
