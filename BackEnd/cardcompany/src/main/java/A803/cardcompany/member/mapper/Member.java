package A803.cardcompany.member.mapper;

import com.a803.cardcompany.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

/*
*   작성자 : 정여민
*   작성일시 : 2024.01.28
*   내용 : 멤버 테이블
* 
* */


@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 아무런 매개변수가 없는 생성자를 생성하되 다른 패키지에 소속된 클래스는 접근을 불허한다
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Builder
    public Member(String name){
        this.name = name;
    }

    // Entity to Dto
    public MemberDto toDto(){
        return MemberDto.builder()
                .id(id)
                .name(name)
                .build();
    }

}
