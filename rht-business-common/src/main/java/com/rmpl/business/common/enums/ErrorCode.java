package com.rmpl.business.common.enums;


import com.rmpl.business.common.exception.ServiceErrorException;

/**
 * @author vensen
 */

public enum ErrorCode {
    UNKNOWN_ERROR("1", "未知的系统错误"),
    DB_ERROR("1", "SYS", "数据库异常"),
    CACHE_ERROR("2", "SYS", "缓存异常"),
    HTTP_ERROR("3", "SYS", "调用HTTP接口发生异常"),
    RETURN_NULL_ERROR("4", "SYS", "服务不能返回空对象"),
    CLOSE_CONNECT("1", "关闭连接"),
    SYS_ERROR("3", "系统出错");

    private final String code;
    private final String message;

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private ErrorCode(String code, String codeSign, String message) {
        this.code = codeSign + "_" + code;
        this.message = message;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ServiceErrorException error() {
        return new ServiceErrorException(this);
    }

    public ServiceErrorException error(Throwable cause) {
        return new ServiceErrorException(this, cause);
    }
}
