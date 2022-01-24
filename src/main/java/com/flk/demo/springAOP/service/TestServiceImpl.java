package com.flk.demo.springAOP.service;

import org.springframework.stereotype.Service;


/**
 * @author ：fanlikuo
 * @description：TODO
 * @date ：2022/1/24 15:02
 */
@Service("testService")
public class TestServiceImpl  implements  TestService{
    @Override
    public void addTest() {
        System.out.println("addTest!!!!!!==============");
    }

    @Override
    public void updateTest(String arg) {
        System.out.println("updateTest===>arg:"+arg.substring(5));
    }
}
