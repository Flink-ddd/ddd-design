package com.rmpl.business.common.bottom.dto;

/**
 * @author muxh
 */
public enum FailCodeEnum {
    FAIL(1, "成功!");
    private final int code;
    private final String message;

    private FailCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
