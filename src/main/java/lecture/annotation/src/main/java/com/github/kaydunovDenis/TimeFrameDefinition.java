package com.github.kaydunovDenis;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimeFrameDefinition {
    String value() default "";
}
