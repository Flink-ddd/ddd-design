package com.rmpl.business.common.annotation;

import java.lang.annotation.*;

/**
 * ExcelColumn
 *
 * @author muxh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface ExcelColumn {
    /**
     * 列索引，以0开始
     */
    int index() default -1;

    /**
     * 列名
     */
    String name() default "";
}
