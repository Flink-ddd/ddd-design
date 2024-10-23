/*
 *
 * This software is the confidential and proprietary information of sipai Company.
 *
 */
package com.rmpl.business.common.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * TODO
 *
 * @author muxh
 * @version V1.0
 * @since 2022-11-30 16:53
 */
public class RandomUtil {

    public static int getRandomInt() {
        return Math.abs(new SecureRandom().nextInt());
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
