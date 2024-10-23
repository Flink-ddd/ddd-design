package com.rmpl.business.common.bottom.domain;


import com.rmpl.business.common.bottom.dto.VO;

/**
 * @author muxh
 */
public interface DomainFactory<V extends VO, D extends DomainI> {
    D perfect(V var1);

    static <T> T get(Class<T> clazz) {
        return ApplicationContextHelper.getBean(clazz);
    }
}
