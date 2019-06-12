package com.zys.divinspringboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * AfterHelloWorldApplicationListener 实现  {@link ApplicationListener} 监听 {@link ContextRefreshedEvent} 事件
 * @author: zys
 * @date: 2019/6/12 23:08
 */
public class AfterHelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("After Hello World " + event.getApplicationContext().getId() +
                " , timestamp : " + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
