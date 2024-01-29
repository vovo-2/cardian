package com.a803.cardcompany.member.service;

import com.a803.cardcompany.member.dto.MemberDto;
import com.a803.cardcompany.member.mapper.Member;

import java.util.Optional;

public interface MemberService {

    public MemberDto findById(Integer id);

    public MemberDto findByName(String name);
}
