package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:db.properties")
@ComponentScan("com.itheima")
public class AppConfig02 {
}
