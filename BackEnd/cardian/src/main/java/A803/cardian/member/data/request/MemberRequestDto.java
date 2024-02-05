package A803.cardian.member.data.request;

import A803.cardian.member.domain.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRequestDto {

    private String name;
    private String residentRegistrationNumber;
    private String phoneNumber;

}
