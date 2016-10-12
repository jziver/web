package com.example.config;


import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.templateresolver.TemplateResolver;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("admin/login");
        registry.addViewController("/").setViewName("index");
    }


    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return (container -> {
            ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
            ErrorPage error403 = new ErrorPage(HttpStatus.FORBIDDEN,"/404.html");
//            ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
            container.addErrorPages(error404,error403);
        });
    }




}
