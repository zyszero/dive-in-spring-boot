package com.zys.divinspringboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * HelloWorldApplicationListener 实现 {@link ApplicationListener} 监听 {@link ContextRefreshedEvent} 事件
 *
 * @author: zys
 * @date: 2019/6/12 23:05
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Hello World " + event.getApplicationContext().getId() +
                " , timestamp : " + event.getTimestamp());
    }
}
