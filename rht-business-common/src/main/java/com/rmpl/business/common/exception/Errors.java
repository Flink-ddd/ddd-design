package com.rmpl.business.common.exception;

import com.rmpl.business.common.enums.BaseErrorCode;
import lombok.Getter;

/**
 * Errors
 *
 * @author muxh
 * @since 2021-12-03 9:50
 */
@Getter
public enum Errors {

    /********************************
     * 保留的基本异常
     *********************************/
    DEFAULT_PARAM_VALID_ERROR(001000, "{0}", BaseErrorCode.PARAMS_ERROR),

    /********************************
     * BIZ 异常(必须都有对应的OutErrorEnum)
     *********************************/

    /********************************
     * DOMAIN 异常
     *********************************/

    /********************************
     * SPI 异常
     *********************************/

    /********************************
     * COMMON 异常
     *********************************/

    /********************************
     * WEB 异常

     /********************************
     * INFRASTRUCTURE 异常
     *********************************/

    END(9999, "end", BaseErrorCode.COMMON_ERROR),

    END_PARAMS(9998, "end", BaseErrorCode.PARAMS_ERROR),

    DUPLICATE_DATA_ERROR(1000, "end", BaseErrorCode.DUPLICATE_DATA_ERROR);


    private Integer code;
    private String message;
    private BaseErrorCode baseErrorCode;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public BaseErrorCode get() {
        return baseErrorCode;
    }

    Errors(Integer code, String message, BaseErrorCode baseErrorCode) {
        this.code = code;
        this.message = message;
        this.baseErrorCode = baseErrorCode;
    }

    /**
     * 通过code查找枚举
     */
    public static Errors findByCode(Integer code) {
        for (Errors item : values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return null;
    }

}
