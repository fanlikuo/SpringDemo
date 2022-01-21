package com.flk.demo.springAOP.proxy;

/**
 * @author ：fanlikuo
 * @description：用户管理接口
 * @date ：2022/1/21 16:35
 */
public interface UserManager {
    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    void delUser(String userName);

}
