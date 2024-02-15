package A803.cardian.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private final String code;
    private final String message;
    public ErrorResponse(ErrorCode errorCode){
        this.code=errorCode.getErrorCode();
        this.message=errorCode.getMessage();
    }
}
