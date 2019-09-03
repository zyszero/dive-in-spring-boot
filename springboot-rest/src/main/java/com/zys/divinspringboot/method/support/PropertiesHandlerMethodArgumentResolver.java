package com.zys.divinspringboot.method.support;

import com.zys.divinspringboot.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * {@link Properties 类型} 实现 {@link HandlerMethodArgumentResolver}
 *
 * @author: zys
 * @date: 2019/7/31 22:45
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        // Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();
        // 复用 PropertiesHttpMessageConverter
        PropertiesHttpMessageConverter propertiesHttpMessageConverter = new PropertiesHttpMessageConverter();

        HttpInputMessage message = new ServletServerHttpRequest(request);

        return propertiesHttpMessageConverter.read(null, null, message);
    }
}
