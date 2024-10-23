
package com.rmpl.business.common.utils;


import com.rmpl.business.common.constant.RedisConstant;

/**
 * @author muxh
 * @version V1.0
 * @since 2021-08-25 18:54
 */
public class CacheKeyUtils {

    /**
     * 缓存过期时间，1天。
     */
    public static final long EXPIRE = 1000L * 60 * 60 * 24;

    public static final long LOGISTICS_EXPIRE = 1000L * 60 * 60 * 2;


    public static String getCacheKey(String prefix, String key) {
        return prefix + key;
    }

    public static String getUserIdKey(String userId) {
        return getCacheKey(RedisConstant.USER_ID_PREFIX, userId);
    }

}
