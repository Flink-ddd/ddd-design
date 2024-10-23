package com.rmpl.business.common.bottom.dto;

import com.rmpl.business.common.bottom.domain.OperatorHolder;
import lombok.Data;

/**
 * @author muxh
 */
@Data
public class StatisticsRequest implements DTO {
    private static final long serialVersionUID = -3045949869548714853L;
    /**
     * 域ID，初始化域ID，从开放平台获取。
     */
    private String domainId;

    /**
     * 内部处理来源
     */
    private Integer updateModify;

    public StatisticsRequest() {
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

    public Integer getUpdateModify() {
        return this.updateModify;
    }

    public void getDomainId(Integer updateModify) {
        this.updateModify = updateModify;
    }

}
