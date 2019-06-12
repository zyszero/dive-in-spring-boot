package com.zys.divinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义自动化装配的实现：
 * HelloWorldAutoConfiguration
 * - 条件判断： user.name == "zys"
 * - 模式注解： @Configuration
 * - @Enable 模块： @EnableHelloWorld -> HelloWorldImportSelector -> HelloWorldConfiguration - > helloWorld
 * <p>
 * 底层装配技术：
 * - Spring 模式注解装配
 * - Spring @Enable 模块装配
 * - Spring 条件装配装配
 * - Spring 工厂加载机制：
 *      - 实现类： SpringFactoriesLoader
 *      - 配置资源： META-INF/spring.factories
 * <p>
 * 自动装配举例:
 * - META-INF:spring.factories
 */
@SpringBootApplication
public class AutoconfigureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoconfigureApplication.class, args);
    }

}
