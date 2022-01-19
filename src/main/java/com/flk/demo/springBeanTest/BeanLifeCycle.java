package com.flk.demo.springBeanTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author ：fanlikuo
 * @description：Spring Bean生命周期
 *
 * 实例化BeanFactoryPostProcessor实现类
 *               |
 * 执行BeanFactoryPostProcessor的postProcessBeanFactory方法
 *               |
 * 实例化BeanPostProcessor实现类
 *               |
 * 实例化InstantiationAwareBeanPostProcessorAdapter实现类
 *               |
 * 执行InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法
 *               |
 *       执行Bean的构造器
 *               |
 * 执行InstantiationAwareBeanPostProcessor的postProcessPropertyValues方法
 *               |
 *       为Bean注入属性
 *               |
 * 调用BeanNameAware的setBeanName()方法
 *               |
 * 调用BeanFactoryAware的setBeanFactory()方法
 *               |
 * 执行BeanPostProcessor的postProcessBeforeInitialization方法
 *               |
 * 调用InitializingBean的afterPropertiesSet()方法
 *               |
 * 调用<bean>的init-method属性指定的初始化方法
 *               |
 * 执行BeanPostProcessor的postProcessAfterInitialization方法
 *               |
 * 执行InstantiationAwareBeanPostProcessor的postProcessAfterInitialization方法
 *               |
 * #####容器初始化成功，执行正常调用后，下面销毁容器#####
 *               |
 *  调用DiposibleBean的destory()方法
 *               |
 * 调用<bean>的destroy-method属性指定的初始化方法

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
