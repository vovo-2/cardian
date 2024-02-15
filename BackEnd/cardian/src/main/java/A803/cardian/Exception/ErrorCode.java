package A803.cardian.Exception;

import lombok.Getter;

@Getter
public enum ErrorCode  {
    PHONE_NUMBER_IS_NOT_VALID(400, "MEMBER_01", "유효하지 않은 전화번호 형식입니다."),
    NO_MEMBER(400, "MEMBER_02", "멤버를 찾을 수 없습니다."),
    NO_SUBCOMMONCODE(404,"NOT_FOUND","서브서먼코드가 없습니다"),
    NO_ASSOCIATE(404,"NOT_FOUND","제휴사가 없습니다"),
    NO_CARD(404,"NOT_FOUND","카드가 없습니다"),
    NO_CARDCATEGORYMAPPING(404,"NOT_FOUND","카드에 저장된 제휴사가 없습니다");



    private final int statusCode;
    private final String errorCode;
    private final String message;

    ErrorCode(int statusCode, String errorCode, String message){
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
