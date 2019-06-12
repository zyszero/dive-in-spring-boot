package com.zys.divinspringboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * JAVA 系统属性 条件判断
 *
 * @author: zys
 * @date: 2019/6/10 22:46
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * Java 系统属性名称
     *
     * @return
     */
    String name();

    /**
     * Java 系统属性值
     *
     * @return
     */
    String value();
}
