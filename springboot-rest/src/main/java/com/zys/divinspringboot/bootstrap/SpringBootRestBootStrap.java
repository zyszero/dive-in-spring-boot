package com.zys.divinspringboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zys
 * @date: 2019/7/20 23:32
 */
@SpringBootApplication(scanBasePackages = {
        "com.zys.divinspringboot.controller",
        "com.zys.divinspringboot.config"
})
public class SpringBootRestBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootStrap.class, args);
    }
}
