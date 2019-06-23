package com.zys.divinspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 应用引导类
 *
 * @author: zys
 * @date: 2019/6/16 20:19
 */
public class SpringApplicationEventBootStrap {
    public static void main(String[] args) {
        // 创建上下文 使用注解驱动来做
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> System.out.println("监听到事件：" + event.getSource()));

        // 启动上下文
        context.refresh();

        // 发送事件
        context.publishEvent("HelloWorld");
        context.publishEvent("2018");
        // 也可以自定义事件
        context.publishEvent(new ApplicationEvent("zyszero") {

        });
        // 关闭上下文
        context.close();
    }
}
