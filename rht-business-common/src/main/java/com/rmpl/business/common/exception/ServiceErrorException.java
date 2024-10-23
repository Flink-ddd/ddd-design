package com.rmpl.business.common.exception;


import com.rmpl.business.common.enums.ErrorCode;

/**
 * @author vensen
 */
public class ServiceErrorException extends RuntimeException{
    private static final long serialVersionUID = 6874544975586866342L;
    private String code;

    public ServiceErrorException() {
    }

    public ServiceErrorException(String message) {
        super(message);
        this.code = ErrorCode.UNKNOWN_ERROR.code();
    }

    public ServiceErrorException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceErrorException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.UNKNOWN_ERROR.code();
    }

    public ServiceErrorException(Throwable cause) {
        super(ErrorCode.UNKNOWN_ERROR.message(), cause);
        this.code = ErrorCode.UNKNOWN_ERROR.code();
    }

    public ServiceErrorException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ServiceErrorException(ErrorCode respCode) {
        super(respCode.message());
        this.code = respCode.code();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ServiceErrorException(ErrorCode respCode, Throwable cause) {
        super(respCode.message(), cause);
        this.code = respCode.code();
    }
}
