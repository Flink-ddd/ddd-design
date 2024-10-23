package com.rmpl.business.common.bottom.domain;

import com.rmpl.business.common.bottom.dto.Request;
import com.rmpl.business.common.bottom.dto.Response;

public interface ExceptionHandlerI {
    void handleException(Request request, Response response, Exception exception);
}
