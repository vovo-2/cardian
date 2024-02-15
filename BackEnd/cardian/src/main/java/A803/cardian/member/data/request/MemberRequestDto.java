package A803.cardian.member.data.request;

import A803.cardian.member.domain.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRequestDto {

    // 이름
    private String name;
    // 주민등록번호
    private String residentRegistrationNumber;
    // 전화번호
    private String phoneNumber;

}
