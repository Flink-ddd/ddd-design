package com.rmpl.business.common.bottom.domain;

public enum BasicErrorCode implements ErrorCodeI {
    PARAM_ERROR("1000", "请求参数校验错误"),
    BIZ_ERROR("2000", "业务逻辑错误"),
    INFRA_ERROR("3000", "基础设施(数据库，缓存，消息等)错误"),
    SYS_ERROR("4000", "未知的其它系统错误"),
    SHARPEN_ERROR("5000", "框架内部错误");

    private String errCode;
    private String errDesc;

    private BasicErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    @Override
    public String getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorDesc() {
        return this.errDesc;
    }
}
