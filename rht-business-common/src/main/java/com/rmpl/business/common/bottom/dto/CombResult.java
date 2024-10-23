package com.rmpl.business.common.bottom.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class CombResult<T> {

    private String code;
    private String status;
    private String msg;
    private T data;

    public static CombResult buildFailure(String errCode, String message) {
        CombResult commonResult = new CombResult();
        commonResult.setMsg(message);
        commonResult.setCode(StringUtils.isEmpty(errCode.trim()) ? String.valueOf(FailCodeEnum.FAIL.getCode()) : errCode);
        return commonResult;
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
