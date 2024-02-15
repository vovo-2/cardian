package com.a803.cardcompany.member.dto;

import com.a803.cardcompany.member.mapper.Member;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MemberDto {

    private Integer memberId;
    private String name;

    // Dto -> Entity
    public Member toEntity(){
        return Member.builder().name(name).build();
    }

}
