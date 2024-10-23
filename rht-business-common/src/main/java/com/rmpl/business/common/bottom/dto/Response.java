package com.rmpl.business.common.bottom.dto;

/**
 * @author muxh
 */
public class Response implements DTO {
    private static final long serialVersionUID = 1L;
    private boolean isSuccess;
    private String code;
    private String message;

    public Response() {
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "Response [isSuccess=" + this.isSuccess + ", code=" + this.code + ", message=" + this.message + "]";
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(SuccessCodeEnum.SUCCESS.getCode());
        response.setMessage(SuccessCodeEnum.SUCCESS.getMessage());
        return response;
    }
}
