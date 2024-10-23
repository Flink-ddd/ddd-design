package com.rmpl.business.common.bottom.logger;

/**
 * @author muxh
 */
public class SLFJLogger implements Logger {
    private org.slf4j.Logger slfjLogger;

    public SLFJLogger(org.slf4j.Logger slfjLogger) {
        this.slfjLogger = slfjLogger;
    }

    public void debug(String msg) {
        this.slfjLogger.debug(msg);
    }

    public void info(String msg) {
        this.slfjLogger.info(msg);
    }

    public void warn(String msg) {
        this.slfjLogger.warn(msg);
    }

    public void error(String msg) {
        this.slfjLogger.error(msg);
    }

    public void error(String msg, Throwable t) {
        this.slfjLogger.error(msg, t);
    }
}
