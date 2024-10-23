package com.rmpl.business.common.enums;

/**
 * @author lujingbo
 */
public enum SuccessCodeEnum {
    SUCCESS("0", "成功!"),
    SETTLE_SUCCESS("200", "成功!"),
    PAY_SUCCESS("000000", "成功");
    private final String code;
    private final String message;

    SuccessCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
    /**
     * 判断code是否存在
     */
    public static boolean getExist(String code) {
        for (SuccessCodeEnum successCodeEnum : values()) {
            if (successCodeEnum.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
}
