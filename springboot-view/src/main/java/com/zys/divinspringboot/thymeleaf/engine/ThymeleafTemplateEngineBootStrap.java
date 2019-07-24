package com.zys.divinspringboot.thymeleaf.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: zys
 * @date: 2019/7/11 23:46
 */
public class ThymeleafTemplateEngineBootStrap {
    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello,World");

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");

        File file = resource.getFile();

        try (FileInputStream fileInputStream = new FileInputStream(file); ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            IOUtils.copy(fileInputStream, byteArrayOutputStream);
            // 模板的内容
            String content = byteArrayOutputStream.toString("UTF-8");
            // 渲染（处理）结果
            String result = templateEngine.process(content, context);
            // 输出渲染（处理）结果
            System.out.println(result);
        }

    }
}
