package com.a803.cardcompany.member.service;

import com.a803.cardcompany.member.dto.MemberDto;
import com.a803.cardcompany.member.mapper.Member;
import com.a803.cardcompany.member.mapper.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public MemberDto findById(Integer id) {
        MemberDto memberDto = new MemberDto();
        memberDto = memberRepository.findById(id).get().toDto();
        return memberDto;
    }

    @Override
    public MemberDto findByName(String name) {
        MemberDto memberDto = new MemberDto();
        memberDto = memberRepository.findByName(name).toDto();
        return memberDto;
    }
}
