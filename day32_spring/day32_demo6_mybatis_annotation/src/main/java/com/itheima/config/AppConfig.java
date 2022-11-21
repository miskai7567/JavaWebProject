package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@MapperScan("com.itheima.dao")
@PropertySource("classpath:db.properties")
@ComponentScan("com.itheima")
@Configuration
public class AppConfig {

    /*
        1. 在配置类里面配置了MapperScannerConfigurer之后，会使得这个AppConfig的类被初始化的时机过早。
        2. 导致了下面的@Bean标记的方法调用时机提前了，但是此时还没有来得及注入 properties的内容。
        3. 所以会报错，说： url not set  没有设置url .因为这些值都是  null

        4. 解决的办法：
            4.1 把MapperScannerConfigurer方法标记成 static 静态
            4.2 把这个方法搬到隔壁的 AppConfig02 这个类上，然后在这里使用 @Import(AppConfig02.class)
            4.3 方法都不需要写了，只需要在类上打注解 @MapperScan("com.itheima.dao")
     */
    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public DruidDataSource dataSource(){

        System.out.println("driverClassName = " + driverClassName);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        //1. 创建对象
        DruidDataSource ds = new DruidDataSource();

        //2. 设置属性
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        //3. 返回对象
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean factoryBean(DataSource ds){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setTypeAliasesPackage("com.itheima.bean");
        return bean;
    }

    /*@Bean
    public  MapperScannerConfigurer msc(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }*/
}
