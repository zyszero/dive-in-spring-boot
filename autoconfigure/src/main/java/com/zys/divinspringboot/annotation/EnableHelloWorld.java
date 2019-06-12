package com.zys.divinspringboot.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @decription: 激活 HelloWorld 模块
 * @author: zys
 * @date: 2019/6/10 22:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
// 注解驱动方式
//@Import(HelloWorldConfiguration.class)
// 接口编程模式
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
