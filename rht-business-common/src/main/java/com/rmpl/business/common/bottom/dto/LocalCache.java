package com.rmpl.business.common.bottom.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @Author muxh
 * @Date 2022-02-28 11:00
 **/
@Data
public class LocalCache {

    @ApiModelProperty("应用ID")
    private String domainId;

    @ApiModelProperty("域名")
    private String domainName;

    @ApiModelProperty("域ID")
    private String topDomainId;

    @ApiModelProperty("应用名")
    private String platformName;

    @ApiModelProperty("应用秘钥")
    private String platSecret;

    @ApiModelProperty("header")
    private String header;

    @ApiModelProperty("accessToken")
    private String accessToken;

    @ApiModelProperty("当前登录商家ID")
    private Long businessId;

    @ApiModelProperty("当前登录商家类型 1厂家 2采购  3商业")
    private Integer businessCategory;

    @ApiModelProperty("账号类型 1主账号 2子账号 3 二级商户号")
    private Integer accountType;

    @ApiModelProperty("当前登录用户ID")
    private Long userId;

    @ApiModelProperty("用户所在省ID")
    private String provinceId;

    @ApiModelProperty("用户所在市ID")
    private String cityId;

    @ApiModelProperty("用户所在区县ID")
    private String areaId;

    @ApiModelProperty("当前登录用户健康通行证ID")
    private String ucId;

    @ApiModelProperty("当前登录类型")
    private Integer loginType;

    @ApiModelProperty("当前用户及下级用户id集合，逗号隔开")
    private String subUserIds;

    @ApiModelProperty("当前及下级domainId集合，逗号隔开")
    private String subDomainIds;

    @ApiModelProperty("用户IP")
    private String userIp;

}
