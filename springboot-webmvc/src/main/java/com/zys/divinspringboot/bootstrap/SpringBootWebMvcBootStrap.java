package com.zys.divinspringboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Web Mvc 引导类
 * @author: zys
 * @date: 2019/7/11 22:00
 */
@SpringBootApplication(scanBasePackages = "com.zys.divinspringboot")
public class SpringBootWebMvcBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootStrap.class, args);
    }
}
