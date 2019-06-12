package com.zys.divinspringboot.annotation;

import com.zys.divinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld {@link ImportSelector} 实现
 *
 * @author: zys
 * @date: 2019/6/10 22:17
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("======= 接口编程方式 =======");
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
