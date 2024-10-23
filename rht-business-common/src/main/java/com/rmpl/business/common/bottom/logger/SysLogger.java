package com.rmpl.business.common.bottom.logger;

/**
 * @author muxh
 */
public class SysLogger implements Logger {
    private String loggerName;

    private SysLogger(String loggerName) {
        this.loggerName = loggerName;
    }

    public static Logger getLogger(Class clz) {
        return new SysLogger(clz.getName());
    }

    public static Logger getLogger(String loggerName) {
        return new SysLogger(loggerName);
    }

    public void debug(String msg) {
        System.out.println("[" + this.loggerName + "] DEBUG: " + msg);
    }

    public void info(String msg) {
        System.out.println("[" + this.loggerName + "] INFO: " + msg);
    }

    public void warn(String msg) {
        System.out.println("[" + this.loggerName + "] WARN: " + msg);
    }

    public void error(String msg) {
        System.err.println("[" + this.loggerName + "] ERROR: " + msg);
    }

    public void error(String msg, Throwable t) {
        System.err.println("[" + this.loggerName + "] ERROR: " + msg);
        t.printStackTrace();
    }
}
