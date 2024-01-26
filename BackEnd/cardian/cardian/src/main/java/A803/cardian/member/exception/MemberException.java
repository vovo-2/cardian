package A803.cardian.member.exception;

import A803.cardian.global.exception.ErrorCode;
import A803.cardian.global.exception.GlobalException;

public class MemberException extends GlobalException {
    public MemberException(ErrorCode errorCode){
        super(errorCode);
    }
}
