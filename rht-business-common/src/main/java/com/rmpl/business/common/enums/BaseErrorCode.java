package com.rmpl.business.common.enums;


/**
 * @author muxh
 * @version V1.0
 * @deac 统一错误码以及提示
 * @since 2021-09-02 09:52
 */
public enum BaseErrorCode {
    COMMON_ERROR("9999", "系统内部错误"), COMMON_SUCCESS("0000", "成功"), COMMON_ALREADY_SUCCESS("0000", "请求已受理，请勿重新发送"),
    SAME_REQUEST("0001", "请勿频繁操作"), PARAMS_ERROR("0008", "入参错误"), PARAMS_JSON_ERROR("0008001", "json序列化失败"),

    AUTH_ERROR("403", "用户未登录"), CONFIG_ERROR("0009", "服务器内部配置错误"), NO_DATA_ERROR("0010", "未查到相对应数据"),

    SPI_ERROR("9101", "远程调用异常"), DUPLICATE_DATA_ERROR("0011", "重复数据"), EXPRESS_NO_NULL("20000", "物流单号不能为空"),
    FILE_NOT_FOUND("0012", "文件找不到"), UPLOAD_FILE_FORMAT_ERROR("0013", "上传文件的格式有误，仅支持xls和xlsx。"),
    UPLOAD_EXCEL_HEADER_ERROR("0014", "Excel表头导入错误"), UPLOAD_EXCEL_DATA_NULL("0015", "Excel数据为空！");

    private String code;

    private String msg;

    BaseErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String message() {
        return msg;
    }
}
