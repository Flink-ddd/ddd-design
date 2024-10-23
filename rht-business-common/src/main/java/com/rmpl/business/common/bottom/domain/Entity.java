package com.rmpl.business.common.bottom.domain;

/**
 * @author muxh
 */
public interface Entity<T> extends DomainI {
    T getUniqueId();
}
