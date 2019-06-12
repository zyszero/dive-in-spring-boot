package com.zys.divinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 引导类
 *
 * @author: zys
 * @date: 2019/6/11 22:23
 */
//@SpringBootApplication
public class SpringApplicationBootStrap {
    public static void main(String[] args) {
//        SpringApplication.run(SpringApplicationBootStrap.class, args);
//        SpringApplication springApplication = new SpringApplication(SpringApplicationBootStrap.class);
//        springApplication.setBannerMode(Banner.Mode.CONSOLE);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        springApplication.setAdditionalProfiles("prod");
//        springApplication.setHeadless(true);

//        new SpringApplicationBuilder(SpringApplicationBootStrap.class)
//                .bannerMode(Banner.Mode.CONSOLE)
//                .web(WebApplicationType.NONE)
//                .profiles("prod")
//                .headless(true)
//                .run(args);

        Set<String> sources = new HashSet<>();
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        // 配置 Spring Boot Bean 源
        springApplication.setSources(sources);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println("Bean：" + context.getBean(ApplicationConfiguration.class));
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
