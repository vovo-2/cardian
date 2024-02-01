package com.a803.cardcompany.member.service;

import com.a803.cardcompany.member.dto.MemberDto;
import com.a803.cardcompany.member.mapper.Member;
import com.a803.cardcompany.member.mapper.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
*   작성자 : 정여민
*   작성 일시 : 2024.01.25
*   업데이트 : 2024.02.01
*/


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;


    public Map<String, MemberDto> getUser(Integer memberId){
        Optional<Member> member = memberRepository.findById(memberId);

        MemberDto memberDto = null;

        if(member.isEmpty()){
            memberDto = MemberDto.builder().name("").build();
        }else{
            memberDto = MemberDto.builder().memberId(member.get().getId()).name(member.get().getName()).build();
        }

        Map<String, MemberDto> response = new HashMap<>();
        response.put("member", memberDto);
        return response;
    }

}
