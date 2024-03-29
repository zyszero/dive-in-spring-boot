package com.zys.divinspringboot.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Spring Web MVC 配置类
 *
 * @author: zys
 * @date: 2019/6/27 23:30
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
     * <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
     * <!--<property name="prefix" value="/WEB-INF/jsp/"/>-->
     * <!--<property name="suffix" value=".jsp"/>-->
     * <!--</bean>-->
     *
     * @return
     */
    @Bean
    public ViewResolver myViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        // ThymeleafViewResolver Ordered.LOWEST_PRECEDENCE - 5
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        // 优先级高于 ThymeleafViewResolver
        // 配置 ViewResolver 的 Content-Type
        viewResolver.setContentType("text/xml;charset=UTF-8");
        return viewResolver;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截中......");
                return super.preHandle(request, response, handler);
            }
        });
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> factory.addContextCustomizers((context) -> {
            String relativePath = "springboot-view/src/main/webapp";
            // 相对于 user.dir = C:\code\zys-dive-in-spring-boot
            File docBaseFile = new File(relativePath);
            if (docBaseFile.exists()) {
                // 解决 Maven 多模块 JSP 无法读取的问题
                context.setDocBase(docBaseFile.getAbsolutePath());
            }
        });

    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .favorPathExtension(true);
    }


}
