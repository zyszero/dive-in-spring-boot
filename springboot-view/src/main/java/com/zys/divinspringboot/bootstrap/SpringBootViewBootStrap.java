package com.zys.divinspringboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 视图引导类
 *
 * @author: zys
 * @date: 2019/7/14 0:09
 */
@SpringBootApplication(scanBasePackages = "com.zys.divinspringboot")
public class SpringBootViewBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootStrap.class, args);
    }
}
