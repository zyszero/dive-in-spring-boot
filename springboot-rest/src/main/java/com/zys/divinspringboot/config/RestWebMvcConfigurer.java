package com.zys.divinspringboot.config;

import com.zys.divinspringboot.method.support.PropertiesHandlerMethodArgumentResolver;
import com.zys.divinspringboot.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest {@link WebMvcConfigurer} 实现
 *
 * @author: zys
 * @date: 2019/7/24 23:05
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init() {
        // 获取当前 RequestMappingHandlerAdapter 所有的 Resolver 对象
        List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newArgumentResolvers = new ArrayList<>(argumentResolvers.size() + 1);
        // 添加 PropertiesHandlerMethodArgumentResolver 到集合首位
        newArgumentResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        // 添加 已注册的 Resolver 对象集合
        newArgumentResolvers.addAll(argumentResolvers);
        // 重新设置 Resolver 对象集合
        requestMappingHandlerAdapter.setArgumentResolvers(newArgumentResolvers);

        // 获取当前 HandlerMethodReturnValueHandler 所有的 Handler 对象
        List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newReturnValueHandlers = new ArrayList<>(returnValueHandlers.size() + 1);
        // 添加 PropertiesHandlerMethodReturnValueHandler 到集合首位
        newReturnValueHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        // 添加 已注册的 Handler 对象集合
        newReturnValueHandlers.addAll(returnValueHandlers);
        // 重新设置 Handler 对象集合
        requestMappingHandlerAdapter.setReturnValueHandlers(newReturnValueHandlers);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到 converters 的末尾
//        converters.add(new PropertiesHttpMessageConverter());
        // 添加到首位
//        converters.set(0, new PropertiesHttpMessageConverter());
    }


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // 添加 PropertiesHandlerMethodArgumentResolver 至集合首位
        // 添加自定义 HandlerMethodArgumentResolver，优先级低于内建 HandlerMethodArgumentResolver
//        if (resolvers.isEmpty()) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }
    }
}
