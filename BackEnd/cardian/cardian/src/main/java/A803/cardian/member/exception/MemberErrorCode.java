package A803.cardian.member.exception;

import A803.cardian.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    PHONE_NUMBER_IS_NOT_VALID(400, "MEMBER_01", "유효하지 않은 전화번호 형식입니다."),
    NO_MEMBER(400, "MEMBER_02", "멤버를 찾을 수 없습니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message){
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
