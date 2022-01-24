package com.flk.demo.springAOP.proxy;

/**
 * @author fanlikuo
 * @version 1.0
 * @description: TODO
 * @date 2022/1/22 上午10:18
 */
public final class UserMangerFinal implements UserManager {


    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用addUser方法");

    }

    @Override
    public void delUser(String userName) {
        System.out.println("调用delUser方法");

    }

    @Override
    public void finalTest() {
        System.out.println("调用finalTest方法");

    }
}
