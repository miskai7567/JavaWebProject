package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


/*
    使用这个类来扮演刚才的 applicationContext.xml 的角色
        @Configuration:
            作用： 表示这个类是一个配置类，可以用来配置spring 相当于 applicationContext.xml
            细节：
                1. 它也是从@Component变化过来的，所以这个类也会被spring的IOC容器所管理。
         @ComponentScan:
            作用：用来扫描组件, 相当于以前的 : <context:component-scan base-package=""/>

         @PropertySource:
            作用：用来导入外部的properties文件

         @Import
            作用：用来导入其他的类，让spring管理，解析这些类
                @Import({AppConfig02.class, Student.class})
 */
@Import({AppConfig02.class})
@Configuration
public class AppConfig {

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    public void show(){
        System.out.println("driverClassName = " + driverClassName);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

    //=============================================================

    /*
        @Bean:
            作用：
                1. spring会自动调用标记的方法，得到方法的返回值放到IOC容器管理起来。
                2. 默认会使用方法的名称作为id值，如果给@Bean注解的value属性赋值，那么将使用
                    value属性的值作为 id值。

            使用的场景：
                1. 无法在类身上打注解，此时spring就无法创建该类的对象！
                    1.1 使用import也可以呀。
                2. 希望在构建对象的时候，顺便给对象进行一些初始化|赋值的操作。
                    2.1 使用import注解就实现不了这个事情！

                3. 真正使用的地方就是：我们希望spring管理jar包里面的类，创建这些类的对象
                    因为我们无法在jar包里面的类，代码上打注解！所以就需要用到@Bean注解了。
     */

    @Bean("s1")
    public Student s1(){
        System.out.println("调用了s1方法~！");
        return new Student("张三");
    }

    @Bean("s2")
    public Student s2(){
        System.out.println("调用了s2方法~！");
        return new Student("李四");
    }


    /*
        创建druid连接池对象
            1. 在创建对象的时候，如果我们希望使用到IOC容器中管理的某个对象，那么可以让spring注入进来
            2. 具体操作：
                2.1 只需要在参数位置，声明即可，spring会自动注入进来 【spring调用这个方法的时候，会把它匹配的对象传递过来】
                2.2 如果IOC 容器当中有多个对象，符合参数的类型:
                    2.2.1 需要在前面加上 @Qualifier 来标记使用哪个对象注入
                    2.2.2 或者在参数上做手脚，把参数名直接写成要注入的那个对象的id名字
     */
    @Bean
    public DruidDataSource ds(@Qualifier("s1") Student student){
        System.out.println("s = " + student);
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }


}
