package com.rmpl.business.common.bottom.domain;

/**
 * @author vensen
 */
public interface DomainEventPublisherI {
    void publish(DomainEvent var1, Boolean var2);
}
