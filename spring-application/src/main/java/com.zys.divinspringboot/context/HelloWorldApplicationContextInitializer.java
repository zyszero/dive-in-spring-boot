package com.zys.divinspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 通过 @{@link Order} 这种形式来实现应用上下文初始器的加载顺序
 * <p>
 * {@link ApplicationContextInitializer} 的实现类
 *
 * @author: zys
 * @date: 2019/6/12 22:26
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C applicationContext) {
        System.out.println("ConfigurableApplicationContext.id = " + applicationContext.getId());
    }
}
