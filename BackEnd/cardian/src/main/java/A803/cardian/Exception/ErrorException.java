package A803.cardian.Exception;

import lombok.Getter;

@Getter
public class ErrorException extends RuntimeException{
    private final int statusCode;
    private final String errorCode;
    private final String message;

    public ErrorException(ErrorCode errorCode){
        this.statusCode = errorCode.getStatusCode();
        this.errorCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }
}
