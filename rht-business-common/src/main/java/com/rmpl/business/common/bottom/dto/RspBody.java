package com.rmpl.business.common.bottom.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("请求返回结果")
public class RspBody <T> implements Serializable {

    private static final long serialVersionUID = -3587330787591619047L;

    @ApiModelProperty("错误码,如值为'200',表示请求返回正常")
    private String code;
    @ApiModelProperty("错误提示信息")
    private String msg;
    @ApiModelProperty("请求返回数据对象")
    private T data;

    public RspBody() {}

    public RspBody(T data) {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
