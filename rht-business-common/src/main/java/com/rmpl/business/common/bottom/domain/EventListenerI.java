package com.rmpl.business.common.bottom.domain;

/**
 * @author muxh
 */
public interface EventListenerI<T extends Event> {
    void execute(T var1);
}
