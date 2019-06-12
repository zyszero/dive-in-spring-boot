package com.zys.divinspringboot.configuration;

import org.springframework.context.annotation.Bean;

/**
 * @decription:
 * @author: zys
 * @date: 2019/6/10 22:07
 */
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() {
        return "Hello World 2019!";
    }
}
