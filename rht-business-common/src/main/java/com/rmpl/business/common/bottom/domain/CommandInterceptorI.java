package com.rmpl.business.common.bottom.domain;


import com.rmpl.business.common.bottom.dto.Request;
import com.rmpl.business.common.bottom.dto.Response;

public interface CommandInterceptorI {
    default void preIntercept(Request request) {
    }

    default void postIntercept(Request command, Response response) {
    }
}
