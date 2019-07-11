package com.zys.divinspringboot.thymeleaf.engine;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * @author: zys
 * @date: 2019/7/11 23:46
 */
public class ThymeleafTemplateEngineBootStrap {
    public static void main(String[] args) {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello,World");
        // 模板的内容
        String content = "<p th:text=\"${message}\">!!!</p>";
        // 渲染（处理）结果
        String result = templateEngine.process(content, context);
        // 输出渲染（处理）结果
        System.out.println(result);
    }
}
