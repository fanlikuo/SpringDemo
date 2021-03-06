package com.flk.demo.springAOP.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：fanlikuo
 * @description：JDK动态代理实现InvocationHandler接口 java动态代理是利用反射机制生成一个实现代理接口的匿名类，
 * 在调用具体方法前调用InvokeHandler来处理
 * 如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP
 * @date ：2022/1/21 16:37
 */
public class JdkProxy implements InvocationHandler {
    private Object target;//需要代理的目标对象

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    //定义获取代理对象方法
    public Object getJDKProxy(Object targetObject) {
        //为目标对象target赋值
        this.target = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

}
