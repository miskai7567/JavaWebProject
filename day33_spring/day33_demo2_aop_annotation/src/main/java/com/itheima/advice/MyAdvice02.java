package com.itheima.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyAdvice02 {


    /*
        1. 环绕增强需要我们在方法内部手动调用目标方法，所有必须声明一个参数： ProceedingJoinPoint

        2. 操作步骤：

            2.1 如果目标方法是无参，这么调用：
                joinPoint.proceed()

            2.2 如果目标方法是有参，并且我们希望在这里指定参数，那么这么调用：
                    joinPoint.proceed(new Object[]{x,x,x,x})
            2.3 如果目标方法是有参，不想由我们来指定参数，外面调用这个方法用什么参数，就写什么参数，那么这么调用：
                    joinPoint.proceed(joinPoint.getArgs());

            2.4 环绕增强还可以得到目标方法的返回值，可以接受它，然后返回出去。
                这样在外面调用的方法就能得到返回值了！
                      Object obj = joinPoint.proceed(joinPoint.getArgs());
                      return obj;

     */
    @Around("execution( * com.itheima..*.*(..))")
    public Object testTime(ProceedingJoinPoint joinPoint) throws Throwable {

        //0. 获取方法的签名信息  public void com.itheima.service.impl.UserService.add(int,int);
        Signature signature = joinPoint.getSignature();

        //得到具体的类 和 具体的方法
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();


        //1. 先记录时间
        long start = System.currentTimeMillis();

        //2. 调用目标方法
        Object o = null;
        for (int i = 0; i <10000 ; i++) {
            o = joinPoint.proceed(joinPoint.getArgs());
        }

        //3. 再记录时间
        long end = System.currentTimeMillis();


        System.out.println("调用 " +className +" 的 " + methodName + " 一万次，消耗的时间：" + (end - start));
        return o;
    }

}
