package com.zys.divinspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * 通过 implements {@link Ordered} 这种形式来实现应用上下文初始器的加载顺序
 * <p>
 * {@link ApplicationContextInitializer} 的实现类
 *
 * @author: zys
 * @date: 2019/6/12 22:30
 */
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("After Application.id = " + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
