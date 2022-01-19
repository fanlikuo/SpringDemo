package com.flk.demo.springBeanTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author ：fanlikuo
 * @description：Spring Bean生命周期
 * @date ：2022/1/18 11:05
 */
@Slf4j
public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器=====>");

        ApplicationContext factory = new ClassPathXmlApplicationContext("springBeanTest/beans.xml");
        log.info("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person", Person.class);
        log.info(person + "");

        log.info("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}
