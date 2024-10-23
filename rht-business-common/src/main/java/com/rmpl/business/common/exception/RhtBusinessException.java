package com.rmpl.business.common.exception;

import lombok.Data;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author muxh
 * @version V1.0
 * @since 2020-04-01 13:24
 */
@Data
@Component
@ConfigurationProperties(prefix = "messages")
@PropertySource(value = {"classpath:messages.properties"})
public class RhtBusinessException extends RuntimeException {
    private static final long serialVersionUID = 1623708858076767443L;

    static Logger logger = LoggerFactory.getLogger(RhtBusinessException.class);

    private static final String SEPARATOR = "";

    @Getter
    private int code;

    @Autowired
    private MessageSource messageSource;

    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 异常信息参数
     */
    private Object[] msgArgs;

    /**
     * 不建议用这个构造器
     */
    @Deprecated
    public RhtBusinessException() {
        super();
    }

    public RhtBusinessException(String msg) {
        super(msg);
    }

    public RhtBusinessException(Throwable cause) {
        super(cause);
    }

    public RhtBusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RhtBusinessException(int code, String msg, Throwable cause) {
        super(SEPARATOR + msg, cause);
        this.code = code;
    }

    public RhtBusinessException(String msgFormat, Object... replacement) {
        super(MessageFormat.format(msgFormat, replacement));
        this.errorCode = msgFormat;
        this.msgArgs = replacement;
        this.code = FailCodeEnum.FAIL.getCode();
    }

    public RhtBusinessException(String msgFormat, Throwable cause, Object... replacement) {
        super(MessageFormat.format(msgFormat, replacement), cause);
        this.code = FailCodeEnum.FAIL.getCode();
    }

    public RhtBusinessException(int code, String msgFormat, Object... replacement) {
        super(SEPARATOR + MessageFormat.format(msgFormat, replacement));
        this.code = code;
        this.errorCode = msgFormat;
        this.msgArgs = replacement;
    }

    public RhtBusinessException(int code, String msgFormat, Throwable cause, Object... replacement) {
        super(SEPARATOR + MessageFormat.format(msgFormat, replacement), cause);
        this.code = code;
    }

    public RhtBusinessException(Errors errors) {
        super(SEPARATOR + errors.getMessage());
        this.code = errors.getCode();
    }

    public RhtBusinessException(Errors errors, Throwable cause) {
        super(SEPARATOR + errors.getMessage(), cause);
        this.code = errors.getCode();
    }

    public RhtBusinessException(Errors errors, Object... replacement) {
        super(SEPARATOR + MessageFormat.format(errors.getMessage(), replacement));
        this.code = errors.getCode();
    }

    public RhtBusinessException(String msg, Errors errors) {
        super(errors.getMessage() + "-" + msg);
        this.code = errors.getCode();
    }


    public String getMessage() {
        if (!isInteger(this.errorCode)) {
            return MessageFormat.format(this.errorCode, this.getMsgArgs());
        }
        String msg = "";
        if (this.errorCode == null) {
            msg = super.getMessage();
            return msg;
        } else {
            try {
                // 这里只要知道可以通过错误码获得相关错误信息
                msg = this.getMsg(this.errorCode, this.getMsgArgs());
            } catch (Exception ex) {
                logger.error("*** read errorcode: [" + this.errorCode + "] failer ***");
                ex.printStackTrace();
            }
            return "[" + this.errorCode + "]" + msg;
        }
    }

    private static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 根据异常Code获取异常描述信息
     *
     * @param errorCode 异常Code
     * @param msgArgs   异常描述参数
     * @return
     * @throws IOException
     */
    public String getMsg(String errorCode, Object... msgArgs) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String errorDesc = "";
        String errMsg = messageSource.getMessage(errorCode, null, currentLocale);

        if (errMsg == null || errMsg.trim().length() == 0) {
            errMsg = "No Defined errorDesc!!!";
        }
        if (msgArgs != null && msgArgs.length > 0) {
            errorDesc = MessageFormat.format(errMsg, msgArgs);
        } else {
            errorDesc = errMsg;
        }
        return errorDesc;
    }

}
