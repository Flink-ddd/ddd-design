package com.rmpl.business.controller.config;

import com.rmpl.business.common.utils.CheckUtil;
import com.rmpl.business.common.utils.YamlConfigurerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * @author: lujingbo
 * @desc:
 * @date: 2022-01-19 11:13
 */
@Configuration
@Slf4j
public class BeanConfiguration {

    @Value("${api.top.serverId}")
    private String serverId;

    @Value("${api.top.serverdbId}")
    private String serverdbId;

    @Bean
    public YamlConfigurerUtil ymlConfigurerUtil() {
        Properties properties = new Properties();
        try {
            String webIP = InetAddress.getLocalHost().getHostAddress();
            if (CheckUtil.isNotEmpty(serverId) && CheckUtil.isNotEmpty(webIP)) {
                String[] serverIds = serverId.split(",");
                for (String ipV : serverIds) {
                    if (CheckUtil.isEmpty(ipV)) {
                        continue;
                    }
                    String[] ipvs = ipV.split("-");
                    if (webIP.equals(ipvs[0])) {
                        properties.setProperty("sequenceServerId", ipvs[1]);
                        properties.setProperty("sequencedbId", serverdbId);
                        return new YamlConfigurerUtil(properties);
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            log.error("获取本地IP失败:{}", e);
            return null;
        }
        return null;
    }

}
