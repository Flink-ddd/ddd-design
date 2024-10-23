package com.rmpl.business.common.bottom.domain;

public class SharpenException extends BaseException {
    private static final long serialVersionUID = 1L;

    public SharpenException(String errMessage) {
        super(errMessage);
        this.setErrCode(BasicErrorCode.SHARPEN_ERROR);
    }

    public SharpenException(String errMessage, Throwable e) {
        super(errMessage, e);
        this.setErrCode(BasicErrorCode.SHARPEN_ERROR);
    }

}
