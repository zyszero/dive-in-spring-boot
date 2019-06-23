package com.zys.divinspringboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 应用上下文引导类
 *
 * @author: zys
 * @date: 2019/6/23 23:43
 */
@SpringBootApplication
public class SpringApplicationContextBootStrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(SpringApplicationContextBootStrap.class)
//                        .web(WebApplicationType.NONE)
                        .run();

        System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
        System.out.println("ConfigurableEnvironment 类型：" + context.getEnvironment().getClass().getName());

        // 关闭上下文
        context.close();
    }
}
