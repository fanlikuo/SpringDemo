package com.flk.demo.springAOP.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ：fanlikuo
 * @description：TODO
 * @date ：2022/1/24 11:04
 */
// Step1:定义切面
@Aspect
@Component
public class TransactionDemo {
    // step2:定义要拦截的方法
    @Pointcut(value = "execution(* com.flk.demo.springAOP.service.*.* (..))")
    public void point(){
    }
    // step3:定义 前置通知
    @Before(value="point()")
    public void before(){
        System.out.println("transaction begin");
    }
    // step4:定义 后置通知
    @AfterReturning(value="point()")
    public void after(){
        System.out.println("transaction commit");
    }

    // step5:定义 环绕通知
    @Around(value="point()")
    public void around(ProceedingJoinPoint joinPoint)  {
        //前置通知@Before
        System.out.println("around====>transaction begin");
        try {
            //目标方法执行
            joinPoint.proceed();
            //环绕返回通知@AfterReturning
            System.out.println("around====>transaction commit");
        } catch (Throwable throwable) {
            //环绕异常通知@AfterThrowing
            System.out.println("around====>环绕异常通知");
            throw new RuntimeException(throwable);
        }finally {
            //最终通知@After
            System.out.println("around====>环绕最终通知");
        }
    }
}
