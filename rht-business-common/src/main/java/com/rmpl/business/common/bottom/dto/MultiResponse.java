package com.rmpl.business.common.bottom.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author muxh
 */
public class MultiResponse<T> extends Response {
    private int total;
    private Collection<T> data;

    public MultiResponse() {
    }

    public static <T> MultiResponse<T> of(Collection<T> data, int total) {
        MultiResponse<T> multiResponse = new MultiResponse();
        multiResponse.setSuccess(true);
        multiResponse.setCode(SuccessCodeEnum.SUCCESS.getCode());
        multiResponse.setMessage(SuccessCodeEnum.SUCCESS.getMessage());
        multiResponse.setData(data);
        multiResponse.setTotal(total);
        return multiResponse;
    }

    public static <T> MultiResponse<T> ofWithoutTotal(Collection<T> data) {
        return of(data, 0);
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return null == this.data ? new ArrayList() : new ArrayList(this.data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public static MultiResponse buildFailure(String errCode, String errMessage) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

    public static MultiResponse buildSuccess() {
        MultiResponse response = new MultiResponse();
        response.setSuccess(true);
        response.setCode(SuccessCodeEnum.SUCCESS.getCode());
        response.setMessage(SuccessCodeEnum.SUCCESS.getMessage());
        return response;
    }
}
