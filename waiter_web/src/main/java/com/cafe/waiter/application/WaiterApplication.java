package com.cafe.waiter.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 5:37 PM
 */

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.cafe.*")
@EnableJpaRepositories(basePackages = "com.cafe.business.core.repository.*")
@EntityScan(basePackages = "com.cafe.business.core.entity.*")
@EnableWebMvc
public class WaiterApplication {
    public static void main(String[] args) {
        SpringApplication.run(WaiterApplication.class, args);
    }

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
