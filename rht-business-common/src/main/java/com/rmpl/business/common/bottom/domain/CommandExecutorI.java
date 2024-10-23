package com.rmpl.business.common.bottom.domain;

import com.rmpl.business.common.bottom.dto.Request;
import com.rmpl.business.common.bottom.dto.Response;

/**
 * @author muxh
 * @desc CommandExecutor为命令执行器
 */
public interface CommandExecutorI<T extends Request, R extends Response> {
    R execute(T var1);
}
