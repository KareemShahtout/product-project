package com.company.products.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.company.products",
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class AppConfig {
}
