package com.zys.divinspringboot.servlet.support;

import com.zys.divinspringboot.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 *
 * @author: zys
 * @date: 2019/7/9 22:36
 */
public class DefaultAnnotationConfigDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * web.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     * DispatcherServlet
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherServletConfiguration.class};
    }

    /**
     * <servlet-mapping>
     * <servlet-name>app</servlet-name>
     * <url-pattern>/</url-pattern>
     * </servlet-mapping>
     * <p>
     * 映射路径
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
