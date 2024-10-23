package com.rmpl.business.common.bottom;


import com.rmpl.business.common.enums.FailCodeEnum;
import com.rmpl.business.common.enums.SuccessCodeEnum;
import com.rmpl.business.common.utils.CheckUtil;

/**
 * @author muxh
 */
public class SingleResponse<T> extends Response {
    private T data;

    public SingleResponse() {
    }

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> singleResponse = new SingleResponse();
        singleResponse.setSuccess(true);
        singleResponse.setCode(SuccessCodeEnum.SUCCESS.getCode());
        singleResponse.setMessage(SuccessCodeEnum.SUCCESS.getMessage());
        singleResponse.setData(data);
        return singleResponse;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse buildFailure(String errCode, String errMessage) {
        SingleResponse response = new SingleResponse();
        response.setSuccess(false);
        response.setCode(CheckUtil.isEmpty(errCode.trim()) ? String.valueOf(FailCodeEnum.FAIL.getCode()) : errCode);
        response.setMessage(errMessage);
        return response;
    }

    public static SingleResponse buildSuccess() {
        SingleResponse response = new SingleResponse();
        response.setSuccess(true);
        response.setCode(SuccessCodeEnum.SUCCESS.getCode());
        response.setMessage(SuccessCodeEnum.SUCCESS.getMessage());
        return response;
    }

}
