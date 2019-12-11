package com.wahaha.heyworld.util;


import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Inherited
public @interface Api {
    String value() default "";

    String notes() default "";

    String tags() default "";

}

