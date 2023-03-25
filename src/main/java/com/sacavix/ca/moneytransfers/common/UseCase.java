package com.sacavix.ca.moneytransfers.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {

    // Solo un alias para abstraernos de Spring framework
    @AliasFor(annotation = Component.class)
    String value() default "";

}
