package com.a803.cardcompany.member.mapper;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    //비워있어도 잘 작동함.
    // long 이 아니라 Long으로 작성. ex) int => Integer 같이 primitive형식 사용못함

    // findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다

    public Optional<Member> findById(Integer id);
    public Member findByName(String name);


}
