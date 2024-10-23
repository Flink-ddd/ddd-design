package com.rmpl.business.common.bottom.logger;

/**
 * @author muxh
 */
public interface Logger {
    void debug(String var1);

    default void debug(String msg, Object... args) {
        this.debug(String.format(msg, args));
    }

    default void info(String msg) {
    }

    default void info(String msg, Object... args) {
        this.info(String.format(msg, args));
    }

    void warn(String var1);

    default void warn(String msg, Object... args) {
        this.warn(String.format(msg, args));
    }

    default void error(String msg) {
    }

    default void error(String msg, Object... args) {
        this.error(String.format(msg, args));
    }

    void error(String var1, Throwable var2);
}
