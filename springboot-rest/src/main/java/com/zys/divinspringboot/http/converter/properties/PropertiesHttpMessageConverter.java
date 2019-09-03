package com.zys.divinspringboot.http.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * {@link Properties} 的 {@link HttpMessageConverter} 的实现
 *
 * @author: zys
 * @date: 2019/7/24 22:59
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter() {
        super(new MediaType("text", "properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // Properties -> String
        // OutputStream -> Writer
        HttpHeaders headers = outputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        assert contentType != null;
        // 获取字符编码
        Charset charset = contentType.getCharset();
        // 当 charset 不存在时，使用 UTF-8
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        // 字符输出流
        try (Writer writer = new OutputStreamWriter(outputMessage.getBody(), charset)) {
            properties.store(writer, "From PropertiesHttpMessageConverter");
        }
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        // 字符流 -> 字符编码
        // 从 请求头 Content-Type 解析编码
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        assert contentType != null;
        // 获取字符编码
        Charset charset = contentType.getCharset();
        // 当 charset 不存在时，使用 UTF-8
        charset = charset == null ? StandardCharsets.UTF_8 : charset;
        // 字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputMessage.getBody(), charset);
        Properties properties = new Properties();
        // 加载字符流成为 Properties 对象
        properties.load(inputStreamReader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}
