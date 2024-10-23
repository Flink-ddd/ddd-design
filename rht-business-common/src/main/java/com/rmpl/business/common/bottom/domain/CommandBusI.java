package com.rmpl.business.common.bottom.domain;


import com.rmpl.business.common.bottom.dto.Request;
import com.rmpl.business.common.bottom.dto.Response;

public interface CommandBusI {
    <T extends Response> T send(Request var1);
}
