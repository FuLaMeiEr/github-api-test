package com.wahaha.heyworld.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiParam {
    String name() default "";

    String value() default "";

    String type() default "";

    String defaultValue() default "";

    boolean required() default false;

    String tags() default "";

}
