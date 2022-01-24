package com.flk.demo.springAOP.proxy;

/**
 * @author fanlikuo
 * @version 1.0
 * @description: cglib和jdk动态代理区别
 *  jdk动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
 *
 * 而cglib动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
 *
 *  使用时点：
 *  1、如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP
 * 2、如果目标对象实现了接口，可以强制使用CGLIB实现AOP
 *∂
 * 3、如果目标对象没有实现了接口，必须采用CGLIB库，spring会自动在JDK动态代理和CGLIB之间转换
 *
 *
 * @date 2022/1/22 上午10:05
 */
public class ProxyTest {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();//实例化JDKProxy对象
        UserManager user = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());//获取代理对象
        user.addUser("admin", "123123");//执行新增方法
//        user.finalTest();
        System.out.println("===================================");
        CglibProxy cglib = new CglibProxy();//实例化CglibProxy对象
        UserManager user2 =  (UserManager) cglib.getCglibProxy(new UserManagerImpl());//获取代理对象
        user2.delUser("admin");//执行删除方法
//        user2.finalTest();
        System.out.println("===================================");
        UserManager  order = (UserManager) jdkProxy.getJDKProxy(new UserMangerFinal());
        order.delUser("123123123");
        System.out.println("===================================");
        // java.lang.IllegalArgumentException: Cannot subclass final class com.flk.demo.springAOP.proxy.Order
        // 不能动态代理final类
        UserManager order2= (UserManager)cglib.getCglibProxy(new UserMangerFinal());
        order2.delUser("123123123");

    }
}
