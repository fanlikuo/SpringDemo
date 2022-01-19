package com.flk.demo.springBeanTest;

import java.beans.PropertyDescriptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @author ：fanlikuo
 * @description：TODO
 * @date ：2022/1/18 10:47
 */
@Slf4j
public class MyInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        log.info("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
        System.out.println("============>实例化InstantiationAwareBeanPostProcessorAdapter实现类");

    }

    // 接口方法、实例化Bean之前调用
    // 如果返回了bean实例, 则会替代原来正常通过target bean生成的bean的流程
    // 典型的例如aop返回proxy对象. 此时bean的执行流程将会缩短,
    // 只会执行 BeanPostProcessor#postProcessAfterInitialization接口完成初始化。
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,
                                                 String beanName) throws BeansException {
        log.info("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        System.out.println("============>执行InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法");
        return null;
    }

    // 接口方法、实例化Bean之后,和任何初始化(Initialization)之前,调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        log.info("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        System.out.println("============>执行InstantiationAwareBeanPostProcessor的postProcessAfterInitialization方法");

        return bean;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,
                                                    PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
       log.info("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        System.out.println("============>执行InstantiationAwareBeanPostProcessor的postProcessPropertyValues方法");

        return pvs;
    }
}