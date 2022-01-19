package com.flk.demo.springBeanTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author ：fanlikuo
 * @description：
 * @date ：2022/1/18 10:48
 */

@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        log.info("这是BeanFactoryPostProcessor实现类构造器！！");
        System.out.println("============>实例化BeanFactoryPostProcessor实现类");

    }

    /**
     * 官方描述
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     * 实现该接口，可以在spring的bean创建之前，修改bean的定义属性。
     * 也就是说，Spring允许BeanFactoryPostProcessor在容器实例化任何其它bean之前读取配置元数据，并可以根据需要进行修改，
     * 例如可以把bean的scope从singleton改为prototype，也可以把property的值给修改掉。
     * 可以同时配置多个BeanFactoryPostProcessor，并通过设置'order'属性来控制各个BeanFactoryPostProcessor的执行次序
     *
     * @param arg0 the bean factory used by the application context
     * @throws org.springframework.beans.BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
            throws BeansException {
        log.info("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        System.out.println("============>执行BeanFactoryPostProcessor的postProcessBeanFactory方法");

        BeanDefinition bd = arg0.getBeanDefinition("person");
        log.info("属性值============" + bd.getPropertyValues().toString());
        bd.getPropertyValues().addPropertyValue("phone", "110");
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }

}
