package com.a803.cardcompany.card.mapper;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;

    @AfterEach
    public void cleanup(){
        cardRepository.deleteAll();
    }

    @Test
    public void getCard(){
        // given



        // when

        // then

    }


}