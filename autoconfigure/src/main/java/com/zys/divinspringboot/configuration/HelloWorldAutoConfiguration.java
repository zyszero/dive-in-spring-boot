package com.zys.divinspringboot.configuration;

import com.zys.divinspringboot.annotation.EnableHelloWorld;
import com.zys.divinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动装配
 *
 * @author: zys
 * @date: 2019/6/10 23:04
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "zys")
public class HelloWorldAutoConfiguration {
}
