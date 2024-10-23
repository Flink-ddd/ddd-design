package com.rmpl.business.common.exception;

/**
 * WarehouseDomainException
 *
 * @author lujingbo
 * @since 2022-11-22 11:12
 */
public class RhtBusinessDomainException extends RhtBusinessException {

    public RhtBusinessDomainException() {
        super();
    }

    public RhtBusinessDomainException(int code, String msg) {
        super(code, msg);
    }

    public RhtBusinessDomainException(int code, Exception errors) {
        super(code + "", errors);
    }

    public RhtBusinessDomainException(Errors errors) {
        super(errors.getCode(), errors.getMessage());
    }

    public RhtBusinessDomainException(Errors errors, Throwable cause) {
        super(errors, cause);
    }

    public RhtBusinessDomainException(String msg, Errors errors) {
        super(msg, errors);
    }
}
