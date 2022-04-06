/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1bankapplicationweb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author ktbff
 */
@Configuration
@ComponentScan(basePackages={"com.mycompany"})
@EnableWebMvc

public class SpringWebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //To change body of generated methods, choose Tools | Templates.
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver vr=new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/view/");
        vr.setSuffix(".jsp");  // /WEB-INF/view/example.jsp
        return vr;
    }
    
}
