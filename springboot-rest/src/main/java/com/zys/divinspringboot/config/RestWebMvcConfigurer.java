package com.zys.divinspringboot.config;

import com.zys.divinspringboot.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Rest {@link WebMvcConfigurer} 实现
 * @author: zys
 * @date: 2019/7/24 23:05
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到 converters 的末尾
//        converters.add(new PropertiesHttpMessageConverter());
        // 添加到首位
        converters.set(0, new PropertiesHttpMessageConverter());
    }
}
