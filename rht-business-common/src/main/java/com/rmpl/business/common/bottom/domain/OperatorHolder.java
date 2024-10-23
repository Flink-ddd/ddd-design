package com.rmpl.business.common.bottom.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.rmpl.business.common.bottom.dto.LocalCache;
import com.rmpl.business.common.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author muxh
 */
@Slf4j
public class OperatorHolder {

//    public static final ThreadLocal<LocalCache> userThreadLocal = new InheritableThreadLocal();

    public static final TransmittableThreadLocal<LocalCache> userThreadLocal = new TransmittableThreadLocal<>();


    public static void set(LocalCache localCache) {
        userThreadLocal.set(localCache);
    }

    public static void unset() {
        log.info("userThreadLocal.remove*******:{}", JSON.toJSONString(userThreadLocal));
        if(CheckUtil.isNotEmpty(userThreadLocal)){
            log.info("userThreadLocal.remove 删除:{}", JSON.toJSONString(userThreadLocal.get()));
            userThreadLocal.remove();
        }
    }

    public static LocalCache get() {
        return userThreadLocal.get();
    }
}
