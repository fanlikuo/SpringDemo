package com.flk.demo.springAOP.proxy;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * @author ：fanlikuo
 * @description：Cglib动态代理，实现MethodInterceptor接口
 * cglib动态代理是利用asm开源包，对代理对象类的class文件加载进来，
 * 通过修改其字节码生成子类来处理
 * 如果目标对象实现了接口，可以强制使用CGLIB实现AOP
 * 如果目标对象没有实现了接口，必须采用CGLIB库，
 * spring会自动在JDK动态代理和CGLIB之间转换
 * @date ：2022/1/21 16:41
 */
//
public class CglibProxy implements MethodInterceptor {
    private Object target;//需要代理的目标对象

    //重写拦截方法
    @Override
    public Object intercept(Object obj, Method method, Object[] arr, MethodProxy proxy) throws Throwable {
        System.out.println("Cglib动态代理，监听开始！");
        Object invoke = method.invoke(target, arr);//方法执行，参数：target 目标对象 arr参数数组
        System.out.println("Cglib动态代理，监听结束！");
        return invoke;
    }
    //定义获取代理对象方法
    public Object getCglibProxy(Object objectTarget){
        //为目标对象target赋值
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);// 设置回调
        Object result = enhancer.create();//创建并返回代理对象
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglib = new CglibProxy();//实例化CglibProxy对象
        UserManager user =  (UserManager) cglib.getCglibProxy(new UserManagerImpl());//获取代理对象
        user.delUser("admin");//执行删除方法
    }

}
