package com.zys.divinspringboot.method.support;

import com.zys.divinspringboot.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Properties;

/**
 * {@link java.util.Properties}  {@link HandlerMethodReturnValueHandler} 实现
 *
 * @author: zys
 * @date: 2019/8/4 23:52
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return Properties.class.equals(returnType.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        // 强制转换
        Properties properties = (Properties) returnValue;
        // 复用 PropertiesHttpMessageConverter
        PropertiesHttpMessageConverter propertiesHttpMessageConverter = new PropertiesHttpMessageConverter();

        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;

        // Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();
        // 请求输入字节流
        InputStream inputStream = request.getInputStream();
        //获取Content-Type 请求头的媒体类型
        String contentType = request.getHeader("Content-Type");

        MediaType mediaType = MediaType.parseMediaType(contentType);

        // 获取 Servlet Response 对象
        HttpServletResponse response = servletWebRequest.getResponse();
        // 通过 PropertiesHttpMessageConverter 输出
        HttpOutputMessage message = new ServletServerHttpResponse(response);
        propertiesHttpMessageConverter.write(properties, mediaType, message);
        // 告知 Spring Web MVC 当前请求已经处理完毕
        mavContainer.setRequestHandled(true);
    }
}
