package com.nixmash.springdata.mvc.config;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;
import com.github.dandelion.thymeleaf.dialect.DandelionDialect;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DandelionConfig {

    @Bean
    public DandelionDialect dandelionDialect()
    {
        return new DandelionDialect();
    }

    @Bean
    public DataTablesDialect dataTablesDialect()
    {
        return new DataTablesDialect();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DandelionFilter());
        return filterRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new DandelionServlet());
        servletRegistrationBean.addUrlMappings("/dandelion-assets/*");
        servletRegistrationBean.setName("dandelionServlet");
        return servletRegistrationBean;
    }

}