package com.rmpl.business.common.bottom.domain;

import com.rmpl.business.common.bottom.logger.Logger;
import com.rmpl.business.common.bottom.logger.LoggerFactory;
import com.rmpl.business.common.bottom.dto.Request;
import com.rmpl.business.common.bottom.dto.Response;

public class DefaultExceptionHandler implements ExceptionHandlerI {
    private Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    public static DefaultExceptionHandler singleton = new DefaultExceptionHandler();

    public DefaultExceptionHandler() {
    }

    public void handleException(Request request, Response response, Exception exception) {
        this.buildResponse(response, exception);
        this.printLog(request, response, exception);
    }

    private void printLog(Request request, Response response, Exception exception) {
        if (exception instanceof BaseException) {
            this.logger.warn(this.buildErrorMsg(request, response));
        } else {
            this.logger.error(this.buildErrorMsg(request, response), exception);
        }

    }

    private String buildErrorMsg(Request request, Response response) {
        return "Process [" + request + "] failed, errorCode: " + response.getCode() + " errorMsg:" + response.getMessage();
    }

    private void buildResponse(Response response, Exception exception) {
        if (exception instanceof BaseException) {
            ErrorCodeI errCode = ((BaseException)exception).getErrCode();
            response.setCode(errCode.getErrorCode());
        } else {
            response.setCode(BasicErrorCode.SYS_ERROR.getErrorCode());
        }

        response.setMessage(exception.getMessage());
        response.setSuccess(false);
    }

}
