package com.flk.demo.springBeanTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/**
 * @author ：fanlikuo
 * @description：TODO
 * @date ：2022/1/18 10:46
 */

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        log.info("这是BeanPostProcessor实现类构造器！！");
        System.out.println("============>实例化BeanPostProcessor实现类");
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        log.info("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        System.out.println("============>执行BeanPostProcessor的postProcessAfterInitialization方法");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
       log.info("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        System.out.println("============>执行BeanPostProcessor的postProcessBeforeInitialization方法");

        return arg0;
    }
}
