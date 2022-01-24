package com.flk.demo.SpringAOP;

import com.flk.demo.springAOP.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：fanlikuo
 * @description：TODO
 * @date ：2022/1/24 15:40
 */
public class AOPTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springAOP/beans.xml");
        TestService testService = (TestService) context.getBean("testService");
        testService.addTest();
        System.out.println("##################################");
        testService.updateTest(null);

    }
}
