package com.rmpl.business.common.utils;

import java.util.Properties;

/**
 * @author: lujingbo
 * @desc:
 * @date: 2022-01-19 11:14
 */
public class YamlConfigurerUtil {
    private static Properties ymlProperties = new Properties();

    public YamlConfigurerUtil(Properties properties) {
        ymlProperties = properties;
    }

    public static String getStrYmlVal(String key) {
        return ymlProperties.getProperty(key);
    }

    public static Integer getIntegerYmlVal(String key) {
        return Integer.valueOf(ymlProperties.getProperty(key));
    }

}
