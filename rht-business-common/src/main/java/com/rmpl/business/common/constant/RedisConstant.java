package com.rmpl.business.common.constant;

/**
 * TODO
 *
 * @author muxh
 * @version V1.0
 * @since 2021-08-24 18:00
 */
public class RedisConstant {

    /**
     * 过期时间
     */
    public static final long EXPIRE_DAY = 24 * 3600L;

    /**
     * 设置超时时间
     */
    public static final long TIME_OUT = 1800L;

    /**
     * redis key 系统前缀
     */
    public final static String ORDER_REDIS_PREFIX = "ORDER_CENTER_REDIS_";

    /**
     * 用户Id前缀
     */
    public final static String USER_ID_PREFIX = ORDER_REDIS_PREFIX + "USER_ID_";


}
