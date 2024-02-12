package A803.cardian.member.data.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberResponseDto {
    
    // 유저 아이디
    private int memberId;
    
    // 로그인 성공 여부 담을 메시지
    private String message;

    private MemberResponseDto(int memberId, String message){
        this.memberId = memberId;
        this.message = message;
    }

    public static MemberResponseDto toResponse(int memberId, String message){
        return new MemberResponseDto(memberId, message);
    }
    
}
