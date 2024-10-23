package com.rmpl.business.common.bottom.dto;

import com.rmpl.business.common.bottom.domain.OperatorHolder;
import lombok.Data;

/**
 * @author muxh
 */
@Data
public class Request implements DTO {
    private static final long serialVersionUID = -3045949869548714856L;
    /**
     * 域ID，初始化域ID，从开放平台获取。
     */
    private String domainId;

    /**
     * 当前登录商家ID
     */
    private Long businessId;

    /**
     * 当前登录用户ID
     */
    private Long userId;

    public Request() {
    }

    public String getDomainId() {
        if (OperatorHolder.get() == null) {
            return null;
        }
        return OperatorHolder.get().getDomainId();
    }

    public void getDomainId(String domainId) {
        this.domainId = domainId;
    }


}
