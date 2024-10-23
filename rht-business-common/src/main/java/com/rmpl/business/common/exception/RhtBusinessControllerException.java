package com.rmpl.business.common.exception;

/**
 * web 异常
 *
 * @author lujingbo
 * @since 2022-11-22 11:12
 */
public class RhtBusinessControllerException extends RhtBusinessException {

    public RhtBusinessControllerException() {
        super();
    }

    public RhtBusinessControllerException(int code, String msg) {
        super(code, msg);
    }

    public RhtBusinessControllerException(Errors errors) {
        super(errors.getCode(), errors.getMessage());
    }

    public RhtBusinessControllerException(Errors errors, Throwable cause) {
        super(errors, cause);
    }

    public RhtBusinessControllerException(Throwable cause) {
        super(cause);
    }

    public RhtBusinessControllerException(String msg, Errors errors) {
        super(msg, errors);
    }
}
