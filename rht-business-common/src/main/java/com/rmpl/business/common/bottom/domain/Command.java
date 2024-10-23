package com.rmpl.business.common.bottom.domain;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author muxh
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface Command {
}
