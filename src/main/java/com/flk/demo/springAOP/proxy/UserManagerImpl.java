package com.flk.demo.springAOP.proxy;

/**
 * @author ：fanlikuo
 * @description：TODO
 * @date ：2022/1/21 16:36
 */
public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: "+userName+" password: "+password);
    }

    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: "+userName);
    }
    @Override
    public final void finalTest(){
        System.out.println("调用了final的方法！");
    }
}
