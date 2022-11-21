package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//@EnableAspectJAutoProxy // 打开AOP的开关
@ComponentScan("com.itheima") // 打开IOC的开关
//@Configuration
@EnableAspectJAutoProxy
//@ComponentScan
@Configuration
public class AppConfig {
}
