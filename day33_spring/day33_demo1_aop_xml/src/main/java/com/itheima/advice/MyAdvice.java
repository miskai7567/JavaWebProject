package com.itheima.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    public void print(){
        System.out.println("打印日志~！");
    }


    //==================================================


    public void before(){
        System.out.println("前置::打印日志~！");
    }


    public void after(){
        System.out.println("后置::打印日志~！");
    }


    public void afterReturning(){
        System.out.println("返回后::打印日志~！");
    }


    public void afterThrowing(){
        System.out.println("异常::打印日志~！");
    }


    /*
        环绕增强：
            1. 它比较特殊一些，功能也强大一些。
                1.1 可以在这个方法里面拥有调用目标方法的权力，以及设置目标方法的参数、获取目标方法执行的返回值！
            2. 具体操作：
                2.1 需要在环绕方法参数位置，设置一个 ProceedingJoinPoint 参数，这是固定写法

                2.2 可以通过它来调用目标方法
                     a. 如果目标方法是无参的，就使用这句话来调用
                            add() ====>  joinPoint.proceed();

                     b. 如果目标方法是有参的，
                             add(int a )  ====>   joinPoint.proceed(new Object[]{10});
                             add(int a  , String b , User c)  ====>   joinPoint.proceed(new Object[]{10 , "abc" , user对象});

                     c. 如果希望使用在单元测试调用的时候，传递的那个参数！
                            可以通过方法得到在调用目标方法的时候本身传递进来的参数。
                                joinPoint.getArgs()

                     d. 如果希望得到返回值，那么就接收一些proceed方法的返回值。
                            Object result = joinPoint.proceed(joinPoint.getArgs());

                     e. 为了让外面调用目标方法的时候，能够得到原始的返回值，环绕增强的方法通常都要返回Object

     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕::打印日志~1111111！");

        //运行目标方法，使用在单元测试调用传递的参数来执行它，得到的返回值也返回出去
        // 这样单元测试的方法执行完毕，也就能够得到返回值了！
        Object result = joinPoint.proceed(joinPoint.getArgs());

        System.out.println("环绕::打印日志~2222222222！");

        return result;
    }

}
